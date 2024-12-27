package rlp.footrix.protrix.simulator.helpers;

import rlp.footrix.framework.types.player.Player;
import rlp.footrix.protrix.simulator.MatchState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamsHandle {

    private final MatchState state;

    public TeamsHandle(MatchState state) {
        this.state = state;
    }

    public Player mostProbablyRivalTo(String team, Player player) {
        Integer[] oppositeCoordinates = oppositeCoordinates(state.playersMapOf(team).get(player));
        return random(aroundCoordinatesOf(oppositeCoordinates).stream()
                .map(c -> state.playerWith(state.playersMapOf(state.rivalOf(team)), c)).filter(Objects::nonNull).toList());
    }

    private Player random(List<Player> list) {
        if (list.isEmpty()) return null;
        return list.get(Math.min(list.size() - 1, (int) (Math.random() * list.size())));
    }

    private Integer[] oppositeCoordinates(Integer[] coordinates) {
        return new Integer[] {7 - coordinates[0], coordinates[1]};
    }

    private List<Integer[]> aroundCoordinatesOf(Integer[] coordinates) {
        List<Integer[]> aroundCoordinates = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            if (coordinates[0] + i < 0 || coordinates[0] + i > 7) continue;
            for (int j = -1; j <= 1; j++) {
                if (coordinates[1] + j < 0 || coordinates[1] + j > 4) continue;
                aroundCoordinates.add(new Integer[]{coordinates[0] + i, coordinates[1] + j});
            }
        }
        return aroundCoordinates;
    }
}
