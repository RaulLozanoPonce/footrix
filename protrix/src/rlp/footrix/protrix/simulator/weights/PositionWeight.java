package rlp.footrix.protrix.simulator.weights;

import rlp.footrix.framework.types.entities.player.Position;

public class PositionWeight {

    public static double attackWeight(Position position) {
        //TODO MEJORAR
        return switch (position.id()) {
            case "PT" -> 0;
            case "CT" -> 0;
            case "CAR" -> 0;
            case "LAT" -> 0.2;
            case "CCD" -> 0.1;
            case "CC" -> 0.2;
            case "MP" -> 0.3;
            case "VOL" -> 0.3;
            case "EXT" -> 0.4;
            case "SS" -> 0.4;
            case "DL" -> 0.4;
            default -> 0;
        };
    }

    public static double defenseWeight(Position position) {
        //TODO MEJORAR
        return switch (position.id()) {
            case "PT" -> 0.1;
            case "CT" -> 0.4;
            case "CAR" -> 0.2;
            case "LAT" -> 0.2;
            case "CCD" -> 0.3;
            case "CC" -> 0.1;
            case "MP" -> 0;
            case "VOL" -> 0;
            case "EXT" -> 0;
            case "SS" -> 0;
            case "DL" -> 0;
            default -> 0;
        };
    }

    public static double goal(Position position) {
        //TODO MEJORAR
        return switch (position.id()) {
            case "PT" -> 0.05;
            case "CT" -> 0.25;
            case "CAR" -> 0.35;
            case "LAT" -> 0.6;
            case "CCD" -> 0.4;
            case "CC" -> 0.6;
            case "MP" -> 0.85;
            case "VOL" -> 0.85;
            case "EXT" -> 0.9;
            case "SS" -> 0.85;
            case "DL" -> 1;
            default -> 0.5;
        };
    }
}
