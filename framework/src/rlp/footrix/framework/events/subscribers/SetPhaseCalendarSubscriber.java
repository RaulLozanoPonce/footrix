package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.SetPhaseCalendarCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.SetPhaseCalendarEvent;

public class SetPhaseCalendarSubscriber implements Subscriber<SetPhaseCalendarEvent> {
    private final Application application;

    public SetPhaseCalendarSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(SetPhaseCalendarEvent event) {
        SetPhaseCalendarCommand command = new SetPhaseCalendarCommand(application);
        command.competition = event.competition();
        command.season = event.season();
        command.nPhase = event.nPhase();
        command.ts = event.ts();
        command.execute();
    }
}
