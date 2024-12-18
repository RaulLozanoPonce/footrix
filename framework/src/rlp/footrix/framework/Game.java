package rlp.footrix.framework;

import java.time.Instant;

public class Game {

    private Instant date;
    private String season;

    public String season() {
        return season;
    }

    public Instant date() {
        return date;
    }

    public Game date(Instant date) {
        this.date = date;
        return this;
    }

    public Game season(String season) {
        this.season = season;
        return this;
    }
}
