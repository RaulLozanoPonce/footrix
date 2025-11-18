package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.types.tables.TeamElo;

public class CacheCalculator extends Calculator {
    private static final double MinDeltaAbsoluteCachePerSeason = -0.1;
    private static final double MaxDeltaAbsoluteCachePerSeason = 0.2;

    private static final double EloFactor = 0.35;
    private static final double MinutesFactor = 0.4;
    private static final double ScoreFactor = 0.25;

    private final double minDeltaAbsoluteCachePerMatch;
    private final double maxDeltaAbsoluteCachePerMatch;

    public CacheCalculator(Application application) {
        super(application);
        this.minDeltaAbsoluteCachePerMatch = MinDeltaAbsoluteCachePerSeason / application.averageMatchPlayer();
        this.maxDeltaAbsoluteCachePerMatch = MaxDeltaAbsoluteCachePerSeason / application.averageMatchPlayer();
    }

    public static double initial(Player player) {
        if (player.contract() == null) return player.overall() / 100.0;
        return factorOf(player.contract()) / (100.0 - player.overall());
    }

    public double deltaAbsoluteCache(Player player, Match match) {
        if (player.isInjured()) return 0.0;
        if (player.hasSanction(match.definition().competition())) return 0.0;
        double percentElo = percentElo(player.team());
        double percentMinutes = percentMinutes(player, match);
        double percentScore = percentScore(player, match);
        double totalPercent = EloFactor * percentElo + MinutesFactor * percentMinutes + ScoreFactor * percentScore;
        return totalPercent * (maxDeltaAbsoluteCachePerMatch - minDeltaAbsoluteCachePerMatch) + minDeltaAbsoluteCachePerMatch;
    }

    private static double factorOf(PlayerContract contract) {
        return switch (contract.role()) {
            case Undisputed -> 1;
            case Regular -> 0.8;
            case Rotation -> 0.5;
            case Substitute -> 0.3;
            case Reserve -> 0.15;
            case Young -> 0.05;
        };
    }

    private double percentElo(Team team) {
        return elo(team) / maxElo();
    }

    private double percentScore(Player player, Match match) {
        return scoreOf(player, match) / 10;
    }

    private double elo(Team team) {
        TeamElo analysis = application.tableStore().teamElo(team.definition().id());
        if (analysis == null) return 0.0;
        return analysis.elo();
    }

    private double maxElo() {
        TeamElo analysis = application.tableStore().maxElo();
        if (analysis == null) return 1.0;
        return analysis.elo();
    }

    private double scoreOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        return statistics != null ? statistics.score() : 0;
    }
}
