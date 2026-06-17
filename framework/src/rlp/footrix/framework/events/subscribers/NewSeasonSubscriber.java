package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.InitGameCommand;
import rlp.footrix.framework.commands.types.NewSeasonCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.InitGameEvent;
import rlp.footrix.framework.events.types.NewSeasonEvent;

public class NewSeasonSubscriber implements Subscriber<NewSeasonEvent> {
    private final Application application;

    public NewSeasonSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(NewSeasonEvent event) {
        new NewSeasonCommand(application, event).execute();
    }
}
