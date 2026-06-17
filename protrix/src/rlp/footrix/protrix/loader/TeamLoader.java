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
        String lineupId = team[3];
        TeamDefinition definition = new TeamDefinition.Simple(id, name, team[2]);
        return new Pes6Team(definition).lineup(lineupId);
    }
}
