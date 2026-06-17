package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.tables.TeamElo;

import java.util.*;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.*;

public class PostMatchCommand extends Command {
    private final Match match;
    private final Team local;
    private final Team visitant;
    private final int deltaElo;
    private final double localMatchImportance;
    private final double visitantMatchImportance;

    public PostMatchCommand(Application application, PlayedMatchEvent event) {
        super(application);
        this.match = application.entityStore().match(event.matchId());
        this.local = team(match.definition().local());
        this.visitant = team(match.definition().visitant());
        this.deltaElo = deltaElo();
        this.localMatchImportance = matchImportance(local.definition().id(), visitant.definition().id());
        this.visitantMatchImportance = matchImportance(visitant.definition().id(), local.definition().id());
    }

    public void execute() {
        adjustTeamElo();
        adjustStatistics();
        adjustMood();
        adjustCache();
        reduceSanctions();
        registerCardsAndSanctions();
        registerEnergy();
        registerInjuries();
    }

    private int deltaElo() {
        TeamElo localElo = eloOf(match.definition().local());
        TeamElo visitantElo = eloOf(match.definition().visitant());
        return application.eloManager().deltaElo(localElo.elo(), visitantElo.elo(), match.definition().competition() + "-" + match.definition().phase(), pointsOf(match.definition().local(), match.winner()), match.withPenalties());
    }

    private double matchImportance(String team, String other) {
        //TODO SI NO FUNCIONA, DEVOLVER 1
        return Math.max(0, Math.min(2, (application.eloManager().importanceOf(match.definition().competition(), match.definition().phase()) / 15.0) * (application.tableStore().teamElo(other).elo() / (double) application.tableStore().teamElo(team).elo())));
    }

    private void adjustTeamElo() {
        TeamElo localElo = eloOf(match.definition().local());
        TeamElo visitantElo = eloOf(match.definition().visitant());
        localElo.elo(localElo.elo() + deltaElo);
        visitantElo.elo(visitantElo.elo() - deltaElo);
    }

    private void reduceSanctions() {
        local.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
        visitant.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
    }

    private void adjustStatistics() {
        adjustStatistics(local);
        adjustStatistics(visitant);
    }

    private void adjustStatistics(Team team) {
        for (Player player : team.players()) {
            boolean available = !player.isInjured() && !player.hasSanction(match.definition().competition());
            Integer enterMinute = available ? enterMinuteOf(player) : null;
            Integer exitMinute = available ? exitMinuteOf(player) : null;
            int maxMinutes = available ? maxMinutesOf(player, (enterMinute == null || exitMinute == null) ? 0 : exitMinute - enterMinute) : 0;
            Double score = available ? scoreOf(player) : null;
            boolean injured = available ? has(player, Injury) : player.isInjured();
            boolean expelled = available ? has(player, Expulsion) : player.hasSanction(match.definition().competition());
            int goals = available ? count(player, Goal) : 0;
            int assists = available ? assistsOf(player) : 0;
            int yellowCards = available ? count(player, YellowCard) : 0;
            int redCards = available ? count(player, RedCard) : 0;
            updatePlayerMatchRecord(team, player, enterMinute, exitMinute, maxMinutes, score, injured, expelled, goals, assists, yellowCards, redCards, player.energy());
        }
        createTeamMatchRecord(team, goalsForOf(team), goalsAgainstOf(team));
    }

    private void adjustMood() {
        local.players().forEach(p -> adjustMood(p, deltaElo, localMatchImportance));
        visitant.players().forEach(p -> adjustMood(p, -deltaElo, visitantMatchImportance));
    }

    private void adjustMood(Player player, int deltaElo, double matchImportance) {
        player.mood().gameTime(application.moodCalculator().deltaGameTimeMood(player, match, matchImportance));
        player.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceMatchMood(player, match, matchImportance));
        player.mood().collectivePerformance(application.moodCalculator().deltaCollectivePerformanceMatchMood(player.team(), deltaElo));
    }

    private void adjustCache() {
        local.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match, localMatchImportance)));
        visitant.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match, visitantMatchImportance)));
    }

    private Integer enterMinuteOf(Player player) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        if (statistics == null) return null;
        return match.events().stream()
                .filter(e -> e.type() == Substitution)
                .filter(e -> e.who().equals(player.definition().id()))
                .map(Match.MatchEvent::minute)
                .findFirst().orElse(0);
    }

    private Integer exitMinuteOf(Player player) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        if (statistics == null) return null;
        return match.events().stream()
                .filter(e -> (e.type() == Substitution && e.secondaryWho().equals(player.definition().id())) || (e.type() == Expulsion && e.who().equals(player.definition().id())))
                .map(Match.MatchEvent::minute)
                .findFirst().orElse(90);
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

    private Double scoreOf(Player player) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.team().definition().id()).get(player.definition().id());
        if (statistics == null) return null;
        return statistics.score();
    }

    private boolean has(Player player, Match.MatchEvent.Type type) {
        return match.events().stream()
                .filter(e -> e.who().equals(player.definition().id()))
                .anyMatch(e -> e.type() == type);
    }

    private int count(Player player, Match.MatchEvent.Type type) {
        return (int) match.events().stream()
                .filter(e -> e.who().equals(player.definition().id()))
                .filter(e -> e.type() == type)
                .count();
    }

    private int assistsOf(Player player) {
        return (int) match.events().stream()
                .filter(e -> e.secondaryWho() != null && e.secondaryWho().equals(player.definition().id()))
                .filter(e -> e.type() == Goal)
                .count();
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

    private void registerEnergy() {
        for (String team : match.playerStatistics().keySet()) {
            for (String player : match.playerStatistics().get(team).keySet()) {
                team(team).player(player).energy(- match.playerStatistics().get(team).get(player).fatigue());
            }
        }
    }

    private void registerInjuries() {
        for (Player player : match.events().stream().filter(e -> e.type() == Injury).map(e -> application.playerManager().get(e.who())).toList()) {
            int injuryDays = application.injuryCalculator().injuryDays(player, match);
            player.addInjury(application.timeManager().future(injuryDays));
        }
    }

    private void updatePlayerMatchRecord(Team team, Player player, Integer enterMinute, Integer exitMinute, int maxMinutes, Double score, boolean injured, boolean expelled, int goals, int assists, int yellowCards, int redCards, double preEnergy) {
        application.recordStore().create().playerMatchRecord(match.definition().id(), player.definition().id(), team.definition().id(), match.definition().competition(), match.definition().season(), match.date(), enterMinute, exitMinute, maxMinutes, score, injured, expelled, goals, assists, yellowCards, redCards, preEnergy);
    }

    private void createTeamMatchRecord(Team team, int goalsFor, int goalsAgainst) {
        application.recordStore().create().teamMatchRecord(team.definition().id(), match.definition().competition(), match.definition().season(), match.date(), goalsFor, goalsAgainst);
    }

    private TeamElo eloOf(String teamId) {
        TeamElo analysis = application.tableStore().teamElo(teamId);
        if (analysis == null) analysis = application.tableStore().create().teamElo(teamId);
        return analysis;
    }

    private int pointsOf(String team, String winner) {
        if (winner == null) return 1;
        if (winner.equals(team)) return 3;
        return 0;
    }

    private int goalsForOf(Team team) {
        return (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team.definition().id())).count();
    }

    private int goalsAgainstOf(Team team) {
        return (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> !e.team().equals(team.definition().id())).count();
    }
}
