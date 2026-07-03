package rlp.footrix.pes6.types;

import rlp.footrix.framework.types.entities.player.Position;

import java.util.List;

public class Positions {
    public static Position PT = Position.of("PT");
    //public static Position LIB = Position.of("LIB");
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
        return List.of(PT, /*LIB,*/ CT, CAR, LAT, CCD, CC, MP, VOL, EXT, SS, DL);
    }

    public static Position of(String positionId) {
        return values().stream().filter(v -> v.id().equals(positionId)).findFirst().orElse(null);
    }

    public static int compare(Position p1, Position p2) {
        return Integer.compare(values().indexOf(p1), values().indexOf(p2));
    }
}
