package rlp.footrix.framework.types.entities.team;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record PlayersLineup(Lineup lineup, Map<Player, Integer[]> positions, List<Player> substitutes, List<Player> substitutions) {

    public Integer[] locationOf(String playerId) {
        Player player = positions.keySet().stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
        if (player == null) return null;
        return positions.get(player);
    }

    public void setLocation(String playerId, Integer[] position) {
        Player player = positions.keySet().stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
        if (player == null) return;
        positions.put(player, position);
    }

    public Position positionOf(String playerId) {
        Integer[] location = locationOf(playerId);
        if (location == null) return null;
        return lineup.positionOf(location);
    }

    public List<Player> fieldPlayers() {
        return new ArrayList<>(positions.keySet());
    }

    public List<Player> benchPlayers() {
        return substitutes;
    }

    public int remainingSubstitutions(int maxSubstitutions) {
        return Math.min(maxSubstitutions - substitutions.size(), substitutes().size());
    }
}
