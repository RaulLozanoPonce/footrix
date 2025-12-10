package rlp.footrix.protrix.model;

import rlp.footrix.framework.types.entities.player.Position;

import java.util.List;

public class Positions {
    public static Position PT = Position.of("PT");
    public static Position CT = Position.of("CT");
    public static Position CAR = Position.of("CAR");
    public static Position LAT = Position.of("LAT");
    public static Position CCD = Position.of("CCD");
    public static Position CC = Position.of("CC");
    public static Position MP = Position.of("MP");
    public static Position VOL = Position.of("VOL");
    public static Position EXT = Position.of("EXT");
    public static Position SS = Position.of("SS");
    public static Position DL = Position.of("DL");

    public static List<Position> values() {
        return List.of(PT, CT, CAR, LAT, CCD, CC, MP, VOL, EXT, SS, DL);
    }

    public static Position of(String positionId) {
        return values().stream().filter(v -> v.id().equals(positionId)).findFirst().orElse(null);
    }
}
