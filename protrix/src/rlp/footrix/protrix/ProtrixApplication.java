package rlp.footrix.protrix;


import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.utils.CuatriFunction;
import rlp.footrix.framework.var.Var;

import java.time.Instant;

public class ProtrixApplication extends Application {

    public ProtrixApplication(FootrixConfiguration configuration, CuatriFunction<MatchDefinition, PhaseDefinition, Instant, Var, MatchSimulator> matchSimulator) {
        super(configuration);
        addRules();
        add(matchSimulator);
    }

    private void addRules() {
        add("rule1", new TeamRule("competition", "season1", "phase", "group", list -> list));   //TODO
    }
}
