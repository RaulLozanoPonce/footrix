package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.types.records.TeamMatchRecord;

public class PsychophysicsCalculator extends Calculator {
    //Energy
    private static final double TacticTrainingFactor = 0.1;
    private static final double TechniqueTrainingFactor = 0.2;
    private static final double PhysicTrainingFactor = 0.5;


    private static final double AverageRating = 5.8;    //TODO MUY PES6
    private static final int MatchStreak = 10;
    private static final double IndividualPerformanceDeltaFactor = 1 / ((10 - AverageRating) * MatchStreak);

    public PsychophysicsCalculator(Application application) {
        super(application);
    }

    public double energyDayRecovery(Player player) {
        return energyFactor(player.psychophysics().energy()) * (0.25 + 0.1 * staminaFactor(player.skills().stamina(), 3));
    }

    public double trainingFatigue(Player player) {
        return trainingTypeFactor() * (1.2 - staminaFactor(player.skills().stamina(), 2));
    }

    public double physicalConditionDayLoss() {
        return -0.015;
    }

    public double physicalConditionMatchGain(Integer minutes) {
        if (minutes == null) return 0;
        //return 0.2 * (minutes / 90.0);
        return 0.1 * (minutes / 90.0);  //TODO REVISAR
    }

    public double physicalConditionTrainGain(double minutes) {
        //return 0.025 * (minutes / 60.0);
        return 0.02 * (minutes / 60.0);  //TODO REVISAR
    }

    public double deltaSelfConfidenceMatch(Player player, Match match, double matchImportance) {
        Double rating = ratingOf(player, match);
        if (rating == null) return 0.0;
        return ((rating - AverageRating) / (10 - AverageRating)) * matchImportance * 0.08;
        //return matchImportance * (rating - AverageRating) * IndividualPerformanceDeltaFactor; //TODO REVISAR
    }

    public double deltaDailySelfConfidence(Player player) {
        double targetConfidence = 0.5 + (player.psychophysics().gameTimeSatisfaction() - 0.5) * 0.4 + (player.psychophysics().collectivePerformance() - 0.5) * 0.2;
        return (targetConfidence - player.psychophysics().selfConfidence()) * 0.02;
    }

    public double deltaGameTimeSatisfaction(Player player, Match match, double matchImportance, Match.MatchRole matchRole) {
        if (player.isInjured()) return 0.0;
        if (player.hasSanction(match.definition().competition())) return 0.0;
        double percentMinutes = percentMinutes(player, match);
        if (percentMinutes >= player.contract().role().expectedPlayingTime()) {
            return factorOf(matchRole, player.contract().role()) * matchImportance * (percentMinutes - player.contract().role().expectedPlayingTime()) / 3;
        } else {
            return factorOf(matchRole, player.contract().role()) * matchImportance * (percentMinutes - player.contract().role().expectedPlayingTime()) / 3.5;
        }
    }

    public double deltaCollectivePerformanceMatchMood(Team team, int deltaElo) {
        int streak = streak(team);
        double eloFactor = deltaElo / 15.0;
        double streakFactor = (streak + 5) / 10.0;
        return 0.2 * eloFactor * (deltaElo <= 0 ? (1 - streakFactor) : streakFactor);
    }

    private double energyFactor(double energy) {
        if (energy < 0.15) return 0.6;
        else if (energy < 0.3) return 0.8;
        else return 1;
    }

    private double staminaFactor(double stamina, int growthPronunciation) {
        return Math.pow((stamina - 1) / 98.0, growthPronunciation);
    }

    private double trainingTypeFactor() {
        //TODO PONER UNO U OTRO SEGÚN EL TIPO DE ENTRENAMIENTO
        return TechniqueTrainingFactor;
    }

    private Double ratingOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        if (statistics == null) return 0.0;
        return statistics.score();
    }

    private double factorOf(Match.MatchRole matchRole, PlayerContract.Role contractRole) {
        if (matchRole == Match.MatchRole.Starter) return -1.665 * contractRole.expectedPlayingTime() + 2.1635;
        else if (matchRole == Match.MatchRole.Substitute) return -0.835 * contractRole.expectedPlayingTime() + 1.0815;
        return -0.835 * contractRole.expectedPlayingTime() + 0.5815;
    }

    private int streak(Team team) {
        return application.recordStore().teamMatchRecords(team.definition().id()).stream()
                .sorted((r1, r2) -> r2.date().compareTo(r1.date()))
                .limit(5)
                .mapToInt(TeamMatchRecord::streak).sum();
    }
}
