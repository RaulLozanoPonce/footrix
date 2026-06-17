package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class DlCreator extends PositionCreator {

    public DlCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.EXT;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 69.80918727915194, stdFactor() * 5.167992090255545, 0.4447158436103876));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 33.89399293286219, stdFactor() * 6.042057029595624, -0.40007947001547056));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 73.04946996466431, stdFactor() * 5.095996001762681, -0.06036701081669717));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 72.2155477031802, stdFactor() * 3.331480827488267, -0.27301755735382743));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 75.0, stdFactor() * 6.360895605793371, 0.2082830798563753));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 74.97879858657244, stdFactor() * 6.291351936570171, 0.361487500590837));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 69.23321554770318, stdFactor() * 5.195677340620996, 0.7571991428480576));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 74.1660777385159, stdFactor() * 7.188247487197257, 0.4448314006707511));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 69.85512367491167, stdFactor() * 5.1264368581439514, 0.39031942765577166));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 71.47349823321555, stdFactor() * 5.990699421848851, 0.3839889696751401));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 65.2826855123675, stdFactor() * 6.060974209257597, -1.1033681985600265));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 65.48763250883393, stdFactor() * 4.779056968677122, 0.2966565720708568));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 61.42756183745583, stdFactor() * 6.228869248859646, -0.4084791209961283));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 61.02120141342756, stdFactor() * 6.7838650857635665, 0.10851236243078145));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.2155477031802, stdFactor() * 4.800949813719266, 0.06590893249163426));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 71.9469964664311, stdFactor() * 4.973762701906998, 0.9465797573993062));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 66.70318021201413, stdFactor() * 6.818588261418637, 0.3966150162693733));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 61.40636042402827, stdFactor() * 6.621014404301993, -0.174315188943206));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 62.30742049469965, stdFactor() * 6.530955860921823, -0.806207198884369));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 68.53356890459364, stdFactor() * 5.701944142569889, -0.024833715275548323));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 72.60424028268551, stdFactor() * 5.625321081982146, 0.090529959231325));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 70.65371024734982, stdFactor() * 5.641180779093356, 0.133742123541988));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 71.59717314487632, stdFactor() * 8.576745265917568, 0.46618444214150684));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 67.3851590106007, stdFactor() * 6.734851051084924, 1.184407928990693));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 64.80565371024736, stdFactor() * 5.197623213657139, -0.2511480511844735));
    }

    @Override
    protected double meanFactor() {
        return ((1.077 - 0.864) * (mean - 50) / 20) + 0.864;
    }

    @Override
    protected double stdFactor() {
        return ((1.1 - 0.696) * (std - 10) / 5) + 0.696;
    }

    @Override
    protected double positionHeight() {
        return 1.34;
    }
}
