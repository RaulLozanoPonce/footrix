package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.TeamMatchRecord;

public class MoodCalculator extends Calculator {
    private static final double AverageRating = 5.7;
    private static final int MatchStreak = 10;
    private static final double IndividualPerformaceDeltaFactor = 1 / ((10 - AverageRating) * MatchStreak);

    public MoodCalculator(Application application) {
        super(application);
    }

    public double deltaGameTimeMood(Player player, Match match, double matchImportance) {
        if (player.isInjured()) return 0.0;
        if (player.hasSanction(match.definition().competition())) return 0.0;
        double percentMinutes = percentMinutes(player, match);
        if (percentMinutes >= player.contract().role().expectedPlayingTime()) {
            return matchImportance * (percentMinutes - player.contract().role().expectedPlayingTime()) / 3;
        } else {
            return matchImportance * (percentMinutes - player.contract().role().expectedPlayingTime()) / 3.5;
        }
    }

    public double deltaIndividualPerformanceMatchMood(Player player, Match match, double matchImportance) {
        Double rating = ratingOf(player, match);
        if (rating == null) return 0.0;
        return matchImportance * ((rating - AverageRating) * IndividualPerformaceDeltaFactor);
    }

    public double deltaIndividualPerformanceInjuryMood(Player player) {
        if (!player.isInjured()) return 0;
        return - 0.015;
    }

    public double deltaCollectivePerformanceMatchMood(Team team, int deltaElo) {
        int streak = streak(team);
        double eloFactor = deltaElo / 15.0;
        double streakFactor = (streak + 5) / 10.0;
        return 0.2 * eloFactor * (deltaElo <= 0 ? (1 - streakFactor) : streakFactor);
    }

    private Double ratingOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        if (statistics == null) return null;
        return statistics.score();
    }

    private int streak(Team team) {
        return application.recordStore().teamMatchRecords(team.definition().id()).stream()
                .sorted((r1, r2) -> r2.date().compareTo(r1.date()))
                .limit(5)
                .mapToInt(TeamMatchRecord::streak).sum();
    }
}
