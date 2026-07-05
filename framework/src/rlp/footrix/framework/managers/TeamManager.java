package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamManager {
    private final Game game;
    private final EntityStore store;
    private final Map<String, TeamDefinition> definitions = new HashMap<>();

    public TeamManager(Game game, EntityStore store) {
        this.game = game;
        this.store = store;
    }

    public void add(Team team) {
        this.definitions.put(team.definition().id(), team.definition());
        this.store.team(team);
    }

    public Team get(String id) {
        return store.team(id);
    }

    public TeamDefinition definition(String id) {
        return definitions.get(id);
    }

    public List<Team> teams() {
        return definitions.keySet().stream().map(store::team).toList();
    }

    public List<TeamDefinition> definitions() {
        return new ArrayList<>(this.definitions.values());
    }

    @Deprecated
    public List<String> ids() {
        return this.definitions.values().stream().map(TeamDefinition::id).toList();
    }
}
