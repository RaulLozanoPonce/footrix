package rlp.footrix.protrix.model;

import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.protrix.model.helpers.OverallCalculator;
import rlp.footrix.protrix.model.helpers.PositionFactorCalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtrixPlayer extends Player {
    private final int attack;
    private final int defense;
    private final int balance;
    private final int stamina;
    private final int speed;
    private final int acceleration;
    private final int response;
    private final int agility;
    private final int dribbleAccuracy;
    private final int dribbleSpeed;
    private final int shortPassAccuracy;
    private final int shortPassSpeed;
    private final int longPassAccuracy;
    private final int longPassSpeed;
    private final int shotAccuracy;
    private final int shotPower;
    private final int shotTechnique;
    private final int freeKickAccuracy;
    private final int swerve;
    private final int heading;
    private final int jump;
    private final int technique;
    private final int aggression;
    private final int mentality;
    private final int gkSkills;
    private final int teamWork;

    public ProtrixPlayer(PlayerDefinition definition, Position mainPosition, List<Position> secondaryPositions, int attack, int defense, int balance, int stamina, int speed, int acceleration, int response, int agility, int dribbleAccuracy, int dribbleSpeed, int shortPassAccuracy, int shortPassSpeed, int longPassAccuracy, int longPassSpeed, int shotAccuracy, int shotPower, int shotTechnique, int freeKickAccuracy, int swerve, int heading, int jump, int technique, int aggression, int mentality, int gkSkills, int teamWork) {
        super(definition, mainPosition, secondaryPositions);
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
        this.otherPositions.putAll(otherPositions(mainPosition, secondaryPositions));
    }

    @Override
    public double overall(Position position) {
        return OverallCalculator.overall(this, position);
    }

    public double techniqueSummary() {
        return OverallCalculator.techniqueSummary(this, mainPosition());
    }

    public double speedSummary() {
        return OverallCalculator.speedSummary(this, mainPosition());
    }

    public double physiqueSummary() {
        return OverallCalculator.physiqueSummary(this, mainPosition());
    }

    public double shootSummary() {
        return OverallCalculator.shootSummary(this, mainPosition());
    }

    public double passSummary() {
        return OverallCalculator.passSummary(this, mainPosition());
    }

    public double dribbleSummary() {
        return OverallCalculator.dribbleSummary(this, mainPosition());
    }

    public double mentalitySummary() {
        return OverallCalculator.mentalitySummary(this, mainPosition());
    }

    public double goalkeeperSummary() {
        return OverallCalculator.goalkeeperSummary(this, mainPosition());
    }

    public int attack() {
        return attack;
    }

    public int defense() {
        return defense;
    }

    public int balance() {
        return balance;
    }

    public int stamina() {
        return stamina;
    }

    public int speed() {
        return speed;
    }

    public int acceleration() {
        return acceleration;
    }

    public int response() {
        return response;
    }

    public int agility() {
        return agility;
    }

    public int dribbleAccuracy() {
        return dribbleAccuracy;
    }

    public int dribbleSpeed() {
        return dribbleSpeed;
    }

    public int shortPassAccuracy() {
        return shortPassAccuracy;
    }

    public int shortPassSpeed() {
        return shortPassSpeed;
    }

    public int longPassAccuracy() {
        return longPassAccuracy;
    }

    public int longPassSpeed() {
        return longPassSpeed;
    }

    public int shotAccuracy() {
        return shotAccuracy;
    }

    public int shotPower() {
        return shotPower;
    }

    public int shotTechnique() {
        return shotTechnique;
    }

    public int freeKickAccuracy() {
        return freeKickAccuracy;
    }

    public int swerve() {
        return swerve;
    }

    public int heading() {
        return heading;
    }

    public int jump() {
        return jump;
    }

    public int technique() {
        return technique;
    }

    public int aggression() {
        return aggression;
    }

    public int mentality() {
        return mentality;
    }

    public int gkSkills() {
        return gkSkills;
    }

    public int teamWork() {
        return teamWork;
    }

    public double otherPositionFactor(Position position) {
        return otherPositions.get(position);
    }

    private Map<Position, Double> otherPositions(Position mainPosition, List<Position> secondaryPositions) {
        Map<Position, Double> otherPositions = new HashMap<>();
        for (Position position : Position.values()) {
            if (position == mainPosition || secondaryPositions.contains(position)) continue;
            otherPositions.put(position, PositionFactorCalculator.factor(mainPosition, position));
        }
        return otherPositions;
    }

    private double average(Integer... skills) {
        return Arrays.stream(skills).mapToInt(s -> s).average().getAsDouble();
    }
}
