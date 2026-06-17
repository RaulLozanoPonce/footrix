package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.events.types.SetPhaseCalendarEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.SeasonReference;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.team.Team;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetPhaseCalendarCommand extends Command {
    private final Competition competition;
    private final SeasonReference season;
    private final int nPhase;
    private final Competition.Phase phase;
    private final Instant ts;

    public SetPhaseCalendarCommand(Application application, SetPhaseCalendarEvent event) {
        super(application);
        this.competition = competition(event.competitionId(), event.season());
        this.season = event.season();
        this.nPhase = event.nPhase();
        this.phase = competition.phase(event.nPhase());
        this.ts = event.executionDate();
    }

    public void execute() {
        for (int i = 0; i < phase.groups().size(); i++) {
            setCalendar(phase.group(i), i);
        }
    }

    private void setCalendar(Competition.Phase.Group group, int groupId) {
        List<List<Team[]>> matchDays = matchDays(group);
        if (phase.definition().hasSecondLeg()) matchDays.addAll(reverse(matchDays));
        Instant date = ts;
        for (int i = 0; i < matchDays.size(); i++) {
            String matchDayName = phase.definition().matchDayName(i);
            Instant finalDate = phase.definition().nextDate(i, date);
            matchDays.get(i).stream().map(m -> matchOf(m, groupId, matchDayName))
                    .forEach(m -> application.taskHub().add(finalDate, new ScheduledMatchEvent().date(finalDate).definition(m)));
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

    private MatchDefinition matchOf(Team[] teams, int groupId, String matchDay) {
        return new MatchDefinition(teams[0].definition().id(), teams[1].definition().id(), competition.definition().id(), application.game().seasonNumber(season), nPhase, groupId, matchDay);
    }

    private List<List<Team[]>> reverse(List<List<Team[]>> matchDays) {
        return matchDays.stream().map(md -> md.stream().map(m -> new Team[] {m[1], m[0]}).toList()).toList();
    }
}
