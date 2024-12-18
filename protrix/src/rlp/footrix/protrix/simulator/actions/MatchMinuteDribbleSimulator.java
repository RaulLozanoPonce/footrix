package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.ActionSimulator;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.PositionFactors;

import java.util.ArrayList;
import java.util.List;

import static rlp.footrix.framework.types.Match.MatchEvent.Type.*;


public class MatchMinuteDribbleSimulator extends ActionSimulator {
    private final ProtrixPlayer player;
    private final String team;
    private final String rivalTeam;
    private final ProtrixPlayer rival;

    public MatchMinuteDribbleSimulator(MatchState state, int minute, Player rival) {
        super(state, minute);
        this.player = (ProtrixPlayer) state.playerWithPossession();
        this.team = state.teamWithPossession();
        this.rivalTeam = state.rivalOf(team);
        this.rival = (ProtrixPlayer) rival;
    }

    @Override
    public List<Match.MatchEvent> simulate() {
        List<Match.MatchEvent> events = new ArrayList<>();
        if (rival != null) {
            if (isSuccessfulDribble()) {
                state.addSuccessfulDribble(player, rival);
                if (isFault()) {
                    fault(events);
                }
            } else {
                state.addUnsuccessfulDribble(player, rival);
                if (isFault()) {
                    fault(events);
                } else {
                    state.init(rivalTeam, rival);
                }
            }
        }
        return events;
    }

    private boolean isSuccessfulDribble() {
        double playerOverall = 1.65 * localFactor(team) * dribbleOf(player) * percentOf(player.overall())/100.0;
        double rivalOverall = localFactor(rivalTeam) * defenseOf(rival) * percentOf(rival.overall())/100.0;
        double total = playerOverall + rivalOverall;
        double random = Math.random() * total;
        return random < playerOverall;
    }

    private boolean isFault() {
        Position rivalPosition = state.positionOf(rival);
        if (rivalPosition == Position.PT) return false; //TODO SE DEBERÁN PODER COMETER
        if (state.events().stream().anyMatch(e -> e.type() == YellowCard && e.who().equals(rival.definition().id()))) {
            if (Math.random() < 0.65) return false;
        }
        return Math.random() < PositionFactors.faultPercentOf(rivalPosition);
    }

    private boolean isInjury() {
        return Math.random() < injuryFactor(player) * resistanceFactor(player) * 0.1;
    }

    private void fault(List<Match.MatchEvent> events) {
        state.addFault(rival, player);
        cards(events);
        if (isInjury()) {
            state.init(team, bestFreeKickPlayerOf(state.playersOf(team).stream().filter(p -> !p.definition().id().equals(player.definition().id())).toList()));
            injury(events);
        } else {
            state.init(team, bestFreeKickPlayerOf(state.playersOf(team)));
        }
    }

    private Player bestFreeKickPlayerOf(List<Player> players) {
        return players.stream().map(p -> (ProtrixPlayer) p).reduce((p1, p2) -> {
            if (p1.freeKickAccuracy() > p2.freeKickAccuracy()) return p1;
            return p2;
        }).orElse(null);
    }

    private void cards(List<Match.MatchEvent> events) {
        double cardRandom = Math.random();
        if (cardRandom < 0.48) {
            if (state.events().stream().anyMatch(e -> e.type() == YellowCard && e.who().equals(rival.definition().id())))
                state.addYellowExpulsion(rival);
            state.addYellowCard(rival);
            events.add(new Match.MatchEvent(rivalTeam, YellowCard, minute, rival.definition().id()));
        } else if (cardRandom < 0.48 + 0.016) {
            state.addRedCard(rival);
            events.add(new Match.MatchEvent(rivalTeam, RedCard, minute, rival.definition().id()));
        }
    }

    private void injury(List<Match.MatchEvent> events) {
        state.addInjury();
        events.add(new Match.MatchEvent(team, Injury, minute, player.definition().id()));
        player.energy(-1.0);
    }

    private double injuryFactor(ProtrixPlayer player) {
        if (player.definition().injuryResistance() == PlayerDefinition.InjuryResistance.A) return 1;
        if (player.definition().injuryResistance() == PlayerDefinition.InjuryResistance.A) return 2;
        return 4;
    }

    private double resistanceFactor(ProtrixPlayer player) {
        return Math.min(1, Math.max(0, -Math.log10(player.energy())));
    }

    private double dribbleOf(ProtrixPlayer player) {
        return player.energy() * (player.mood().overall() + 0.5) * (0.55 * player.dribbleSummary() + 0.35 * player.techniqueSummary() + 0.1 * player.speedSummary());
    }
}
