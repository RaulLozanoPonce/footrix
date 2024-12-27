package rlp.footrix.framework.events;

import rlp.footrix.framework.types.*;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.var.PlayerMatchPerformance;
import rlp.footrix.framework.var.Revision;
import rlp.footrix.framework.var.TeamResult;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.helpers.LineupGenerator.playersLineup;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.Goal;

public class SimulateMatch extends Event {

    private final MatchDefinition definition;
    private Team local;
    private Team visitant;
    private List<Player> localPlayers;
    private List<Player> visitantPlayers;

    public SimulateMatch(MatchDefinition definition) {
        super(definition.date());
        this.definition = definition;
    }

    @Override
    public Event setup() {
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
        postMatchPlayersRevisions(revisions, match).forEach(r -> configuration.var().publish(r));
        postMatchTeamsRevisions(match).forEach(r -> configuration.var().publish(r));
    }

    private Match playMatch() {
        PlayersLineup localLineup = playersLineup(local.lineup(), localPlayers);
        PlayersLineup visitantLineup = playersLineup(visitant.lineup(), visitantPlayers);
        return configuration.matchSimulator(definition).simulate(localLineup, visitantLineup);
    }

    private void postMatch(Match match) {
        adjustMood(match);
        reduceSanctions();
        registerCardsAndSanctions(match);
        registerInjuries(match);
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
                .filter(e -> e.who().equals(player.definition().id()))
                .filter(e -> e.type() == Match.MatchEvent.Type.NeededSubstitution || e.type() == Match.MatchEvent.Type.Expulsion)
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

        //TODO TENGO QUE PONER AQUI EL REGISTRO DE SANCIONES
        for (String playerId : teams.keySet()) {
            Player player = configuration.playerManager().get(playerId);
            registerCardsAndSanctionsTo(player, teams.get(playerId), yellowCards, expulsions);
        }
    }

    private void registerCardsAndSanctionsTo(Player player, String teamId, Map<String, Integer> yellowCards, Map<String, Integer> expulsions) {
        if (expulsions.containsKey(player.definition().id())) {
            player.yellowCards(-5, definition.competition());
            if (yellowCards.containsKey(player.definition().id()) && yellowCards.get(player.definition().id()) >= 2) {
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(1);
                player.sanction(1, definition.competition());
            } else {
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(3);
                player.sanction(3, definition.competition());
            }
        } else {
            player.yellowCards(yellowCards.get(player.definition().id()), definition.competition());
            if (player.yellowCards(definition.competition()) >= 5) {
                player.yellowCards(-5, definition.competition());
                configuration.teamManager().get(teamId).registrationOf(player.definition().id()).addSanction(1);
                player.sanction(1, definition.competition());
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
        //TODO TENDRE QUE TOCAR POR %
        match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.MinorInjury)
                .forEach(e -> configuration.playerManager().get(e.who()).addInjury(configuration.timeManager().future(10)));    //TODO 10
        match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.SeriousInjury)
                .forEach(e -> configuration.playerManager().get(e.who()).addInjury(configuration.timeManager().future(60)));
        match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.VerySeriousInjury)
                .forEach(e -> configuration.playerManager().get(e.who()).addInjury(configuration.timeManager().future(250)));
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
        revisions.addAll(playersOf(local).stream().map(p -> revisionOf(p, local.registrationOf(p.definition().id()))).toList());
        revisions.addAll(playersOf(visitant).stream().map(p -> revisionOf(p, visitant.registrationOf(p.definition().id()))).toList());
        return revisions;
    }

    private Revision revisionOf(Player player, PlayerRegistration registration) {
        return new PlayerMatchPerformance(ts)
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
        revision.enterMinute(match.events().stream().filter(e -> e.who().equals(player.definition().id()) && e.type() == Match.MatchEvent.Type.SubstituteIn).map(Match.MatchEvent::minute).findFirst().orElse(null));
        revision.exitMinute(match.events().stream().filter(e -> e.who().equals(player.definition().id()) && e.type() == Match.MatchEvent.Type.SubstituteOut).map(Match.MatchEvent::minute).findFirst().orElse(null));
    }

    private List<Revision> postMatchTeamsRevisions(Match match) {
        List<Revision> revisions = new ArrayList<>();
        int localGoals = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(match.definition().local())).count();
        int visitantGoals = (int) match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(match.definition().visitant())).count();
        revisions.add(new TeamResult(match.definition().date()).competitionId(match.definition().competition()).teamId(match.definition().local()).goalsFor(localGoals).goalsAgainst(visitantGoals).points(pointsOf(localGoals, visitantGoals)));
        revisions.add(new TeamResult(match.definition().date()).competitionId(match.definition().competition()).teamId(match.definition().visitant()).goalsFor(visitantGoals).goalsAgainst(localGoals).points(pointsOf(visitantGoals, localGoals)));
        return revisions;
    }

    private int pointsOf(int goalsFor, int goalsAgainst) {
        if (goalsFor > goalsAgainst) return 3;
        if (goalsFor < goalsAgainst) return 0;
        return 1;
    }
}
