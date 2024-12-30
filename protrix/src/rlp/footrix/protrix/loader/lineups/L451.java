package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

public class L451 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, null, CCD, null, null},
            {null, CC, null, CC, null},
            {VOL, null, null, null, VOL},
            {null, null, null, null, null},
            {null, null, DL, null, null},
            {null, null, null, null, null}
    };

    public L451() {
        super("4_5_1", distribution);
    }
}
