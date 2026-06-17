package rlp.footrix.framework.events.types;

import rlp.footrix.framework.events.Event;

public class PlayedMatchEvent extends Event {
    private String matchId;

    public String matchId() {
        return matchId;
    }

    public PlayedMatchEvent matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }
}
