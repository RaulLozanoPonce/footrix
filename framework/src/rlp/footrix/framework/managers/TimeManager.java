package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.types.player.Player;

import java.time.Instant;
import java.util.function.Function;

public class TimeManager {

    private final Game game;
    private final EventManager eventManager;
    private final PlayerManager playerManager;
    private final Function<Player, Double> energyRecoveryProvider;

    public TimeManager(Game game, EventManager eventManager, PlayerManager playerManager, Function<Player, Double> energyRecoveryProvider) {
        this.game = game;
        this.eventManager = eventManager;
        this.playerManager = playerManager;
        this.energyRecoveryProvider = energyRecoveryProvider;
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
            p.energy(energyRecoveryProvider.apply(p));
        });
        eventManager.execute(date);
    }

    public Instant future(int days) {
        return Instant.ofEpochSecond(game.date().getEpochSecond() + ((long) days * 24 * 60 * 60));
    }
}
