package rlp.footrix.framework.managers;

import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.Game;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamManager {
    private final Game game;
    private final EntityStore store;
    private final Map<String, TeamDefinition> teams = new HashMap<>();

    public TeamManager(Game game, EntityStore store) {
        this.game = game;
        this.store = store;
    }

    public Team get(String id) {
        return store.team(id);
    }

    public void add(Team team) {
        this.teams.put(team.definition().id(), team.definition());
        this.store.team(team);
    }

    public List<TeamDefinition> teamDefinitions() {
        return new ArrayList<>(this.teams.values());
    }

    public List<String> ids() {
        return this.teams.values().stream().map(TeamDefinition::id).toList();
    }
}
