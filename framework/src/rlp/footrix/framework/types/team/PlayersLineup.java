package rlp.footrix.framework.types.team;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;

import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.generators.LineupGenerator.scoreOfMatch;

public record PlayersLineup(Lineup lineup, Map<Player, Integer[]> positions, List<Player> substitutes) {

    public Player substitute(Player player) {
        Integer[] location = positions.get(player);
        Position position = lineup.positionOf(location);
        Player newPlayer = bestPlayerOf(substitutes, position);
        if (newPlayer == null) return null;
        if (scoreOfMatch(player, position) > scoreOfMatch(newPlayer, position)) return null;
        substitutes.remove(newPlayer);
        positions.put(newPlayer, location);
        positions.remove(player);
        return newPlayer;
    }

    private Player bestPlayerOf(List<Player> players, Position position) {
        return players.stream().reduce((p1, p2) -> {
            if (LineupGenerator.scoreOfMatch(p1, position) > LineupGenerator.scoreOfMatch(p2, position)) return p1;
            if (LineupGenerator.scoreOfMatch(p1, position) < LineupGenerator.scoreOfMatch(p2, position)) return p2;
            if (p1.relativeCache(position) > p2.relativeCache(position)) return p1;
            return p2;
        }).orElse(null);
    }
}
