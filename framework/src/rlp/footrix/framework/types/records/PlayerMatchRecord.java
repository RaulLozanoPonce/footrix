package rlp.footrix.framework.types.records;

import java.time.Instant;

public record PlayerMatchRecord(String player, String team, String competition, int season, Instant date,
                                Integer enterMinute, Integer exitMinute, int maxMinutes, Double score, boolean injured,
                                boolean expelled, int goals, int assists, int yellowCards, int redCards, double preEnergy) {

    public int playedMinutes() {
        if (enterMinute == null || exitMinute == null) return 0;
        return exitMinute - enterMinute;
    }

    public double playedMinutesPercent() {
        if (maxMinutes == 0) return 0;
        return playedMinutes() / (double) maxMinutes;
    }

    public Double playedAvailableMinutesPercent() {
        if (maxMinutes == 0) return null;
        return playedMinutes() / (double) maxMinutes;
    }
}
