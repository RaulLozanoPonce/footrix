package rlp.footrix.protrix.simulator.types;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.weights.PlayerValue;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.generators.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Injury;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Substitution;

public class SubstitutionEventSimulator extends EventSimulator {
    private static final double BaseSubChance = 0.44;
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
            return substitutions(local(), tacticPlayersToSubstitute(local(), new HashSet<>()), minute);
        } else {
            return substitutions(local(), tacticPlayersToSubstitute(visitant(), new HashSet<>()), minute);
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

    private Set<String> tacticPlayersToSubstitute(String team, Set<String> necessarySubstitutions) {
        if (state.lineup(team).remainingSubstitutions(5) <= 0) return new HashSet<>();  //TODO
        Set<String> tacticSubstitutions = new HashSet<>();
        Set<String> irreplaceablePlayers = irreplaceablePlayers(team);
        List<String> replaceablePlayers;
        //for (int i = 0; i < state.lineup(team).remainingSubstitutions(5) - necessarySubstitutions.size(); i++) {
        for (int i = 0; i < 1; i++) {
            replaceablePlayers = replaceablePlayers(team, irreplaceablePlayers, necessarySubstitutions);
            if (replaceablePlayers.isEmpty()) break;
            tacticSubstitutions.add(replaceablePlayers.getFirst());
        }
        return tacticSubstitutions;
    }

    private List<String> replaceablePlayers(String team, Set<String> irreplaceablePlayers, Set<String> necessarySubstitutions) {
        return state.lineup(team).fieldPlayers().stream()
                .filter(p -> !irreplaceablePlayers.contains(p.definition().id()))
                .filter(p -> !necessarySubstitutions.contains(p.definition().id()))
                .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.lineup(team).positionOf(p1.definition().id())), scoreOfMatch(p2, state.lineup(team).positionOf(p2.definition().id()))))
                .map(p -> p.definition().id())
                .toList();
    }

    private Set<String> irreplaceablePlayers(String team) {
        return state.events().stream()
                .filter(e -> e.type() == Substitution)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .collect(Collectors.toSet());
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
            if (LineupGenerator.scoreOfMatch(p1, position) > LineupGenerator.scoreOfMatch(p2, position)) return p1;
            if (LineupGenerator.scoreOfMatch(p1, position) < LineupGenerator.scoreOfMatch(p2, position)) return p2;
            if (p1.cache().relativeCache(position) > p2.cache().relativeCache(position)) return p1;
            return p2;
        }).orElse(null);
    }

    private String pickPlayerOut(PlayersLineup lineup) {
        Map<Player, Double> weights = new HashMap<>();
        double total = 0;

        for (Player p : lineup.fieldPlayers()) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double weight = (playerValue.fatigue(player) * 0.7) + ((10 - playerValue.rating(player)) * 0.4);
            if (weight < 0.01) weight = 0.01;
            weights.put(p, weight);
            total += weight;
        }

        double r = Math.random() * total;
        for (var e : weights.entrySet()) {
            r -= e.getValue();
            if (r <= 0) return e.getKey().definition().id();
        }

        return lineup.fieldPlayers().get((int) (Math.random() * lineup.fieldPlayers().size())).definition().id();
    }

    private String pickPlayerIn(PlayersLineup lineup, Position positionOut) {
        Map<Player, Double> weights = new HashMap<>();
        double total = 0;

        for (Player p : lineup.substitutes()) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double weight = ((1.0 - playerValue.fatigue(player)) * 0.7) + (player.overall(positionOut) / 200.0);
            weights.put(p, weight);
            total += weight;
        }

        double r = Math.random() * total;
        for (var e : weights.entrySet()) {
            r -= e.getValue();
            if (r <= 0) return e.getKey().definition().id();
        }

        return lineup.substitutes().get((int) (Math.random() * lineup.substitutes().size())).definition().id();
    }
}
