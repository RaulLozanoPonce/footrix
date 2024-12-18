package rlp.footrix.framework.events;

import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.Competition.Phase;
import rlp.footrix.framework.types.Competition.Phase.Group;
import rlp.footrix.framework.types.Team;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class InitPhase extends Event {

    private final String competitionId;
    private final String season;
    private final int nPhase;
    private final List<String> ruleIds;
    private final List<Team> teams;

    public InitPhase(Instant ts, String competitionId, String season, int nPhase, List<Team> teams, List<String> ruleIds) {
        super(ts);
        this.competitionId = competitionId;
        this.season = season;
        this.nPhase = nPhase;
        this.teams = teams;
        this.ruleIds = ruleIds;
    }

    public InitPhase(Instant ts, String competitionId, String season, int nPhase, List<String> ruleIds) {
        this(ts, competitionId, season, nPhase, new ArrayList<>(), ruleIds);
    }

    public InitPhase(Instant ts, String competitionId, String season, int nPhase, Set<Team> teams) {
        //TODO
        this(ts, competitionId, season, nPhase, new ArrayList<>(teams), new ArrayList<>());
    }

    @Override
    public void execute() {
        Competition competition = configuration.competitionManager().get(competitionId, season);
        Phase phase = competition.phase(nPhase);
        int maxTeams = phase.definition().nGroups() * phase.definition().groupDefinition().nTeams();
        List<Team> teams = (this.teams.isEmpty()) ? teams(rules(ruleIds), maxTeams) : this.teams;
        teams.forEach(t -> t.addCompetition(competitionId + ";" + nPhase));
        phase.init(teams);
    }

    private List<Team> teams(List<TeamRule> rules, int maxTeams) {
        List<Team> teams = new ArrayList<>();
        for (TeamRule rule : rules) {
            Competition competition = competition(rule.competition(), rule.season());
            for (Phase phase : phases(competition, rule.phase())) {
                for (Group group : groups(phase, rule.group())) {
                    for (Team team : rule.predicate().get(group.teams())) {
                        teams.add(team);
                        if (teams.size() == maxTeams) return teams;
                    }
                }
            }
        }
        throw new RuntimeException("There are more teams than are allowed");
    }

    private Competition competition(String competition, String season) {
        return configuration.competitionManager().get(competition, season);
    }

    private List<Phase> phases(Competition competition, String phase) {
        return Collections.singletonList(competition.phase(Integer.parseInt(phase)));
    }

    private List<Group> groups(Phase phase, String group) {
        return Collections.singletonList(phase.group(Integer.parseInt(group)));
    }

    private List<TeamRule> rules(List<String> ruleIds) {
        return configuration.rulesManager().get(ruleIds);
    }
}
