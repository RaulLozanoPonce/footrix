package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class MpCreator extends PositionCreator {

    public MpCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.MP;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 67.50515463917526, stdFactor() * 5.646079315241148, 0.7121112424329666));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 46.103092783505154, stdFactor() * 8.901865131553173, -0.02898742764928195));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 71.85051546391753, stdFactor() * 4.1703772449317515, -0.06224154648396696));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 72.3917525773196, stdFactor() * 3.6393266502145885, 0.6097801013437826));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 74.17525773195877, stdFactor() * 4.858645004564575, 0.16311886075379897));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 75.3917525773196, stdFactor() * 5.844366138890326, 0.025990729514729055));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 68.30412371134021, stdFactor() * 5.350442672611897, 1.2789001380356464));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 76.53092783505154, stdFactor() * 7.007883951424318, 0.1596803227032453));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 74.54123711340206, stdFactor() * 6.581560874089131, 0.600312575976293));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 72.78865979381443, stdFactor() * 5.679859450363894, 0.508667540873821));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.68041237113403, stdFactor() * 5.1406061854047325, 0.1190116695584054));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 69.64948453608247, stdFactor() * 5.03159187845813, 0.930129008126814));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 68.31443298969072, stdFactor() * 6.126397308153591, 0.4277038939825198));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 65.76804123711341, stdFactor() * 7.38734454021224, 0.4043041765729901));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 66.43298969072166, stdFactor() * 5.511001181329802, 0.6879615830570002));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 71.29896907216495, stdFactor() * 4.51747315415602, 1.2604025234581504));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 64.99484536082474, stdFactor() * 5.519158739191872, 0.7651215377455016));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 64.94329896907216, stdFactor() * 6.063727324048597, 0.28299879340202033));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 66.71134020618557, stdFactor() * 6.4910600344401965, -0.1540672106344255));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 61.91237113402062, stdFactor() * 5.596774750947289, 0.8916195479440139));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 67.12886597938144, stdFactor() * 4.712335455279609, 0.46732304908557015));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 74.31958762886597, stdFactor() * 6.153555595035559, 0.2441820153736313));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 69.0721649484536, stdFactor() * 7.241571728003665, 0.3747710130561356));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 66.76288659793815, stdFactor() * 6.205919280124879, 1.5793487884309754));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 49.94845360824742, stdFactor() * 0.7179581586177349, -13.820462414374925));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 66.64432989690722, stdFactor() * 5.189895904237558, 0.10399683402412126));
    }

    @Override
    protected double meanFactor() {
        return ((1.041 - 0.833) * (mean - 50) / 20) + 0.833;
    }

    @Override
    protected double stdFactor() {
        return ((1.03 - 0.705) * (std - 10) / 5) + 0.705;
    }

    @Override
    protected double positionHeight() {
        return -3.87;
    }
}
