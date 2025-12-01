package rlp.footrix.framework;

import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.stores.RecordStore;
import rlp.footrix.framework.stores.TableStore;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.types.entities.player.Player;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public interface FootrixConfiguration {
    int initSeason();
    Instant initDate();
    Function<Integer, String> seasonProvider();
    DataBase initDatabase(Application application);
    List<Task> initTasks(Application application);
    Function<Player, Double> energyRecoveryProvider();
    ModelCloudAccessor models();
    EntityStore entityStore();
    RecordStore recordStore();
    TableStore tableStore();
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
