package rlp.footrix.protrix.loader;

import rlp.footrix.framework.types.Country;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.protrix.model.ProtrixPlayer;

import java.io.File;
import java.io.IOException;
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
                //return InjuryResistance.valueOf(raw[5]);  //TODO
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
                .map(PlayerLoader::positionOf).toList();
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
}
