package rlp.footrix.framework.types.team;

import rlp.footrix.framework.types.player.Player;

import java.util.List;
import java.util.Map;

public record PlayersLineup(Lineup lineup, Map<Player, Integer[]> positions, List<Player> substitutes) {

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
}
