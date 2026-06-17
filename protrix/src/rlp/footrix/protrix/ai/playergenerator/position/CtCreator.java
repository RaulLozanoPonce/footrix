package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class CtCreator extends PositionCreator {

    public CtCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.CT;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 50.093023255813954, stdFactor() * 8.825098502963336, -0.6001754282924049));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 69.46511627906976, stdFactor() * 5.776035978131354, 0.0908795144645429));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 75.65503875968992, stdFactor() * 5.68850928945669, 0.23843813536882885));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 72.91472868217055, stdFactor() * 3.954076865219162, -0.4333658646351016));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 71.25968992248062, stdFactor() * 5.209091414681922, 0.12129307627852864));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 70.19767441860465, stdFactor() * 4.057427547847977, 0.1733446732636787));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 69.1937984496124, stdFactor() * 4.67309131119853, 0.3679387804205043));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 68.02325581395348, stdFactor() * 5.723139075362299, 0.7295012645480135));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 65.01550387596899, stdFactor() * 5.185259706862465, -1.7669136362859388));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 66.2984496124031, stdFactor() * 4.4152280611630434, -0.12934334849039592));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 65.09302325581395, stdFactor() * 6.273211355249248, -0.41401652650716925));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 65.79069767441861, stdFactor() * 4.789213591659018, 0.6048255702396093));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 63.56201550387597, stdFactor() * 5.461398942781042, 0.6634917310689303));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 60.2906976744186, stdFactor() * 9.150959991829101, 0.3513584921093641));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 58.674418604651166, stdFactor() * 4.985836422884486, -0.9935842899497522));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 70.2248062015504, stdFactor() * 5.286706491427198, -0.8270397059993679));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 57.37984496124031, stdFactor() * 4.853806398255387, 0.49237632187260766));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 57.48837209302326, stdFactor() * 6.548372868344905, -1.6314957855018108));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 59.298449612403104, stdFactor() * 5.687045617833473, -1.2018875776068896));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 69.25968992248062, stdFactor() * 5.4299933627069965, -0.14676189970538217));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 73.3062015503876, stdFactor() * 5.624020910040562, -0.3257998998363796));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 66.4922480620155, stdFactor() * 4.9748333550972745, -0.8827652524749593));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 57.98449612403101, stdFactor() * 9.264370052456684, 0.05899273903103843));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 69.95348837209302, stdFactor() * 6.4056886988121695, 1.4128121671293075));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 65.81007751937985, stdFactor() * 5.153554097739278, 0.4953188723253755));
    }

    @Override
    protected double meanFactor() {
        return ((1.084 - 0.877) * (mean - 50) / 20) + 0.877;
    }

    @Override
    protected double stdFactor() {
        return ((0.9 - 0.623) * (std - 10) / 5) + 0.623;
    }

    @Override
    protected double positionHeight() {
        return 4.18;
    }
}
