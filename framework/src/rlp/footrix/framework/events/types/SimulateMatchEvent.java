package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;

import java.time.Instant;

public class SimulateMatchEvent implements Event {
    private Instant ts;
    private MatchDefinition definition;

    public Instant ts() {
        return ts;
    }

    public SimulateMatchEvent ts(Instant ts) {
        this.ts = ts;
        return this;
    }

    public MatchDefinition definition() {
        return definition;
    }

    public SimulateMatchEvent definition(MatchDefinition definition) {
        this.definition = definition;
        return this;
    }
}
