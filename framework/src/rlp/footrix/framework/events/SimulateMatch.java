package rlp.footrix.framework.events;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team.PlayersLineup;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.var.PlayerMatchPerformance;
import rlp.footrix.framework.var.Revision;
import rlp.footrix.framework.var.MatchResult;
import rlp.footrix.framework.var.VarTerminal;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.generators.LineupGenerator.playersLineup;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.Goal;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.Substitution;

public class SimulateMatch extends Event {

    private final MatchDefinition definition;
    private Competition competition;
    private Competition.Phase phase;
    private Team local;
    private Team visitant;
    private List<Player> localPlayers;
    private List<Player> visitantPlayers;

    public SimulateMatch(Instant date, MatchDefinition definition) {
        super(date);
        this.definition = definition;
    }

    @Override
    public Event setup() {
        this.competition = configuration.competitionManager().get(definition.competition(), definition.season());
        this.phase = this.competition.phase(definition.phase());
        this.local = configuration.teamManager().get(definition.local());
        this.visitant = configuration.teamManager().get(definition.visitant());
        this.localPlayers = availablePlayersOf(local);
        this.visitantPlayers = availablePlayersOf(visitant);
        return this;
    }

    @Override
    public void execute() {
        List<Revision> revisions = preMatchPlayersRevisions();
        Match match = playMatch();
        configuration.matchStore().save(match);
        postMatch(match);
        postMatchPlayersRevisions(revisions, match).forEach(VarTerminal::publish);
        postMatchTeamsRevisions(match).forEach(VarTerminal::publish);
    }

    private Match playMatch() {
        PlayersLineup localLineup = playersLineup(phase, configuration.lineupsManager().get(local.lineup()), localPlayers);
        PlayersLineup visitantLineup = playersLineup(phase, configuration.lineupsManager().get(visitant.lineup()), visitantPlayers);
        return configuration.matchSimulator(definition, ts).simulate(localLineup, visitantLineup);
    }

    private void postMatch(Match match) {
        adjustMood(match);
        reduceSanctions();
        registerCardsAndSanctions(match);
        registerInjuries(match);
        adjustTeamRankingScores(match);
    }

    private void adjustMood(Match match) {
        adjustMood(match, localPlayers, local);
        adjustMood(match, visitantPlayers, visitant);
    }

    private void adjustMood(Match match, List<Player> players, Team team) {
        players.forEach(p -> {
            double minutes = minutesOf(p, match);
            double maxMinutes = maxMinutesOf(p, match);
            double difference = (minutes/maxMinutes) - team.contractOf(p.definition().id()).role().expectedPlayingTime();
            team.registrationOf(p.definition().id()).addMinutes(minutes, maxMinutes, match.definition().competition());
            p.mood().gameTime(deltaGameTimeMood(difference));
        });
    }

    private double maxMinutesOf(Player player, Match match) {
        Match.MatchEvent outs = match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.NeededSubstitution || e.type() == Match.MatchEvent.Type.Expulsion)
                .filter(e -> e.who().equals(player.definition().id()))
                .findFirst().orElse(null);
        if (outs == null) return match.duration();
        return outs.minute();
    }

    private double minutesOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        if (statistics == null) return 0.0;
        return statistics.minutes().values().stream().mapToDouble(v -> v).sum();
    }

    private double deltaGameTimeMood(double difference) {
        return 0.21 * difference;
    }

    private void reduceSanctions() {
        reduceSanctions(playersOf(local));
        reduceSanctions(playersOf(visitant));
    }

    private void reduceSanctions(List<Player> players) {
        players.forEach(p -> p.sanction(- 1, definition.competition()));
    }

    private void registerCardsAndSanctions(Match match) {
        Map<String, String> teams = new HashMap<>();
        Map<String, Integer> yellowCards = new HashMap<>();
        Map<String, Integer> expulsions = new HashMap<>();

        for (Match.MatchEvent event : match.events()) {
            fill(event, teams, yellowCards, expulsions);
        }

        for (String playerId : teams.keySet()) {
            Player player = configuration.playerManager().get(playerId);
            registerCardsAndSanctionsTo(player, teams.get(playerId), yellowCards, expulsions);
        }
    }

    private void registerCardsAndSanctionsTo(Player player, String teamId, Map<String, Integer> yellowCards, Map<String, Integer> expulsions) {
        if (expulsions.containsKey(player.definition().id())) {
            player.yellowCards(- competition.definition().accumulatedYellowCardNumber(), definition.competition());
            if (yellowCards.containsKey(player.definition().id()) && yellowCards.get(player.definition().id()) >= 2) {
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(competition.definition().doubleYellowCardSanction());
                player.sanction(competition.definition().doubleYellowCardSanction(), definition.competition());
            } else {
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(competition.definition().redCardSanction());
                player.sanction(competition.definition().redCardSanction(), definition.competition());
            }
        } else {
            player.yellowCards(yellowCards.get(player.definition().id()), definition.competition());
            if (player.yellowCards(definition.competition()) >= competition.definition().accumulatedYellowCardNumber()) {
                player.yellowCards(- competition.definition().accumulatedYellowCardNumber(), definition.competition());
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(competition.definition().accumulatedYellowCardSanction());
                player.sanction(competition.definition().accumulatedYellowCardSanction(), definition.competition());
            }
        }
    }

    private static void fill(Match.MatchEvent event, Map<String, String> players, Map<String, Integer> yellowCards, Map<String, Integer> expulsions) {
        if (event.type() == Match.MatchEvent.Type.YellowCard) {
            players.put(event.who(), event.team());
            yellowCards.putIfAbsent(event.who(), 0);
            yellowCards.put(event.who(), yellowCards.get(event.who()) + 1);
        } else if (event.type() == Match.MatchEvent.Type.Expulsion) {
            players.put(event.who(), event.team());
            expulsions.putIfAbsent(event.who(), 0);
            expulsions.put(event.who(), expulsions.get(event.who()) + 1);
        }
    }

    private void registerInjuries(Match match) {
        match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.MinorInjury || e.type() == Match.MatchEvent.Type.SeriousInjury || e.type() == Match.MatchEvent.Type.VerySeriousInjury)
                .forEach(e -> configuration.playerManager().get(e.who()).addInjury(configuration.timeManager().future(injuryDaysOf(e))));
    }

    private int injuryDaysOf(Match.MatchEvent event) {
        double random = 0.99 * Math.random();
        return (int) Math.round(minInjuryDaysOf(event) - meanInjuryDaysOf(event) * Math.log10(1 - random));
    }

    private float minInjuryDaysOf(Match.MatchEvent event) {
        return switch (event.type()) {
            case MinorInjury -> 1;
            case SeriousInjury -> 20;
            case VerySeriousInjury -> 120;
            default -> 0;
        };
    }

    private float meanInjuryDaysOf(Match.MatchEvent event) {
        return switch (event.type()) {
            case MinorInjury -> 9;
            case SeriousInjury -> 50;
            case VerySeriousInjury -> 190;
            default -> 0;
        };
    }

    private void adjustTeamRankingScores(Match match) {
        int localNewScore = configuration.teamRankingHandler()
                .newScore(local, visitant, definition.competition() + "-" + definition.phase(), pointsOf(local.definition().id(), match), phase.definition().withPenalties());
        int visitantNewScore = configuration.teamRankingHandler()
                .newScore(visitant, local, definition.competition() + "-" + definition.phase(), pointsOf(visitant.definition().id(), match), phase.definition().withPenalties());
        local.elo(localNewScore);
        visitant.elo(visitantNewScore);
    }

    private List<Player> availablePlayersOf(Team team) {
        return playersOf(team).stream()
                .filter(p -> !p.isInjured())
                .filter(p -> !p.hasSanction(definition.competition()))
                .toList();
    }

    private List<Player> playersOf(Team team) {
        return team.players().stream()
                .map(d -> configuration.playerManager().get(d.id()))
                .toList();
    }

    private List<Revision> preMatchPlayersRevisions() {
        List<Revision> revisions = new ArrayList<>();
        revisions.addAll(playersOf(local).stream().map(this::revisionOf).toList());
        revisions.addAll(playersOf(visitant).stream().map(this::revisionOf).toList());
        return revisions;
    }

    private Revision revisionOf(Player player) {
        return new PlayerMatchPerformance(UUID.randomUUID().toString())
                .date(ts)
                .player(player.definition().id())
                .match(definition.local() + " - " + definition.visitant())
                .preEnergy(player.energy())
                .preHappiness(player.mood().gameTime())
                .note(noteOf(player));
    }

    private String noteOf(Player player) {
        if (player.isInjured()) return "Lesionado";
        if (player.hasSanction(definition.competition())) return "Sancionado";
        return null;
    }

    private List<Revision> postMatchPlayersRevisions(List<Revision> revisions, Match match) {
        Map<String, List<Revision>> revisionMap = revisions.stream().collect(Collectors.groupingBy(r -> ((PlayerMatchPerformance) r).player()));
        playersOf(local).forEach(p -> revisionOf(p, (PlayerMatchPerformance) revisionMap.get(p.definition().id()).getFirst(), match));
        playersOf(visitant).forEach(p -> revisionOf(p, (PlayerMatchPerformance) revisionMap.get(p.definition().id()).getFirst(), match));
        return revisions;
    }

    private void revisionOf(Player player, PlayerMatchPerformance revision, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        revision.position(statistics == null ? null : statistics.minutes().entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null));
        revision.postEnergy(player.energy());
        revision.postHappiness(player.mood().gameTime());
        revision.expelled(match.events().stream().anyMatch(e -> e.who().equals(player.definition().id()) && e.type() == Match.MatchEvent.Type.Expulsion));
        revision.injured(match.events().stream().anyMatch(e -> e.who().equals(player.definition().id()) && (e.type() == Match.MatchEvent.Type.MinorInjury || e.type() == Match.MatchEvent.Type.SeriousInjury || e.type() == Match.MatchEvent.Type.VerySeriousInjury)));
        revision.enterMinute(match.events().stream().filter(e -> e.type() == Substitution).filter(e -> e.who().equals(player.definition().id())).map(Match.MatchEvent::minute).findFirst().orElse(null));
        revision.exitMinute(match.events().stream().filter(e -> e.type() == Substitution).filter(e -> e.secondaryWho().equals(player.definition().id())).map(Match.MatchEvent::minute).findFirst().orElse(null));
    }

    private List<Revision> postMatchTeamsRevisions(Match match) {
        List<Revision> revisions = new ArrayList<>();
        int localGoals = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(match.definition().local())).count();
        int visitantGoals = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(match.definition().visitant())).count();
        revisions.add(new MatchResult(matchResultKey(match)).localGoals(localGoals).visitantGoals(visitantGoals));
        return revisions;
    }

    private static String matchResultKey(Match match) {
        return match.definition().competition() + ";" +
                match.definition().phase() + ";" +
                match.definition().group() + ";" +
                match.definition().matchDay() + ";" +
                match.definition().season() + ";" +
                match.definition().local() + ";" +
                match.definition().visitant();
    }

    private int pointsOf(String team, Match match) {
        int goalsFor = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team)).count();
        int goalsAgainst = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> !e.team().equals(team)).count();
        return pointsOf(goalsFor, goalsAgainst);
    }

    private int pointsOf(int goalsFor, int goalsAgainst) {
        if (goalsFor > goalsAgainst) return 3;
        if (goalsFor < goalsAgainst) return 0;
        return 1;
    }
}
