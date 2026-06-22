package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;

public class TrainEvent extends Event {
    private String teamId;
    private TrainType type;
    private int minutes;

    public String teamId() {
        return teamId;
    }

    public TrainEvent teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public TrainType type() {
        return type;
    }

    public TrainEvent type(TrainType type) {
        this.type = type;
        return this;
    }

    public int minutes() {
        return minutes;
    }

    public TrainEvent minutes(int minutes) {
        this.minutes = minutes;
        return this;
    }

    public enum TrainType {
        Tactic(1), Technique(2), Physic(5);

        private final int intensity;

        TrainType(int intensity) {
            this.intensity = intensity;
        }

        public int intensity() {
            return intensity;
        }
    }
}
