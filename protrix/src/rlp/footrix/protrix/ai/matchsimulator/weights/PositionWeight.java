package rlp.footrix.protrix.ai.matchsimulator.weights;

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
        //TODO MEJORAR PORQUE LOS GOLEADORES NO REPRESENTAN
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

    public static double bonusOfGoal(Position position) {
        return switch (position.id()) {
            case "PT" -> 0.84;
            case "CT" -> 0.42;
            case "CAR" -> 0.42;
            case "LAT" -> 0.42;
            case "CCD" -> 0.49;
            case "CC" -> 0.56;
            case "MP" -> 0.63;
            case "VOL" -> 0.56;
            case "EXT" -> 0.7;
            case "SS" -> 0.7;
            case "DL" -> 0.7;
            default -> 0;
        };
    }

    public static double bonusOfAssist(Position position) {
        return switch (position.id()) {
            case "PT" -> 0.3;
            case "CT" -> 0.4;
            case "CAR" -> 0.5;
            case "LAT" -> 0.5;
            case "CCD" -> 0.6;
            case "CC" -> 0.6;
            case "MP" -> 0.6;
            case "VOL" -> 0.6;
            case "EXT" -> 0.5;
            case "SS" -> 0.5;
            case "DL" -> 0.5;
            default -> 0;
        };
    }

    public static double bonusOfCleanSheet(Position position) {
        return switch (position.id()) {
            case "PT" -> 0.8;
            case "CT" -> 0.4;
            case "CAR" -> 0.35;
            case "LAT" -> 0.3;
            case "CCD" -> 0.25;
            case "CC" -> 0.15;
            case "MP" -> 0;
            case "VOL" -> 0.2;
            case "EXT" -> 0;
            case "SS" -> 0;
            case "DL" -> 0;
            default -> 0;
        };
    }
}
