package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Player;
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
                .filter(e -> e.type() == MinorInjury || e.type() == SeriousInjury || e.type() == VerySeriousInjury)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
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
        List<Match.MatchEvent> substitutions = new ArrayList<>();
        //TODO OPTIMIZAR
        for (String playerId : necessarySubstitutions) {
            Player playerToSubstitute = state.playersOf(team).stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = state.substitute(team, playerToSubstitute);
            if (successful == null) continue;
            substitutions.add(new Match.MatchEvent(team, Substitution, minute, successful.definition().id(), playerToSubstitute.definition().id()));
            substitutions.add(new Match.MatchEvent(team, NeededSubstitution, minute, playerToSubstitute.definition().id(), null));
        }
        for (String playerId : tacticSubstitutions) {
            Player playerToSubstitute = state.playersOf(team).stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
            if (playerToSubstitute == null) continue;
            Player successful = state.substitute(team, playerToSubstitute);
            if (successful == null) continue;
            substitutions.add(new Match.MatchEvent(team, Substitution, minute, successful.definition().id(), playerToSubstitute.definition().id()));
        }
        return substitutions;
    }
}
