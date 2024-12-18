package rlp.footrix.protrix.model.helpers;

import rlp.footrix.framework.types.Position;
import rlp.footrix.protrix.model.ProtrixPlayer;

import java.util.HashMap;
import java.util.Map;

public class OverallCalculator {
    public static final Map<Position, Double[]> Factors = factors();

    private static Map<Position, Double[]> factors() {
        Map<Position, Double[]> factors = new HashMap<>();
        factors.put(Position.PT, new Double[]{0.0, 0.1823, 0.1823, 0.0, 0.0, 0.0, 0.1823, 0.1823, 0.0, 0.0, 0.0, 0.1823, 0.0, 0.1823, 0.0, 0.0, 0.0, 0.1068, 0.0, 0.1823, 0.0, 0.1823, 0.1823, 0.1823, 0.0, -60.4896});
        factors.put(Position.CT, new Double[]{0.0, 0.1725, 0.0894, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.1725, 0.0781, 0.0, 0.0626, 0.1725, 0.0, 0.1725, -35.0471});
        factors.put(Position.CAR, new Double[]{0.0, 0.1379, 0.0, 0.0764, 0.0371, 0.0371, 0.1379, 0.0371, 0.0, 0.0371, 0.1379, 0.0, 0.1379, 0.1379, 0.0, 0.0, 0.0, 0.0, 0.0543, 0.0543, 0.1379, 0.1379, 0.0764, 0.0, 0.0, -31.003});
        factors.put(Position.LAT, new Double[]{0.06485, 0.06895, 0.0, 0.0726, 0.01855, 0.05585, 0.06895, 0.05585, 0.06485, 0.05585, 0.1338, 0.0, 0.1338, 0.1338, 0.04005, 0.0, 0.0, 0.0, 0.02715, 0.02715, 0.1338, 0.1338, 0.0382, 0.0, 0.06485, -33.0792});
        factors.put(Position.CCD, new Double[]{0.0, 0.1477, 0.0556, 0.0733, 0.0, 0.0, 0.1477, 0.0, 0.0, 0.0, 0.1477, 0.0, 0.1477, 0.0, 0.0, 0.1477, 0.0, 0.0, 0.037, 0.037, 0.1477, 0.1477, 0.0733, 0.0, 0.1477, -36.9984});
        factors.put(Position.CC, new Double[]{0.1204, 0.1204, 0.0, 0.0856, 0.0, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.1204, 0.0, 0.0, 0.0, 0.0, 0.1204, 0.1204, 0.0, 0.0, 0.1204, -34.2756});
        factors.put(Position.MP, new Double[]{0.1047, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1128, 0.1047, 0.1128, 0.1047, 0.0, 0.1047, 0.1047, 0.1047, 0.1047, 0.1047, 0.0, 0.0, 0.0, 0.1047, 0.1047, 0.0, 0.0, 0.1047, -32.1313});
        factors.put(Position.VOL, new Double[]{0.1297, 0.0, 0.0, 0.0688, 0.0, 0.0746, 0.0, 0.0746, 0.1297, 0.0746, 0.1297, 0.0, 0.1297, 0.1297, 0.0801, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1297, 0.1297, 0.0, 0.0, 0.1297, -35.1554});
        factors.put(Position.EXT, new Double[]{0.1101, 0.0, 0.0, 0.0388, 0.0, 0.0773, 0.0, 0.0773, 0.1101, 0.0773, 0.1101, 0.0, 0.1101, 0.1101, 0.1101, 0.1101, 0.0, 0.0, 0.0, 0.0, 0.1101, 0.1101, 0.0, 0.0, 0.1101, -32.1498});
        factors.put(Position.SS, new Double[]{0.11098, 0.0, 0.0, 0.00776, 0.0, 0.01546, 0.0, 0.07634, 0.11098, 0.07634, 0.0639, 0.04708, 0.0639, 0.11098, 0.11098, 0.11098, 0.04188, 0.0, 0.05636, 0.05636, 0.11098, 0.11098, 0.0, 0.0, 0.0639, -30.23536});
        factors.put(Position.DL, new Double[]{0.1177, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0394, 0.1177, 0.0394, 0.0, 0.1177, 0.0, 0.1177, 0.1177, 0.1177, 0.0, 0.0, 0.1409, 0.1409, 0.1177, 0.1177, 0.0, 0.0, 0.0, -27.3822});
        return factors;
    }

    public static double overall(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        overall += player.attack() * factors[0];
        overall += player.defense() * factors[1];
        overall += player.balance() * factors[2];
        overall += player.stamina() * factors[3];
        overall += player.speed() * factors[4];
        overall += player.acceleration() * factors[5];
        overall += player.response() * factors[6];
        overall += player.agility() * factors[7];
        overall += player.dribbleAccuracy() * factors[8];
        overall += player.dribbleSpeed() * factors[9];
        overall += player.shortPassAccuracy() * factors[10];
        overall += player.shortPassSpeed() * factors[11];
        overall += player.longPassAccuracy() * factors[12];
        overall += player.longPassSpeed() * factors[13];
        overall += player.shotAccuracy() * factors[14];
        overall += player.shotTechnique() * factors[15];
        overall += player.freeKickAccuracy() * factors[16];
        overall += player.swerve() * factors[17];
        overall += player.heading() * factors[18];
        overall += player.jump() * factors[19];
        overall += player.technique() * factors[20];
        overall += player.aggression() * factors[21];
        overall += player.mentality() * factors[22];
        overall += player.gkSkills() * factors[23];
        overall += player.teamWork() * factors[24];
        overall += factors[25];
        return overall * positionFactor(player, position);
    }

    public static double techniqueSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[15] + factors[17] + factors[20];
        overall += player.agility() * factors[7]/totalFactor;
        overall += player.shotTechnique() * factors[15]/totalFactor;
        overall += player.swerve() * factors[17]/totalFactor;
        overall += player.technique() * factors[20]/totalFactor;
        return overall;
    }

    public static double speedSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[4] + factors[5] + factors[7];
        if (totalFactor == 0) return (player.speed() + player.acceleration() + player.agility())/3.0;
        overall += player.speed() * factors[4]/totalFactor;
        overall += player.acceleration() * factors[5]/totalFactor;
        overall += player.agility() * factors[7]/totalFactor;
        return overall;
    }

    public static double physiqueSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[2] + factors[3] + factors[19];
        if (totalFactor == 0) return (player.balance() + player.stamina() + player.jump())/3.0;
        overall += player.balance() * factors[2]/totalFactor;
        overall += player.stamina() * factors[3]/totalFactor;
        overall += player.jump() * factors[19]/totalFactor;
        return overall;
    }

    public static double shootSummary(ProtrixPlayer player, Position position) {
        //FALTA POTENCIA DE TIRO
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[10] + factors[11] + factors[12] + factors[13] + factors[18];
        overall += player.shortPassAccuracy() * factors[10]/totalFactor;
        overall += player.shortPassSpeed() * factors[11]/totalFactor;
        overall += player.longPassAccuracy() * factors[12]/totalFactor;
        overall += player.longPassSpeed() * factors[13]/totalFactor;
        overall += player.heading() * factors[18]/totalFactor;
        return overall;
    }

    public static double passSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[14] + factors[15] + factors[16] + factors[17] + factors[18];
        overall += player.shotAccuracy() * factors[14]/totalFactor;
        overall += player.shotTechnique() * factors[15]/totalFactor;
        overall += player.freeKickAccuracy() * factors[16]/totalFactor;
        overall += player.swerve() * factors[17]/totalFactor;
        overall += player.heading() * factors[18]/totalFactor;
        return overall;
    }

    public static double dribbleSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[8] + factors[9];
        if (totalFactor == 0) return (player.agility() + player.dribbleAccuracy() + player.dribbleSpeed())/3.0;
        overall += player.agility() * factors[7]/totalFactor;
        overall += player.dribbleAccuracy() * factors[8]/totalFactor;
        overall += player.dribbleSpeed() * factors[9]/totalFactor;
        return overall;
    }

    public static double mentalitySummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[0] + factors[1] + factors[6] + factors[21] + factors[22] + factors[24];
        overall += player.attack() * factors[0]/totalFactor;
        overall += player.defense() * factors[1]/totalFactor;
        overall += player.response() * factors[6]/totalFactor;
        overall += player.aggression() * factors[21]/totalFactor;
        overall += player.mentality() * factors[22]/totalFactor;
        overall += player.teamWork() * factors[24]/totalFactor;
        return overall;
    }

    public static double goalkeeperSummary(ProtrixPlayer player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[23];
        overall += player.agility() * factors[7]/totalFactor;
        overall += player.gkSkills() * factors[23]/totalFactor;
        return overall;
    }

    private static double positionFactor(ProtrixPlayer player, Position position) {
        //TODO HABRÍA QUE AÑADIR VALORES ENTRE 0.8 Y 1 PARA LAS SECUNDARIAS
        if (player.mainPosition() == position) return 1;
        if (player.secondaryPositions().contains(position)) return 1;
        return player.otherPositionFactor(position) * 0.8;
    }
}
