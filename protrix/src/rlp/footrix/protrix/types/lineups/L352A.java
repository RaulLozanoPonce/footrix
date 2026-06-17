package rlp.footrix.protrix.types.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.protrix.types.Positions.*;

public class L352A extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {null, CT, CT, CT, null},
            {null, null, CCD, null, null},
            {LAT, CC, null, CC, LAT},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, DL, null, DL, null},
            {null, null, null, null, null}
    };

    public L352A() {
        super("3_5_2_A", distribution);
    }
}
