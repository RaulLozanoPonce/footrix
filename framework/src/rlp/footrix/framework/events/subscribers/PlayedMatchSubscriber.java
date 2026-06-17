package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.PostMatchCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.PlayedMatchEvent;

public class PlayedMatchSubscriber implements Subscriber<PlayedMatchEvent> {
    private final Application application;

    public PlayedMatchSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(PlayedMatchEvent event) {
        new PostMatchCommand(application, event).execute();
    }
}
