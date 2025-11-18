package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.ai.MatchSimulator;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.simulator.types.*;
import rlp.footrix.protrix.simulator.weights.PlayerValue;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtrixMatchSimulator implements MatchSimulator {
    private final Map<String, Match.PlayerStatistics> playerStatistics = new HashMap<>();

    @Override
    public Match simulate(MatchDefinition definition, Instant date, PlayersLineup localLineup, PlayersLineup visitantLineup) {
        MatchState state = new MatchState(definition.local(), definition.visitant(), localLineup, visitantLineup);
        PlayerValue playerValue = new PlayerValue(state);

        GoalEventSimulator goalSimulator = new GoalEventSimulator(state, playerValue);
        CardEventSimulator cardSimulator = new CardEventSimulator(state, playerValue);
        InjuryEventSimulator injurySimulator = new InjuryEventSimulator(state, playerValue);
        SubstitutionEventSimulator substitutionSimulator = new SubstitutionEventSimulator(definition, state, playerValue);
        FatigueSimulator fatigueSimulator = new FatigueSimulator(state, playerValue);

        for (int i = 1; i <= 90; i++) {
            state.minuteEvents().addAll(goalSimulator.simulate(i));
            state.minuteEvents().addAll(cardSimulator.simulate(i));
            state.minuteEvents().addAll(injurySimulator.simulate(i));
            state.minuteEvents().addAll(substitutionSimulator.simulate(i));
            state.events().addAll(state.minuteEvents());
            fatigueSimulator.simulate(i);
            for (Player player : state.localLineup().fieldPlayers()) {
                this.playerStatistics.putIfAbsent(player.definition().id(), new Match.PlayerStatistics());
                this.playerStatistics.get(player.definition().id()).addScore(0.1).addMinute();
            }
            for (Player player : state.visitantLineup().fieldPlayers()) {
                this.playerStatistics.putIfAbsent(player.definition().id(), new Match.PlayerStatistics());
                this.playerStatistics.get(player.definition().id()).addScore(0.1).addMinute();
            }
            handle(state.minuteEvents(), state);
            state.minuteEvents().clear();
        }

        return new Match(definition, date, playerStatistics, state.events(), "", 90, null);
    }

    private void handle(List<Match.MatchEvent> events, MatchState state) {
        for (Match.MatchEvent event : events) {
            if (event.type() != Match.MatchEvent.Type.Substitution) continue;
            if (event.team().equals(state.local())) {
                state.substitute(state.local(), event.who(), event.secondaryWho());
            } else {
                state.substitute(state.visitant(), event.who(), event.secondaryWho());
            }
        }
    }
}
