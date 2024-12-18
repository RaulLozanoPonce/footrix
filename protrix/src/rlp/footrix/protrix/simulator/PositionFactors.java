package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Position;

import java.util.HashMap;
import java.util.Map;

public class PositionFactors {
    //PASS, DRIBBLE, SHOT
    private static final Map<Position, Double[]> actionProbability = new HashMap<>() {{
        put(Position.PT, new Double[]{0.98, 0.02, 0.0});
        put(Position.CT, new Double[]{0.9, 0.07, 0.03});
        put(Position.CAR, new Double[]{0.83, 0.13, 0.04});
        put(Position.LAT, new Double[]{0.80, 0.12, 0.08});
        put(Position.CCD, new Double[]{0.88, 0.08, 0.04});
        put(Position.CC, new Double[]{0.85, 0.07, 0.08});
        put(Position.MP, new Double[]{0.81, 0.07, 0.12});
        put(Position.VOL, new Double[]{0.79, 0.13, 0.08});
        put(Position.EXT, new Double[]{0.68, 0.16, 0.16});
        put(Position.SS, new Double[]{0.68, 0.08, 0.24});
        put(Position.DL, new Double[]{0.62, 0.07, 0.31});
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
        put(Position.PT, 0.005);
        put(Position.CT, 1.0);
        put(Position.CAR, 1.0);
        put(Position.LAT, 0.5);
        put(Position.CCD, 1.0);
        put(Position.CC, 0.5);
        put(Position.MP, 0.5);
        put(Position.VOL, 0.5);
        put(Position.EXT, 0.13);
        put(Position.SS, 0.5);
        put(Position.DL, 0.17);
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
        put(Position.PT, 0.3);
        put(Position.CT, 0.7);
        put(Position.CAR, 1.225);
        put(Position.LAT, 1.15);
        put(Position.CCD, 0.925);
        put(Position.CC, 1.0);
        put(Position.MP, 1.0);
        put(Position.VOL, 1.075);
        put(Position.EXT, 1.3);
        put(Position.SS, 1.15);
        put(Position.DL, 1.0);
    }};

    private static Map<Integer, Double> substitutionPercent = new HashMap<>() {{
        put(1, 0.064883623);
        put(2, 0.069473015);
        put(3, 0.074387027);
        put(4, 0.079648621);
        put(5, 0.085282381);
        put(6, 0.091314631);
        put(7, 0.09777356);
        put(8, 0.104689345);
        put(9, 0.112094303);
        put(10, 0.120023032);
        put(11, 0.128512583);
        put(12, 0.137602621);
        put(13, 0.147335623);
        put(14, 0.157757066);
        put(15, 0.168915645);
        put(16, 0.180863501);
        put(17, 0.19365646);
        put(18, 0.207354299);
        put(19, 0.222021024);
        put(20, 0.237725165);
        put(21, 0.254540102);
        put(22, 0.272544404);
        put(23, 0.291822199);
        put(24, 0.312463564);
        put(25, 0.334564947);
        put(26, 0.358229621);
        put(27, 0.383568161);
        put(28, 0.410698963);
        put(29, 0.439748799);
        put(30, 0.470853408);
        put(31, 0.504158129);
        put(32, 0.539818583);
        put(33, 0.578001395);
        put(34, 0.61888498);
        put(35, 0.662660371);
        put(36, 0.709532111);
        put(37, 0.759719216);
        put(38, 0.813456189);
        put(39, 0.870994121);
        put(40, 0.932601865);
        put(41, 0.99856729);
        put(42, 1.069198626);
        put(43, 1.144825906);
        put(44, 1.225802505);
        put(45, 1.312506795);
        put(46, 1.405343912);
        put(47, 1.504747647);
        put(48, 1.611182473);
        put(49, 1.72514572);
        put(50, 1.847169892);
        put(51, 1.977825161);
        put(52, 2.117722025);
        put(53, 2.26751417);
        put(54, 2.427901513);
        put(55, 2.599633483);
        put(56, 2.783512514);
        put(57, 2.980397801);
        put(58, 3.191209311);
        put(59, 3.416932083);
        put(60, 3.306784264);
        put(61, 3.131285545);
        put(62, 2.962080326);
        put(63, 2.799168605);
        put(64, 2.642550383);
        put(65, 2.492225661);
        put(66, 2.348194438);
        put(67, 2.210456714);
        put(68, 2.079012489);
        put(69, 1.953861763);
        put(70, 1.835004536);
        put(71, 1.722440809);
        put(72, 1.61617058);
        put(73, 1.516193851);
        put(74, 1.422510621);
        put(75, 1.33512089);
        put(76, 1.254024658);
        put(77, 1.179221925);
        put(78, 1.110712692);
        put(79, 1.048496957);
        put(80, 0.992574722);
        put(81, 0.942945986);
        put(82, 0.899610749);
        put(83, 0.862569011);
        put(84, 0.831820773);
        put(85, 0.807366033);
        put(86, 0.789204793);
        put(87, 0.777337051);
        put(88, 0.771762809);
        put(89, 0.772482066);
        put(90, 0.779494823);
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
        return substitutionPercent.get(minute);
    }
}
