package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.NewDayCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.NewDayEvent;

public class NewDaySubscriber implements Subscriber<NewDayEvent> {
    private final Application application;

    public NewDaySubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(NewDayEvent event) {
        new NewDayCommand(application, event).execute();
    }
}
