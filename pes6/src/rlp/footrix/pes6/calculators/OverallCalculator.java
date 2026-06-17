package rlp.footrix.pes6.calculators;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.pes6.types.player.Pes6Skills;

import java.util.HashMap;
import java.util.Map;

public class OverallCalculator {
    public static final Map<Position, Double[]> Factors = factors();

    private static Map<Position, Double[]> factors() {
        Map<Position, Double[]> factors = new HashMap<>();
        factors.put(Positions.PT, new Double[]{0.0, 0.1823, 0.1823, 0.0, 0.0, 0.0, 0.1823, 0.1823, 0.0, 0.0, 0.0, 0.1823, 0.0, 0.1823, 0.0, 0.0, 0.0, 0.1068, 0.0, 0.1823, 0.0, 0.1823, 0.1823, 0.1823, 0.0, 0.0, -60.4896});
        factors.put(Positions.CT, new Double[]{0.0, 0.1725, 0.0894, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.0, 0.0, 0.1725, 0.0, 0.0, 0.1725, 0.0781, 0.0, 0.0626, 0.1725, 0.0, 0.1725, 0.0, -35.0471});
        factors.put(Positions.CAR, new Double[]{0.0, 0.1379, 0.0, 0.0764, 0.0371, 0.0371, 0.1379, 0.0371, 0.0, 0.0371, 0.1379, 0.0, 0.1379, 0.1379, 0.0, 0.0, 0.0, 0.0, 0.0543, 0.0543, 0.1379, 0.1379, 0.0764, 0.0, 0.0, 0.0, -31.003});
        factors.put(Positions.LAT, new Double[]{0.06485, 0.06895, 0.0, 0.0726, 0.01855, 0.05585, 0.06895, 0.05585, 0.06485, 0.05585, 0.1338, 0.0, 0.1338, 0.1338, 0.04005, 0.0, 0.0, 0.0, 0.02715, 0.02715, 0.1338, 0.1338, 0.0382, 0.0, 0.06485, 0.0, -33.0792});
        factors.put(Positions.CCD, new Double[]{0.0, 0.1477, 0.0556, 0.0733, 0.0, 0.0, 0.1477, 0.0, 0.0, 0.0, 0.1477, 0.0, 0.1477, 0.0, 0.0, 0.1477, 0.0, 0.0, 0.037, 0.037, 0.1477, 0.1477, 0.0733, 0.0, 0.1477, 0.0, -36.9984});
        factors.put(Positions.CC, new Double[]{0.1204, 0.1204, 0.0, 0.0856, 0.0, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.0, 0.1204, 0.1204, 0.0, 0.0, 0.0, 0.0, 0.1204, 0.1204, 0.0, 0.0, 0.1204, 0.0, -34.2756});
        factors.put(Positions.MP, new Double[]{0.1047, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1128, 0.1047, 0.1128, 0.1047, 0.0, 0.1047, 0.1047, 0.1047, 0.1047, 0.1047, 0.0, 0.0, 0.0, 0.1047, 0.1047, 0.0, 0.0, 0.1047, 0.0, -32.1313});
        factors.put(Positions.VOL, new Double[]{0.1297, 0.0, 0.0, 0.0688, 0.0, 0.0746, 0.0, 0.0746, 0.1297, 0.0746, 0.1297, 0.0, 0.1297, 0.1297, 0.0801, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1297, 0.1297, 0.0, 0.0, 0.1297, 0.0, -35.1554});
        factors.put(Positions.EXT, new Double[]{0.1101, 0.0, 0.0, 0.0388, 0.0, 0.0773, 0.0, 0.0773, 0.1101, 0.0773, 0.1101, 0.0, 0.1101, 0.1101, 0.1101, 0.1101, 0.0, 0.0, 0.0, 0.0, 0.1101, 0.1101, 0.0, 0.0, 0.1101, 0.0, -32.1498});
        factors.put(Positions.SS, new Double[]{0.11098, 0.0, 0.0, 0.00776, 0.0, 0.01546, 0.0, 0.07634, 0.11098, 0.07634, 0.0639, 0.04708, 0.0639, 0.11098, 0.11098, 0.11098, 0.04188, 0.0, 0.05636, 0.05636, 0.11098, 0.11098, 0.0, 0.0, 0.0639, 0.0, -30.23536});
        factors.put(Positions.DL, new Double[]{0.1177, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0394, 0.1177, 0.0394, 0.0, 0.1177, 0.0, 0.1177, 0.1177, 0.1177, 0.0, 0.0, 0.1409, 0.1409, 0.1177, 0.1177, 0.0, 0.0, 0.0, 0.0, -27.3822});
        return factors;
    }

    public static double overall(Pes6Skills skills, Pes6Player player, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        overall += skills.attack() * factors[0];
        overall += skills.defense() * factors[1];
        overall += skills.balance() * factors[2];
        overall += skills.stamina() * factors[3];
        overall += skills.speed() * factors[4];
        overall += skills.acceleration() * factors[5];
        overall += skills.response() * factors[6];
        overall += skills.agility() * factors[7];
        overall += skills.dribbleAccuracy() * factors[8];
        overall += skills.dribbleSpeed() * factors[9];
        overall += skills.shortPassAccuracy() * factors[10];
        overall += skills.shortPassSpeed() * factors[11];
        overall += skills.longPassAccuracy() * factors[12];
        overall += skills.longPassSpeed() * factors[13];
        overall += skills.shotAccuracy() * factors[14];
        overall += skills.shotTechnique() * factors[15];
        overall += skills.shotPower() * factors[25];
        overall += skills.freeKickAccuracy() * factors[16];
        overall += skills.swerve() * factors[17];
        overall += skills.heading() * factors[18];
        overall += skills.jump() * factors[19];
        overall += skills.technique() * factors[20];
        overall += skills.aggression() * factors[21];
        overall += skills.mentality() * factors[22];
        overall += skills.gkSkills() * factors[23];
        overall += skills.teamWork() * factors[24];
        overall += factors[26];
        return overall * positionFactor(player, position);
    }

    public static double techniqueSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[15] + factors[17] + factors[20];
        overall += skills.agility() * factors[7]/totalFactor;
        overall += skills.shotTechnique() * factors[15]/totalFactor;
        overall += skills.swerve() * factors[17]/totalFactor;
        overall += skills.technique() * factors[20]/totalFactor;
        return overall;
    }

    public static double speedSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[4] + factors[5] + factors[7];
        if (totalFactor == 0) return (skills.speed() + skills.acceleration() + skills.agility())/3.0;
        overall += skills.speed() * factors[4]/totalFactor;
        overall += skills.acceleration() * factors[5]/totalFactor;
        overall += skills.agility() * factors[7]/totalFactor;
        return overall;
    }

    public static double physiqueSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[2] + factors[3] + factors[19];
        if (totalFactor == 0) return (skills.balance() + skills.stamina() + skills.jump())/3.0;
        overall += skills.balance() * factors[2]/totalFactor;
        overall += skills.stamina() * factors[3]/totalFactor;
        overall += skills.jump() * factors[19]/totalFactor;
        return overall;
    }

    public static double shootSummary(Pes6Skills skills, Position position) {
        //FALTA POTENCIA DE TIRO
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[10] + factors[11] + factors[12] + factors[13] + factors[18];
        overall += skills.shortPassAccuracy() * factors[10]/totalFactor;
        overall += skills.shortPassSpeed() * factors[11]/totalFactor;
        overall += skills.longPassAccuracy() * factors[12]/totalFactor;
        overall += skills.longPassSpeed() * factors[13]/totalFactor;
        overall += skills.heading() * factors[18]/totalFactor;
        return overall;
    }

    public static double passSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[14] + factors[15] + factors[16] + factors[17] + factors[18];
        overall += skills.shotAccuracy() * factors[14]/totalFactor;
        overall += skills.shotTechnique() * factors[15]/totalFactor;
        overall += skills.freeKickAccuracy() * factors[16]/totalFactor;
        overall += skills.swerve() * factors[17]/totalFactor;
        overall += skills.heading() * factors[18]/totalFactor;
        return overall;
    }

    public static double dribbleSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[8] + factors[9];
        if (totalFactor == 0) return (skills.agility() + skills.dribbleAccuracy() + skills.dribbleSpeed())/3.0;
        overall += skills.agility() * factors[7]/totalFactor;
        overall += skills.dribbleAccuracy() * factors[8]/totalFactor;
        overall += skills.dribbleSpeed() * factors[9]/totalFactor;
        return overall;
    }

    public static double mentalitySummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[0] + factors[1] + factors[6] + factors[21] + factors[22] + factors[24];
        overall += skills.attack() * factors[0]/totalFactor;
        overall += skills.defense() * factors[1]/totalFactor;
        overall += skills.response() * factors[6]/totalFactor;
        overall += skills.aggression() * factors[21]/totalFactor;
        overall += skills.mentality() * factors[22]/totalFactor;
        overall += skills.teamWork() * factors[24]/totalFactor;
        return overall;
    }

    public static double goalkeeperSummary(Pes6Skills skills, Position position) {
        Double[] factors = Factors.get(position);
        double overall = 0.0;
        double totalFactor = factors[7] + factors[23];
        overall += skills.agility() * factors[7]/totalFactor;
        overall += skills.gkSkills() * factors[23]/totalFactor;
        return overall;
    }

    private static double positionFactor(Pes6Player player, Position position) {
        //TODO HABRÍA QUE AÑADIR VALORES ENTRE 0.8 Y 1 PARA LAS SECUNDARIAS
        if (player.mainPosition() == position) return 1;
        if (player.secondaryPositions().contains(position)) return 1;
        return player.otherPositionFactor(position) * 0.8;
    }
}
