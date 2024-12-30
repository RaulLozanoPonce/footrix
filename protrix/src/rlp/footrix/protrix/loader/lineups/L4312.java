package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

public class L4312 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, null, CCD, null, null},
            {null, CC, null, CC, null},
            {null, null, MP, null, null},
            {null, null, null, null, null},
            {null, DL, null, DL, null},
            {null, null, null, null, null}
    };

    public L4312() {
        super("4_3_1_2", distribution);
    }
}
