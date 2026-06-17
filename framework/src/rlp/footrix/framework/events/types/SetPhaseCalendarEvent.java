package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.time.Instant;

public class SetPhaseCalendarEvent extends Event {
    private String competitionId;
    private SeasonReference season;
    private int nPhase;
    private Instant executionDate;

    public String competitionId() {
        return competitionId;
    }

    public SetPhaseCalendarEvent competitionId(String competitionId) {
        this.competitionId = competitionId;
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

    public Instant executionDate() {
        return executionDate;
    }

    public SetPhaseCalendarEvent executionDate(Instant executionDate) {
        this.executionDate = executionDate;
        return this;
    }
}
