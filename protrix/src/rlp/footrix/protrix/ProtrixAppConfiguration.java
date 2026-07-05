package rlp.footrix.protrix;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.ai.MatchSimulator;
import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.ai.PlayerGenerator;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.stores.types.MemoryEntityStore;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.protrix.ai.matchsimulator.ProtrixMatchSimulator;
import rlp.footrix.protrix.ai.playergenerator.ProtrixPlayerGenerator;
import rlp.footrix.protrix.competitions.SpainFirstDivisionDefinition;
import rlp.footrix.protrix.helper.ContractHelper;
import rlp.footrix.protrix.loader.PlayerLoader;
import rlp.footrix.protrix.loader.TeamLoader;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProtrixAppConfiguration implements FootrixConfiguration.SimpleFootrixConfiguration {
    private static final Map<String, Map<Player, String>> players = PlayerLoader.players();
    private static final List<Team> teams = TeamLoader.teams();

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
                double maxElo = teams.stream().mapToInt(t -> t.elo().quantity()).max().orElse(0);
                return teams.stream().map(t -> teamOf(t, maxElo)).toList();
            }

            @Override
            public List<Player> players() {
                return players.entrySet().stream().flatMap(e -> e.getValue().keySet().stream()).toList();
            }
        };
    }

    @Override
    public ModelCloudAccessor models(Application application) {
        return new ModelCloudAccessor() {
            @Override
            public MatchSimulator matchSimulator() {
                return new ProtrixMatchSimulator(application);
            }

            @Override
            public PlayerGenerator playerGenerator() {
                return new ProtrixPlayerGenerator();
            }
        };
    }

    @Override
    public EntityStore entityStore() {
        return new MemoryEntityStore();
    }

    @Override
    public double averageMatchPlayer() {
        return 38;
    }

    private Team teamOf(Team team, double maxElo) {
        Map<Player, PlayerContract> teamPlayers = ContractHelper.generate(players.get(team.definition().name()), team.elo().quantity() / maxElo);
        teamPlayers.forEach(team::setPlayer);
        return team;
    }
}
