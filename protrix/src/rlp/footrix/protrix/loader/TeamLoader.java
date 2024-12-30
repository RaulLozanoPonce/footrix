package rlp.footrix.protrix.loader;

import rlp.footrix.framework.types.Country;
import rlp.footrix.framework.types.definitions.TeamDefinition;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.protrix.model.ProtrixTeam;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
        Country country = Country.valueOf(team[2]);
        String lineupId = team[3];
        int elo = Integer.parseInt(team[4]);
        TeamDefinition definition = new TeamDefinition.Simple(id, name, country);
        return new ProtrixTeam(definition).lineup(lineupId).elo(elo);
    }
}
