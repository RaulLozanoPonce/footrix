package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

public class L4411 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, CCD, null, CCD, null},
            {null, null, null, null, null},
            {VOL, null, MP, null, VOL},
            {null, null, null, null, null},
            {null, null, DL, null, null},
            {null, null, null, null, null}
    };

    public L4411() {
        super("4_4_1_1", distribution);
    }
}
