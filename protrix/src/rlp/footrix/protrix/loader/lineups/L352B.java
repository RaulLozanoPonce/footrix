package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.protrix.model.Positions.*;

public class L352B extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {null, CT, CT, CT, null},
            {null, null, CCD, null, null},
            {LAT, CC, null, CC, LAT},
            {null, null, null, null, null},
            {null, SS, null, null, null},
            {null, null, null, DL, null},
            {null, null, null, null, null}
    };

    public L352B() {
        super("3_5_2_B", distribution);
    }
}
