package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.PlayersLineup;
import rlp.footrix.protrix.simulator.MatchState;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.generators.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.*;
import static rlp.footrix.protrix.simulator.helpers.PositionFactors.substitutionPercentOf;

public class SubstitutionsSimulator extends ActionSimulator {

    public SubstitutionsSimulator(MatchState state, int minute) {
        super(state, minute);
    }

    public List<Match.MatchEvent> simulate() {
        List<Match.MatchEvent> events = new ArrayList<>();
        events.addAll(handleSubstitutions(state.local()));
        events.addAll(handleSubstitutions(state.visitant()));
        if (!events.isEmpty()) state.setPossession(state.teamWithPossession(), state.playerWithPossession());
        return events;
    }

    private List<Match.MatchEvent> handleSubstitutions(String team) {
        Set<String> necessarySubstitutions = neededSubstitutions(team);
        Set<String> tacticSubstitutions = tacticPlayersToSubstitute(team, necessarySubstitutions);
        if (necessarySubstitutions.isEmpty() && tacticSubstitutions.isEmpty()) return new ArrayList<>();
        return substitute(team, necessarySubstitutions, tacticSubstitutions);
    }

    private Set<String> neededSubstitutions(String team) {
        return state.events().stream()
                .filter(e -> e.type() == PendingSubstitution)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(p -> state.playerOf(p, team) != null)
                .filter(id -> !state.playerWithPossession().definition().id().equals(id))
                .limit(state.restSubstitutions(team))
                .collect(Collectors.toSet());
    }

    private Set<String> tacticPlayersToSubstitute(String team, Set<String> necessarySubstitutions) {
        Set<String> tacticSubstitutions = new HashSet<>();
        Set<String> irreplaceablePlayers = irreplaceablePlayers(team);
        List<String> replaceablePlayers;
        for (int i = 0; i < state.restSubstitutions(team) - necessarySubstitutions.size(); i++) {
            if (100 * Math.random() < 3.25 * substitutionPercentOf(minute)) {
                replaceablePlayers = replaceablePlayers(team, irreplaceablePlayers, necessarySubstitutions);
                if (replaceablePlayers.isEmpty()) break;
                tacticSubstitutions.add(replaceablePlayers.getFirst());
            } else {
                break;
            }
        }
        return tacticSubstitutions;
    }

    private Set<String> irreplaceablePlayers(String team) {
        return state.events().stream()
                .filter(e -> e.type() == Substitution)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .collect(Collectors.toSet());
    }

    private List<String> replaceablePlayers(String team, Set<String> irreplaceablePlayers, Set<String> necessarySubstitutions) {
        return state.playersOf(team).stream()
                .filter(p -> !irreplaceablePlayers.contains(p.definition().id()))
                .filter(p -> !necessarySubstitutions.contains(p.definition().id()))
                .filter(p -> !state.playerWithPossession().definition().id().equals(p.definition().id()))
                .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.positionOf(p1)), scoreOfMatch(p2, state.positionOf(p2))))
                .map(p -> p.definition().id())
                .toList();
    }

    private List<Match.MatchEvent> substitute(String team, Set<String> necessarySubstitutions, Set<String> tacticSubstitutions) {
        List<Match.MatchEvent> events = new ArrayList<>();
        for (String playerId : merge(necessarySubstitutions, tacticSubstitutions)) {
            Player playerToSubstitute = state.playerOf(playerId, team);
            if (playerToSubstitute == null) continue;
            Player successful = substitute(team, playerToSubstitute);
            if (successful == null) continue;
            events.add(new Match.MatchEvent(team, Substitution, minute, successful.definition().id(), playerToSubstitute.definition().id()));
            if (necessarySubstitutions.contains(playerId)) events.add(new Match.MatchEvent(team, NeededSubstitution, minute, playerToSubstitute.definition().id(), null));
        }
        return events;
    }

    private Set<String> merge(Set<String> necessarySubstitutions, Set<String> tacticSubstitutions) {
        Set<String> substitutions = new HashSet<>();
        substitutions.addAll(necessarySubstitutions);
        substitutions.addAll(tacticSubstitutions);
        return substitutions;
    }

    private Player substitute(String team, Player playerToSubstitute) {
        PlayersLineup lineup;
        if (team.equals(state.local())) lineup = state.localPlayersLineup();
        else lineup = state.visitantPlayersLineup();
        Player successful = substitute(lineup, playerToSubstitute);
        if (successful != null) state.restSubstitutions().put(team, state.restSubstitutions(team) - 1);
        return successful;
    }

    private Player substitute(PlayersLineup lineup, Player player) {
        Integer[] location = lineup.positions().get(player);
        Position position = lineup.lineup().positionOf(location);
        Player newPlayer = bestPlayerOf(lineup.substitutes(), position);
        if (newPlayer == null) return null;
        if (scoreOfMatch(player, position) > scoreOfMatch(newPlayer, position)) return null;
        lineup.substitutes().remove(newPlayer);
        lineup.positions().put(newPlayer, location);
        lineup.positions().remove(player);
        return newPlayer;
    }

    private Player bestPlayerOf(List<Player> players, Position position) {
        return players.stream().reduce((p1, p2) -> {
            if (LineupGenerator.scoreOfMatch(p1, position) > LineupGenerator.scoreOfMatch(p2, position)) return p1;
            if (LineupGenerator.scoreOfMatch(p1, position) < LineupGenerator.scoreOfMatch(p2, position)) return p2;
            if (p1.relativeCache(position) > p2.relativeCache(position)) return p1;
            return p2;
        }).orElse(null);
    }
}
