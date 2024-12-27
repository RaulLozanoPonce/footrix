package rlp.footrix.framework.managers;

import rlp.footrix.framework.types.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamManager {

    private final Map<String, Team> teams;

    public TeamManager(List<Team> teams) {
        this.teams = teams.stream().collect(Collectors.toMap(t -> t.definition().id(), t -> t));
    }

    public Team get(String id) {
        return teams.get(id);
    }

    public List<Team> teams() {
        return new ArrayList<>(teams.values());
    }
}
