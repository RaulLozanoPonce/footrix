package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;

import static rlp.footrix.framework.types.player.Position.*;

public class L4123 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, null, CCD, null, null},
            {null, null, null, null, null},
            {null, MP, null, MP, null},
            {null, null, null, null, null},
            {EXT, null, DL, null, EXT},
            {null, null, null, null, null}
    };

    public L4123() {
        super("4_1_2_3", distribution);
    }
}
