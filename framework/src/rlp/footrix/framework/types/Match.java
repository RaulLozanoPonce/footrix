package rlp.footrix.framework.types;

import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Match(MatchDefinition definition, Map<String, PlayerStatistics> playerStatistics, List<MatchEvent> events, String mvp, int duration) {

    public int localPoints() {
        int localGoals = localGoals();
        int visitantGoals = visitantGoals();
        if (localGoals == visitantGoals) return 1;
        if (localGoals > visitantGoals) return 3;
        return 0;
    }

    public int visitantPoints() {
        int localGoals = localGoals();
        int visitantGoals = visitantGoals();
        if (localGoals == visitantGoals) return 1;
        if (localGoals < visitantGoals) return 3;
        return 0;
    }

    public int localGoals() {
        return (int) events.stream().filter(e -> e.type == MatchEvent.Type.Goal).filter(e -> e.team.equals(definition.local())).count();
    }

    public int visitantGoals() {
        return (int) events.stream().filter(e -> e.type == MatchEvent.Type.Goal).filter(e -> e.team.equals(definition.visitant())).count();
    }

    public static class PlayerStatistics {
        private final Map<Position, Double> minutes = new HashMap<>();
        private Double score = 0.0;
        private int goalsAgainst = 0;

        public Map<Position, Double> minutes() {
            return minutes;
        }

        public Double score() {
            return score;
        }

        public int goalsAgainst() {
            return goalsAgainst;
        }

        public void addMinute(Position position) {
            if (!this.minutes.containsKey(position)) this.minutes.put(position, 0.0);
            this.minutes.put(position, this.minutes.get(position) + 1);
        }

        public PlayerStatistics addScore(Double score) {
            this.score += score;
            return this;
        }

        public PlayerStatistics addGoalAgainst() {
            this.goalsAgainst++;
            return this;
        }
    }

    public record MatchEvent(String team, Type type, int minute, String who) {
        public enum Type {Goal, Assist, RedCard, YellowCard, SubstituteIn, SubstituteOut, Injury, NeededSubstitution, Expulsion}
    }
}
