package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class PtCreator extends PositionCreator {

    public PtCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.PT;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 30.939226519337016, stdFactor() * 4.136780479036484, 0.0017822698911314607));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 71.13812154696133, stdFactor() * 3.450883108653302, 1.280295311761419));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 74.94475138121547, stdFactor() * 4.0051685453591315, 0.10982774721393464));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 63.77900552486188, stdFactor() * 8.347042131129957, -0.6889364481605229));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 61.994475138121544, stdFactor() * 5.174185107680756, -2.142701857292672));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 63.8232044198895, stdFactor() * 5.251636010402686, -0.6640297835237118));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 73.20441988950276, stdFactor() * 6.731945593003384, 0.008013129448130533));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 65.38674033149171, stdFactor() * 8.262004120872179, 0.731553613058298));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 50.994475138121544, stdFactor() * 8.545627366326032, -0.98557100378847));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 52.790055248618785, stdFactor() * 5.18010193992759, -0.856814848937076));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 54.61878453038674, stdFactor() * 8.262598505916978, -1.0544301608660043));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 56.77900552486188, stdFactor() * 7.311011565894008, -1.0985595624905433));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 56.91160220994475, stdFactor() * 6.595699623980231, -1.15241022165588));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 61.30386740331492, stdFactor() * 4.8237187664576755, -0.39728187004859666));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 36.21546961325967, stdFactor() * 7.921348329771361, 1.8189705101115075));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 69.0939226519337, stdFactor() * 5.2680395441215735, -0.23543996065437137));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 42.607734806629836, stdFactor() * 6.494078144856598, 1.4195184798664038));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 51.5414364640884, stdFactor() * 11.793816465164985, -0.10944780349020285));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 46.06629834254144, stdFactor() * 7.930673370559252, 2.0321813527235792));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 49.9171270718232, stdFactor() * 7.509163626336559, -0.20484711120636745));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 70.28729281767956, stdFactor() * 6.6512575141349775, -0.14630435995351573));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 57.06077348066298, stdFactor() * 9.53424572898278, -0.40829107044301));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 49.26519337016575, stdFactor() * 13.25503483339906, 0.4121291465901436));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 64.47513812154696, stdFactor() * 12.43229176190129, 0.48429240810251234));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 73.21546961325967, stdFactor() * 5.4019526742563135, 0.06367959788379922));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 61.96132596685083, stdFactor() * 6.794086187334767, 0.563238869781085));
    }

    @Override
    protected double meanFactor() {
        return ((1.035 - 0.875) * (mean - 50) / 20) + 0.875;
    }

    @Override
    protected double stdFactor() {
        return ((0.55 - 0.315) * (std - 10) / 5) + 0.315;
    }

    @Override
    protected double positionHeight() {
        return 6.36;
    }
}
