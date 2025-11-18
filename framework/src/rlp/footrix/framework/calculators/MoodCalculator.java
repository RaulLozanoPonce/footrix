package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.TeamMatchRecord;

public class MoodCalculator extends Calculator {
    private static final double AverageRating = 5.7;
    private static final int MatchStreak = 5;
    private static final double IndividualPerformaceDeltaFactor = 1 / ((10 - AverageRating) * MatchStreak);

    public MoodCalculator(Application application) {
        super(application);
    }

    public double deltaGameTimeMood(Player player, Match match) {
        if (player.isInjured()) return 0.0;
        if (player.hasSanction(match.definition().competition())) return 0.0;
        double percentMinutes = percentMinutes(player, match);
        return 0.21 * (percentMinutes - player.contract().role().expectedPlayingTime());
    }

    public double deltaIndividualPerformanceMatchMood(Player player, Match match) {
        Double rating = ratingOf(player, match);
        if (rating == null) return 0.0;
        return (rating - AverageRating) * IndividualPerformaceDeltaFactor;
    }

    public double deltaIndividualPerformanceInjuryMood(Player player) {
        if (!player.isInjured()) return 0;
        return - 0.015;
    }

    public double deltaCollectivePerformanceMatchMood(Team team, int deltaElo) {
        int streak = streak(team);
        double eloMood = Math.tanh(deltaElo/15.0);    //EL 15 CONTROLA LA SENSIBILIDAD. DEBE SER MÁS BAJO CUANTO MÁS BAJO SEA DELTA
        double streakMood = Math.tanh(streak/2.0);
        return Math.max(-1, Math.min(1, eloMood + 0.15 * streakMood));
    }

    private Double ratingOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
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
