package rlp.footrix.protrix.simulator.types;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.weights.PlayerValue;

public class FatigueSimulator {
    private static final double BaseFatigueLoss = 0.008;
    private final MatchState state;
    private final PlayerValue playerValue;

    public FatigueSimulator(MatchState state, PlayerValue playerValue) {
        this.state = state;
        this.playerValue = playerValue;
    }

    public void simulate(int minute) {
        double matchIntensity = getMatchIntensity(minute);
        applyFatigueToTeam(state.localLineup(), matchIntensity);
        applyFatigueToTeam(state.visitantLineup(), matchIntensity);
    }

    private void applyFatigueToTeam(PlayersLineup lineup, double intensity) {
        for (Player p : lineup.fieldPlayers()) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double staminaFactor = (1.0 - playerValue.stamina(player)) * 0.008;
            double fitnessFactor = (1.0 - playerValue.fitness(player)) * 0.005;
            double randomVariation = (Math.random() * 0.004) - 0.002;
            double totalLoss = Math.max(0, (BaseFatigueLoss + staminaFactor + fitnessFactor + randomVariation) * intensity);
            state.addFatigue(player.definition().id(), totalLoss);
        }
    }

    private double getMatchIntensity(int minute) {
        double base;
        if (minute < 15) base = 0.8;
        else if (minute < 60) base = 1.0;
        else if (minute < 75) base = 1.15;
        else base = 1.25;
        return base;
    }
}
