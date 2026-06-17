package rlp.footrix.protrix.ai.playergenerator.position;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.types.Positions;
import rlp.footrix.protrix.ai.playergenerator.PositionCreator;

public class CcCreator extends PositionCreator {

    public CcCreator(double mean, double std) {
        super(mean, std);
    }

    @Override
    protected Position position() {
        return Positions.CC;
    }

    @Override
    protected double attack() {
        return Math.round(nextSkewNormal(meanFactor() * 65.95067264573991, stdFactor() * 4.844639184169338, 0.7000712288568474));
    }

    @Override
    protected double defense() {
        return Math.round(nextSkewNormal(meanFactor() * 56.61434977578475, stdFactor() * 7.311854523977384, 0.2890508355760411));
    }

    @Override
    protected double balance() {
        return Math.round(nextSkewNormal(meanFactor() * 72.30044843049328, stdFactor() * 4.227148398363612, 0.33969658864248464));
    }

    @Override
    protected double stamina() {
        return Math.round(nextSkewNormal(meanFactor() * 74.01793721973094, stdFactor() * 4.757132270337073, 1.0400827949564257));
    }

    @Override
    protected double topSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 72.73991031390135, stdFactor() * 4.904913329172589, 0.06738386179184888));
    }

    @Override
    protected double acceleration() {
        return Math.round(nextSkewNormal(meanFactor() * 73.33632286995515, stdFactor() * 4.5081386786273425, 0.11009511817390048));
    }

    @Override
    protected double response() {
        return Math.round(nextSkewNormal(meanFactor() * 68.5201793721973, stdFactor() * 4.8637560064422685, 0.3181107813650073));
    }

    @Override
    protected double agility() {
        return Math.round(nextSkewNormal(meanFactor() * 73.55156950672645, stdFactor() * 5.711201633818319, 0.08568417816717205));
    }

    @Override
    protected double dribbleAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.52466367713005, stdFactor() * 5.159446138729378, 0.5447100705663357));
    }

    @Override
    protected double dribbleSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 71.03139013452915, stdFactor() * 4.908523690029209, -0.007967102999508582));
    }

    @Override
    protected double shortPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 71.7847533632287, stdFactor() * 4.577494968500132, 0.2180254106679673));
    }

    @Override
    protected double shortPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 69.59192825112108, stdFactor() * 4.385616062434231, 0.7416730858055004));
    }

    @Override
    protected double longPassAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 67.65470852017937, stdFactor() * 5.634678882451998, 0.4734079836339041));
    }

    @Override
    protected double longPassSpeed() {
        return Math.round(nextSkewNormal(meanFactor() * 64.24215246636771, stdFactor() * 7.106944886256604, 0.23912642160768144));
    }

    @Override
    protected double shotAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 63.856502242152466, stdFactor() * 5.1880875643579225, 0.34382691841083496));
    }

    @Override
    protected double shotPower() {
        return Math.round(nextSkewNormal(meanFactor() * 70.60986547085201, stdFactor() * 4.683235529723607, 0.2960212586270799));
    }

    @Override
    protected double shotTechnique() {
        return Math.round(nextSkewNormal(meanFactor() * 62.80717488789238, stdFactor() * 4.879959256300233, 0.27663361783492085));
    }

    @Override
    protected double freeKickAccuracy() {
        return Math.round(nextSkewNormal(meanFactor() * 63.152466367713004, stdFactor() * 4.9678317199496105, 1.302851596690471));
    }

    @Override
    protected double swerve() {
        return Math.round(nextSkewNormal(meanFactor() * 64.22421524663677, stdFactor() * 4.747113507823781, 0.9728590416861601));
    }

    @Override
    protected double heading() {
        return Math.round(nextSkewNormal(meanFactor() * 63.20627802690583, stdFactor() * 4.407462555099596, 0.23872487233748008));
    }

    @Override
    protected double jump() {
        return Math.round(nextSkewNormal(meanFactor() * 68.08520179372198, stdFactor() * 5.373182142173281, -0.22593359774453683));
    }

    @Override
    protected double technique() {
        return Math.round(nextSkewNormal(meanFactor() * 71.92825112107623, stdFactor() * 4.987756188158154, 0.40658309981291735));
    }

    @Override
    protected double aggression() {
        return Math.round(nextSkewNormal(meanFactor() * 68.88340807174887, stdFactor() * 6.375264915840109, 0.5715923820011208));
    }

    @Override
    protected double mentality() {
        return Math.round(nextSkewNormal(meanFactor() * 69.4035874439462, stdFactor() * 5.439957741143515, 1.1448314535357287));
    }

    @Override
    protected double goalKeeping() {
        return Math.round(nextSkewNormal(meanFactor() * 50.0, stdFactor() * 0.0, 0.0));
    }

    @Override
    protected double teamWork() {
        return Math.round(nextSkewNormal(meanFactor() * 68.08520179372198, stdFactor() * 5.154977113011509, 0.7925062917564569));
    }

    @Override
    protected double meanFactor() {
        return ((1.071 - 0.862) * (mean - 50) / 20) + 0.862;
    }

    @Override
    protected double stdFactor() {
        return ((1.13 - 0.75) * (std - 10) / 5) + 0.75;
    }

    @Override
    protected double positionHeight() {
        return -1.88;
    }
}
