package rlp.footrix.protrix.model;

import rlp.footrix.framework.types.definitions.TeamDefinition;
import rlp.footrix.framework.types.team.Lineup;
import rlp.footrix.framework.types.team.Team;

public class ProtrixTeam extends Team {

    private Lineup lineup;

    public ProtrixTeam(TeamDefinition definition) {
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
