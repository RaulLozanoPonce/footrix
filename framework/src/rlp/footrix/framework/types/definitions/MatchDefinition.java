package rlp.footrix.framework.types.definitions;

import java.time.Instant;

public record MatchDefinition(Instant date, String local, String visitant, String competition, String season, int phase, int group, String matchDay) { }
