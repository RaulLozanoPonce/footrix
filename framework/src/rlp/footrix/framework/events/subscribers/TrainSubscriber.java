package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.TrainCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.TrainEvent;

public class TrainSubscriber implements Subscriber<TrainEvent> {
    private final Application application;

    public TrainSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(TrainEvent event) {
        new TrainCommand(application, event).execute();
    }
}
