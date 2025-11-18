package rlp.footrix.protrix;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.stores.RecordStore;
import rlp.footrix.framework.stores.TableStore;
import rlp.footrix.framework.stores.types.MemoryEntityStore;
import rlp.footrix.framework.stores.types.MemoryRecordStore;
import rlp.footrix.framework.stores.types.MemoryTableStore;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.types.tables.TeamElo;
import rlp.footrix.protrix.events.InitGame;
import rlp.footrix.protrix.loader.PlayerLoader;
import rlp.footrix.protrix.loader.TeamEloLoader;
import rlp.footrix.protrix.loader.TeamLoader;
import rlp.footrix.protrix.loader.competitions.SpainFirstDivisionDefinition;
import rlp.footrix.protrix.model.helpers.InitialContractGenerator;
import rlp.footrix.protrix.simulator.ProtrixMatchSimulator;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProtrixAppConfiguration implements FootrixConfiguration.SimpleFootrixConfiguration {
    private static final Map<String, Map<Player, String>> players = PlayerLoader.players();
    private static final List<Team> teams = TeamLoader.teams();
    private static final List<TeamElo> elos = TeamEloLoader.elos();

    @Override
    public Instant initDate() {
        return Instant.parse("2024-08-01T00:00:00Z");
    }

    @Override
    public Function<Integer, String> seasonProvider() {
        return number -> "season" + number;
    }

    @Override
    public DataBase initDatabase(Application application) {
        return new DataBase() {
            @Override
            public List<CompetitionDefinition> competitions() {
                return List.of(new SpainFirstDivisionDefinition());
            }

            @Override
            public List<Team> teams() {
                return teams.stream().map(t -> teamOf(t, application)).toList();
            }

            @Override
            public List<Player> players() {
                return players.entrySet().stream().flatMap(e -> e.getValue().keySet().stream()).toList();
            }

            @Override
            public List<TeamElo> elos() {
                return elos;
            }
        };
    }

    @Override
    public List<Task> initTasks(Application application) {
        return List.of(new InitGame(Instant.parse("2024-08-01T00:00:00Z"), application));
    }

    @Override
    public ModelCloudAccessor models() {
        return ProtrixMatchSimulator::new;
    }

    @Override
    public EntityStore entityStore() {
        return new MemoryEntityStore();
    }

    @Override
    public RecordStore recordStore() {
        return new MemoryRecordStore();
    }

    @Override
    public TableStore tableStore() {
        return new MemoryTableStore();
    }

    @Override
    public double averageMatchPlayer() {
        return 38;
    }

    private Team teamOf(Team team, Application application) {
        double eloPosition = eloOf(team, application) / teams.stream().mapToDouble(t -> eloOf(t, application)).max().orElse(0.0);
        Map<Player, PlayerContract> teamPlayers = InitialContractGenerator.generate(players.get(team.definition().name()));
        teamPlayers.forEach((p, c) -> {
            team.setPlayer(p, c);
            p.cache().absoluteCache(eloPosition * initialCacheFactorOf(c.role()));
        });
        return team;
    }

    private double eloOf(Team team, Application application) {
        return application.tableStore().teamElo(team.definition().id()).elo();
    }

    private double initialCacheFactorOf(PlayerContract.Role role) {
        return switch (role) {
            case Undisputed -> 1;
            case Regular -> 0.8;
            case Rotation -> 0.5;
            case Substitute -> 0.3;
            case Reserve -> 0.15;
            case Young -> 0.2;
        };
    }
}
