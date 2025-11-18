package rlp.footrix.framework.types.records;

import java.time.Instant;

public record TeamMatchRecord(String team, String competition, int season, Instant date, int goalsFor, int goalsAgainst) {
    public int streak() {
        return Integer.compare(goalsFor, goalsAgainst);
    }

    public int points() {
        if (goalsFor > goalsAgainst) return 3;
        if (goalsAgainst > goalsFor) return 0;
        return 1;
    }
}
