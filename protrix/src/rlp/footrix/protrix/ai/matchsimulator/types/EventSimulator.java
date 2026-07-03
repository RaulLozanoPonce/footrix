package rlp.footrix.protrix.ai.matchsimulator.types;

import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;

import java.util.List;

public abstract class EventSimulator {
    protected final MatchState state;
    protected final PlayerValue playerValue;

    public EventSimulator(MatchState state, PlayerValue playerValue) {
        this.state = state;
        this.playerValue = playerValue;
    }

    protected PlayersLineup localLineup() {
        return state.localLineup();
    }

    protected PlayersLineup visitantLineup() {
        return state.visitantLineup();
    }

    protected String local() {
        return state.local();
    }

    protected String visitant() {
        return state.visitant();
    }

    public abstract List<MatchEvent> simulate(int minute);
}
