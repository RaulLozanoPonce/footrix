package rlp.footrix.protrix.types.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.protrix.types.Positions.*;

public class L4213 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, CCD, null, CCD, null},
            {null, null, null, null, null},
            {null, null, MP, null, null},
            {EXT, null, null, null, EXT},
            {null, null, DL, null, null},
            {null, null, null, null, null}
    };

    public L4213() {
        super("4_2_1_3", distribution);
    }
}
