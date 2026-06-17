package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.InitGameCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.InitGameEvent;

public class InitGameSubscriber implements Subscriber<InitGameEvent> {
    private final Application application;

    public InitGameSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(InitGameEvent event) {
        new InitGameCommand(application, event).execute();
    }
}
