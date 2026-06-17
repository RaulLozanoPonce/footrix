package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;

import java.time.Instant;

public class ScheduledMatchEvent extends Event {
    private MatchDefinition definition;
    private Instant date;

    public MatchDefinition definition() {
        return definition;
    }

    public ScheduledMatchEvent definition(MatchDefinition definition) {
        this.definition = definition;
        return this;
    }

    public Instant date() {
        return date;
    }

    public ScheduledMatchEvent date(Instant date) {
        this.date = date;
        return this;
    }
}
