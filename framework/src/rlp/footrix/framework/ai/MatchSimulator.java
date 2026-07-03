package rlp.footrix.framework.ai;

import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.team.PlayersLineup;

import java.time.Instant;

public interface MatchSimulator {
    Match simulate(MatchDefinition definition, Instant date, PlayersLineup localLineup, PlayersLineup visitantLineup);
}
