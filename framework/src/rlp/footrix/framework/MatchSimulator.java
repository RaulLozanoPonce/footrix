package rlp.footrix.framework;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.PlayersLineup;

public interface MatchSimulator {
    Match simulate(PlayersLineup localPlayersLineup, PlayersLineup visitantPlayersLineup);
}
