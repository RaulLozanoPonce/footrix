package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static rlp.footrix.framework.types.entities.match.MatchEvent.Type.Injury;

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
        this.localMatchImportance = matchImportance(local, visitant);
        this.visitantMatchImportance = matchImportance(visitant, local);
    }

    public void execute() {
        registerMatch();
        adjustTeamElo();
        adjustMood();
        adjustCache();
        reduceSanctions();
        registerCardsAndSanctions();
        registerEnergyAndPhysicalForm();
        registerInjuries();
    }

    private int deltaElo() {
        return application.eloManager().deltaElo(local.elo().quantity(), visitant.elo().quantity(), match.definition().competition(), match.definition().phase(), pointsOf(match.definition().local()), match.withPenalties());
    }

    private double matchImportance(Team team, Team other) {
        //TODO SI NO FUNCIONA, DEVOLVER 1
        return Math.max(0, Math.min(2, (application.eloManager().importance(match.definition().competition(), match.definition().phase()) / 15.0) * (other.elo().quantity() / (double) team.elo().quantity())));
    }

    private void registerMatch() {
        application.streakManager().newMatch(match);
    }

    private void adjustTeamElo() {
        local.elo().adjust(local.elo().quantity() + deltaElo);
        visitant.elo().adjust(visitant.elo().quantity() - deltaElo);
    }

    private void reduceSanctions() {
        local.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
        visitant.players().forEach(p -> p.sanction(- 1, match.definition().competition()));
    }

    private void adjustMood() {
        local.players().forEach(p -> adjustMood(p, deltaElo, localMatchImportance, startingRole(local.definition().id(), p)));
        visitant.players().forEach(p -> adjustMood(p, -deltaElo, visitantMatchImportance, startingRole(visitant.definition().id(), p)));
    }

    private Match.MatchRole startingRole(String team, Player player) {
        Match.PlayerStatistics playerStatistics = match.playerStatistics().get(team).get(player.definition().id());
        if (playerStatistics == null) return Match.MatchRole.Reserve;
        return playerStatistics.matchRole();
    }

    private void adjustMood(Player player, int deltaElo, double matchImportance, Match.MatchRole matchRole) {
        player.psychophysics().gameTimeSatisfaction(application.psychophysicsCalculator().deltaGameTimeSatisfaction(player, match, matchImportance, matchRole));
        player.psychophysics().selfConfidence(application.psychophysicsCalculator().deltaSelfConfidenceMatch(player, match, matchImportance));
        player.psychophysics().collectivePerformance(application.psychophysicsCalculator().deltaCollectivePerformanceMatchMood(player.team(), deltaElo));
    }

    private void adjustCache() {
        local.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match, localMatchImportance)));
        visitant.players().forEach(p -> p.cache().absoluteCache(application.cacheCalculator().deltaAbsoluteCache(p, match, visitantMatchImportance)));
    }

    private void registerCardsAndSanctions() {
        CompetitionDefinition competition = application.competitionManager().get(match.definition().competition()).definition();
        Set<String> players = new HashSet<>();
        Map<String, Integer> yellowCardsMap = new HashMap<>();
        Set<String> expelledPlayers = new HashSet<>();
        for (MatchEvent event : match.events()) fill(event, players, yellowCardsMap, expelledPlayers);
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

    private static void fill(MatchEvent event, Set<String> players, Map<String, Integer> yellowCards, Set<String> expelledPlayers) {
        if (event.type() == MatchEvent.Type.YellowCard) {
            players.add(event.who());
            yellowCards.putIfAbsent(event.who(), 0);
            yellowCards.put(event.who(), yellowCards.get(event.who()) + 1);
        } else if (event.type() == MatchEvent.Type.Expulsion) {
            players.add(event.who());
            expelledPlayers.add(event.who());
        }
    }

    private void registerEnergyAndPhysicalForm() {
        for (String team : match.playerStatistics().keySet()) {
            for (String player : match.playerStatistics().get(team).keySet()) {
                team(team).player(player).psychophysics().energy(- match.playerStatistics().get(team).get(player).fatigue());
                team(team).player(player).psychophysics().physicalCondition(application.psychophysicsCalculator().physicalConditionMatchGain(match.playerStatistics().get(team).get(player).minutes()));
            }
        }
    }

    private void registerInjuries() {
        for (Player player : match.events().stream().filter(e -> e.type() == Injury).map(e -> application.playerManager().get(e.who())).toList()) {
            int injuryDays = application.injuryCalculator().injuryDays(player, match);
            if (injuryDays == 0) continue;
            player.addInjury(application.timeManager().future(injuryDays));
        }
    }

    private int pointsOf(String team) {
        if (match.goalsFor(team) > match.goalsAgainst(team)) return 3;
        if (match.goalsFor(team) == match.goalsAgainst(team)) return 1;
        return 0;
    }
}
