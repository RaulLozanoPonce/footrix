package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class SsCreator extends PositionCreator {

    public SsCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.SS;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 68.35714285714286, stdFactor() * 4.634438690717785, 0.393930432257787));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 35.42857142857143, stdFactor() * 8.54593277723193, 0.0033515022566466685));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 70.14285714285714, stdFactor() * 6.467161342055401, 1.1677966700856217));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 74.28571428571429, stdFactor() * 3.9502399426358408, -0.026164815450370717));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 79.07142857142857, stdFactor() * 3.7511902872859664, 0.6862814955161562));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 81.28571428571429, stdFactor() * 4.140393356054126, 0.5518215962069198));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 71.92857142857143, stdFactor() * 3.8323378226368807, -0.13059623122951616));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 82.78571428571429, stdFactor() * 4.9796288312185775, 0.36097579712057387));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 80.5, stdFactor() * 4.879312688042478, 0.7648357897613335));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 79.14285714285714, stdFactor() * 5.627639795716289, 0.7925436387857396));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.92857142857143, stdFactor() * 5.497751788256243, -0.4702033874815268));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 67.42857142857143, stdFactor() * 4.36267888263244, 1.146695108799755));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.28571428571429, stdFactor() * 3.8316208947805217, 0.47124444759713113));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 69.28571428571429, stdFactor() * 3.6674990730127597, 0.22945772368632936));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 68.64285714285714, stdFactor() * 3.815094370385227, 0.4576797022661147));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 76.21428571428571, stdFactor() * 3.9061799444267487, 1.2795385299546085));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 68.21428571428571, stdFactor() * 5.699913243989858, 0.2152517270492485));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 62.357142857142854, stdFactor() * 5.956343003724851, -0.1850227166962151));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 67.78571428571429, stdFactor() * 5.337509811607936, -0.04975412137711366));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 62.0, stdFactor() * 7.961445558729607, -1.1636300306097371));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 70.42857142857143, stdFactor() * 6.8355888352997605, -0.9602576642599802));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 79.92857142857143, stdFactor() * 2.8679739756969074, -0.12886617269252668));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 77.35714285714286, stdFactor() * 6.1595097564303325, 0.042329801298346646));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 64.28571428571429, stdFactor() * 3.3610568719828735, 0.3359596250577119));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 65.85714285714286, stdFactor() * 4.329809781878731, 0.7557543278949372));
    }

    @Override
    protected double meanFactor() {
        return ((1.014 - 0.81) * (mean - 50) / 20) + 0.81;
    }

    @Override
    protected double stdFactor() {
        return ((1.4 - 1) * (std - 10) / 5) + 1;
    }

    @Override
    protected double positionHeight() {
        return -3.64;
    }
}