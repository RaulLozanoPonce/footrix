package rlp.footrix.framework.events;

import rlp.footrix.framework.types.*;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.helpers.LineupGenerator.playersLineup;

public class SimulateMatch extends Event {

    private final MatchDefinition definition;

    public SimulateMatch(MatchDefinition definition) {
        super(definition.date());
        this.definition = definition;
    }

    @Override
    public void execute() {
        Team local = configuration.teamManager().get(definition.local());
        Team visitant = configuration.teamManager().get(definition.visitant());
        List<Player> localPlayers = playersOf(local);
        List<Player> visitantPlayers = playersOf(visitant);
        PlayersLineup localPlayersLineup = playersLineup(local.lineup(), localPlayers);
        PlayersLineup visitantPlayersLineup = playersLineup(visitant.lineup(), visitantPlayers);

        Match match = configuration.matchSimulator(definition).simulate(localPlayersLineup, visitantPlayersLineup);
        configuration.matchStore().save(match);
        postMatch(match, localPlayers, visitantPlayers, local, visitant);
    }

    private void postMatch(Match match, List<Player> localPlayers, List<Player> visitantPlayers, Team local, Team visitant) {
        adjustMood(match, localPlayers, visitantPlayers, local, visitant);
        reduceSanctions(allPlayersOf(local));
        reduceSanctions(allPlayersOf(visitant));
        registerCardsAndSanctions(match);
        registerInjuries(match);
    }

    private void adjustMood(Match match, List<Player> localPlayers, List<Player> visitantPlayers, Team local, Team visitant) {
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

    private void reduceSanctions(List<Player> players) {
        players.forEach(p -> p.sanction(-1, definition.competition()));
    }

    private void registerCardsAndSanctions(Match match) {
        Map<String, String> players = new HashMap<>();
        Map<String, Integer> yellowCards = new HashMap<>();
        Map<String, Integer> expulsions = new HashMap<>();

        for (Match.MatchEvent event : match.events()) {
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

        //TODO TENGO QUE PONER AQUI EL REGISTRO DE SANCIONES
        for (String playerId : players.keySet()) {
            Player player = configuration.playerManager().get(playerId);
            if (expulsions.containsKey(playerId)) {
                player.yellowCards(-5, definition.competition());
                if (yellowCards.containsKey(playerId) && yellowCards.get(playerId) >= 2) {
                    configuration.teamManager().get(players.get(playerId)).registrationOf(playerId).addSanction(1);
                    player.sanction(1, definition.competition());
                } else {
                    configuration.teamManager().get(players.get(playerId)).registrationOf(playerId).addSanction(3);
                    player.sanction(3, definition.competition());
                }
            } else {
                player.yellowCards(yellowCards.get(playerId), definition.competition());
                if (player.yellowCards(definition.competition()) >= 5) {
                    player.yellowCards(-5, definition.competition());
                    configuration.teamManager().get(players.get(playerId)).registrationOf(playerId).addSanction(1);
                    player.sanction(1, definition.competition());
                }
            }
        }
    }

    private void registerInjuries(Match match) {
        match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.Injury)
                .forEach(e -> {
                    configuration.teamManager().get(e.team()).registrationOf(e.who()).addInjury();
                    configuration.playerManager().get(e.who()).addInjury(configuration.timeManager().future(30));
                });
    }

    private List<Player> playersOf(Team team) {
        return allPlayersOf(team).stream()
                .filter(p -> !p.isInjured())
                .filter(p -> !p.hasSanction(definition.competition()))
                .toList();
    }

    private List<Player> allPlayersOf(Team team) {
        return team.players().stream()
                .map(d -> configuration.playerManager().get(d.id()))
                .toList();
    }
}
