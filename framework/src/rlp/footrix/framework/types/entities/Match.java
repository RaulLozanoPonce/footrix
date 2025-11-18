package rlp.footrix.framework.types.entities;

import com.google.gson.JsonObject;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Goal;

public record Match(MatchDefinition definition, Instant date, Map<String, PlayerStatistics> playerStatistics, List<MatchEvent> events, String mvp, int duration, Penalties penalties) {

    public String winner() {
        if (penalties != null) return penalties.winner();
        int localGoals = goalsForOf(definition().local());
        int visitantGoals = goalsForOf(definition().visitant());
        if (localGoals > visitantGoals) return definition.local();
        if (visitantGoals > localGoals) return definition.visitant();
        return null;
    }

    public boolean withPenalties() {
        return penalties != null;
    }

    public static class PlayerStatistics {
        private int minutes = 0;
        private double score = 0.0;

        public int minutes() {
            return minutes;
        }

        public Double score() {
            return score;
        }

        public void addMinute() {
            this.minutes++;
        }

        public PlayerStatistics addScore(Double score) {
            this.score += score;
            return this;
        }
    }

    public record MatchEvent(String team, Type type, int minute, String who, String secondaryWho, JsonObject metaInfo) {
        public enum Type {Goal, RedCard, YellowCard, Substitution, Injury, Expulsion}
    }

    public record Penalties(String winner) {
        //TODO DETALLAR MÁS
    }

    private int goalsForOf(String team) {
        return (int) events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team)).count();
    }
}
