package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.InitPhaseCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.InitPhaseEvent;

public class InitPhaseSubscriber implements Subscriber<InitPhaseEvent> {
    private final Application application;

    public InitPhaseSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(InitPhaseEvent event) {
        InitPhaseCommand command = new InitPhaseCommand(application);
        command.competition = event.competition();
        command.nPhase = event.nPhase();
        command.teamRules = event.teamRules();
        command.teams = event.teams();
        command.execute();
    }
}
