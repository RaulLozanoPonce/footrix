package rlp.footrix.framework;

import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.types.entities.player.Player;

import java.time.Instant;
import java.util.function.Function;

public interface FootrixConfiguration {
    int initSeason();
    Instant initDate();
    Function<Integer, String> seasonProvider();
    DataBase initDatabase(Application application);
    Function<Player, Double> energyRecoveryProvider();  //TODO POR QUE?
    ModelCloudAccessor models(Application application);
    EntityStore entityStore();
    double averageMatchPlayer();

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
