package rlp.footrix.protrix;


import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.entities.SeasonReference;
import rlp.footrix.protrix.loader.lineups.*;

public class ProtrixApplication extends Application {

    public ProtrixApplication(FootrixConfiguration configuration) {
        super(configuration);
        addLineups();
        addRules();
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
        add("ESP-1-RULE", new TeamRule("ESP-1", SeasonReference.Last, 0, 0, list -> list));
    }
}
