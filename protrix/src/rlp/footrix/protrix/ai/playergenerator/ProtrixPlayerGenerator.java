package rlp.footrix.protrix.ai.playergenerator;

import rlp.footrix.framework.ai.PlayerGenerator;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.protrix.ai.playergenerator.position.*;

import java.time.Instant;
import java.util.List;

public class ProtrixPlayerGenerator implements PlayerGenerator {

    @Override
    public Pes6Player generate(Instant now) {
        Position mainPosition = position();
        if (mainPosition.equals(Positions.PT)) return new PtCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.CT)) return new CtCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.CAR) || mainPosition.equals(Positions.LAT)) return new CarCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.CCD)) return new CcdCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.CC)) return new CcCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.MP)) return new MpCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.VOL)) return new VolCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.SS)) return new SsCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.EXT)) return new ExtCreator(60, 10).generate(now);
        if (mainPosition.equals(Positions.DL)) return new DlCreator(60, 10).generate(now);
        return null;
    }

    private Position position() {
        //TODO NO ES AL AZAR, HAY MÁS PROBABILIDADES DE QUE SALGA X POSICION
        List<Position> positions = Positions.values();
        return positions.get(Math.min((int) (Math.random() * positions.size()), positions.size() - 1));
    }
}
