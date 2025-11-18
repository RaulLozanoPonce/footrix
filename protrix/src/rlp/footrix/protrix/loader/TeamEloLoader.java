package rlp.footrix.protrix.loader;

import rlp.footrix.framework.types.tables.TeamElo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TeamEloLoader {

    public static List<TeamElo> elos() {
        List<TeamElo> elos = new ArrayList<>();
        File file = new File("./temp/elo.tsv");
        try {
            List<String[]> lines = Files.readAllLines(file.toPath()).stream().filter(l -> !l.startsWith("Id\tName")).map(l -> l.split("\t")).toList();
            for (String[] team : lines) {
                elos.add(eloOf(team));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return elos;
    }

    private static TeamElo eloOf(String[] team) {
        String id = team[0];
        String elo = team[2];
        return new TeamElo(id, Integer.parseInt(elo));
    }
}
