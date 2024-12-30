package rlp.footrix.protrix;


import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.utils.TriFunction;
import rlp.footrix.protrix.loader.lineups.*;

import java.time.Instant;

public class ProtrixApplication extends Application {

    public ProtrixApplication(FootrixConfiguration configuration, TriFunction<MatchDefinition, PhaseDefinition, Instant, MatchSimulator> matchSimulator) {
        super(configuration);
        addLineups();
        addRules();
        add(matchSimulator);
    }

    private void addLineups() {
        add(new L352A());
        add(new L352B());
        add(new L352A());
        add(new L433A());
        add(new L433B());
        add(new L442());
        add(new L451());
        add(new L4123());
        add(new L4213());
        add(new L4222());
        add(new L4312());
        add(new L4411());
        add(new L5212());
    }

    private void addRules() {
        add("rule1", new TeamRule("competition", "season1", "phase", "group", list -> list));   //TODO
    }
}
