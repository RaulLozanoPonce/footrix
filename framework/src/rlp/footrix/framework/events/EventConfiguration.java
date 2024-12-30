package rlp.footrix.framework.events;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.TeamRankingHandler;
import rlp.footrix.framework.stores.match.MatchMemoryStore;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.var.Var;

import java.time.Instant;

public interface EventConfiguration {
    Game game();
    CompetitionManager competitionManager();
    RulesManager rulesManager();
    MatchSimulator matchSimulator(MatchDefinition definition, Instant date);
    EventManager eventManager();
    MatchMemoryStore matchStore();
    TeamManager teamManager();
    PlayerManager playerManager();
    TimeManager timeManager();
    TeamRankingHandler teamRankingHandler();
    LineupsManager lineupsManager();
}
