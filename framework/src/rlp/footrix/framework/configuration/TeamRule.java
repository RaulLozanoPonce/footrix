package rlp.footrix.framework.configuration;

import rlp.footrix.framework.types.entities.SeasonReference;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public record TeamRule(String competition, SeasonReference season, int phase, int group, Predicate predicate) {

    public interface Predicate {
        List<Team> get(List<Team> teams);
    }
}
