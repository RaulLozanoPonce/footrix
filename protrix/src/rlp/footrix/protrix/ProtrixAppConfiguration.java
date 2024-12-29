package rlp.footrix.protrix;

import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.InitPhase;
import rlp.footrix.framework.events.SetPhaseCalendar;
import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.Country;
import rlp.footrix.framework.types.SeasonReference;
import rlp.footrix.framework.types.definitions.TeamDefinition;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.types.team_player.PlayerContract;
import rlp.footrix.framework.var.Var;
import rlp.footrix.protrix.loader.PlayerLoader;
import rlp.footrix.protrix.loader.SpainFirstDivisionDefinition;
import rlp.footrix.protrix.model.ProtrixTeam;
import rlp.footrix.protrix.model.helpers.InitialContractGenerator;
import rlp.footrix.protrix.var.ProtrixVar;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static rlp.footrix.framework.types.Country.Spain;

public class ProtrixAppConfiguration implements FootrixConfiguration.SimpleFootrixConfiguration {

    private static final Map<String, Map<Player, String>> players = PlayerLoader.players();
    private final ProtrixVar var;

    public ProtrixAppConfiguration() {
        this.var = new ProtrixVar();
    }

    @Override
    public Instant initDate() {
        return Instant.parse("2024-08-01T00:00:00Z");
    }

    @Override
    public Function<Integer, String> seasonProvider() {
        return new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "season1";
            }
        };
    }

    @Override
    public DataBase initDatabase() {
        return new DataBase() {
            @Override
            public List<Competition> competitions() {
                return List.of(new Competition(new SpainFirstDivisionDefinition()));    //TODO. QUIZAS DEBERÍA CREARSE EN EL FRAMEWORK Y SOLO PASARLE LAS DEFINICIONES
            }

            @Override
            public List<Team> teams() {
                return players.keySet().stream().map(teamName -> teamOf(teamName)).toList();
            }

            @Override
            public List<Player> players() {
                return players.entrySet().stream().flatMap(e -> e.getValue().keySet().stream()).toList();
            }
        };
    }

    private Team teamOf(String teamName) {
        ProtrixTeam team = new ProtrixTeam(teamDefinitionOf(teamName));
        Map<Player, PlayerContract> teamPlayers = InitialContractGenerator.generate(players.get(teamName));
        teamPlayers.forEach(team::setPlayer);
        return team;
    }

    private TeamDefinition teamDefinitionOf(String teamName) {
        return new TeamDefinition() {
            @Override
            public String id() {
                return teamName;
            }

            @Override
            public String name() {
                return teamName;
            }

            @Override
            public Country country() {
                return Spain;
            }
        };
    }

    @Override
    public List<Event> initEvents() {
        return List.of(
                new InitPhase(Instant.parse("2024-08-02T00:00:00Z"), "ESP-1", SeasonReference.Current, 0, new HashSet<>(initDatabase().teams())),
                new SetPhaseCalendar(Instant.parse("2024-08-04T00:00:00Z"), "ESP-1", SeasonReference.Current, 0)
        );
    }

    @Override
    public Var var() {
        return var;
    }
}
