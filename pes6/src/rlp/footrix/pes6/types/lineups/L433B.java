package rlp.footrix.pes6.types.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.pes6.types.Positions.*;

public class L433B extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, null, null, null, null},
            {null, CC, CC, CC, null},
            {null, null, null, null, null},
            {EXT, null, null, null, EXT},
            {null, null, DL, null, null},
            {null, null, null, null, null}
    };

    public L433B() {
        super("4_3_3_B", distribution);
    }
}
