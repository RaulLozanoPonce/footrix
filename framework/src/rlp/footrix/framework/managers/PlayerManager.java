package rlp.footrix.framework.managers;

import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerManager {

    private final Map<String, Player> players;

    public PlayerManager(List<Player> players) {
        this.players = players.stream().collect(Collectors.toMap(p -> p.definition().id(), p -> p));
    }

    public Player get(String id) {
        return players.get(id);
    }

    public List<Player> players() {
        return new ArrayList<>(players.values());
    }
}
