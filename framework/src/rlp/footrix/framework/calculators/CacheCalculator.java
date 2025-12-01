package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.types.tables.TeamElo;

public class CacheCalculator extends Calculator {
    private static final double ExceptionalAbsoluteCachePerSeason = -0.1;
    private static final double MinDeltaAbsoluteCachePerSeason = 0;
    private static final double MaxDeltaAbsoluteCachePerSeason = 0.4;

    private static final double EloFactor = 0.25;

    private final double exceptionalDeltaAbsoluteCachePerMatch;
    private final double minDeltaAbsoluteCachePerMatch;
    private final double maxDeltaAbsoluteCachePerMatch;

    public CacheCalculator(Application application) {
        super(application);
        this.exceptionalDeltaAbsoluteCachePerMatch = ExceptionalAbsoluteCachePerSeason / application.averageMatchPlayer();
        this.minDeltaAbsoluteCachePerMatch = MinDeltaAbsoluteCachePerSeason / application.averageMatchPlayer();
        this.maxDeltaAbsoluteCachePerMatch = MaxDeltaAbsoluteCachePerSeason / application.averageMatchPlayer();
    }

    public static double initial(Player player) {
        //TODO
        if (player.contract() == null) return player.overall() / 100.0;
        return factorOf(player.contract()) / (100.0 - player.overall());
    }

    public double deltaAbsoluteCache(Player player, Match match, double matchImportance) {
        if (player.isInjured()) return exceptionalDeltaAbsoluteCachePerMatch;
        if (player.hasSanction(match.definition().competition())) return exceptionalDeltaAbsoluteCachePerMatch;
        double percentElo = percentElo(player.team());
        double percentTeamRole = percentElo * (player.contract().role().expectedPlayingTime() + 0.3);
        double percentPerformance = Math.max(0, Math.min(1, (0.5 * percentMinutes(player, match) + 0.5 * percentScore(player, match)) * matchImportance));
        double percentWin = (match.winner() == null ? 0.5 : (match.winner().equals(player.team().definition().id()) ? 1 : 0)) * (1 - (percentElo/2));
        double totalPercent = Math.pow(Math.min(1, Math.max(0, EloFactor * percentTeamRole + (0.5 * percentPerformance + 0.1 * percentWin + 0.4 * percentPerformance * percentWin))), 3);
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
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        return statistics != null ? fix(statistics.score()) : 0;
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

    private double fix(Double score) {
        double min = 4;
        double mean = 6;
        double max = 8;
        double normalized = Math.min(1, Math.max(0, (score - min)/(max - min)));
        double meanFactor = (mean - min)/(max - min);
        if (score <= mean) {
            return 0.5 * Math.pow(normalized/meanFactor, 3);
        } else {
            return 0.5 + 0.5 * (1 - Math.pow(1 - ((normalized - meanFactor) / (1 - meanFactor)), 3));
        }
    }
}
