package rlp.footrix.protrix;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.ai.MatchSimulator;
import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.ai.PlayerGenerator;
import rlp.footrix.framework.ai.Trainer;
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
import rlp.footrix.protrix.ai.trainer.ProtrixTrainer;
import rlp.footrix.protrix.events.InitGame;
import rlp.footrix.protrix.ai.playergenerator.ProtrixPlayerGenerator;
import rlp.footrix.protrix.loader.PlayerLoader;
import rlp.footrix.protrix.loader.TeamEloLoader;
import rlp.footrix.protrix.loader.TeamLoader;
import rlp.footrix.protrix.types.competitions.SpainFirstDivisionDefinition;
import rlp.footrix.protrix.helper.ContractHelper;
import rlp.footrix.protrix.ai.matchsimulator.ProtrixMatchSimulator;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProtrixAppConfiguration implements FootrixConfiguration.SimpleFootrixConfiguration {
    private static final Map<String, Map<Player, String>> players = PlayerLoader.players();
    private static final List<Team> teams = TeamLoader.teams();
    private static final List<TeamElo> elos = TeamEloLoader.elos();

    @Override
    public int initSeason() {
        return 0;
    }

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
        return new ModelCloudAccessor() {
            @Override
            public MatchSimulator matchSimulator() {
                return new ProtrixMatchSimulator();
            }

            @Override
            public PlayerGenerator playerGenerator() {
                return new ProtrixPlayerGenerator();
            }

            @Override
            public Trainer trainer() {
                return new ProtrixTrainer();
            }
        };
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
        double eloPosition = application.tableStore().eloPosition(team.definition().id());
        Map<Player, PlayerContract> teamPlayers = ContractHelper.generate(players.get(team.definition().name()), eloPosition);
        teamPlayers.forEach(team::setPlayer);
        return team;
    }
}
