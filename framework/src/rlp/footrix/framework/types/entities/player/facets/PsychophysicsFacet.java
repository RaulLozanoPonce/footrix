package rlp.footrix.framework.types.entities.player.facets;

import rlp.footrix.framework.generators.ContractGenerator;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class PsychophysicsFacet {
    private final Player player;
    private double energy = 1;
    private double physicalCondition = 0;
    private double selfConfidence = 0.5;
    private double emotionalStability = 0.5;
    private double gameTimeSatisfaction = 0.5;
    private double coachRelationship = 0.5;
    private double collectivePerformance = 0.5;

    public PsychophysicsFacet(Player player) {
        this.player = player;
    }

    public double energy() {
        return energy;
    }

    public PsychophysicsFacet energy(double deltaEnergy) {
        this.energy = adjust(this.energy + deltaEnergy);
        return this;
    }

    public double physicalCondition() {
        return physicalCondition;
    }

    public PsychophysicsFacet physicalCondition(double deltaPhysicalCondition) {
        this.physicalCondition = adjust(this.physicalCondition + deltaPhysicalCondition);
        return this;
    }

    public double selfConfidence() {
        return selfConfidence;
    }

    public PsychophysicsFacet selfConfidence(double deltaSelfConfidence) {
        this.selfConfidence = adjust(this.selfConfidence + deltaSelfConfidence);
        return this;
    }

    public double emotionalStability() {
        return emotionalStability;
    }

    public PsychophysicsFacet emotionalStability(double deltaEmotionalStability) {
        this.emotionalStability = adjust(this.emotionalStability + deltaEmotionalStability);
        return this;
    }

    public double contractSatisfaction() {
        PlayerContract expected = ContractGenerator.expectedContract(player, player.team());
        double salarySatisfaction = min(max((player.contract().salary()/(double) expected.salary())/2.0, 0), 1);
        double roleSatisfaction = min(max(0.5 + player.contract().role().expectedPlayingTime() - expected.role().expectedPlayingTime(), 0), 1);
        double contractMood = 0.6 * salarySatisfaction + 0.4 * roleSatisfaction;
        if (contractMood >= 0.5) return 0.7 * contractMood + 0.4;
        else return 1.3 * contractMood;
    }

    public double gameTimeSatisfaction() {
        return gameTimeSatisfaction;
    }

    public PsychophysicsFacet gameTimeSatisfaction(double deltaGameTimeSatisfaction) {
        this.gameTimeSatisfaction = adjust(this.gameTimeSatisfaction + deltaGameTimeSatisfaction);
        return this;
    }

    public double coachRelationship() {
        return coachRelationship;
    }

    public PsychophysicsFacet coachRelationship(double deltaCoachRelationship) {
        this.coachRelationship = adjust(this.coachRelationship + deltaCoachRelationship);
        return this;
    }

    public double collectivePerformance() {
        return collectivePerformance;
    }

    public PsychophysicsFacet collectivePerformance(double deltaCollectivePerformance) {
        this.collectivePerformance = adjust(this.collectivePerformance + deltaCollectivePerformance);
        return this;
    }

    private double adjust(double value) {
        return Math.max(0, Math.min(1, value));
    }
}
