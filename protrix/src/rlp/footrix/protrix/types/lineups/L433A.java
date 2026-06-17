package rlp.footrix.protrix.types.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.protrix.types.Positions.*;

public class L433A extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, null, CCD, null, null},
            {null, CC, null, CC, null},
            {null, null, null, null, null},
            {EXT, null, null, null, EXT},
            {null, null, DL, null, null},
            {null, null, null, null, null}
    };

    public L433A() {
        super("4_3_3_A", distribution);
    }
}
