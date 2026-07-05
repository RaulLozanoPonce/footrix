package rlp.footrix.protrix.ai.matchsimulator.types;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.generators.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.entities.match.MatchEvent.Type.*;

public class SubstitutionEventSimulator extends EventSimulator {
    private static final double BaseSubChance = 1;
    private final MatchDefinition definition;

    public SubstitutionEventSimulator(MatchDefinition definition, MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
        this.definition = definition;
    }

    @Override
    public List<MatchEvent> simulate(int minute) {
        Set<String> localNeededSubstitutions = neededSubstitutions(local());
        Set<String> visitantNeededSubstitutions = neededSubstitutions(visitant());
        if (!localNeededSubstitutions.isEmpty() || !visitantNeededSubstitutions.isEmpty())
            return simulateNeededSubstitutions(localNeededSubstitutions, visitantNeededSubstitutions, minute);

        if (minute < 45) return new ArrayList<>();
        if (Math.random() > BaseSubChance) return new ArrayList<>();
        if (Math.random() < 0.5) {
            return substitutions(local(), tacticPlayersToSubstitute(local(), minute), minute);
        } else {
            return substitutions(visitant(), tacticPlayersToSubstitute(visitant(), minute), minute);
        }
    }

    private List<MatchEvent> simulateNeededSubstitutions(Set<String> localNeededSubstitutions, Set<String> visitantNeededSubstitutions, int minute) {
        List<MatchEvent> events = new ArrayList<>();
        events.addAll(substitutions(local(), localNeededSubstitutions, minute));
        events.addAll(substitutions(visitant(), visitantNeededSubstitutions, minute));
        return events;
    }

    private Set<String> neededSubstitutions(String team) {
        int remainingSubstitutions = state.lineup(team).remainingSubstitutions(5);
        if (remainingSubstitutions <= 0) return new HashSet<>();

        Set<String> expelled = state.minuteEvents().stream().filter(e -> e.type() == Expulsion && e.team().equals(team)).map(MatchEvent::who).collect(Collectors.toSet());
        Player goalkeeper = state.goalkeeper(team);

        Set<String> neededSubstitutions = new HashSet<>();
        if (goalkeeper.mainPosition() != Positions.PT && !expelled.contains(goalkeeper.definition().id())) {
            neededSubstitutions.add(goalkeeper.definition().id());
        }
        Set<String> injureds = state.minuteEvents().stream()
                .filter(e -> e.type() == Injury)
                .filter(e -> e.team().equals(team))
                .map(MatchEvent::who)
                .filter(p -> !expelled.contains(p))
                .collect(Collectors.toSet());
        for (String injured : injureds) {
            if (neededSubstitutions.size() == remainingSubstitutions) break;
            neededSubstitutions.add(injured);
        }
        return neededSubstitutions;
    }

    private Set<String> tacticPlayersToSubstitute(String team, int minute) {
        int remainingSubstitutions = state.lineup(team).remainingSubstitutions(5);  //TODO PARAMETRIZAR
        if (remainingSubstitutions <= 0) return new HashSet<>();
        List<String> replaceablePlayers = replaceablePlayers(team, irreplaceablePlayers(team), minute);
        if (replaceablePlayers.isEmpty()) return new HashSet<>();
        return replaceablePlayers.stream()
                .limit(min(remainingSubstitutions, 3, replaceablePlayers.size()))
                .collect(Collectors.toSet());
    }

    private long min(int remainingSubstitutions, int maxSubstitutionsByWindow, int replaceablePlayers) {
        return Math.min(remainingSubstitutions, Math.min(maxSubstitutionsByWindow, replaceablePlayers));
    }

    private List<String> replaceablePlayers(String team, Set<String> irreplaceablePlayers, int minute) {
        Set<String> expelled = state.minuteEvents().stream().filter(e -> e.type() == Expulsion && e.team().equals(team)).map(MatchEvent::who).collect(Collectors.toSet());
        return state.lineup(team).fieldPlayers().stream()
                .filter(p -> !expelled.contains(p.definition().id()))
                .filter(p -> !irreplaceablePlayers.contains(p.definition().id()))
                .filter(p -> performance((Pes6Player) p, minute) < 0.3)
                .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.lineup(team).positionOf(p1.definition().id()), energy(p1)), scoreOfMatch(p2, state.lineup(team).positionOf(p2.definition().id()), energy(p2))))
                .map(p -> p.definition().id())
                .toList();
    }

    private Set<String> irreplaceablePlayers(String team) {
        Set<String> players = new HashSet<>();
        state.lineup(team).fieldPlayers().stream()
                .filter(p -> state.positionOf(team, p.definition().id()) == Positions.PT)
                .forEach(p -> players.add(p.definition().id()));
        state.events().stream()
                .filter(e -> e.type() == Substitution)
                .filter(e -> e.team().equals(team))
                .map(MatchEvent::who)
                .forEach(players::add);
        return players;
    }

    private List<MatchEvent> substitutions(String team, Collection<String> substitutions, int minute) {
        Set<String> noNewPlayers = new HashSet<>();
        List<MatchEvent> events = new ArrayList<>();
        for (String playerId : substitutions) {
            Player playerToSubstitute = state.lineup(team).fieldPlayers().stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = substitute(team, playerToSubstitute, noNewPlayers);
            if (successful == null) continue;
            noNewPlayers.add(successful.definition().id());
            events.add(new MatchEvent(team, Substitution, minute, successful.definition().id(), playerId, null));
        }
        return events;
    }

    private Player substitute(String team, Player player, Set<String> newPlayers) {
        PlayersLineup lineup = state.lineup(team);
        Position position = lineup.positionOf(player.definition().id());
        return lineup.substitutes().stream().filter(p -> !newPlayers.contains(p.definition().id())).reduce((p1, p2) -> {
            if (LineupGenerator.scoreOfMatch(p1, position, energy(p1)) > LineupGenerator.scoreOfMatch(p2, position, energy(p2))) return p1;
            if (LineupGenerator.scoreOfMatch(p1, position, energy(p1)) < LineupGenerator.scoreOfMatch(p2, position, energy(p2))) return p2;
            if (p1.cache().relativeCache(position) > p2.cache().relativeCache(position)) return p1;
            return p2;
        }).orElse(null);
    }

    private double performance(Pes6Player player, int minute) {
        double energyPerformance = 1;
        if (energy(player) < 0.25) energyPerformance = 0;
        else if (energy(player) < 0.4) energyPerformance = (energy(player) - 0.25) / 0.15;
        double scorePerformance = 1;
        if (playerValue.score(player, minute) < 4.5) scorePerformance = 0;
        else if (playerValue.score(player, minute) < 5.5) scorePerformance = (playerValue.score(player, minute) - 4.5) / 1.0;
        return energyPerformance * scorePerformance;
    }

    private double energy(Player player) {
        return Math.max(0, player.psychophysics().energy() - state.fatigue(player.definition().id()));
    }
}
