package rlp.footrix.framework.managers;

import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.Game;
import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {
    private final Game game;
    private final EntityStore store;
    private final Map<String, PlayerDefinition> players = new HashMap<>();

    public PlayerManager(Game game, EntityStore store) {
        this.game = game;
        this.store = store;
    }

    public Player get(String id) {
        return this.store.player(id);
    }

    public void add(Player player) {
        this.players.put(player.definition().id(), player.definition());
        this.store.player(player);
    }

    public List<Player> players() {
        return this.players.values().stream().map(this.store::player).toList();
    }
}
