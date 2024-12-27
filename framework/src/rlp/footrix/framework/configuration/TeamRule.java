package rlp.footrix.framework.configuration;

import rlp.footrix.framework.types.team.Team;

import java.util.List;

public record TeamRule(String competition, String season, String phase, String group, Predicate predicate) {

    public interface Predicate {
        List<Team> get(List<Team> teams);
    }
}
