package rlp.footrix.protrix.loader.lineups;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.Lineup;

import static rlp.footrix.protrix.model.Positions.*;

public class L4222 extends Lineup {

    private static Position[][] distribution = new Position[][] {
            {null, null, PT, null, null},
            {CAR, CT, null, CT, CAR},
            {null, CCD, null, CCD, null},
            {null, null, null, null, null},
            {null, MP, null, MP, null},
            {null, null, null, null, null},
            {null, DL, null, DL, null},
            {null, null, null, null, null}
    };

    public L4222() {
        super("4_2_2_2", distribution);
    }
}
