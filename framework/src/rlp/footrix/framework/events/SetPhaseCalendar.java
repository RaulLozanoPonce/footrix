package rlp.footrix.framework.events;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.SecondLegPolicy.*;

public class SetPhaseCalendar extends Event {

    private final String competition;
    private final String season;
    private final int phaseId;
    private Competition.Phase phase;

    public SetPhaseCalendar(Instant ts, String competition, String season, int phaseId) {
        super(ts);
        this.competition = competition;
        this.season = season;
        this.phaseId = phaseId;
    }

    @Override
    public boolean preconditions() {
        this.phase = configuration.competitionManager().get(competition, season).phase(phaseId);
        if (this.phase.groups().stream().anyMatch(g -> g.teams().size() % 2 == 1)) return false; //TODO POR AHORA
        return true;
    }

    @Override
    public void execute() {
        for (int i = 0; i < phase.groups().size(); i++) {
            setCalendar(phase.group(i), i);
        }
    }

    private void setCalendar(Competition.Phase.Group group, int groupId) {
        List<List<Team[]>> matchDays = matchDays(group);

        if (phase.definition().secondLegPolicy() != OnlyOneLeg) {
            if (phase.definition().secondLegPolicy() == Ordered) matchDays.addAll(reverse(matchDays));
            if (phase.definition().secondLegPolicy() == Unordered) matchDays.addAll(matchDays(group));
        }

        Instant date = ts;
        for (int i = 0; i < matchDays.size(); i++) {
            String matchDayName = phase.definition().matchDayName(i);
            Instant finalDate = phase.definition().nextDate(i, date);
            matchDays.get(i).stream().map(m -> matchOf(m, finalDate, groupId, matchDayName))
                    .forEach(m -> configuration.eventManager().add(new SimulateMatch(m)));
            date = finalDate;
        }
    }

    private List<List<Team[]>> matchDays(Competition.Phase.Group group) {
        List<Team> teams = new ArrayList<>(group.teams());
        Collections.shuffle(teams);
        List<List<Team[]>> matchDays = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i++) {
            List<Team[]> matchDay = new ArrayList<>();
            for (int j = 0; j < teams.size() / 2; j++) {
                Team local = teams.get(j);
                Team visitant = teams.get(teams.size() - 1 - j);
                if (i % 2 == 0) {
                    matchDay.add(new Team[]{local, visitant});
                } else {
                    matchDay.add(new Team[]{visitant, local});
                }
            }
            matchDays.add(matchDay);
            teams.add(1, teams.removeLast());
        }
        return matchDays;
    }

    private MatchDefinition matchOf(Team[] teams, Instant date, int groupId, String matchDay) {
        return new MatchDefinition(date, teams[0].definition().id(), teams[1].definition().id(), competition, season, phaseId, groupId, matchDay);
    }

    private List<List<Team[]>> reverse(List<List<Team[]>> matchDays) {
        return matchDays.stream().map(md -> md.stream().map(m -> new Team[] {m[1], m[0]}).toList()).toList();
    }
}
