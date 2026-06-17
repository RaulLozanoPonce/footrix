package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class VolCreator extends PositionCreator {

    public VolCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.VOL;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 70.73239436619718, stdFactor() * 5.659272407749131, 0.4072258282977736));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 50.478873239436616, stdFactor() * 8.359526908913272, 0.9852034639216537));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 70.56338028169014, stdFactor() * 6.135918593160387, -0.2861732966832584));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 74.50704225352112, stdFactor() * 4.8810807920161645, -0.07078039558665199));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 76.97183098591549, stdFactor() * 5.911180280949255, 0.22155540651675373));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 76.84507042253522, stdFactor() * 5.582236846395496, 0.0675827087947092));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 68.80281690140845, stdFactor() * 5.546220639343669, -1.1804500860019518));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 78.80281690140845, stdFactor() * 6.484310114884695, -0.25553479797025086));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 72.46478873239437, stdFactor() * 5.448016640197719, -0.741795992722673));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 74.12676056338029, stdFactor() * 5.508252451587758, -0.08064767059366619));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 69.09859154929578, stdFactor() * 4.579940516074932, -0.5069989493595731));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 69.29577464788733, stdFactor() * 4.196578082871067, -0.002476204749347969));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 70.78873239436619, stdFactor() * 5.059405648203993, -0.37001071292561655));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 71.4225352112676, stdFactor() * 5.533435956156474, -0.034497379506225834));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 66.4225352112676, stdFactor() * 5.7112970051368634, 0.49243159901981));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 72.97183098591549, stdFactor() * 5.403627963787492, -0.7804814019170082));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 65.64788732394366, stdFactor() * 5.836091136929864, 0.536811503462966));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 63.352112676056336, stdFactor() * 10.460945862109213, -0.699713997216346));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 65.30985915492958, stdFactor() * 9.774005684607332, -1.2561181144893476));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 63.2112676056338, stdFactor() * 8.446327169600739, -0.9698992095162539));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 69.08450704225352, stdFactor() * 6.4114773846221365, -1.082372582008943));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 73.47887323943662, stdFactor() * 5.714290744464587, -0.4908264605209188));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 74.84507042253522, stdFactor() * 7.721302420343241, -0.05091442823976282));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 70.7605633802817, stdFactor() * 8.33146323751527, 0.7106743034852687));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 64.47887323943662, stdFactor() * 7.848310382186141, -0.8560602663839346));
    }

    @Override
    protected double meanFactor() {
        return ((1.053 - 0.855) * (mean - 50) / 20) + 0.855;
    }

    @Override
    protected double stdFactor() {
        return ((0.97 - 0.651) * (std - 10) / 5) + 0.651;
    }

    @Override
    protected double positionHeight() {
        return -3.76;
    }
}
