package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class CcdCreator extends PositionCreator {

    public CcdCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.CCD;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 62.3, stdFactor() * 6.1248635485512715, -0.9227811124914223));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 64.82307692307693, stdFactor() * 5.196100781102143, -0.026494881985033438));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 73.23846153846154, stdFactor() * 4.895503151174596, 0.16247299068350737));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 74.43076923076923, stdFactor() * 4.226051470534176, 0.3912130738358742));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 70.71538461538462, stdFactor() * 4.585509051542367, 0.045683866216650666));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 71.58461538461539, stdFactor() * 4.149875528878891, 0.5709822240300262));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 69.20769230769231, stdFactor() * 5.738076486511541, -1.4662122219333067));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 72.1923076923077, stdFactor() * 6.125428197462277, 0.8241233149076643));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 68.58461538461539, stdFactor() * 5.481165234833231, -0.2108205898150181));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 68.73846153846154, stdFactor() * 4.65816586680802, 0.23409612219379436));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 70.63076923076923, stdFactor() * 5.650188254445495, -0.8046668985115287));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 69.1076923076923, stdFactor() * 4.853267346396581, -0.39141674565635265));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 68.1076923076923, stdFactor() * 5.915747154900688, 0.641013196490398));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 64.57692307692308, stdFactor() * 7.7738035392531755, 0.2680090991957679));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 61.761538461538464, stdFactor() * 5.977741460085521, -1.1574833236697224));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 71.38461538461539, stdFactor() * 4.612730304133997, 0.21943722402044144));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 61.47692307692308, stdFactor() * 5.6926654628176045, -0.29027708837507243));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 61.05384615384615, stdFactor() * 6.272014300605558, -0.2797867658408947));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 62.59230769230769, stdFactor() * 6.481573349340878, 0.76603341773466));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 65.29230769230769, stdFactor() * 6.683830023314524, -0.8332306571709343));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 70.01538461538462, stdFactor() * 6.512938363749051, -1.0510204598317554));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 70.56923076923077, stdFactor() * 5.565589825110319, 0.19745197723617045));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 67.49230769230769, stdFactor() * 5.635224425273251, 0.11499041449653133));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 70.93846153846154, stdFactor() * 6.375527150910549, 0.5659257286367592));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 67.3923076923077, stdFactor() * 5.756689608918371, -0.1545254424130385));
    }

    @Override
    protected double meanFactor() {
        return ((1.076 - 0.875) * (mean - 50) / 20) + 0.875;
    }

    @Override
    protected double stdFactor() {
        return ((1 - 0.65) * (std - 10) / 5) + 0.65;
    }

    @Override
    protected double positionHeight() {
        return -1.2;
    }
}
