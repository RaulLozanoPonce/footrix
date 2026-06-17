package rlp.footrix.framework.events;

import java.time.Instant;

public abstract class Event {
    private Instant ts;

    public Instant ts() {
        return ts;
    }

    public Event ts(Instant ts) {
        this.ts = ts;
        return this;
    }
}
