package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.tables.TeamElo;

import java.util.*;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Goal;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Injury;

public class PostMatchCommand extends Command {
    public Match match;
    public List<Player> localPlayers;
    public List<Player> visitantPlayers;
    public Team local;
    public Team visitant;

    public PostMatchCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        int deltaElo = deltaElo();
        adjustTeamElo(deltaElo);
        adjustStatistics();
        adjustMood(deltaElo);
        adjustCache();
        reduceSanctions();
        registerCardsAndSanctions();
        registerInjuries();
    }

    private int deltaElo() {
        TeamElo localElo = eloOf(local);
        TeamElo visitantElo = eloOf(visitant);
        return application.eloManager().deltaElo(localElo.elo(), visitantElo.elo(), match.definition().competition() + "-" + match.definition().phase(), pointsOf(local), match.withPenalties());
    }

    private void adjustTeamElo(int deltaElo) {
        TeamElo localElo = eloOf(local);
        TeamElo visitantElo = eloOf(visitant);
        localElo.elo(localElo.elo() + deltaElo);
        visitantElo.elo(visitantElo.elo() - deltaElo);
    }

    private void reduceSanctions() {
        local.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
        visitant.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
    }

    private void adjustStatistics() {
        adjustStatistics(localPlayers, local);
        adjustStatistics(visitantPlayers, visitant);
    }

    private void adjustStatistics(List<Player> players, Team team) {
        for (Player player : players) {
            int minutes = minutesOf(player);
            updatePlayerMatchRecord(team, player, minutes, maxMinutesOf(player, minutes), scoreOf(player));
        }
        createTeamMatchRecord(team, goalsForOf(team), goalsAgainstOf(team));
    }

    private void adjustMood(int deltaElo) {
        local.players().forEach(p -> adjustMood(p, deltaElo));
        visitant.players().forEach(p -> adjustMood(p, -deltaElo));
    }

    private void adjustMood(Player player, int deltaElo) {
        player.mood().gameTime(application.moodCalculator().deltaGameTimeMood(player, match));
        player.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceMatchMood(player, match));
        player.mood().collectivePerformance(application.moodCalculator().deltaCollectivePerformanceMatchMood(player.team(), deltaElo));
    }

    private void adjustCache() {
        local.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match)));
        visitant.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match)));
    }

    private int minutesOf(Player player) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        return statistics != null ? statistics.minutes() : 0;
    }

    private int maxMinutesOf(Player player, int playedMinutes) {
        List<Integer> minutes = match.events().stream()
                .filter(e -> e.type() == Injury || e.type() == Match.MatchEvent.Type.Expulsion)
                .filter(e -> e.who().equals(player.definition().id()))
                .map(Match.MatchEvent::minute)
                .toList();
        if (minutes.isEmpty()) return match.duration();
        return Math.max(playedMinutes, minutes.stream().mapToInt(m -> m).max().orElse(0));
    }

    private double scoreOf(Player player) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        if (statistics == null) return 0.0;
        return statistics.score();
    }

    private void registerCardsAndSanctions() {
        CompetitionDefinition competition = application.competitionManager().get(match.definition().competition()).definition();
        Set<String> players = new HashSet<>();
        Map<String, Integer> yellowCardsMap = new HashMap<>();
        Set<String> expelledPlayers = new HashSet<>();
        for (Match.MatchEvent event : match.events()) fill(event, players, yellowCardsMap, expelledPlayers);
        for (String playerId : players) {
            Player player = application.playerManager().get(playerId);
            int yellowCards = yellowCardsMap.getOrDefault(playerId, 0);
            boolean isExpelled = expelledPlayers.contains(playerId);
            registerCardsAndSanctionsTo(player, yellowCards, isExpelled, competition);
        }
    }

    private void registerCardsAndSanctionsTo(Player player, Integer yellowCards, boolean isExpelled, CompetitionDefinition competition) {
        if (isExpelled) {
            player.yellowCards(- competition.accumulatedYellowCardNumber(), competition.id());
            if (yellowCards >= 2) {
                player.sanction(competition.doubleYellowCardSanction(), competition.id());
            } else {
                player.sanction(competition.redCardSanction(), competition.id());
            }
        } else {
            player.yellowCards(yellowCards, competition.id());
            if (player.yellowCards(competition.id()) >= competition.accumulatedYellowCardNumber()) {
                player.yellowCards(- competition.accumulatedYellowCardNumber(), competition.id());
                player.sanction(competition.accumulatedYellowCardSanction(), competition.id());
            }
        }
    }

    private static void fill(Match.MatchEvent event, Set<String> players, Map<String, Integer> yellowCards, Set<String> expelledPlayers) {
        if (event.type() == Match.MatchEvent.Type.YellowCard) {
            players.add(event.who());
            yellowCards.putIfAbsent(event.who(), 0);
            yellowCards.put(event.who(), yellowCards.get(event.who()) + 1);
        } else if (event.type() == Match.MatchEvent.Type.Expulsion) {
            players.add(event.who());
            expelledPlayers.add(event.who());
        }
    }

    private void registerInjuries() {
        for (Player player : match.events().stream().filter(e -> e.type() == Injury).map(e -> application.playerManager().get(e.who())).toList()) {
            int injuryDays = application.injuryCalculator().deltaInjury(player, match);
            player.addInjury(application.timeManager().future(injuryDays));
        }
    }

    private void updatePlayerMatchRecord(Team team, Player player, int minutes, int maxMinutes, double score) {
        PlayerMatchRecord analysis = application.recordStore().playerMatchRecord(player.definition().id(), team.definition().id(), match.definition().competition(), match.definition().season());
        if (analysis == null) analysis = application.recordStore().create().playerMatchRecord(player.definition().id(), team.definition().id(), match.definition().competition(), match.definition().season());
        analysis.playedMinutes(analysis.playedMinutes() + minutes)
                .maxMinutes(analysis.maxMinutes() + maxMinutes)
                .totalScore(analysis.totalScore() + score);
    }

    private void createTeamMatchRecord(Team team, int goalsFor, int goalsAgainst) {
        application.recordStore().create().teamMatchRecord(team.definition().id(), match.definition().competition(), match.definition().season(), match.date(), goalsFor, goalsAgainst);
    }

    private TeamElo eloOf(Team team) {
        TeamElo analysis = application.tableStore().teamElo(team.definition().id());
        if (analysis == null) analysis = application.tableStore().create().teamElo(team.definition().id());
        return analysis;
    }

    private int pointsOf(Team team) {
        String winner = match.winner();
        if (winner == null) return 1;
        if (winner.equals(team.definition().id())) return 3;
        return 0;
    }

    private int goalsForOf(Team team) {
        return (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team.definition().id())).count();
    }

    private int goalsAgainstOf(Team team) {
        return (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> !e.team().equals(team.definition().id())).count();
    }
}
