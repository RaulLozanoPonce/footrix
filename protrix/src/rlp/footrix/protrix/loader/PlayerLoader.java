package rlp.footrix.protrix.loader;

import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.pes6.types.player.Pes6Skills;
import rlp.footrix.protrix.helper.InjuryHelper;

import java.io.File;
import java.nio.file.Files;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerLoader {

    public static Map<String, Map<Player, String>> players() {
        Map<String, Map<Player, String>> players = new HashMap<>();
        File file = new File("./temp/players.tsv");
        try {
            List<String[]> lines = Files.readAllLines(file.toPath()).stream().filter(l -> !l.startsWith("name\tage")).map(l -> l.split("\t")).toList();
            for (int i = 0; i < lines.size(); i++) {
                String[] player = lines.get(i);
                players.putIfAbsent(player[8], new HashMap<>());
                players.get(player[8]).put(playerOf(player, i), player[9]);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    private static Player playerOf(String[] raw, Integer id) {
        Pes6Player player = new Pes6Player(playerDefinitionOf(raw, id), positionOf(raw[6]), positionsOf(raw[7]));
        Pes6Skills skills = new Pes6Skills(player, Integer.parseInt(raw[11]), Integer.parseInt(raw[12]), Integer.parseInt(raw[13]),
                Integer.parseInt(raw[14]), Integer.parseInt(raw[15]), Integer.parseInt(raw[16]), Integer.parseInt(raw[17]),
                Integer.parseInt(raw[18]), Integer.parseInt(raw[19]), Integer.parseInt(raw[20]), Integer.parseInt(raw[21]),
                Integer.parseInt(raw[22]), Integer.parseInt(raw[23]), Integer.parseInt(raw[24]), Integer.parseInt(raw[25]),
                Integer.parseInt(raw[26]), Integer.parseInt(raw[27]), Integer.parseInt(raw[28]), Integer.parseInt(raw[29]),
                Integer.parseInt(raw[30]), Integer.parseInt(raw[31]), Integer.parseInt(raw[32]), Integer.parseInt(raw[33]),
                Integer.parseInt(raw[34]), Integer.parseInt(raw[35]), Integer.parseInt(raw[36]));
        player.skills(skills);
        return player;
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
            public String country() {
                return raw[10];
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
                return InjuryHelper.randomInjuryResistance();
            }
        };
    }

    private static List<Position> positionsOf(String positions) {
        return Arrays.stream(positions.replace("[", "")
                        .replace("]", "")
                        .replace("\"", "")
                        .split(","))
                .map(PlayerLoader::positionOf).toList();
    }

    private static Position positionOf(String position) {
        return switch (position) {
            case "GK" -> Positions.PT;
            case "CBT" -> Positions.CT;
            case "SB" -> Positions.CAR;
            case "WB" -> Positions.LAT;
            case "DM" -> Positions.CCD;
            case "CM" -> Positions.CC;
            case "AM" -> Positions.MP;
            case "SM" -> Positions.VOL;
            case "WF" -> Positions.EXT;
            case "SS" -> Positions.SS;
            case "CF" -> Positions.DL;
            default -> throw new RuntimeException("No existe la posicion");
        };
    }
}
