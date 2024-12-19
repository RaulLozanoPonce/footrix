package rlp.footrix.framework.events;

import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.MatchMemoryStore;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.var.Var;

public interface EventConfiguration {
    CompetitionManager competitionManager();
    RulesManager rulesManager();
    MatchSimulator matchSimulator(MatchDefinition definition);
    EventManager eventManager();
    MatchMemoryStore matchStore();
    TeamManager teamManager();
    PlayerManager playerManager();
    TimeManager timeManager();
    Var var();
}
