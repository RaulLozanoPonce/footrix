package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

public class L442 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, CCD, null, CCD, null},
            {null, null, null, null, null},
            {VOL, null, null, null, VOL},
            {null, null, null, null, null},
            {null, DL, null, DL, null},
            {null, null, null, null, null}
    };

    public L442() {
        super("4_4_2", distribution);
    }
}
