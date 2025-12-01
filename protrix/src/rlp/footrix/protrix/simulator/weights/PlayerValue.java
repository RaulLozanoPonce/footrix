package rlp.footrix.protrix.simulator.weights;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.MatchState;

public class PlayerValue {
    private final MatchState state;

    public PlayerValue(MatchState state) {
        this.state = state;
    }

    public double attack(ProtrixPlayer player) {
        return (0.25 * player.shootSummary() +
                0.2 * player.attack() +
                0.15 * player.dribbleSummary() +
                0.15 * player.techniqueSummary() +
                0.1 * player.speedSummary() +
                0.1 * player.passSummary() +
                0.03 * player.physiqueSummary() +
                0.02 * player.mentalitySummary()) / 100.0;
    }

    public double defense(ProtrixPlayer player, Position position) {
        if (position.id().equals("PT")) {
            return (0.37 * player.goalkeeperSummary() +
                    0.18 * player.defense() +
                    0.15 * player.physiqueSummary() +
                    0.1 * player.speedSummary() +
                    0.1 * player.mentalitySummary() +
                    0.05 * player.techniqueSummary() +
                    0.05 * player.passSummary()) / 100.0;
        } else {
            return (0.3 * player.defense() +
                    0.2 * player.physiqueSummary() +
                    0.15 * player.speedSummary() +
                    0.15 * player.mentalitySummary() +
                    0.1 * player.techniqueSummary() +
                    0.07 * player.passSummary() +
                    0.03 * player.dribbleSummary()) / 100.0;
        }
    }

    public double pass(ProtrixPlayer player) {
        return player.passSummary() / 100.0;
    }

    public double agression(ProtrixPlayer player) {
        return player.aggression() / 100.0;
    }

    public double discipline(ProtrixPlayer player) {
        return player.mentalitySummary() / 100.0;
    }

    public double fitness(ProtrixPlayer player) {
        return player.physiqueSummary() / 100.0;
    }

    public double stamina(ProtrixPlayer player) {
        return player.stamina() / 100.0;
    }

    public double injuryProne(ProtrixPlayer player) {
        return switch (player.definition().injuryResistance()) {
            case A -> 0.15;
            case B -> 0.4;
            case C -> 0.7;
        };
    }

    public double form(ProtrixPlayer player) {
        return player.mood().overall();
    }

    public double energy(ProtrixPlayer player) {
        return player.energy() - state.fatigue(player.definition().id());
    }

    public double score(ProtrixPlayer player, int minute) {
        return state.score(player.team().definition().id(), player.definition().id(), minute);
    }
}
