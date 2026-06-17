package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class CarCreator extends PositionCreator {

    public CarCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.CAR;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 63.19004524886878, stdFactor() * 4.890630234320754, -0.8186376157926248));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 61.8235294117647, stdFactor() * 6.0212191634173, 0.20115679623210797));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 72.28054298642535, stdFactor() * 4.221485270096743, 0.26581156000086553));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 74.44343891402715, stdFactor() * 3.8343797568987865, 0.8504480624152243));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 75.5972850678733, stdFactor() * 5.891117493558618, 0.09104315845984681));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 75.8868778280543, stdFactor() * 5.169918210053474, 0.2936536488049736));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 67.67873303167421, stdFactor() * 4.2609164855211334, 0.17101708582491526));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 74.17194570135747, stdFactor() * 5.401795182810828, -0.025970279260668923));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 68.95475113122171, stdFactor() * 4.670773496051717, 0.30418011015019725));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 71.50226244343891, stdFactor() * 5.065591982267261, 0.41241095771100533));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 66.62443438914028, stdFactor() * 4.879375916828003, -0.17137034545111393));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 66.43891402714932, stdFactor() * 3.860302236970169, 0.9539421546938232));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 66.91855203619909, stdFactor() * 5.445821557793223, 0.11521122238693825));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 66.64253393665159, stdFactor() * 6.163219414395323, 0.2279305425046835));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 60.737556561085974, stdFactor() * 4.372838832727964, -0.5975777729425886));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 71.06787330316742, stdFactor() * 4.577604524625839, -0.3334027286434683));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 59.67420814479638, stdFactor() * 4.968328320666151, -0.07848100159255346));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 59.90497737556561, stdFactor() * 5.498348729344649, -0.6777487295180551));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 62.963800904977376, stdFactor() * 5.345223189166105, -0.8483091307028169));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 64.65610859728507, stdFactor() * 5.735798372499793, 0.2554291711844762));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 69.83710407239819, stdFactor() * 5.2898426452822696, 0.7923179285384505));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 68.76923076923077, stdFactor() * 5.14482563059534, -0.8922497760553633));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 68.18099547511312, stdFactor() * 6.680623331354193, 0.31700886532189443));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 69.74660633484163, stdFactor() * 5.412867646447648, 1.1378945939343101));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 65.82805429864253, stdFactor() * 4.952256631324029, 0.7142861143674905));
    }

    @Override
    protected double meanFactor() {
        return ((1.075 - 0.857) * (mean - 50) / 20) + 0.857;
    }

    @Override
    protected double stdFactor() {
        return ((1.09 - 0.74) * (std - 10) / 5) + 0.74;
    }

    @Override
    protected double positionHeight() {
        return -2.59;
    }
}
