package rlp.footrix.protrix.simulator.helpers;

import rlp.footrix.framework.types.player.Position;

import java.util.HashMap;
import java.util.Map;

public class PositionFactors {
    //PASS, DRIBBLE, SHOT
    private static final Map<Position, Double[]> actionProbability = new HashMap<>() {{
        put(Position.PT, new Double[]{0.9878, 0.0122, 0.0});
        put(Position.CT, new Double[]{0.9402, 0.0427, 0.0171});
        put(Position.CAR, new Double[]{0.8979, 0.0793, 0.0228});
        put(Position.LAT, new Double[]{0.8812, 0.0732, 0.0456});
        put(Position.CCD, new Double[]{0.9284, 0.0488, 0.0228});
        put(Position.CC, new Double[]{0.9117, 0.0427, 0.0456});
        put(Position.MP, new Double[]{0.8889, 0.0427, 0.0684});
        put(Position.VOL, new Double[]{0.8751, 0.0793, 0.0456});
        put(Position.EXT, new Double[]{0.8112, 0.0976, 0.0912});
        put(Position.SS, new Double[]{0.8144, 0.0488, 0.1368});
        put(Position.DL, new Double[]{0.7806, 0.0427, 0.1767});
    }};

    private static final Map<Position, Map<Position, Double>> passProbability = new HashMap<>() {{
        put(Position.PT, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.6);
            put(Position.CAR, 0.3);
            put(Position.LAT, 0.3);
            put(Position.CCD, 0.1);
            put(Position.CC, 0.002);
            put(Position.MP, 0.002);
            put(Position.VOL, 0.002);
            put(Position.EXT, 0.002);
            put(Position.SS, 0.002);
            put(Position.DL, 0.002);
        }});
        put(Position.CT, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.4);
            put(Position.CAR, 0.35);
            put(Position.LAT, 0.35);
            put(Position.CCD, 0.2);
            put(Position.CC, 0.0);
            put(Position.MP, 0.0);
            put(Position.VOL, 0.05);
            put(Position.EXT, 0.05);
            put(Position.SS, 0.05);
            put(Position.DL, 0.05);
        }});
        put(Position.CAR, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.2);
            put(Position.CAR, 0.0);
            put(Position.LAT, 0.0);
            put(Position.CCD, 0.4);
            put(Position.CC, 0.4);
            put(Position.MP, 0.0);
            put(Position.VOL, 0.3);
            put(Position.EXT, 0.3);
            put(Position.SS, 0.1);
            put(Position.DL, 0.1);
        }});
        put(Position.LAT, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.2);
            put(Position.CAR, 0.0);
            put(Position.LAT, 0.0);
            put(Position.CCD, 0.4);
            put(Position.CC, 0.4);
            put(Position.MP, 0.0);
            put(Position.VOL, 0.3);
            put(Position.EXT, 0.3);
            put(Position.SS, 0.1);
            put(Position.DL, 0.1);
        }});
        put(Position.CCD, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.3);
            put(Position.CAR, 0.15);
            put(Position.LAT, 0.15);
            put(Position.CCD, 0.0);
            put(Position.CC, 0.4);
            put(Position.MP, 0.15);
            put(Position.VOL, 0.15);
            put(Position.EXT, 0.15);
            put(Position.SS, 0.15);
            put(Position.DL, 0.15);
        }});
        put(Position.CC, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.2);
            put(Position.CAR, 0.0);
            put(Position.LAT, 0.0);
            put(Position.CCD, 0.2);
            put(Position.CC, 0.0);
            put(Position.MP, 0.25);
            put(Position.VOL, 0.35);
            put(Position.EXT, 0.35);
            put(Position.SS, 0.2);
            put(Position.DL, 0.2);
        }});
        put(Position.MP, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.1);
            put(Position.CAR, 0.0);
            put(Position.LAT, 0.0);
            put(Position.CCD, 0.0);
            put(Position.CC, 0.2);
            put(Position.MP, 0.0);
            put(Position.VOL, 0.3);
            put(Position.EXT, 0.3);
            put(Position.SS, 0.4);
            put(Position.DL, 0.4);
        }});
        put(Position.VOL, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.0);
            put(Position.CAR, 0.1);
            put(Position.LAT, 0.1);
            put(Position.CCD, 0.3);
            put(Position.CC, 0.3);
            put(Position.MP, 0.2);
            put(Position.VOL, 0.0);
            put(Position.EXT, 0.3);
            put(Position.SS, 0.4);
            put(Position.DL, 0.4);
        }});
        put(Position.EXT, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.0);
            put(Position.CAR, 0.1);
            put(Position.LAT, 0.1);
            put(Position.CCD, 0.3);
            put(Position.CC, 0.3);
            put(Position.MP, 0.2);
            put(Position.VOL, 0.2);
            put(Position.EXT, 0.0);
            put(Position.SS, 0.4);
            put(Position.DL, 0.4);
        }});
        put(Position.SS, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.0);
            put(Position.CAR, 0.1);
            put(Position.LAT, 0.1);
            put(Position.CCD, 0.2);
            put(Position.CC, 0.2);
            put(Position.MP, 0.2);
            put(Position.VOL, 0.25);
            put(Position.EXT, 0.25);
            put(Position.SS, 0.25);
            put(Position.DL, 0.25);
        }});
        put(Position.DL, new HashMap<>() {{
            put(Position.PT, 0.0);
            put(Position.CT, 0.0);
            put(Position.CAR, 0.1);
            put(Position.LAT, 0.1);
            put(Position.CCD, 0.2);
            put(Position.CC, 0.2);
            put(Position.MP, 0.2);
            put(Position.VOL, 0.25);
            put(Position.EXT, 0.25);
            put(Position.SS, 0.25);
            put(Position.DL, 0.25);
        }});
    }};

    private static final Map<Position, Double> faultPercent = new HashMap<>() {{
        put(Position.PT, 0.17);  //TODO
        put(Position.CT, 1.0);
        put(Position.CAR, 1.0);
        put(Position.LAT, 1.0);
        put(Position.CCD, 1.0);
        put(Position.CC, 0.494);
        put(Position.MP, 1.0);
        put(Position.VOL, 1.0);
        put(Position.EXT, 0.138);
        put(Position.SS, 1.0);
        put(Position.DL, 0.171);
    }};

    //successfulDribbleOf, unsuccessfulDribbleOf, successfulDribbleCutOf, unsuccessfulDribbleCutOf, successfulPassOf, unsuccessfulPassOf,
    //successfulPassCutOf, unsuccessfulPassCutOf, shootOffTargetOf, addShootInTargetSavedOf, goalOf, assistanceOf, faultCommitedOf
    //foulsReceivedOf, yellowCardOf, redCardOf
    private static final Map<Position, Double[]> points = Map.of(
            Position.PT, new Double[] {0.3, -0.2, 0.5, -0.1, 0.05, -0.1, 0.3, -0.1, null, 0.5, -1.0, 2.0, -0.3, 0.1, -0.5, -2.0},
            Position.CT, new Double[] {0.3, -0.2, 0.4, -0.2, 0.05, -0.1, 0.4, -0.2, -0.05, 0.2, 2.0, 1.5, -0.3, 0.1, -0.5, -2.0},
            Position.LAT, new Double[] {0.3, -0.2, 0.4, -0.2, 0.05, -0.1, 0.5, -0.1, -0.05, 0.2, 2.0, 1.5, -0.3, 0.1, -0.5, -2.0},
            Position.CAR, new Double[] {0.3, -0.2, 0.4, -0.2, 0.05, -0.1, 0.5, -0.1, -0.05, 0.2, 2.0, 1.5, -0.3, 0.1, -0.5, -2.0},
            Position.CCD, new Double[] {0.3, -0.2, 0.3, -0.2, 0.1, -0.2, 0.4, -0.1, -0.1, 0.3, 1.5, 2.0, -0.2, 0.2, -0.5, -2.0},
            Position.CC, new Double[] {0.3, -0.2, 0.3, -0.2, 0.1, -0.2, 0.4, -0.1, -0.1, 0.3, 1.5, 2.0, -0.2, 0.2, -0.5, -2.0},
            Position.MP, new Double[] {0.3, -0.2, 0.3, -0.2, 0.1, -0.2, 0.4, -0.1, -0.1, 0.3, 1.5, 2.0, -0.2, 0.2, -0.5, -2.0},
            Position.VOL, new Double[] {0.3, -0.2, 0.3, -0.2, 0.1, -0.2, 0.4, -0.1, -0.1, 0.3, 1.5, 2.0, -0.2, 0.2, -0.5, -2.0},
            Position.EXT, new Double[] {0.4, -0.3, 0.2, -0.1, 0.05, -0.2, 0.3, -0.1, -0.3, 0.5, 2.5, 1.5, -0.3, 0.3, -0.5, -2.0},
            //Position.SS, new Double[] {0.4, -0.3, 0.2, -0.1, 0.05, -0.2, 0.3, -0.1, -0.3, 0.5, 2.5, 1.5, -0.3, 0.3, -0.5, -2.0},  //TODO
            Position.DL, new Double[] {0.4, -0.3, 0.2, -0.1, 0.05, -0.2, 0.3, -0.1, -0.3, 0.5, 2.5, 1.5, -0.3, 0.3, -0.5, -2.0}
    );

    private static Map<Position, Double> fatigueFactor = new HashMap<>() {{
        put(Position.PT, 0.417);
        put(Position.CT, 0.583);
        put(Position.CAR, 0.917);
        put(Position.LAT, 1.0);
        put(Position.CCD, 0.833);
        put(Position.CC, 0.875);
        put(Position.MP, 0.75);
        put(Position.VOL, 0.958);
        put(Position.EXT, 0.917);
        put(Position.SS, 0.75);
        put(Position.DL, 0.708);
    }};

    private static Map<Integer, Double> substitutionPercent = new HashMap<>() {{
        put(45, 1.593593966);
        put(46, 1.706313131);
        put(47, 1.827005223);
        put(48, 1.956234191);
        put(49, 2.094603868);
        put(50, 2.242760804);
        put(51, 2.401397275);
        put(52, 2.571254529);
        put(53, 2.753126241);
        put(54, 2.947862225);
        put(55, 3.156372407);
        put(56, 3.379631072);
        put(57, 3.618681419);
        put(58, 3.874640437);
        put(59, 4.148704121);
        put(60, 4.014966986);
        put(61, 3.801883365);
        put(62, 3.596441063);
        put(63, 3.39864008);
        put(64, 3.208480414);
        put(65, 3.025962067);
        put(66, 2.851085039);
        put(67, 2.683849329);
        put(68, 2.524254937);
        put(69, 2.372301863);
        put(70, 2.227990108);
        put(71, 2.091319671);
        put(72, 1.962290553);
        put(73, 1.840902753);
        put(74, 1.727156271);
        put(75, 1.621051108);
        put(76, 1.522587263);
        put(77, 1.431764736);
        put(78, 1.348583527);
        put(79, 1.273043637);
        put(80, 1.205145066);
        put(81, 1.144887813);
        put(82, 1.092271878);
        put(83, 1.047297261);
        put(84, 1.009963963);
        put(85, 0.980271983);
        put(86, 0.958221321);
        put(87, 0.943811978);
        put(88, 0.937043953);
        put(89, 0.937917247);
        put(90, 0.946431859);
    }};

    public static Double passProbabilityOf(Position position) {
        return actionProbability.get(position)[0];
    }

    public static Double dribbleProbabilityOf(Position position) {
        return actionProbability.get(position)[1];
    }

    public static Double shotProbabilityOf(Position position) {
        return actionProbability.get(position)[2];
    }

    public static Double passProbabilityBetween(Position from, Position to) {
        return passProbability.get(from).get(to);
    }

    public static Double faultPercentOf(Position position) {
        return faultPercent.get(position);
    }

    public static Double successfulDribbleOf(Position position) {
        return points.get(position)[0];
    }

    public static Double unsuccessfulDribbleOf(Position position) {
        return points.get(position)[1];
    }

    public static Double successfulDribbleCutOf(Position position) {
        return points.get(position)[2];
    }

    public static Double unsuccessfulDribbleCutOf(Position position) {
        return points.get(position)[3];
    }

    public static Double successfulPassOf(Position position) {
        return points.get(position)[4];
    }

    public static Double unsuccessfulPassOf(Position position) {
        return points.get(position)[5];
    }

    public static Double successfulPassCutOf(Position position) {
        return points.get(position)[6];
    }

    public static Double unsuccessfulPassCutOf(Position position) {
        return points.get(position)[7];
    }

    public static Double shootOffTargetOf(Position position) {
        return points.get(position)[8];
    }

    public static Double addShootInTargetSavedOf(Position position) {
        return points.get(position)[9];
    }

    public static Double goalOf(Position position) {
        return points.get(position)[10];
    }

    public static Double assistanceOf(Position position) {
        return points.get(position)[11];
    }

    public static Double faultCommitedOf(Position position) {
        return points.get(position)[12];
    }

    public static Double foulsReceivedOf(Position position) {
        return points.get(position)[13];
    }

    public static Double yellowCardOf(Position position) {
        return points.get(position)[14];
    }

    public static Double redCardOf(Position position) {
        return points.get(position)[15];
    }

    public static Double fatigueFactorOf(Position position) {
        return fatigueFactor.get(position);
    }

    public static Double substitutionPercentOf(int minute) {
        if (!substitutionPercent.containsKey(minute)) return 0.0;
        return substitutionPercent.get(minute);
    }
}
