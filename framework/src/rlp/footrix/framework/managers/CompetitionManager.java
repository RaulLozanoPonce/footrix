package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompetitionManager {
    private final Game game;
    private final EntityStore store;
    private final Map<String, CompetitionDefinition> definitions = new HashMap<>();

    public CompetitionManager(Game game, EntityStore store) {
        this.game = game;
        this.store = store;
    }

    public void add(CompetitionDefinition definition) {
        this.definitions.put(definition.id(), definition);
    }

    public void setupNewSeason() {
        definitions.values().forEach(d -> this.store.competition(new Competition(d), game.seasonNumber()));
    }

    public Competition get(String id) {
        return store.competition(id, game.seasonNumber());
    }

    public Competition get(String id, int season) {
        return store.competition(id, season);
    }

    public CompetitionDefinition definition(String id) {
        return definitions.get(id);
    }
}
