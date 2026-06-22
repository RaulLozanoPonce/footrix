package rlp.footrix.pes6.calculators;

public class SkillCalculator {
    private static int AgeDays = 365;
    private static int AgeTrains = 200;
    private static double MeanSkillValue = 78;
    private static double GradeSkillValue = 6;

    //TODO HACER QUE LAS SKILLS SEAN UN ENUMERADO

    public static double ageEvolutionOf(int skillId, int age) {
        double ageEvolution = 0.0;
        if (skillId == 0 || skillId == 1 || skillId == 24) ageEvolution = 0;
        else if (skillId == 2 || skillId == 3) ageEvolution = -0.0114 * Math.pow(age, 2) + 0.3226 * age - 0.3063;
        else if (skillId == 4 || skillId == 5 || skillId == 7 || skillId == 19 || skillId == 25) ageEvolution = -0.0083 * Math.pow(age, 2) + 0.0272 * age + 4.4222;
        else if (skillId == 6 || skillId == 21 || skillId == 22) ageEvolution = -0.0097 * Math.pow(age, 2) + 0.4251 * age - 3.8951;
        else if (skillId == 23) ageEvolution = -0.0085 * Math.pow(age, 2) + 0.331 * age - 1.5472;
        else ageEvolution = -0.0062 * Math.pow(age, 2) + 0.1689 * age + 0.4288;
        return (ageEvolution - 0.8) / AgeDays;
    }

    public static double trainEvolutionOf(int skillId, double trainScore) {
        double trainEvolution = 0.0;
        if (skillId == 0 || skillId == 1 || skillId == 24) trainEvolution = 1.5;
        else if (skillId == 2 || skillId == 3) trainEvolution = 2.5;
        else if (skillId == 4 || skillId == 5 || skillId == 7 || skillId == 19 || skillId == 25) trainEvolution = 2.5;
        else if (skillId == 6 || skillId == 21 || skillId == 22) trainEvolution = 1.5;
        else if (skillId == 23) trainEvolution = 1.5;
        else trainEvolution = 2;
        return ((trainScore / 10.0) * 10 * (trainEvolution / 26.0)) / AgeTrains;
    }

    public static double sigmoid(double skill) {
        return 1 / (1 + Math.exp(- (skill - MeanSkillValue) / GradeSkillValue));
    }
}
