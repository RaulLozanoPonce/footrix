package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;

public class PlayMatchEvent extends Event {
    private MatchDefinition definition;

    public MatchDefinition definition() {
        return definition;
    }

    public PlayMatchEvent definition(MatchDefinition definition) {
        this.definition = definition;
        return this;
    }
}
