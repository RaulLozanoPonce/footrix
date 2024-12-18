package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.Position;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.ActionSimulator;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.PositionFactors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchMinutePassSimulator extends ActionSimulator {
    private final ProtrixPlayer player;
    private final String team;
    private final String rivalTeam;
    private final ProtrixPlayer rival;

    public MatchMinutePassSimulator(MatchState state, int minute, Player rival) {
        super(state, minute);
        this.player = (ProtrixPlayer) state.playerWithPossession();
        this.team = state.teamWithPossession();
        this.rivalTeam = state.rivalOf(team);
        this.rival = (ProtrixPlayer) rival;
    }

    @Override
    public List<Match.MatchEvent> simulate() {
        if (rival == null) return successfulPass();
        double playerOverall = 5 * localFactor(team) * passOf(player) * percentOf(player.overall())/100.0;
        double rivalOverall = localFactor(rivalTeam) * defenseOf(rival) * percentOf(rival.overall())/100.0;
        double total = playerOverall + rivalOverall;
        double random = Math.random() * total;
        return random < playerOverall ? successfulPass() : unsuccessfulPass();
    }

    private double passOf(ProtrixPlayer player) {
        return player.energy() * (player.mood().overall() + 0.5) * (0.7 * player.passSummary() + 0.3 * player.techniqueSummary());
    }

    private List<Match.MatchEvent> successfulPass() {
        state.addSuccessfulPass(player, rival);
        state.playerWithPossession(teamMate());
        return new ArrayList<>();
    }

    private List<Match.MatchEvent> unsuccessfulPass() {
        state.addUnsuccessfulPass(player, rival);
        state.init(rivalTeam, rival);
        return new ArrayList<>();
    }

    private Player teamMate() {
        Map<Player, Double> probabilities = state.playersMapOf(team).entrySet().stream()
                .filter(e -> !e.getKey().definition().id().equals(player.definition().id()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> passProbabilityTo(state.positionOf(e.getKey()))));
        double total = probabilities.values().stream().mapToDouble(v -> v).sum();
        double random = Math.random() * total;
        double count = 0;
        if (random == total) return probabilities.keySet().stream().findAny().orElse(null);
        for (Player teammate : probabilities.keySet()) {
            count += probabilities.get(teammate);
            if (random < count) return teammate;
        }
        return null;
    }

    private Double passProbabilityTo(Position position) {
        return PositionFactors.passProbabilityBetween(state.positionOf(player), position);
    }
}
