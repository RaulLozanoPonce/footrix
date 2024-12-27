package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Match;
import rlp.footrix.protrix.model.ProtrixPlayer;

import java.util.List;

public abstract class MatchActionSimulator {

    protected final MatchState state;
    protected final int minute;

    public MatchActionSimulator(MatchState state, int minute) {
        this.state = state;
        this.minute = minute;
    }

    protected double localFactor(String team) {
        if (team.equals(state.local())) return 1.65;
        return 1;
    }

    protected double defenseOf(ProtrixPlayer player) {
        return player.energy() * (player.mood().overall() + 0.5) * (0.6 * player.defense() + 0.2 * player.physiqueSummary() + 0.20 * player.speedSummary());
    }

    protected double percentOf(double overall) {
        double min = 40;
        double limit = 72.0;
        double exponent = 4.0;
        if (overall >= limit) return limit * (Math.pow(overall, exponent) / Math.pow(limit, exponent));
        return limit * (overall - min) / (limit - min);
    }

    public abstract List<Match.MatchEvent> simulate();
}
