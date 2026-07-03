package rlp.footrix.framework.types.entities.match;

import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.types.entities.match.MatchEvent.Type.Goal;

public record Match(MatchDefinition definition, Instant date, Map<Player, Integer[]> localLineup, Map<Player, Integer[]> visitantLineup, Map<String, Map<String, Match.PlayerStatistics>> playerStatistics, List<MatchEvent> events, int duration, Penalties penalties) {

    public boolean isDraw() {
        if (penalties != null) return false;
        int localGoals = goalsFor(definition().local());
        int visitantGoals = goalsFor(definition().visitant());
        return localGoals == visitantGoals;
    }

    public String winner() {
        if (penalties != null) return penalties.winner();
        int localGoals = goalsFor(definition().local());
        int visitantGoals = goalsFor(definition().visitant());
        if (localGoals > visitantGoals) return definition.local();
        if (visitantGoals > localGoals) return definition.visitant();
        return null;
    }

    public int localGoals() {
        return goalsFor(definition.local());
    }

    public int visitantGoals() {
        return goalsFor(definition.visitant());
    }

    public boolean withPenalties() {
        return penalties != null;
    }

    public int streak(String team) {
        if (team.equals(definition.local())) {
            return Integer.compare(localGoals(), visitantGoals());
        } else {
            return Integer.compare(visitantGoals(), localGoals());
        }
    }

    public int goalsFor(String team) {
        return (int) events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team)).count();
    }

    public int goalsAgainst(String team) {
        return (int) events().stream().filter(e -> e.type() == Goal).filter(e -> !e.team().equals(team)).count();
    }

    public enum MatchRole {
        Starter, Substitute, Reserve
    }

    public record PlayerStatistics(Integer minutes, Double score, Double fatigue, MatchRole matchRole, Integer enterMinute, Integer exitMinute, Integer goals, Integer assists, Integer yellowCards, Integer redCards, Integer receivedGoals) {}

    public record Penalties(String winner) {
        //TODO DETALLAR MÁS
    }
}
