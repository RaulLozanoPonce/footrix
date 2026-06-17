package rlp.footrix.protrix.types.player;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.player.facets.SkillsFacet;
import rlp.footrix.protrix.helper.OverallCalculator;
import rlp.footrix.protrix.types.ProtrixPlayer;

import java.time.Instant;

public class ProtrixSkills implements SkillsFacet {
    private final ProtrixPlayer player;

    private double attack;
    private double defense;
    private double balance;
    private double stamina;
    private double speed;
    private double acceleration;
    private double response;
    private double agility;
    private double dribbleAccuracy;
    private double dribbleSpeed;
    private double shortPassAccuracy;
    private double shortPassSpeed;
    private double longPassAccuracy;
    private double longPassSpeed;
    private double shotAccuracy;
    private double shotPower;
    private double shotTechnique;
    private double freeKickAccuracy;
    private double swerve;
    private double heading;
    private double jump;
    private double technique;
    private double aggression;
    private double mentality;
    private double gkSkills;
    private double teamWork;

    public ProtrixSkills(ProtrixPlayer player, double attack, double defense, double balance, double stamina, double speed, double acceleration, double response, double agility, double dribbleAccuracy, double dribbleSpeed, double shortPassAccuracy, double shortPassSpeed, double longPassAccuracy, double longPassSpeed, double shotAccuracy, double shotPower, double shotTechnique, double freeKickAccuracy, double swerve, double heading, double jump, double technique, double aggression, double mentality, double gkSkills, double teamWork) {
        this.player = player;
        this.attack = attack;
        this.defense = defense;
        this.balance = balance;
        this.stamina = stamina;
        this.speed = speed;
        this.acceleration = acceleration;
        this.response = response;
        this.agility = agility;
        this.dribbleAccuracy = dribbleAccuracy;
        this.dribbleSpeed = dribbleSpeed;
        this.shortPassAccuracy = shortPassAccuracy;
        this.shortPassSpeed = shortPassSpeed;
        this.longPassAccuracy = longPassAccuracy;
        this.longPassSpeed = longPassSpeed;
        this.shotAccuracy = shotAccuracy;
        this.shotPower = shotPower;
        this.shotTechnique = shotTechnique;
        this.freeKickAccuracy = freeKickAccuracy;
        this.swerve = swerve;
        this.heading = heading;
        this.jump = jump;
        this.technique = technique;
        this.aggression = aggression;
        this.mentality = mentality;
        this.gkSkills = gkSkills;
        this.teamWork = teamWork;
    }

    @Override
    public Player player() {
        return player;
    }

    @Override
    public void naturalProgress(Instant now) {
        attack(minMax(attack() + ageEvolutionOf(0, player.definition().age(now))));
        defense(minMax(defense() + ageEvolutionOf(1, player.definition().age(now))));
        balance(minMax(balance() + ageEvolutionOf(2, player.definition().age(now))));
        stamina(minMax(stamina() + ageEvolutionOf(3, player.definition().age(now))));
        speed(minMax(speed() + ageEvolutionOf(4, player.definition().age(now))));
        acceleration(minMax(acceleration() + ageEvolutionOf(5, player.definition().age(now))));
        response(minMax(response() + ageEvolutionOf(6, player.definition().age(now))));
        agility(minMax(agility() + ageEvolutionOf(7, player.definition().age(now))));
        dribbleAccuracy(minMax(dribbleAccuracy() + ageEvolutionOf(8, player.definition().age(now))));
        dribbleSpeed(minMax(dribbleSpeed() + ageEvolutionOf(9, player.definition().age(now))));
        shortPassAccuracy(minMax(shortPassAccuracy() + ageEvolutionOf(10, player.definition().age(now))));
        shortPassSpeed(minMax(shortPassSpeed() + ageEvolutionOf(11, player.definition().age(now))));
        longPassAccuracy(minMax(longPassAccuracy() + ageEvolutionOf(12, player.definition().age(now))));
        longPassSpeed(minMax(longPassSpeed() + ageEvolutionOf(13, player.definition().age(now))));
        shotAccuracy(minMax(shotAccuracy() + ageEvolutionOf(14, player.definition().age(now))));
        shotTechnique(minMax(shotTechnique() + ageEvolutionOf(15, player.definition().age(now))));
        freeKickAccuracy(minMax(freeKickAccuracy() + ageEvolutionOf(16, player.definition().age(now))));
        swerve(minMax(swerve() + ageEvolutionOf(17, player.definition().age(now))));
        heading(minMax(heading() + ageEvolutionOf(18, player.definition().age(now))));
        jump(minMax(jump() + ageEvolutionOf(19, player.definition().age(now))));
        technique(minMax(technique() + ageEvolutionOf(20, player.definition().age(now))));
        aggression(minMax(aggression() + ageEvolutionOf(21, player.definition().age(now))));
        mentality(minMax(mentality() + ageEvolutionOf(22, player.definition().age(now))));
        gkSkills(minMax(gkSkills() + ageEvolutionOf(23, player.definition().age(now))));
        teamWork(minMax(teamWork() + ageEvolutionOf(24, player.definition().age(now))));
        shotPower(minMax(shotPower() + ageEvolutionOf(25, player.definition().age(now))));
    }

    @Override
    public void trainingProgress(double score) {
        attack(minMax(attack() + trainEvolutionOf(0, score)));
        defense(minMax(defense() + trainEvolutionOf(1, score)));
        balance(minMax(balance() + trainEvolutionOf(2, score)));
        stamina(minMax(stamina() + trainEvolutionOf(3, score)));
        speed(minMax(speed() + trainEvolutionOf(4, score)));
        acceleration(minMax(acceleration() + trainEvolutionOf(5, score)));
        response(minMax(response() + trainEvolutionOf(6, score)));
        agility(minMax(agility() + trainEvolutionOf(7, score)));
        dribbleAccuracy(minMax(dribbleAccuracy() + trainEvolutionOf(8, score)));
        dribbleSpeed(minMax(dribbleSpeed() + trainEvolutionOf(9, score)));
        shortPassAccuracy(minMax(shortPassAccuracy() + trainEvolutionOf(10, score)));
        shortPassSpeed(minMax(shortPassSpeed() + trainEvolutionOf(11, score)));
        longPassAccuracy(minMax(longPassAccuracy() + trainEvolutionOf(12, score)));
        longPassSpeed(minMax(longPassSpeed() + trainEvolutionOf(13, score)));
        shotAccuracy(minMax(shotAccuracy() + trainEvolutionOf(14, score)));
        shotTechnique(minMax(shotTechnique() + trainEvolutionOf(15, score)));
        freeKickAccuracy(minMax(freeKickAccuracy() + trainEvolutionOf(16, score)));
        swerve(minMax(swerve() + trainEvolutionOf(17, score)));
        heading(minMax(heading() + trainEvolutionOf(18, score)));
        jump(minMax(jump() + trainEvolutionOf(19, score)));
        technique(minMax(technique() + trainEvolutionOf(20, score)));
        aggression(minMax(aggression() + trainEvolutionOf(21, score)));
        mentality(minMax(mentality() + trainEvolutionOf(22, score)));
        gkSkills(minMax(gkSkills() + trainEvolutionOf(23, score)));
        teamWork(minMax(teamWork() + trainEvolutionOf(24, score)));
        shotPower(minMax(shotPower() + trainEvolutionOf(25, score)));
    }

    @Override
    public double overall(Position position) {
        return OverallCalculator.overall(this, player, position);
    }

    public double techniqueSummary() {
        return OverallCalculator.techniqueSummary(this, player.mainPosition());
    }

    public double speedSummary() {
        return OverallCalculator.speedSummary(this, player.mainPosition());
    }

    public double physiqueSummary() {
        return OverallCalculator.physiqueSummary(this, player.mainPosition());
    }

    public double shootSummary() {
        return OverallCalculator.shootSummary(this, player.mainPosition());
    }

    public double passSummary() {
        return OverallCalculator.passSummary(this, player.mainPosition());
    }

    public double dribbleSummary() {
        return OverallCalculator.dribbleSummary(this, player.mainPosition());
    }

    public double mentalitySummary() {
        return OverallCalculator.mentalitySummary(this, player.mainPosition());
    }

    public double goalkeeperSummary() {
        return OverallCalculator.goalkeeperSummary(this, player.mainPosition());
    }

    public double attack() {
        return attack;
    }

    public double defense() {
        return defense;
    }

    public double balance() {
        return balance;
    }

    public double stamina() {
        return stamina;
    }

    public double speed() {
        return speed;
    }

    public double acceleration() {
        return acceleration;
    }

    public double response() {
        return response;
    }

    public double agility() {
        return agility;
    }

    public double dribbleAccuracy() {
        return dribbleAccuracy;
    }

    public double dribbleSpeed() {
        return dribbleSpeed;
    }

    public double shortPassAccuracy() {
        return shortPassAccuracy;
    }

    public double shortPassSpeed() {
        return shortPassSpeed;
    }

    public double longPassAccuracy() {
        return longPassAccuracy;
    }

    public double longPassSpeed() {
        return longPassSpeed;
    }

    public double shotAccuracy() {
        return shotAccuracy;
    }

    public double shotPower() {
        return shotPower;
    }

    public double shotTechnique() {
        return shotTechnique;
    }

    public double freeKickAccuracy() {
        return freeKickAccuracy;
    }

    public double swerve() {
        return swerve;
    }

    public double heading() {
        return heading;
    }

    public double jump() {
        return jump;
    }

    public double technique() {
        return technique;
    }

    public double aggression() {
        return aggression;
    }

    public double mentality() {
        return mentality;
    }

    public double gkSkills() {
        return gkSkills;
    }

    public double teamWork() {
        return teamWork;
    }

    public void attack(double attack) {
        this.attack = attack;
    }

    public void defense(double defense) {
        this.defense = defense;
    }

    public void balance(double balance) {
        this.balance = balance;
    }

    public void stamina(double stamina) {
        this.stamina = stamina;
    }

    public void speed(double speed) {
        this.speed = speed;
    }

    public void acceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void response(double response) {
        this.response = response;
    }

    public void agility(double agility) {
        this.agility = agility;
    }

    public void dribbleAccuracy(double dribbleAccuracy) {
        this.dribbleAccuracy = dribbleAccuracy;
    }

    public void dribbleSpeed(double dribbleSpeed) {
        this.dribbleSpeed = dribbleSpeed;
    }

    public void shortPassAccuracy(double shortPassAccuracy) {
        this.shortPassAccuracy = shortPassAccuracy;
    }

    public void shortPassSpeed(double shortPassSpeed) {
        this.shortPassSpeed = shortPassSpeed;
    }

    public void longPassAccuracy(double longPassAccuracy) {
        this.longPassAccuracy = longPassAccuracy;
    }

    public void longPassSpeed(double longPassSpeed) {
        this.longPassSpeed = longPassSpeed;
    }

    public void shotAccuracy(double shotAccuracy) {
        this.shotAccuracy = shotAccuracy;
    }

    public void shotPower(double shotPower) {
        this.shotPower = shotPower;
    }

    public void shotTechnique(double shotTechnique) {
        this.shotTechnique = shotTechnique;
    }

    public void freeKickAccuracy(double freeKickAccuracy) {
        this.freeKickAccuracy = freeKickAccuracy;
    }

    public void swerve(double swerve) {
        this.swerve = swerve;
    }

    public void heading(double heading) {
        this.heading = heading;
    }

    public void jump(double jump) {
        this.jump = jump;
    }

    public void technique(double technique) {
        this.technique = technique;
    }

    public void aggression(double aggression) {
        this.aggression = aggression;
    }

    public void mentality(double mentality) {
        this.mentality = mentality;
    }

    public void gkSkills(double gkSkills) {
        this.gkSkills = gkSkills;
    }

    public void teamWork(double teamWork) {
        this.teamWork = teamWork;
    }


    //TODO SKILLSCALCULATORS

    private static double ageEvolutionOf(int skillId, int age) {
        double ageEvolution = 0.0;
        if (skillId == 0 || skillId == 1 || skillId == 24) ageEvolution = 0;
        else if (skillId == 2 || skillId == 3) ageEvolution = -0.0114 * Math.pow(age, 2) + 0.3226 * age - 0.3063;
        else if (skillId == 4 || skillId == 5 || skillId == 7 || skillId == 19 || skillId == 25) ageEvolution = -0.0083 * Math.pow(age, 2) + 0.0272 * age + 4.4222;
        else if (skillId == 6 || skillId == 21 || skillId == 22) ageEvolution = -0.0097 * Math.pow(age, 2) + 0.4251 * age - 3.8951;
        else if (skillId == 23) ageEvolution = -0.0085 * Math.pow(age, 2) + 0.331 * age - 1.5472;
        else ageEvolution = -0.0062 * Math.pow(age, 2) + 0.1689 * age + 0.4288;
        return ageEvolution - 0.8;
    }

    private static double trainEvolutionOf(int skillId, double trainScore) {
        double trainEvolution = 0.0;
        if (skillId == 0 || skillId == 1 || skillId == 24) trainEvolution = 1.5;
        else if (skillId == 2 || skillId == 3) trainEvolution = 2.5;
        else if (skillId == 4 || skillId == 5 || skillId == 7 || skillId == 19 || skillId == 25) trainEvolution = 2.5;
        else if (skillId == 6 || skillId == 21 || skillId == 22) trainEvolution = 1.5;
        else if (skillId == 23) trainEvolution = 1.5;
        else trainEvolution = 2;
        return (trainScore / 10.0) * 10 * (trainEvolution / 26.0);
    }

    private static double minMax(double value) {
        return Math.min(99, Math.max(1, value));
    }
}
