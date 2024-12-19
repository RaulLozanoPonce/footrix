package rlp.footrix.framework.events;

import java.time.Instant;

public abstract class Event {

    protected final Instant ts;
    protected EventConfiguration configuration;

    protected Event(Instant ts) {
        this.ts = ts;
    }

    public Instant ts() {
        return ts;
    }

    public Event with(EventConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public abstract void execute();

    public boolean preconditions() {
        return true;
    }

    public Event setup() {
        return this;
    }
}
