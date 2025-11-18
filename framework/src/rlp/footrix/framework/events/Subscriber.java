package rlp.footrix.framework.events;

public interface Subscriber<T extends Event> {
    void receive(T event);
}
