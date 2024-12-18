package rlp.footrix.protrix;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.util.function.Function;

public class ProtrixApplication extends Application {

    public ProtrixApplication(FootrixConfiguration configuration, Function<MatchDefinition, MatchSimulator> matchSimulator) {
        super(configuration);
        addRules();
        add(matchSimulator);
    }

    private void addRules() {
        add("rule1", new TeamRule("competition", "season1", "phase", "group", list -> list));
    }
}
