package rlp.footrix.protrix.loader;

import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.pes6.types.Pes6Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TeamLoader {

    public static List<Team> teams() {
        List<Team> teams = new ArrayList<>();
        File file = new File("./temp/teams.tsv");
        try {
            List<String[]> lines = Files.readAllLines(file.toPath()).stream().filter(l -> !l.startsWith("Id\tName")).map(l -> l.split("\t")).toList();
            for (int i = 0; i < lines.size(); i++) {
                String[] team = lines.get(i);
                teams.add(teamOf(team));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }

    private static Team teamOf(String[] team) {
        String id = team[0];
        String name = team[1];
        String country = team[2];
        String lineupId = team[3];
        int elo = (int) eloOf(team);
        int fans = Integer.parseInt(team[5]);
        int stadiumCapacity = Integer.parseInt(team[6]);

        TeamDefinition definition = new TeamDefinition.Simple(id, name, country);
        Pes6Team pes6Team = new Pes6Team(definition);
        pes6Team.init(elo, elo, fans, stadiumCapacity);
        pes6Team.lineup(lineupId);  //TODO PONER EN EL INIT
        return pes6Team;
    }

    private static double eloOf(String[] line) {
        return Double.parseDouble(line[4]);
    }
}
