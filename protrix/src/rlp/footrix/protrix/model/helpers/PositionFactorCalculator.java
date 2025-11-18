package rlp.footrix.protrix.model.helpers;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.model.Positions;

import java.util.HashMap;
import java.util.Map;

public class PositionFactorCalculator {
    public static final Map<Position, Double[]> Factors = factors();

    private static Map<Position, Double[]> factors() {
        Map<Position, Double[]> factors = new HashMap<>();
        factors.put(Positions.PT, new Double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        factors.put(Positions.CT, new Double[]{0.0, 1.0, 0.6, 0.5, 0.2, 0.1, 0.0, 0.1, 0.1, 0.1, 0.0});
        factors.put(Positions.CAR, new Double[]{0.0, 0.6, 1.0, 0.5, 0.3, 0.2, 0.1, 0.2, 0.4, 0.3, 0.0});
        factors.put(Positions.LAT, new Double[]{0.0, 0.5, 0.5, 1.0, 0.5, 0.3, 0.1, 0.3, 0.3, 0.2, 0.0});
        factors.put(Positions.CCD, new Double[]{0.0, 0.2, 0.3, 0.5, 1.0, 0.6, 0.3, 0.7, 0.2, 0.1, 0.0});
        factors.put(Positions.CC, new Double[]{0.0, 0.1, 0.2, 0.3, 0.6, 1.0, 0.6, 0.8, 0.3, 0.2, 0.1});
        factors.put(Positions.MP, new Double[]{0.0, 0.0, 0.1, 0.1, 0.3, 0.6, 1.0, 0.5, 0.5, 0.6, 0.4});
        factors.put(Positions.VOL, new Double[]{0.0, 0.1, 0.2, 0.3, 0.7, 0.8, 0.5, 1.0, 0.3, 0.2, 0.1});
        factors.put(Positions.EXT, new Double[]{0.0, 0.1, 0.4, 0.3, 0.2, 0.3, 0.5, 0.3, 1.0, 0.7, 0.6});
        factors.put(Positions.SS, new Double[]{0.0, 0.1, 0.3, 0.2, 0.1, 0.2, 0.6, 0.2, 0.7, 1.0, 0.8});
        factors.put(Positions.DL, new Double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.4, 0.1, 0.6, 0.8, 1.0});
        return factors;
    }

    public static double factor(Position from, Position to) {
        Double[] factors = Factors.get(from);
        return factors[Positions.values().indexOf(to)];
    }
}
