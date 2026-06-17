package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;

public class TrainEvent extends Event {
    private String teamId;
    private int minutes;

    public String teamId() {
        return teamId;
    }

    public TrainEvent teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public int minutes() {
        return minutes;
    }

    public TrainEvent minutes(int minutes) {
        this.minutes = minutes;
        return this;
    }
}
