package rlp.footrix.protrix.ai.matchsimulator.types;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;
import rlp.footrix.protrix.types.Positions;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.generators.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Injury;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Substitution;

public class SubstitutionEventSimulator extends EventSimulator {
    private static final double BaseSubChance = 1;
    private final MatchDefinition definition;

    public SubstitutionEventSimulator(MatchDefinition definition, MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
        this.definition = definition;
    }

    @Override
    public List<Match.MatchEvent> simulate(int minute) {
        Set<String> localNeededSubstitutions = neededSubstitutions(local());
        Set<String> visitantNeededSubstitutions = neededSubstitutions(visitant());
        if (!localNeededSubstitutions.isEmpty() || !visitantNeededSubstitutions.isEmpty())
            return simulateNeededSubstitutions(localNeededSubstitutions, visitantNeededSubstitutions, minute);

        //TODO ESTUDIAR SUSTITUCIONES CON UNA NORMAL
        if (minute < 45) return new ArrayList<>();
        if (Math.random() > BaseSubChance) return new ArrayList<>();
        if (Math.random() < 0.5) {
            return substitutions(local(), tacticPlayersToSubstitute(local()), minute);
        } else {
            return substitutions(visitant(), tacticPlayersToSubstitute(visitant()), minute);
        }
    }

    private List<Match.MatchEvent> simulateNeededSubstitutions(Set<String> localNeededSubstitutions, Set<String> visitantNeededSubstitutions, int minute) {
        List<Match.MatchEvent> events = new ArrayList<>();
        events.addAll(substitutions(local(), localNeededSubstitutions, minute));
        events.addAll(substitutions(visitant(), visitantNeededSubstitutions, minute));
        return events;
    }

    private Set<String> neededSubstitutions(String team) {
        return state.minuteEvents().stream()
                .filter(e -> e.type() == Injury)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .limit(state.lineup(team).remainingSubstitutions(5))
                .collect(Collectors.toSet());
    }

    private Set<String> tacticPlayersToSubstitute(String team) {
        int remainingSubstitutions = state.lineup(team).remainingSubstitutions(5);  //TODO PARAMETRIZAR
        if (remainingSubstitutions <= 0) return new HashSet<>();
        List<String> replaceablePlayers = replaceablePlayers(team, irreplaceablePlayers(team));
        if (replaceablePlayers.isEmpty()) return new HashSet<>();
        return replaceablePlayers.stream()
                .limit(min(remainingSubstitutions, 3, replaceablePlayers.size()))
                .collect(Collectors.toSet());
    }

    private long min(int remainingSubstitutions, int maxSubstitutionsByWindow, int replaceablePlayers) {
        return Math.min(remainingSubstitutions, Math.min(maxSubstitutionsByWindow, replaceablePlayers));
    }

    private List<String> replaceablePlayers(String team, Set<String> irreplaceablePlayers) {
        //TODO TENER EN CUENTA LA PUNTUACION ACTUAL DEL PARTIDO
        return state.lineup(team).fieldPlayers().stream()
                .filter(p -> !irreplaceablePlayers.contains(p.definition().id()))
                .filter(p -> energy(p) < 0.25)
                .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.lineup(team).positionOf(p1.definition().id()), energy(p1)), scoreOfMatch(p2, state.lineup(team).positionOf(p2.definition().id()), energy(p2))))
                .map(p -> p.definition().id())
                .toList();
    }

    private double energy(Player player) {
        return player.energy() - state.fatigue(player.definition().id());
    }

    private Set<String> irreplaceablePlayers(String team) {
        Set<String> players = new HashSet<>();
        state.lineup(team).fieldPlayers().stream()
                .filter(p -> state.positionOf(team, p.definition().id()) == Positions.PT)
                .forEach(p -> players.add(p.definition().id()));
        state.events().stream()
                .filter(e -> e.type() == Substitution)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .forEach(players::add);
        return players;
    }

    private List<Match.MatchEvent> substitutions(String team, Collection<String> substitutions, int minute) {
        List<Match.MatchEvent> events = new ArrayList<>();
        for (String playerId : substitutions) {
            Player playerToSubstitute = state.lineup(team).fieldPlayers().stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = substitute(team, playerToSubstitute);
            if (successful == null) continue;
            events.add(new Match.MatchEvent(team, Substitution, minute, successful.definition().id(), playerId, null));
        }
        return events;
    }

    private Player substitute(String team, Player player) {
        PlayersLineup lineup = state.lineup(team);
        Position position = lineup.positionOf(player.definition().id());
        return lineup.substitutes().stream().reduce((p1, p2) -> {
            if (LineupGenerator.scoreOfMatch(p1, position, energy(p1)) > LineupGenerator.scoreOfMatch(p2, position, energy(p2))) return p1;
            if (LineupGenerator.scoreOfMatch(p1, position, energy(p1)) < LineupGenerator.scoreOfMatch(p2, position, energy(p2))) return p2;
            if (p1.cache().relativeCache(position) > p2.cache().relativeCache(position)) return p1;
            return p2;
        }).orElse(null);
    }
}
