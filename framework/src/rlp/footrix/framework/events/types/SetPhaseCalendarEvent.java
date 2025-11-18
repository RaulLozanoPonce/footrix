package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.time.Instant;

public class SetPhaseCalendarEvent implements Event {
    private Competition competition;
    private SeasonReference season;
    private int nPhase;
    private Instant ts;

    public Competition competition() {
        return competition;
    }

    public SetPhaseCalendarEvent competition(Competition competition) {
        this.competition = competition;
        return this;
    }

    public SeasonReference season() {
        return season;
    }

    public SetPhaseCalendarEvent season(SeasonReference season) {
        this.season = season;
        return this;
    }

    public int nPhase() {
        return nPhase;
    }

    public SetPhaseCalendarEvent nPhase(int nPhase) {
        this.nPhase = nPhase;
        return this;
    }

    public Instant ts() {
        return ts;
    }

    public SetPhaseCalendarEvent ts(Instant ts) {
        this.ts = ts;
        return this;
    }
}
