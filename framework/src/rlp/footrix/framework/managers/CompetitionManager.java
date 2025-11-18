package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;

import java.util.ArrayList;
import java.util.List;

public class CompetitionManager {
    private final Game game;
    private final EntityStore store;
    private List<CompetitionDefinition> definitions = new ArrayList<>();

    public CompetitionManager(Game game, EntityStore store) {
        this.game = game;
        this.store = store;
    }

    public void setup(CompetitionDefinition definition) {
        this.definitions.add(definition);
    }

    public void setupNewSeason() {
        definitions.forEach(d -> this.store.competition(new Competition(d), game.seasonNumber()));
    }

    public Competition get(String id) {
        return store.competition(id, game.seasonNumber());
    }

    public Competition get(String id, int season) {
        return store.competition(id, season);
    }
}
