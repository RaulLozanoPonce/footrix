package rlp.footrix.framework.tasks.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.types.SimulateMatchEvent;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;

import java.time.Instant;

public class SimulateMatchTask extends Task {
    private final MatchDefinition matchDefinition;

    public SimulateMatchTask(Instant executionDate, Application application, MatchDefinition matchDefinition) {
        super(executionDate, application);
        this.matchDefinition = matchDefinition;
    }

    @Override
    public void execute() {
        SimulateMatchEvent event = new SimulateMatchEvent();
        event.definition(matchDefinition);
        event.ts(executionDate);
        application.eventHub().publish(event);
    }
}
