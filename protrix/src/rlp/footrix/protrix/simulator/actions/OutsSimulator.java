package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.generators.LineupGenerator;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.protrix.simulator.MatchState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static rlp.footrix.framework.types.Match.MatchEvent.Type.*;

public class OutsSimulator extends ActionSimulator {

    public OutsSimulator(MatchState state, int minute) {
        super(state, minute);
    }

    public List<Match.MatchEvent> simulate() {
        List<Match.MatchEvent> events = new ArrayList<>();
        events.addAll(handleOuts(state.local()));
        events.addAll(handleOuts(state.visitant()));
        return events;
    }

    private List<Match.MatchEvent> handleOuts(String team) {
        List<Match.MatchEvent> events = new ArrayList<>();
        List<String> expulsedPlayers = expulsedOf(team);
        Set<String> outPlayers = new HashSet<>();
        outPlayers.addAll(redCardPlayers(team, expulsedPlayers));
        outPlayers.addAll(doubleYellowCardPlayers(team, expulsedPlayers));
        for (String player : outPlayers) {
            events.add(new Match.MatchEvent(team, Expulsion, minute, player, null));
            if (state.positionOf(state.playerOf(player, team)) == Position.PT) {
                Player worstPlayer = worstPlayerOf(team, player);
                state.change(team, player, worstPlayer.definition().id());
                events.add(new Match.MatchEvent(team, PendingSubstitution, minute, worstPlayer.definition().id(), null));
            }
            state.out(team, player);
        }
        return events;
    }

    private Set<String> doubleYellowCardPlayers(String team, List<String> expulsed) {
        return state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == YellowCard)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(p -> !expulsed.contains(p))
                .filter(who -> state.events().stream().filter(e2 -> e2.who().equals(who)).filter(e2 -> e2.type() == YellowCard).count() >= 2)
                .collect(Collectors.toSet());
    }

    private Set<String> redCardPlayers(String team, List<String> expulsed) {
        return state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == RedCard)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(p -> !expulsed.contains(p))
                .collect(Collectors.toSet());
    }

    private List<String> expulsedOf(String team) {
        return state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == Expulsion)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .distinct()
                .toList();
    }

    private Player worstPlayerOf(String team, String player) {
        return state.playersOf(team).stream()
                .filter(p -> !p.definition().id().equals(player))
                .reduce((p1, p2) -> {
                    double p1Score = LineupGenerator.scoreOfMatch(p1, state.positionOf(p1));
                    double p2Score = LineupGenerator.scoreOfMatch(p2, state.positionOf(p2));
                    if (p1Score > p2Score) return p2;
                    return p1;
                }).orElse(null);
    }
}
