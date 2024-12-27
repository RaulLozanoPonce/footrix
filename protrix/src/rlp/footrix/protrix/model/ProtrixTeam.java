package rlp.footrix.protrix.model;

import rlp.footrix.framework.types.team.Lineup;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.types.definitions.TeamDefinition;

import static rlp.footrix.framework.types.player.Position.*;

public class ProtrixTeam extends Team {

    private Lineup lineup;

    public ProtrixTeam(TeamDefinition definition) {
        super(definition, new Lineup("4-3-3", distribution()));
    }

    private static Position[][] distribution() {
        return new Position[][] {
                {null, null, PT, null, null},
                {CAR, CT, null, CT, CAR},
                {null, null, CCD, null, null},
                {null, CC, null, CC, null},
                {null, null, null, null, null},
                {EXT, null, null, null, EXT},
                {null, null, DL, null, null},
                {null, null, null, null, null}
        };
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
