package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.PlayersLineup;
import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.var.Var;
import rlp.footrix.protrix.simulator.actions.MatchDribbleSimulator;
import rlp.footrix.protrix.simulator.actions.MatchPassSimulator;
import rlp.footrix.protrix.simulator.actions.MatchShootSimulator;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.helpers.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.*;
import static rlp.footrix.protrix.simulator.PositionFactors.*;

public class ProtrixMatchSimulator implements MatchSimulator {

    private final MatchDefinition definition;
    private TeamsHandle teamsHandle;
    private MatchState state;
    private final Var var;

    public ProtrixMatchSimulator(MatchDefinition definition, Var var) {
        this.definition = definition;
        this.var = var;
    }

    @Override
    public Match simulate(PlayersLineup localPlayersLineup, PlayersLineup visitantPlayersLineup) {
        this.state = new MatchState(definition.local(), definition.visitant(), localPlayersLineup, visitantPlayersLineup, var);
        this.teamsHandle = new TeamsHandle(this.state);
        simulateMatch();
        return new Match(definition, state.playerStatistics(), state.events(), state.mvp(), 90);    //TODO DURACION
    }

    private void simulateMatch() {
        state.init(state.local(), state.localPlayers().getFirst());
        simulateMatch(1, 45);
        state.init(state.visitant(), state.visitantPlayers().getFirst());
        simulateMatch(46, 90);
    }

    private void simulateMatch(int from, int to) {
        for (int i = from; i <= to; i++) {
            for (int j = 0; j < 5; j++) simulateSubMinute(i);
            state.addMinutes();
            if (handleSubstitutions(i)) state.init(state.teamWithPossession(), state.playerWithPossession());
        }
    }

    private void simulateSubMinute(int minute) {
        state.events().addAll(eventsOf(minute));
        handleOuts(minute);
        state.addFatigue();
    }

    private List<Match.MatchEvent> eventsOf(int minute) {
        Position position = state.positionOf(state.playerWithPossession());
        double actionValue = Math.random();
        if (actionValue < shotProbabilityOf(position)) {
            return new MatchShootSimulator(state, minute).simulate();
        } else {
            Player rival = teamsHandle.mostProbablyRivalTo(state.teamWithPossession(), state.playerWithPossession());
            if (actionValue < shotProbabilityOf(position) + passProbabilityOf(position)) {
                return new MatchPassSimulator(state, minute, rival).simulate();
            } else {
                return new MatchDribbleSimulator(state, minute, rival).simulate();
            }
        }
    }

    private void handleOuts(int minute) {
        handleOuts(state.local(), minute);
        handleOuts(state.visitant(), minute);
    }

    private void handleOuts(String team, int minute) {
        List<String> expulsed = state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == Expulsion)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .distinct()
                .toList();
        Set<String> outPlayers = new HashSet<>();
        outPlayers.addAll(state.events().stream()
                .filter(e -> e.minute() == minute)
                    .filter(e -> e.type() == RedCard)
                    .filter(e -> e.team().equals(team))
                    .map(Match.MatchEvent::who)
                    .filter(p -> !expulsed.contains(p))
                    .collect(Collectors.toSet())
        );
        outPlayers.addAll(state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == YellowCard)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(p -> !expulsed.contains(p))
                .filter(who -> state.events().stream().filter(e2 -> e2.who().equals(who)).filter(e2 -> e2.type() == YellowCard).count() >= 2)
                .collect(Collectors.toSet())
        );
        for (String player : outPlayers) {
            state.events().add(new Match.MatchEvent(team, Expulsion, minute, player));
            state.out(team, player);
        }
    }

    private boolean handleSubstitutions(int minute) {
        return handleSubstitutions(state.local(), minute) || handleSubstitutions(state.visitant(), minute);
    }

    private boolean handleSubstitutions(String team, int minute) {
        Set<String> necessarySubstitutions = neededSubstitutions(team);
        Set<String> tacticSubstitutions = tacticPlayersToSubstitute(team, minute, necessarySubstitutions);
        if (necessarySubstitutions.isEmpty() && tacticSubstitutions.isEmpty()) return false;
        return substitute(team, minute, necessarySubstitutions, tacticSubstitutions);
    }

    private Set<String> neededSubstitutions(String team) {
        return state.events().stream()
                .filter(e -> e.type() == MinorInjury || e.type() == SeriousInjury || e.type() == VerySeriousInjury)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(id -> !state.playerWithPossession().definition().id().equals(id))
                .limit(state.restSubstitutions(team))
                .collect(Collectors.toSet());
    }

    private Set<String> tacticPlayersToSubstitute(String team, int minute, Set<String> necessarySubstitutions) {
        Set<String> tacticSubstitutions = new HashSet<>();
        Set<String> irreplaceablePlayers = irreplaceablePlayers(team);
        List<String> replaceablePlayers;
        for (int i = 0; i < state.restSubstitutions(team) - necessarySubstitutions.size(); i++) {
            if (100 * Math.random() < 3.25 * substitutionPercentOf(minute)) {
                replaceablePlayers = replaceablePlayers(team, irreplaceablePlayers, necessarySubstitutions);
                if (replaceablePlayers.isEmpty()) break;
                tacticSubstitutions.add(replaceablePlayers.getFirst());
            } else {
                break;
            }
        }
        return tacticSubstitutions;
    }

    private Set<String> irreplaceablePlayers(String team) {
        return state.events().stream()
                .filter(e -> e.type() == SubstituteIn)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .collect(Collectors.toSet());
    }

    private List<String> replaceablePlayers(String team, Set<String> irreplaceablePlayers, Set<String> necessarySubstitutions) {
        return state.playersOf(team).stream()
                .filter(p -> !irreplaceablePlayers.contains(p.definition().id()))
                .filter(p -> !necessarySubstitutions.contains(p.definition().id()))
                .filter(p -> !state.playerWithPossession().definition().id().equals(p.definition().id()))
                .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.positionOf(p1)), scoreOfMatch(p2, state.positionOf(p2))))
                .map(p -> p.definition().id())
                .toList();
    }

    private boolean substitute(String team, int minute, Set<String> necessarySubstitutions, Set<String> tacticSubstitutions) {
        boolean areThereSubstitutions = false;
        //TODO OPTIMIZAR
        for (String playerId : necessarySubstitutions) {
            Player playerToSubstitute = state.playersOf(team).stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = state.substitute(team, playerToSubstitute);
            if (successful == null) continue;
            areThereSubstitutions = true;
            state.events().add(new Match.MatchEvent(team, SubstituteOut, minute, playerToSubstitute.definition().id()));
            state.events().add(new Match.MatchEvent(team, SubstituteIn, minute, successful.definition().id()));
            state.events().add(new Match.MatchEvent(team, NeededSubstitution, minute, playerToSubstitute.definition().id()));
        }
        for (String playerId : tacticSubstitutions) {
            Player playerToSubstitute = state.playersOf(team).stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = state.substitute(team, playerToSubstitute);
            if (successful == null) continue;
            areThereSubstitutions = true;
            state.events().add(new Match.MatchEvent(team, SubstituteOut, minute, playerToSubstitute.definition().id()));
            state.events().add(new Match.MatchEvent(team, SubstituteIn, minute, successful.definition().id()));
        }
        return areThereSubstitutions;
    }
}
