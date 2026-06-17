package rlp.footrix.protrix.ai.matchsimulator.weights;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.types.ProtrixPlayer;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.types.player.ProtrixSkills;

public class PlayerValue {
    private final MatchState state;

    public PlayerValue(MatchState state) {
        this.state = state;
    }

    public double attack(ProtrixPlayer player) {
        return (0.25 * ((ProtrixSkills) player.skills()).shootSummary() +
                0.2 * ((ProtrixSkills) player.skills()).attack() +
                0.15 * ((ProtrixSkills) player.skills()).dribbleSummary() +
                0.15 * ((ProtrixSkills) player.skills()).techniqueSummary() +
                0.1 * ((ProtrixSkills) player.skills()).speedSummary() +
                0.1 * ((ProtrixSkills) player.skills()).passSummary() +
                0.03 * ((ProtrixSkills) player.skills()).physiqueSummary() +
                0.02 * ((ProtrixSkills) player.skills()).mentalitySummary()) / 100.0;
    }

    public double defense(ProtrixPlayer player, Position position) {
        if (position.id().equals("PT")) {
            return (0.37 * ((ProtrixSkills) player.skills()).goalkeeperSummary() +
                    0.18 * ((ProtrixSkills) player.skills()).defense() +
                    0.15 * ((ProtrixSkills) player.skills()).physiqueSummary() +
                    0.1 * ((ProtrixSkills) player.skills()).speedSummary() +
                    0.1 * ((ProtrixSkills) player.skills()).mentalitySummary() +
                    0.05 * ((ProtrixSkills) player.skills()).techniqueSummary() +
                    0.05 * ((ProtrixSkills) player.skills()).passSummary()) / 100.0;
        } else {
            return (0.3 * ((ProtrixSkills) player.skills()).defense() +
                    0.2 * ((ProtrixSkills) player.skills()).physiqueSummary() +
                    0.15 * ((ProtrixSkills) player.skills()).speedSummary() +
                    0.15 * ((ProtrixSkills) player.skills()).mentalitySummary() +
                    0.1 * ((ProtrixSkills) player.skills()).techniqueSummary() +
                    0.07 * ((ProtrixSkills) player.skills()).passSummary() +
                    0.03 * ((ProtrixSkills) player.skills()).dribbleSummary()) / 100.0;
        }
    }

    public double pass(ProtrixPlayer player) {
        return ((ProtrixSkills) player.skills()).passSummary() / 100.0;
    }

    public double agression(ProtrixPlayer player) {
        return ((ProtrixSkills) player.skills()).aggression() / 100.0;
    }

    public double discipline(ProtrixPlayer player) {
        return ((ProtrixSkills) player.skills()).mentalitySummary() / 100.0;
    }

    public double fitness(ProtrixPlayer player) {
        return ((ProtrixSkills) player.skills()).physiqueSummary() / 100.0;
    }

    public double stamina(ProtrixPlayer player) {
        return ((ProtrixSkills) player.skills()).stamina() / 100.0;
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
