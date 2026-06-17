package rlp.footrix.pes6.types.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.pes6.types.Positions.*;

public class L5212 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, CT, CT, CAR},
            {null, CCD, null, CCD, null},
            {null, null, null, null, null},
            {null, null, MP, null, null},
            {null, null, null, null, null},
            {null, DL, null, DL, null},
            {null, null, null, null, null}
    };

    public L5212() {
        super("5_2_1_2", distribution);
    }
}
