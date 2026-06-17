package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;

import java.time.Instant;

public class NewDayEvent extends Event {
    private Instant date;

    public Instant date() {
        return date;
    }

    public NewDayEvent date(Instant date) {
        this.date = date;
        return this;
    }
}
