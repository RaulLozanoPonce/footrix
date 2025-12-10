package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.player.Player;

import java.util.HashMap;
import java.util.Map;

public class RetireCalculator extends Calculator {
    private final Map<Integer, Double> probability = new HashMap<>();

    public RetireCalculator(Application application) {
        super(application);
        this.probability.put(31, 0.15);
        this.probability.put(32, 0.2);
        this.probability.put(33, 0.25);
        this.probability.put(34, 0.3);
        this.probability.put(35, 0.35);
        this.probability.put(36, 0.4);
        this.probability.put(37, 0.4);
        this.probability.put(38, 0.4);
        this.probability.put(39, 0.4);
        this.probability.put(40, 0.4);
        this.probability.put(41, 0.4);
        this.probability.put(42, 0.5);
        this.probability.put(43, 0.5);
    }

    public boolean decidedToRetire(Player player) {
        if (!player.active() || player.isDecidedToRetire()) return true;
        int age = player.definition().age(application.getDate());
        if (age < 31) return false;
        Double yearProbability = this.probability.get(age);
        if (yearProbability == null) return true;
        double dayProbability = 1 - Math.pow(1 - yearProbability, 1.0/365);
        return Math.random() < dayProbability;
    }
}
