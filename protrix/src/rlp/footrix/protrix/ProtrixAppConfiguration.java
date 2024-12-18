package rlp.footrix.protrix;

import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.configuration.DataBase;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.InitPhase;
import rlp.footrix.framework.events.SetPhaseCalendar;
import rlp.footrix.framework.types.*;
import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.framework.types.definitions.TeamDefinition;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.model.ProtrixTeam;
import rlp.footrix.protrix.model.helpers.InitialContractGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.*;

import static rlp.footrix.framework.types.Country.Spain;

public class ProtrixAppConfiguration implements FootrixConfiguration {

    private static final Map<String, Map<Player, String>> players = players();

    private static Map<String, Map<Player, String>> players() {
        Map<String, Map<Player, String>> players = new HashMap<>();
        File file = new File("./temp/players.tsv");
        try {
            List<String[]> lines = Files.readAllLines(file.toPath()).stream().filter(l -> !l.startsWith("name\tage")).map(l -> l.split("\t")).toList();
            for (int i = 0; i < lines.size(); i++) {
                String[] player = lines.get(i);
                players.putIfAbsent(player[8], new HashMap<>());
                players.get(player[8]).put(playerOf(player, i), player[9]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    private static Player playerOf(String[] raw, Integer id) {
        return new ProtrixPlayer(playerDefinitionOf(raw, id), positionOf(raw[6]), positionsOf(raw[7]), Integer.parseInt(raw[10]),
                Integer.parseInt(raw[11]), Integer.parseInt(raw[12]), Integer.parseInt(raw[13]), Integer.parseInt(raw[14]),
                Integer.parseInt(raw[15]), Integer.parseInt(raw[16]), Integer.parseInt(raw[17]), Integer.parseInt(raw[18]),
                Integer.parseInt(raw[19]), Integer.parseInt(raw[20]), Integer.parseInt(raw[21]), Integer.parseInt(raw[22]),
                Integer.parseInt(raw[23]), Integer.parseInt(raw[24]), Integer.parseInt(raw[25]), Integer.parseInt(raw[26]),
                Integer.parseInt(raw[27]), Integer.parseInt(raw[28]), Integer.parseInt(raw[29]), Integer.parseInt(raw[30]),
                Integer.parseInt(raw[31]), Integer.parseInt(raw[32]), Integer.parseInt(raw[33]), Integer.parseInt(raw[34]),
                Integer.parseInt(raw[35])
        );
    }

    private static PlayerDefinition playerDefinitionOf(String[] raw, Integer id) {
        return new PlayerDefinition() {
            @Override
            public String id() {
                return String.valueOf(id);
            }

            @Override
            public String name() {
                return raw[0];
            }

            @Override
            public Instant birth() {
                //TODO TRUNCAR AL AÑO QUE VIENE Y RESTAR AÑOS
                return Instant.ofEpochMilli(Instant.now().toEpochMilli() - ((long) Integer.parseInt(raw[1]) * 365 * 24 * 60 * 60 * 1000));
            }

            @Override
            public Country country() {
                return null;
            }

            @Override
            public int height() {
                return Integer.parseInt(raw[2]);
            }

            @Override
            public int weight() {
                return Integer.parseInt(raw[3]);
            }

            @Override
            public Foot foot() {
                return Foot.valueOf(raw[4]);
            }

            @Override
            public InjuryResistance injuryResistance() {
                //return InjuryResistance.valueOf(raw[5]);
                return randomInjuryResistance();
            }
        };
    }

    private static PlayerDefinition.InjuryResistance randomInjuryResistance() {
        double random = Math.random();
        if (random < 0.37) return PlayerDefinition.InjuryResistance.A;
        if (random < 0.37 + 0.48) return PlayerDefinition.InjuryResistance.B;
        return PlayerDefinition.InjuryResistance.C;
    }

    private static List<Position> positionsOf(String positions) {
        return Arrays.stream(positions.replace("[", "")
                        .replace("]", "")
                        .replace("\"", "")
                        .split(","))
                .map(ProtrixAppConfiguration::positionOf).toList();
    }

    private static Position positionOf(String position) {
        return switch (position) {
            case "GK" -> Position.PT;
            case "CBT" -> Position.CT;
            case "SB" -> Position.CAR;
            case "WB" -> Position.LAT;
            case "DM" -> Position.CCD;
            case "CM" -> Position.CC;
            case "AM" -> Position.MP;
            case "SM" -> Position.VOL;
            case "WF" -> Position.EXT;
            case "SS" -> Position.SS;
            case "CF" -> Position.DL;
            default -> throw new RuntimeException("No existe la posicion");
        };
    }

    @Override
    public Instant initDate() {
        return Instant.parse("2024-08-01T00:00:00Z");
    }

    @Override
    public String initSeason() {
        return "season1";
    }

    @Override
    public DataBase initDatabase() {
        return new DataBase() {
            @Override
            public List<Competition> competitions() {
                return List.of(
                        competition("ESP-1", "Liga Española", Spain, List.of(
                                new CompetitionDefinition.PhaseDefinition() {
                                    @Override
                                    public GroupDefinition groupDefinition() {
                                        return new GroupDefinition() {
                                            @Override
                                            public String name(int value) {
                                                return "Liga Regular";
                                            }

                                            @Override
                                            public int nTeams() {
                                                return 6;
                                            }

                                            @Override
                                            public SortPolicy sortPolicy() {
                                                return SortPolicy.Mirrored;
                                            }

                                            @Override
                                            public List<TeamClassification> classification(List<TeamClassification> list) {
                                                return list.stream().sorted((o1, o2) -> {
                                                    if (o1.points() > o2.points()) return -1;
                                                    else if (o1.points() == o2.points()) return 0;
                                                    return 1;
                                                }).toList();
                                            }
                                        };
                                    }

                                    @Override
                                    public int nGroups() {
                                        return 1;
                                    }

                                    @Override
                                    public LocalPolicy localPolicy() {
                                        return LocalPolicy.Keep;
                                    }

                                    @Override
                                    public boolean secondLeg() {
                                        return true;
                                    }

                                    @Override
                                    public String matchDayName(int i) {
                                        return "Jornada " + (i + 1);
                                    }

                                    @Override
                                    public Instant nextDate(int i, Instant instant) {
                                        return Instant.ofEpochMilli(instant.toEpochMilli() + 1000 * 60 * 60 * 24 * 7);
                                    }
                                }
                        ))
                );
            }

            private Competition competition(String id, String name, Country country, List<CompetitionDefinition.PhaseDefinition> phases) {
                return new Competition(new CompetitionDefinition() {
                    @Override
                    public String id() {
                        return id;
                    }

                    @Override
                    public String name() {
                        return name;
                    }

                    @Override
                    public Country country() {
                        return country;
                    }

                    @Override
                    public List<PhaseDefinition> phases() {
                        return phases;
                    }
                }, "season1");
            }

            @Override
            public List<Team> teams() {
                return getTeams();
            }

            @Override
            public List<Player> players() {
                return players.entrySet().stream().flatMap(e -> e.getValue().keySet().stream()).toList();
            }
        };
    }

    private List<Team> getTeams() {
        return players.keySet().stream().map(this::teamOf).toList();
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
                new InitPhase(Instant.parse("2024-08-02T00:00:00Z"), "ESP-1", "season1", 0, new HashSet<>(initDatabase().teams())),
                new SetPhaseCalendar(Instant.parse("2024-08-04T00:00:00Z"), "ESP-1", "season1", 0)
        );
    }
}
