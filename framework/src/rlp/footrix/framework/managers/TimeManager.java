package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.events.EventHub;
import rlp.footrix.framework.events.types.NewDayEvent;

import java.time.Instant;

public class TimeManager {
    private final Game game;
    private final EventHub eventHub;

    public TimeManager(Game game, EventHub eventHub) {
        this.game = game;
        this.eventHub = eventHub;
    }

    public void update(Instant date) {
        Instant currentDate = this.game.date();
        while (currentDate.isBefore(date)) {
            currentDate = Instant.ofEpochMilli(currentDate.toEpochMilli() + 24 * 60 * 60 * 1000);
            eventHub.publish(new NewDayEvent().date(currentDate));
        }
    }

    public Instant future(int days) {
        return Instant.ofEpochSecond(game.date().getEpochSecond() + ((long) days * 24 * 60 * 60));
    }
}
