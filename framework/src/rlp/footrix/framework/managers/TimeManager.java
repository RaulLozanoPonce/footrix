package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;

import java.time.Instant;

public class TimeManager {

    private final Game game;
    private final EventManager eventManager;
    private final PlayerManager playerManager;

    public TimeManager(Game game, EventManager eventManager, PlayerManager playerManager) {
        this.game = game;
        this.eventManager = eventManager;
        this.playerManager = playerManager;
    }

    public Instant get() {
        return game.date();
    }

    public void set(Instant date) {
        game.date(date);
    }

    public void update(Instant date) {
        game.date(date);
        playerManager.players().forEach(p -> {
            if (p.isInjured() && !p.recoveryDate().isAfter(date)) p.recovery();
            p.energy(0.07143);
        });
        eventManager.execute(date);
    }

    public Instant future(int days) {
        return Instant.ofEpochSecond(game.date().getEpochSecond() + ((long) days * 24 * 60 * 60));
    }
}
