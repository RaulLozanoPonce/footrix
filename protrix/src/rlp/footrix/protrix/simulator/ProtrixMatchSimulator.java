package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.types.*;
import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.PlayersLineup;
import rlp.footrix.framework.var.Var;
import rlp.footrix.protrix.simulator.actions.*;
import rlp.footrix.protrix.simulator.helpers.TeamsHandle;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.types.Match.MatchEvent.Type.Expulsion;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.Goal;
import static rlp.footrix.protrix.simulator.helpers.PositionFactors.*;

public class ProtrixMatchSimulator implements MatchSimulator {

    private static final int framesPerMinute = 5;

    private final MatchDefinition definition;
    private final MatchState state;
    private final TeamsHandle teamsHandle;

    public ProtrixMatchSimulator(MatchDefinition definition, CompetitionDefinition competition, Var var) {
        this.definition = definition;
        this.state = new MatchState(definition.local(), definition.visitant(), var, competition.substitutionsNumber(), framesPerMinute * 90);
        this.teamsHandle = new TeamsHandle(this.state);
    }

    @Override
    public Match simulate(PlayersLineup localPlayersLineup, PlayersLineup visitantPlayersLineup) {
        this.state.localPlayers(localPlayersLineup).visitantPlayers(visitantPlayersLineup);
        simulateMatch();
        return new Match(definition, state.playerStatistics(), state.events(), state.mvp(), 90);    //TODO DURACION (TENER EN CUENTA PRORROGAS O INCLUSO SI TERMINA UN PARTIDO ANTES)
    }

    private void simulateMatch() {
        state.setPossession(state.local(), state.localPlayers().getFirst());
        boolean continueMatch = simulateMatch(1, 45);
        if (!continueMatch) return;
        state.setPossession(state.visitant(), state.visitantPlayers().getFirst());
        simulateMatch(46, 90);
    }

    private boolean simulateMatch(int from, int to) {
        for (int i = from; i <= to; i++) {
            for (int j = 0; j < framesPerMinute; j++) {
                boolean continueMatch = simulateSubMinute(i);
                if (!continueMatch) return false;
            }
            state.addMinutes();
            state.events().addAll(new SubstitutionsSimulator(state, i).simulate());
        }
        return true;
    }

    private boolean simulateSubMinute(int minute) {
        state.events().addAll(eventsOfAction(minute));
        state.events().addAll(new OutsSimulator(state, minute).simulate());
        state.addFatigue();
        Map<String, List<Match.MatchEvent>> outs = state.events().stream().filter(e -> e.type() == Expulsion).collect(Collectors.groupingBy(Match.MatchEvent::team));
        for (Map.Entry<String, List<Match.MatchEvent>> entry : outs.entrySet()) {
            if (entry.getValue().size() >= 5) {
                state.events(state.events().stream().filter(e -> e.type() != Goal).toList());
                String team = state.rivalOf(entry.getKey());
                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
                return false;
            }
        }
        return true;
    }

    private List<Match.MatchEvent> eventsOfAction(int minute) {
        Position position = state.positionOf(state.playerWithPossession());
        double actionValue = Math.random();
        if (actionValue < shotProbabilityOf(position)) {
            return new ShootSimulator(state, minute).simulate();
        } else {
            Player rival = teamsHandle.mostProbablyRivalTo(state.teamWithPossession(), state.playerWithPossession());
            if (actionValue < shotProbabilityOf(position) + passProbabilityOf(position)) {
                return new PassSimulator(state, minute, rival).simulate();
            } else {
                return new DribbleSimulator(state, minute, rival).simulate();
            }
        }
    }
}
