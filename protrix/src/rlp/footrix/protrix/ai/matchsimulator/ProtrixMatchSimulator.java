package rlp.footrix.protrix.ai.matchsimulator;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.ai.MatchSimulator;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.ai.matchsimulator.types.*;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Expulsion;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Substitution;

public class ProtrixMatchSimulator implements MatchSimulator {
    private final Application application;
    private MatchState state;

    public ProtrixMatchSimulator(Application application) {
        this.application = application;
    }

    @Override
    public Match simulate(MatchDefinition definition, Instant date, PlayersLineup localLineup, PlayersLineup visitantLineup) {
        Map<Player, Integer[]> firstLocalLineup = new HashMap<>(localLineup.positions());
        Map<Player, Integer[]> firstVisitantLineup = new HashMap<>(visitantLineup.positions());
        this.state = new MatchState(definition.local(), definition.visitant(), localLineup, visitantLineup);
        PlayerValue playerValue = new PlayerValue(state);

        GoalEventSimulator goalSimulator = new GoalEventSimulator(state, playerValue);
        CardEventSimulator cardSimulator = new CardEventSimulator(state, playerValue);
        InjuryEventSimulator injurySimulator = new InjuryEventSimulator(state, playerValue);
        SubstitutionEventSimulator substitutionSimulator = new SubstitutionEventSimulator(definition, state, playerValue);
        FatigueSimulator fatigueSimulator = new FatigueSimulator(state, playerValue);

        for (int i = 1; i <= 90; i++) {
            savePlayersState(definition, date, i);
            state.minuteEvents().addAll(goalSimulator.simulate(i));
            state.minuteEvents().addAll(cardSimulator.simulate(i));
            state.minuteEvents().addAll(injurySimulator.simulate(i));
            state.minuteEvents().addAll(substitutionSimulator.simulate(i));
            state.events().addAll(state.minuteEvents());
            fatigueSimulator.simulate(i);
            addMinutes();
            handle(state.minuteEvents(), state, i);
            state.minuteEvents().clear();
        }
        return new Match(definition, date, firstLocalLineup, firstVisitantLineup, statistics(), state.events(), 90, null);
    }

    private void addMinutes() {
        for (Player player : state.localLineup().fieldPlayers()) this.state.addMinute(player.definition().id());
        for (Player player : state.visitantLineup().fieldPlayers()) this.state.addMinute(player.definition().id());
    }

    private void handle(List<Match.MatchEvent> events, MatchState state, int minute) {
        for (Match.MatchEvent event : events) {
            if (event.type() == Substitution) {
                if (event.team().equals(state.local())) {
                    state.substitute(state.local(), event.who(), event.secondaryWho());
                } else {
                    state.substitute(state.visitant(), event.who(), event.secondaryWho());
                }
                if (minute == 90) this.state.addMinute(event.who());    //TODO
            } else if (event.type() == Expulsion) {
                if (event.team().equals(state.local())) {
                    state.expell(state.local(), event.who());
                } else {
                    state.expell(state.visitant(), event.who());
                }
            }
        }
    }

    private Map<String, Map<String, Match.PlayerStatistics>> statistics() {
        Map<String, Map<String, Match.PlayerStatistics>> playerStatistics = new HashMap<>();
        playerStatistics.put(state.local(), statistics(state.local()));
        playerStatistics.put(state.visitant(), statistics(state.visitant()));
        return playerStatistics;
    }

    private Map<String, Match.PlayerStatistics> statistics(String team) {
        Map<String, Match.PlayerStatistics> playerStatistics = new HashMap<>();
        PlayersLineup lineup = state.lineup(team);
        for (Player player : lineup.fieldPlayers()) playerStatistics.put(player.definition().id(), statistics(team, player.definition().id()));
        for (Player player : lineup.substitutions()) playerStatistics.put(player.definition().id(), statistics(team, player.definition().id()));
        for (Player player : lineup.expelled()) playerStatistics.put(player.definition().id(), statistics(team, player.definition().id()));
        return playerStatistics;
    }

    private Match.PlayerStatistics statistics(String team, String player) {
        return new Match.PlayerStatistics(state.minutes(player), state.score(team, player, 90), state.fatigue(player), state.matchRole(player));
    }

    private void savePlayersState(MatchDefinition match, Instant date, int minute) {
        state.localLineup().fieldPlayers().forEach(p -> savePlayerState(p, match, date, minute));
        state.localLineup().benchPlayers().forEach(p -> savePlayerState(p, match, date, minute));
        state.visitantLineup().fieldPlayers().forEach(p -> savePlayerState(p, match, date, minute));
        state.visitantLineup().benchPlayers().forEach(p -> savePlayerState(p, match, date, minute));
    }

    private void savePlayerState(Player player, MatchDefinition match, Instant date, int minute) {
        double fatigue = state.fatigue(player.definition().id());
        application.recordStore().create().playerMinuteRecord(match.id(), player.definition().id(), date, minute, Math.max(0, player.psychophysics().energy() - fatigue), player.skills().stamina());
    }
}
