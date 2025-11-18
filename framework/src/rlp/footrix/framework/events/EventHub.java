package rlp.footrix.framework.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventHub {
    private final Map<Class<? extends Event>, List<Subscriber<?>>> subscribers = new HashMap<>();

    public <T extends Event> void subscribe(Class<T> eventType, Subscriber<T> subscriber) {
        subscribers.putIfAbsent(eventType, new ArrayList<>());
        subscribers.get(eventType).add(subscriber);
    }

    public <T extends Event> void publish(T event) {
        List<Subscriber<?>> subscribers = this.subscribers.get(event.getClass());
        if (subscribers == null) return;
        subscribers.stream()
                .map(s -> (Subscriber<T>) s)
                .forEach(s -> s.receive(event));
    }
}
