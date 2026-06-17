package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.events.types.SimulateMatchEvent;

public class ScheduledMatchSubscriber implements Subscriber<ScheduledMatchEvent> {
    private final Application application;

    public ScheduledMatchSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(ScheduledMatchEvent event) {
        //TODO AQUÍ HABRÁ QUE DECIDIR SI SE SIMULA O NO DEPENDIENDO DE SI LOS MANAGERS SON REALES
        application.eventHub().publish(new SimulateMatchEvent().definition(event.definition()));
    }
}
