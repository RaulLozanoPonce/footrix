package rlp.footrix.pes6;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.pes6.types.lineups.*;

public abstract class Pes6Application extends Application {

    public Pes6Application(FootrixConfiguration configuration) {
        super(new Pes6GamePlatform(), configuration);
        addLineups();
    }

    private void addLineups() {
        add(new L352A());
        add(new L352B());
        //add(new L352A()); //TODO
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
}
