package rlp.footrix.protrix;


import rlp.footrix.framework.FootrixConfiguration;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.types.InitPhaseEvent;
import rlp.footrix.framework.events.types.NewSeasonEvent;
import rlp.footrix.framework.events.types.SetPhaseCalendarEvent;
import rlp.footrix.framework.types.entities.SeasonReference;
import rlp.footrix.pes6.Pes6Application;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rlp.footrix.framework.utils.TimeHelper.getInstantOf;
import static rlp.footrix.framework.utils.TimeHelper.yearOf;

public class ProtrixApplication extends Pes6Application {

    public ProtrixApplication(FootrixConfiguration configuration) {
        super(configuration);
        addRules();
    }

    private void addRules() {
        add("ESP-1-RULE", new TeamRule("ESP-1", SeasonReference.Last, 0, 0, list -> list));
    }

    @Override
    public Map<Instant, List<Event>> newSeasonTasks(boolean isInitGame) {
        Instant executionDate = game().date();
        Map<Instant, List<Event>> newSeasonTasks = new HashMap<>();
        if (isInitGame) {
            putIn(newSeasonTasks, date(2, 8, yearOf(executionDate)), new InitPhaseEvent().competitionId("ESP-1").season(SeasonReference.Current).teamIds(teamManager().ids()));
        } else {
            putIn(newSeasonTasks, date(2, 8, yearOf(executionDate)), new InitPhaseEvent().competitionId("ESP-1").season(SeasonReference.Current).rulesIds(List.of("ESP-1-RULE")));
        }
        putIn(newSeasonTasks, date(4, 8, yearOf(executionDate)), new SetPhaseCalendarEvent().competitionId("ESP-1").season(SeasonReference.Current).nPhase(0).executionDate(executionDate));
        putIn(newSeasonTasks, date(1, 8, yearOf(executionDate) + 1), new NewSeasonEvent());
        return newSeasonTasks;
    }

    private void putIn(Map<Instant, List<Event>> newSeasonTasks, Instant date, Event event) {
        newSeasonTasks.putIfAbsent(date, new ArrayList<>());
        newSeasonTasks.get(date).add(event);
    }

    private Instant date(int day, int month, int year) {
        return getInstantOf(year, month, day);
    }
}
