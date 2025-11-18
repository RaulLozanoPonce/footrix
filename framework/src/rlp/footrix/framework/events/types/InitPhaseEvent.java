package rlp.footrix.framework.events.types;

import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public class InitPhaseEvent implements Event {
    private Competition competition;
    private int nPhase;
    private List<TeamRule> teamRules;
    private List<Team> teams;

    public Competition competition() {
        return competition;
    }

    public InitPhaseEvent competition(Competition competition) {
        this.competition = competition;
        return this;
    }

    public int nPhase() {
        return nPhase;
    }

    public InitPhaseEvent nPhase(int nPhase) {
        this.nPhase = nPhase;
        return this;
    }

    public List<TeamRule> teamRules() {
        return teamRules;
    }

    public InitPhaseEvent teamRules(List<TeamRule> teamRules) {
        this.teamRules = teamRules;
        return this;
    }

    public List<Team> teams() {
        return teams;
    }

    public InitPhaseEvent teams(List<Team> teams) {
        this.teams = teams;
        return this;
    }
}
