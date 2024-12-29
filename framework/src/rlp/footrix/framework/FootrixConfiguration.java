package rlp.footrix.framework;

import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.var.Var;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public interface FootrixConfiguration {
    Instant initDate();
    Function<Integer, String> seasonProvider();
    DataBase initDatabase();
    List<Event> initEvents();
    Var var();
    Function<Player, Double> energyRecoveryProvider();

    public interface SimpleFootrixConfiguration extends FootrixConfiguration {
        @Override
        default Function<Player, Double> energyRecoveryProvider() {
            return new Function<Player, Double>() {
                @Override
                public Double apply(Player player) {
                    if (player.isInjured()) return 0.0;
                    return 0.07143;
                }
            };
        }
    }
}
