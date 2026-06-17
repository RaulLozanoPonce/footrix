package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.player.Player;

public class EnergyCalculator extends Calculator {
    private static final double TacticTrainingFactor = 0.1;
    private static final double TechniqueTrainingFactor = 0.2;
    private static final double PhysicTrainingFactor = 0.5;

    public EnergyCalculator(Application application) {
        super(application);
    }

    public double trainingFatigue(Player player) {
        return trainingTypeFactor() * (1.2 - staminaFactor(player.skills().stamina(), 2));
    }

    public double dayRecovery(Player player) {
        return energyFactor(player.energy()) * (0.25 + 0.1 * staminaFactor(player.skills().stamina(), 3));
    }

    private double trainingTypeFactor() {
        //TODO PONER UNO U OTRO SEGÚN EL TIPO DE ENTRENAMIENTO
        return TechniqueTrainingFactor;
    }

    private double energyFactor(double energy) {
        if (energy < 0.15) return 0.6;
        else if (energy < 0.3) return 0.8;
        else return 1;
    }

    private double staminaFactor(double stamina, int growthPronunciation) {
        return Math.pow((stamina - 1) / 98.0, growthPronunciation);
    }
}
