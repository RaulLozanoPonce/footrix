package rlp.footrix.framework.types.entities.team.facets;

import rlp.footrix.framework.types.entities.team.Team;

import java.util.HashMap;
import java.util.Map;

public class FanFacet {
    private static final double SpeedFans = 0.0015;
    private static final int MinFans = 5000;
    private static final int MaxFans = 10000000;
    private static final int MaxEloScore = 850;

    private final Team team;
    private Map<Integer, Integer> subscribers;
    private Map<Integer, Fans> fans;

    public FanFacet(Team team) {
        this.team = team;
    }

    public void init(int fans, double eloPoints) {
        this.fans = initFans(fans, eloPoints);
        this.subscribers = initSubscribers(fans);
    }

    public void newSeason(double eloPoints) {
        this.fans = newSeasonFans(eloPoints);
        this.subscribers = initSubscribers(totalFans()); //TODO CUADRAR CON LA CAMPAÑA DE ABONADOS
    }

    public void restoreDailyFans(double eloPoints) {
        int totalFans = totalFans();
        int deltaFans = deltaFans(eloPoints, totalFans);
        double totalWeight = newFanTotalWeight();
        for (int i = 10; i <= 85; i++) {
            Fans ageFans = fans.get(i);
            int ageFansNumber = ageFans == null ? 0 : ageFans.number();
            double ageFansWealth = ageFans == null ? 0 : ageFans.wealth();
            double weight = newFanRate(i) / totalWeight;
            int newNumber = Math.max(0, ageFansNumber + (int) Math.round(deltaFans * weight));
            if (newNumber < ageFansNumber || newNumber == 0) {
                fans.put(i, new Fans(newNumber, Math.min(1, ageFansWealth)));
            } else {
                double oldPercent = ageFansNumber / (double) newNumber;
                double targetWealth = targetWealth(eloPoints);
                double newWealth = oldPercent * ageFansWealth + (1 - oldPercent) * targetWealth;
                fans.put(i, new Fans(newNumber, Math.min(1, newWealth)));
            }
        }
    }

    public int totalFans() {
        return totalFans(this.fans);
    }

    public int totalSubscribers() {
        return subscribers.values().stream().mapToInt(n -> n).sum();
    }

    private int deltaFans(double eloPoints, int totalFans) {
        int targetFans = targetFans(eloPoints);
        int deltaFans = (int) Math.round((targetFans - totalFans) * SpeedFans);
        int newTotalFans = Math.max(MinFans, Math.min(MaxFans, totalFans + deltaFans));
        return newTotalFans - totalFans;
    }

    private double newFanTotalWeight() {
        double totalWeight = 0.0;
        for (int i = 10; i <= 85; i++) {
            totalWeight += newFanRate(i);
        }
        return totalWeight;
    }

    private double weight(Integer age, int totalFans) {
        return ageWeight(age) * currentFanWeight(age, totalFans);
    }

    private double ageWeight(int age) {
        return Math.exp(-age / 25.0);
    }

    private double currentFanWeight(int age, int totalFans) {
        Fans ageFans = fans.get(age);
        if (ageFans == null) return 0;
        return ageFans.number() / (double) totalFans;
    }

    private Map<Integer, Fans> newSeasonFans(double eloPoints) {
        Map<Integer, Fans> newFans = new HashMap<>();
        for (int i = 10; i <= 84; i++) {
            Fans fans = this.fans.get(i);
            if (fans == null) continue;
            newFans.put(i + 1, new Fans((int) Math.round(survivalRate(i) * fans.number()), fans.wealth()));
        }
        int missingFans = targetFans(eloPoints) - totalFans(newFans);
        if (missingFans > 0) newFans.put(10, new Fans(missingFans, meanWealth(newFans)));
        return newFans;
    }

    private double survivalRate(int age) {
        return 0.90 + 0.10 / (1.0 + Math.exp((age - 80.0) / 4.0));
    }

    private double newFanRate(int age) {
        return 1.0 / (1.0 + Math.exp((age - 22.0) / 6.0));
    }

    private int targetFans(double eloPoints) {
        return (int) Math.max(MinFans, Math.round(MaxFans * Math.pow(eloPoints / MaxEloScore, 4)));
    }

    private int totalFans(Map<Integer, Fans> fans) {
        return fans.values().stream().mapToInt(Fans::number).sum();
    }

    private double meanWealth(Map<Integer, Fans> fans) {
        return fans.values().stream().mapToDouble(Fans::wealth).average().orElse(0.0);
    }

    private Map<Integer, Fans> initFans(int totalFans, double eloPoints) {
        Map<Integer, Fans> fans = new HashMap<>();
        double wealth = targetWealth(eloPoints);
        double totalWeight = 0;
        for (int i = 10; i <= 85; i++) totalWeight += initialFansWeight(i);
        for (int i = 10; i <= 85; i++) fans.put(i, new Fans((int) Math.round(totalFans * initialFansWeight(i)/totalWeight), wealth));
        return fans;
    }

    private Map<Integer, Integer> initSubscribers(int totalFans) {
        Map<Integer, Integer> subscribers = new HashMap<>();
        for (int i = 10; i <= 85; i++) {
            Fans fansAge = fans.get(i);
            if (fansAge == null) continue;
            double weight = fansAge.number() / (double) totalFans;
            subscribers.put(i, (int) Math.round(weight * 0.75 * team.stadium().capacity()));
        }
        return subscribers;
    }

    private double targetWealth(double eloPoints) {
        return 0.85 + 0.30 * Math.pow(eloPoints / MaxEloScore, 4);
    }

    private double initialFansWeight(int age) {
        double mean = 35;
        double sigma = 15;
        return Math.exp(-Math.pow(age - mean, 2) / (2 * sigma * sigma));
    }

    public record Fans(int number, double wealth) {}
}
