package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitPhaseCommand extends Command {
    public Competition competition;
    public int nPhase;
    public List<TeamRule> teamRules;
    public List<Team> teams;

    public InitPhaseCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        Competition.Phase phase = competition.phase(nPhase);
        int maxTeams = phase.definition().nGroups() * phase.definition().groupDefinition().nTeams();
        List<Team> teams = (this.teams.isEmpty()) ? teams(teamRules, maxTeams) : this.teams;
        teams.forEach(t -> t.addCompetition(competition.definition().id() + ";" + nPhase));
        phase.init(teams);
    }

    private List<Team> teams(List<TeamRule> rules, int maxTeams) {
        List<Team> teams = new ArrayList<>();
        for (TeamRule rule : rules) {
            Competition competition = competition(rule.competition(), application.game().seasonNumber(rule.season()));
            for (Competition.Phase phase : phases(competition, rule.phase())) {
                for (Competition.Phase.Group group : groups(phase, rule.group())) {
                    for (Team team : rule.predicate().get(group.teams())) {
                        teams.add(team);
                        if (teams.size() == maxTeams) return teams;
                    }
                }
            }
        }
        throw new RuntimeException("There are more teams than are allowed");
    }

    private Competition competition(String competition, int season) {
        return application.competitionManager().get(competition, season);
    }

    private List<Competition.Phase> phases(Competition competition, int phase) {
        return Collections.singletonList(competition.phase(phase));
    }

    private List<Competition.Phase.Group> groups(Competition.Phase phase, int group) {
        return Collections.singletonList(phase.group(group));
    }
}
