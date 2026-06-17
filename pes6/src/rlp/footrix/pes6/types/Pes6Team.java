package rlp.footrix.pes6.types;

import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.team.Lineup;
import rlp.footrix.framework.types.entities.team.Team;

public class Pes6Team extends Team {

    private Lineup lineup;

    public Pes6Team(TeamDefinition definition) {
        super(definition);
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double midfield() {
        return 0;
    }

    @Override
    public double defense() {
        return 0;
    }
}
