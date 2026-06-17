package rlp.footrix.protrix.ai.matchsimulator.weights;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.player.Pes6Skills;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;

public class PlayerValue {
    private final MatchState state;

    public PlayerValue(MatchState state) {
        this.state = state;
    }

    public double attack(Pes6Player player) {
        return (0.25 * ((Pes6Skills) player.skills()).shootSummary() +
                0.2 * ((Pes6Skills) player.skills()).attack() +
                0.15 * ((Pes6Skills) player.skills()).dribbleSummary() +
                0.15 * ((Pes6Skills) player.skills()).techniqueSummary() +
                0.1 * ((Pes6Skills) player.skills()).speedSummary() +
                0.1 * ((Pes6Skills) player.skills()).passSummary() +
                0.03 * ((Pes6Skills) player.skills()).physiqueSummary() +
                0.02 * ((Pes6Skills) player.skills()).mentalitySummary()) / 100.0;
    }

    public double defense(Pes6Player player, Position position) {
        if (position.id().equals("PT")) {
            return (0.37 * ((Pes6Skills) player.skills()).goalkeeperSummary() +
                    0.18 * ((Pes6Skills) player.skills()).defense() +
                    0.15 * ((Pes6Skills) player.skills()).physiqueSummary() +
                    0.1 * ((Pes6Skills) player.skills()).speedSummary() +
                    0.1 * ((Pes6Skills) player.skills()).mentalitySummary() +
                    0.05 * ((Pes6Skills) player.skills()).techniqueSummary() +
                    0.05 * ((Pes6Skills) player.skills()).passSummary()) / 100.0;
        } else {
            return (0.3 * ((Pes6Skills) player.skills()).defense() +
                    0.2 * ((Pes6Skills) player.skills()).physiqueSummary() +
                    0.15 * ((Pes6Skills) player.skills()).speedSummary() +
                    0.15 * ((Pes6Skills) player.skills()).mentalitySummary() +
                    0.1 * ((Pes6Skills) player.skills()).techniqueSummary() +
                    0.07 * ((Pes6Skills) player.skills()).passSummary() +
                    0.03 * ((Pes6Skills) player.skills()).dribbleSummary()) / 100.0;
        }
    }

    public double pass(Pes6Player player) {
        return ((Pes6Skills) player.skills()).passSummary() / 100.0;
    }

    public double agression(Pes6Player player) {
        return ((Pes6Skills) player.skills()).aggression() / 100.0;
    }

    public double discipline(Pes6Player player) {
        return ((Pes6Skills) player.skills()).mentalitySummary() / 100.0;
    }

    public double fitness(Pes6Player player) {
        return ((Pes6Skills) player.skills()).physiqueSummary() / 100.0;
    }

    public double stamina(Pes6Player player) {
        return ((Pes6Skills) player.skills()).stamina() / 100.0;
    }

    public double injuryProne(Pes6Player player) {
        return switch (player.definition().injuryResistance()) {
            case A -> 0.15;
            case B -> 0.4;
            case C -> 0.7;
        };
    }

    public double form(Pes6Player player) {
        return player.mood().overall();
    }

    public double energy(Pes6Player player) {
        return player.energy() - state.fatigue(player.definition().id());
    }

    public double score(Pes6Player player, int minute) {
        return state.score(player.team().definition().id(), player.definition().id(), minute);
    }
}
