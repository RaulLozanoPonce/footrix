package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

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
