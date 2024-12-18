package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.MatchSimulator;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.PlayersLineup;
import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.protrix.simulator.actions.MatchMinuteDribbleSimulator;
import rlp.footrix.protrix.simulator.actions.MatchMinutePassSimulator;
import rlp.footrix.protrix.simulator.actions.MatchMinuteShootSimulator;

import java.util.*;
import java.util.stream.Collectors;

import static rlp.footrix.framework.helpers.LineupGenerator.scoreOfMatch;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.*;
import static rlp.footrix.protrix.simulator.PositionFactors.*;

public class ProtrixMatchSimulator implements MatchSimulator {

    private final MatchDefinition definition;
    private MatchState state;

    public ProtrixMatchSimulator(MatchDefinition definition) {
        this.definition = definition;
    }

    @Override
    public Match simulate(PlayersLineup localPlayersLineup, PlayersLineup visitantPlayersLineup) {
        this.state = new MatchState(definition.local(), definition.visitant(), localPlayersLineup, visitantPlayersLineup);
        simulateMatch();
        Statistics.register(state);
        return new Match(definition, state.playerStatistics(), state.events(), state.mvp(), 90);    //TODO DURACION
    }

    private void simulateMatch() {
        state.init(state.local(), state.localPlayers().getFirst());
        simulateMatch(1, 45);
        state.init(state.visitant(), state.visitantPlayers().getFirst());
        simulateMatch(46, 90);
    }

    private void simulateMatch(int from, int to) {
        for (int i = from; i <= to; i++) {
            simulateSubMinute(i);
            simulateSubMinute(i);
            simulateSubMinute(i);
            state.addMinutes();
            state.addFatigue();
            boolean areSubstitutions = handleSubstitutions(i);
            if (areSubstitutions) state.init(state.teamWithPossession(), state.playerWithPossession());
        }
    }

    private void simulateSubMinute(int minute) {
        state.events().addAll(eventsOf(minute));
        handleOuts(minute);
    }

    private List<Match.MatchEvent> eventsOf(int minute) {
        Position position = state.positionOf(state.playerWithPossession());
        double actionValue = Math.random();
        if (actionValue < shotProbabilityOf(position)) {
            return new MatchMinuteShootSimulator(state, minute).simulate();
        } else {
            Player rival = mostProbablyRivalTo(state.teamWithPossession(), state.playerWithPossession());
            if (actionValue < shotProbabilityOf(position) + passProbabilityOf(position)) {
                return new MatchMinutePassSimulator(state, minute, rival).simulate();
            } else {
                return new MatchMinuteDribbleSimulator(state, minute, rival).simulate();
            }
        }
    }

    private Player mostProbablyRivalTo(String team, Player player) {
        Integer[] oppositeCoordinates = oppositeCoordinates(state.playersMapOf(team).get(player));
        return random(aroundCoordinatesOf(oppositeCoordinates).stream()
                .map(c -> state.playerWith(state.playersMapOf(state.rivalOf(team)), c)).filter(Objects::nonNull).toList());
    }

    private Player random(List<Player> list) {
        if (list.isEmpty()) return null;
        return list.get(Math.min(list.size() - 1, (int) (Math.random() * list.size())));
    }

    private Integer[] oppositeCoordinates(Integer[] coordinates) {
        return new Integer[] {7 - coordinates[0], coordinates[1]};
    }

    private List<Integer[]> aroundCoordinatesOf(Integer[] coordinates) {
        List<Integer[]> aroundCoordinates = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            if (coordinates[0] + i < 0 || coordinates[0] + i > 7) continue;
            for (int j = -1; j <= 1; j++) {
                if (coordinates[1] + j < 0 || coordinates[1] + j > 4) continue;
                aroundCoordinates.add(new Integer[]{coordinates[0] + i, coordinates[1] + j});
            }
        }
        return aroundCoordinates;
    }

    private void handleOuts(int minute) {
        handleOuts(state.local(), minute);
        handleOuts(state.visitant(), minute);
    }

    private void handleOuts(String team, int minute) {
        List<String> expulsed = state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == Expulsion)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .distinct()
                .toList();
        List<String> redCards = state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == RedCard)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .distinct()
                .filter(p -> !expulsed.contains(p))
                .toList();
        List<String> yellowCards = state.events().stream()
                .filter(e -> e.minute() == minute)
                .filter(e -> e.type() == YellowCard)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .distinct()
                .filter(p -> !expulsed.contains(p))
                .filter(who -> state.events().stream().filter(e2 -> e2.type() == YellowCard && e2.who().equals(who)).count() >= 2)
                .toList();
        if (!redCards.isEmpty() || !yellowCards.isEmpty()) {
            Set<String> outPlayers = new HashSet<>();
            outPlayers.addAll(redCards);
            outPlayers.addAll(yellowCards);
            for (String player : outPlayers) {
                state.events().add(new Match.MatchEvent(team, Expulsion, minute, player));
                state.out(team, player);
            }
        }
    }

    private boolean handleSubstitutions(int minute) {
        return handleSubstitutions(state.local(), minute) || handleSubstitutions(state.visitant(), minute);
    }

    private boolean handleSubstitutions(String team, int minute) {
        boolean areThereSubstitutions = false;
        List<Player> playersToSubstitute = neededSubstitutions(team);
        Set<String> necessarySubstitutions = playersToSubstitute.stream().map(p -> p.definition().id()).collect(Collectors.toSet());
        int restSubstitutions = state.restSubstitutions(team) - playersToSubstitute.size();
        while (restSubstitutions > 0) {
            if (100 * Math.random() < 3.25 * substitutionPercentOf(minute)) {
                List<Player> newPlayersToSubstitute = state.playersOf(team).stream()
                        .filter(p -> !playersToSubstitute.contains(p))
                        .filter(p -> !state.playerWithPossession().definition().id().equals(p.definition().id()))
                        .sorted((p1, p2) -> Double.compare(scoreOfMatch(p1, state.positionOf(p1)),  scoreOfMatch(p2, state.positionOf(p2))))
                        .toList();
                if (newPlayersToSubstitute.isEmpty()) break;
                playersToSubstitute.add(newPlayersToSubstitute.getFirst());
                restSubstitutions--;
            } else {
                break;
            }
        }
        if (playersToSubstitute.isEmpty()) return areThereSubstitutions;
        for (Player playerToSubstitute : playersToSubstitute) {
            Player successful = state.substitute(team, playerToSubstitute);
            if (successful != null) {
                areThereSubstitutions = true;
                state.events().add(new Match.MatchEvent(team, SubstituteOut, minute, playerToSubstitute.definition().id()));
                state.events().add(new Match.MatchEvent(team, SubstituteIn, minute, successful.definition().id()));
                if (necessarySubstitutions.contains(playerToSubstitute.definition().id())) {
                    state.events().add(new Match.MatchEvent(team, NeededSubstitution, minute, playerToSubstitute.definition().id()));
                }
            }
        }
        return areThereSubstitutions;
    }

    private List<Player> neededSubstitutions(String team) {
        return state.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.Injury)
                .filter(e -> e.team().equals(team))
                .map(Match.MatchEvent::who)
                .filter(id -> !state.playerWithPossession().definition().id().equals(id))
                .distinct()
                .map(id -> state.playersOf(team).stream().filter(p -> p.definition().id().equals(id)).findFirst().orElse(null))
                .filter(Objects::nonNull)
                .limit(state.restSubstitutions(team))
                .collect(Collectors.toList());
    }
}
