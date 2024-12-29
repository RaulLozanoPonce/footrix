package rlp.footrix.framework;

import rlp.footrix.framework.types.SeasonReference;

import java.time.Instant;
import java.util.function.Function;

public class Game {

    private Instant date;
    private int season;
    private Function<Integer, String> seasonProvider;

    public Instant date() {
        return date;
    }

    public Game date(Instant date) {
        this.date = date;
        return this;
    }

    public String season() {
        return seasonProvider.apply(season);
    }

    public String season(SeasonReference reference) {
        return seasonProvider.apply(seasonNumber(reference));
    }

    public int seasonNumber() {
        return season;
    }

    private Integer seasonNumber(SeasonReference reference) {
        if (reference == SeasonReference.Last) return season - 1;
        if (reference == SeasonReference.Next) return season + 1;
        return season;
    }

    public Game initSeason(int season) {
        this.season = season;
        return this;
    }

    public Game seasonProvider(Function<Integer, String> seasonProvider) {
        this.seasonProvider = seasonProvider;
        return this;
    }
}
