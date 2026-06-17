package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.PlayMatchEvent;

public class PlayMatchSubscriber implements Subscriber<PlayMatchEvent> {
    private final Application application;

    public PlayMatchSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(PlayMatchEvent event) {
        //TODO
    }
}
