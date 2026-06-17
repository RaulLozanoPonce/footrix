package rlp.footrix.framework.types.records;

import java.time.Instant;

public record PlayerMinuteRecord(String matchId, String player, Instant date, int minute, double energy, double stamina) {
}
