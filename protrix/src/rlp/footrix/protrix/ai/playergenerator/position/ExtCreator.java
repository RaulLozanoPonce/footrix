package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class ExtCreator extends PositionCreator {

    public ExtCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.EXT;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 66.26794258373205, stdFactor() * 5.265542567974275, 0.6197445451849316));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 38.311004784689, stdFactor() * 7.325136087274584, 0.5630261715455245));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 71.63636363636364, stdFactor() * 3.9857701434432524, 0.4410426474595165));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 71.73205741626795, stdFactor() * 2.3277126599855, 0.9430244462619148));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 78.49282296650718, stdFactor() * 6.053542841580839, 0.08769606113498862));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 79.82296650717703, stdFactor() * 6.081359349861024, 0.015162761425943938));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 66.77990430622009, stdFactor() * 4.373145539983278, 1.242743264663566));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 78.84210526315789, stdFactor() * 6.794295356599722, -0.10485313593497518));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 72.83732057416267, stdFactor() * 5.381802001761232, 0.43472378359207875));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 75.35406698564593, stdFactor() * 5.56854103383385, 0.12139958584758596));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 67.50717703349282, stdFactor() * 4.939168040758952, 0.6566594306279862));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 66.69856459330144, stdFactor() * 4.566816751019704, 0.9651968528959545));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 65.20574162679426, stdFactor() * 5.146018396466191, 0.4821349942891899));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 65.25837320574162, stdFactor() * 5.492148174583994, 0.5201168030485109));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 66.70334928229666, stdFactor() * 4.743217655598037, 0.6905984921071805));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 70.77511961722487, stdFactor() * 4.248546483351666, 1.2249530447734058));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 64.00956937799043, stdFactor() * 4.6233005512025835, 0.8175396821298657));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 62.29665071770335, stdFactor() * 4.004569298543658, 0.416340007215388));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 65.08612440191388, stdFactor() * 5.349537075930737, 0.9567889490964987));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 61.21531100478469, stdFactor() * 4.05568867147446, -0.9861648932108938));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 67.00956937799043, stdFactor() * 3.839308870374286, 1.3252074564954366));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 72.20095693779905, stdFactor() * 5.325717633393334, 0.37326383382390255));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 67.29665071770334, stdFactor() * 8.530377746478035, 0.4259255806091208));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 64.87081339712918, stdFactor() * 3.598552033672773, 1.5708470496801128));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 64.73205741626795, stdFactor() * 4.298364634968639, -0.6331000004985842));
    }

    @Override
    protected double meanFactor() {
        return ((1.054 - 0.843) * (mean - 50) / 20) + 0.843;
    }

    @Override
    protected double stdFactor() {
        return ((1.2 - 0.815) * (std - 10) / 5) + 0.815;
    }

    @Override
    protected double positionHeight() {
        return -4.44;
    }
}
