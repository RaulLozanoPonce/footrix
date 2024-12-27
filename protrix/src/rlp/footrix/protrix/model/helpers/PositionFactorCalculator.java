package rlp.footrix.protrix.model.helpers;

import rlp.footrix.framework.types.player.Position;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PositionFactorCalculator {
    public static final Map<Position, Double[]> Factors = factors();

    private static Map<Position, Double[]> factors() {
        Map<Position, Double[]> factors = new HashMap<>();
        factors.put(Position.PT, new Double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        factors.put(Position.CT, new Double[]{0.0, 1.0, 0.6, 0.5, 0.2, 0.1, 0.0, 0.1, 0.1, 0.1, 0.0});
        factors.put(Position.CAR, new Double[]{0.0, 0.6, 1.0, 0.5, 0.3, 0.2, 0.1, 0.2, 0.4, 0.3, 0.0});
        factors.put(Position.LAT, new Double[]{0.0, 0.5, 0.5, 1.0, 0.5, 0.3, 0.1, 0.3, 0.3, 0.2, 0.0});
        factors.put(Position.CCD, new Double[]{0.0, 0.2, 0.3, 0.5, 1.0, 0.6, 0.3, 0.7, 0.2, 0.1, 0.0});
        factors.put(Position.CC, new Double[]{0.0, 0.1, 0.2, 0.3, 0.6, 1.0, 0.6, 0.8, 0.3, 0.2, 0.1});
        factors.put(Position.MP, new Double[]{0.0, 0.0, 0.1, 0.1, 0.3, 0.6, 1.0, 0.5, 0.5, 0.6, 0.4});
        factors.put(Position.VOL, new Double[]{0.0, 0.1, 0.2, 0.3, 0.7, 0.8, 0.5, 1.0, 0.3, 0.2, 0.1});
        factors.put(Position.EXT, new Double[]{0.0, 0.1, 0.4, 0.3, 0.2, 0.3, 0.5, 0.3, 1.0, 0.7, 0.6});
        factors.put(Position.SS, new Double[]{0.0, 0.1, 0.3, 0.2, 0.1, 0.2, 0.6, 0.2, 0.7, 1.0, 0.8});
        factors.put(Position.DL, new Double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.4, 0.1, 0.6, 0.8, 1.0});
        return factors;
    }

    public static double factor(Position from, Position to) {
        Double[] factors = Factors.get(from);
        return factors[Arrays.stream(Position.values()).toList().indexOf(to)];
    }
}
