package rlp.footrix.protrix;

import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.InitPhase;
import rlp.footrix.framework.events.SetPhaseCalendar;
import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.SeasonReference;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.types.team_player.PlayerContract;
import rlp.footrix.framework.var.Var;
import rlp.footrix.protrix.loader.PlayerLoader;
import rlp.footrix.protrix.loader.TeamLoader;
import rlp.footrix.protrix.loader.competitions.SpainFirstDivisionDefinition;
import rlp.footrix.protrix.model.helpers.InitialContractGenerator;
import rlp.footrix.protrix.var.ProtrixVar;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProtrixAppConfiguration implements FootrixConfiguration.SimpleFootrixConfiguration {

    private static final Map<String, Map<Player, String>> players = PlayerLoader.players();
    private static final List<Team> teams = TeamLoader.teams();
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
        return number -> "season1";
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
                return teams.stream().map(t -> teamOf(t)).toList();
            }

            @Override
            public List<Player> players() {
                return players.entrySet().stream().flatMap(e -> e.getValue().keySet().stream()).toList();
            }
        };
    }

    private Team teamOf(Team team) {
        double eloPosition = team.elo() / teams.stream().mapToDouble(Team::elo).max().orElse(0.0);
        Map<Player, PlayerContract> teamPlayers = InitialContractGenerator.generate(players.get(team.definition().name()));
        teamPlayers.forEach((p, c) -> {
            team.setPlayer(p, c);
            p.absoluteCache(eloPosition * initialCacheFactorOf(c.role()));
        });
        return team;
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
