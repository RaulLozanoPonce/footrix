package rlp.footrix.framework.managers;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.EventConfiguration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventManager {

    private EventConfiguration configuration;
    private List<Event> events = new ArrayList<>();

    public EventManager with(EventConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public synchronized void execute(Instant date) {
        List<Event> futureEvents = new ArrayList<>();
        List<Event> eventsToExecute = new ArrayList<>();
        for (Event event : events.stream().sorted(Comparator.comparing(Event::ts)).toList()) {
            if (event.ts().isAfter(date)) {
                futureEvents.add(event);
            } else {
                eventsToExecute.add(event);
            }
        }
        this.events = futureEvents;
        eventsToExecute.forEach(e -> e.with(configuration));
        if (eventsToExecute.stream().allMatch(Event::preconditions)) {
            eventsToExecute.forEach(Event::execute);
        } else {
            this.events.addAll(eventsToExecute);
        }
    }

    public synchronized void add(Event event) {
        this.events.add(event);
    }

    public synchronized void add(List<Event> events) {
        this.events.addAll(events);
    }
}
