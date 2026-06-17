package algorithms;

import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.player.Pes6Skills;
import rlp.footrix.protrix.ai.playergenerator.position.*;
import rlp.footrix.pes6.types.Pes6Player;

import java.time.Instant;

import static rlp.footrix.pes6.calculators.OverallCalculator.Factors;

public class PlayerTraining {

    public static void train(Pes6Player player, int age, double trainScore) {
        System.out.println(age + ": " + player.overall());
        ((Pes6Skills) player.skills()).attack(minMax(((Pes6Skills) player.skills()).attack() + ageEvolutionOf(0, age) + trainEvolutionOf(0, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).defense(minMax(((Pes6Skills) player.skills()).defense() + ageEvolutionOf(1, age) + trainEvolutionOf(1, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).balance(minMax(((Pes6Skills) player.skills()).balance() + ageEvolutionOf(2, age) + trainEvolutionOf(2, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).stamina(minMax(((Pes6Skills) player.skills()).stamina() + ageEvolutionOf(3, age) + trainEvolutionOf(3, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).speed(minMax(((Pes6Skills) player.skills()).speed() + ageEvolutionOf(4, age) + trainEvolutionOf(4, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).acceleration(minMax(((Pes6Skills) player.skills()).acceleration() + ageEvolutionOf(5, age) + trainEvolutionOf(5, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).response(minMax(((Pes6Skills) player.skills()).response() + ageEvolutionOf(6, age) + trainEvolutionOf(6, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).agility(minMax(((Pes6Skills) player.skills()).agility() + ageEvolutionOf(7, age) + trainEvolutionOf(7, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).dribbleAccuracy(minMax(((Pes6Skills) player.skills()).dribbleAccuracy() + ageEvolutionOf(8, age) + trainEvolutionOf(8, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).dribbleSpeed(minMax(((Pes6Skills) player.skills()).dribbleSpeed() + ageEvolutionOf(9, age) + trainEvolutionOf(9, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).shortPassAccuracy(minMax(((Pes6Skills) player.skills()).shortPassAccuracy() + ageEvolutionOf(10, age) + trainEvolutionOf(10, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).shortPassSpeed(minMax(((Pes6Skills) player.skills()).shortPassSpeed() + ageEvolutionOf(11, age) + trainEvolutionOf(11, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).longPassAccuracy(minMax(((Pes6Skills) player.skills()).longPassAccuracy() + ageEvolutionOf(12, age) + trainEvolutionOf(12, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).longPassSpeed(minMax(((Pes6Skills) player.skills()).longPassSpeed() + ageEvolutionOf(13, age) + trainEvolutionOf(13, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).shotAccuracy(minMax(((Pes6Skills) player.skills()).shotAccuracy() + ageEvolutionOf(14, age) + trainEvolutionOf(14, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).shotTechnique(minMax(((Pes6Skills) player.skills()).shotTechnique() + ageEvolutionOf(15, age) + trainEvolutionOf(15, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).freeKickAccuracy(minMax(((Pes6Skills) player.skills()).freeKickAccuracy() + ageEvolutionOf(16, age) + trainEvolutionOf(16, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).swerve(minMax(((Pes6Skills) player.skills()).swerve() + ageEvolutionOf(17, age) + trainEvolutionOf(17, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).heading(minMax(((Pes6Skills) player.skills()).heading() + ageEvolutionOf(18, age) + trainEvolutionOf(18, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).jump(minMax(((Pes6Skills) player.skills()).jump() + ageEvolutionOf(19, age) + trainEvolutionOf(19, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).technique(minMax(((Pes6Skills) player.skills()).technique() + ageEvolutionOf(20, age) + trainEvolutionOf(20, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).aggression(minMax(((Pes6Skills) player.skills()).aggression() + ageEvolutionOf(21, age) + trainEvolutionOf(21, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).mentality(minMax(((Pes6Skills) player.skills()).mentality() + ageEvolutionOf(22, age) + trainEvolutionOf(22, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).gkSkills(minMax(((Pes6Skills) player.skills()).gkSkills() + ageEvolutionOf(23, age) + trainEvolutionOf(23, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).teamWork(minMax(((Pes6Skills) player.skills()).teamWork() + ageEvolutionOf(24, age) + trainEvolutionOf(24, trainScore, player.mainPosition())));
        ((Pes6Skills) player.skills()).shotPower(minMax(((Pes6Skills) player.skills()).shotPower() + ageEvolutionOf(25, age) + trainEvolutionOf(25, trainScore, player.mainPosition())));
    }

    private static double minMax(double value) {
        return Math.min(99, Math.max(1, value));
    }

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

    private static double trainEvolutionOf(int skillId, double trainScore, Position position) {
        /*double trainEvolution = 0.0;
        if (skillId == 0 || skillId == 1 || skillId == 24) trainEvolution = 1.5;
        else if (skillId == 2 || skillId == 3) trainEvolution = 2.5;
        else if (skillId == 4 || skillId == 5 || skillId == 7 || skillId == 19 || skillId == 25) trainEvolution = 2.5;
        else if (skillId == 6 || skillId == 21 || skillId == 22) trainEvolution = 1.5;
        else if (skillId == 23) trainEvolution = 1.5;
        else trainEvolution = 2;
        return (trainScore / 10.0) * 10 * (trainEvolution / 26.0);*/
        return 0;
    }

    private static double positionWeight(Position position, int skillId) {
        double total = 0.0;
        double positionWeight = 0.0;
        for (int i = 0; i < 26; i++) {
            double parcial = Factors.get(position)[i];
            if (parcial == 0) parcial = 0.01;
            if (i == skillId) positionWeight = parcial;
            total += parcial;
        }
        return positionWeight / total;
    }

    public static void main(String[] args) {
        Pes6Player player = new PtCreator(72, 0).generate(Instant.now());
        for (int i = 16; i < 46; i++) {
            train(player, i, 10);
        }
        System.out.println();
    }
}
