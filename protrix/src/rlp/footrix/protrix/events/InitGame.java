package rlp.footrix.protrix.events;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.tasks.types.InitPhaseTask;
import rlp.footrix.framework.tasks.types.SetPhaseCalendarTask;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.time.Instant;
import java.util.List;

import static rlp.footrix.framework.utils.TimeHelper.getInstantOf;
import static rlp.footrix.framework.utils.TimeHelper.yearOf;

public class InitGame extends Task {

    public InitGame(Instant executionDate, Application application) {
        super(executionDate, application);
    }

    @Override
    public void execute() {
        //TODO PASAR A FRAMEWORK
        initSeason();
        initEvents();
    }

    private void initSeason() {
        application.game().initSeason(0);
    }

    private void initEvents() {
        application.taskHub().add(new InitPhaseTask(date(2, 8, yearOf(executionDate)), application, "ESP-1", SeasonReference.Current, 0, List.of(), application.teamManager().ids()));
        application.taskHub().add(new SetPhaseCalendarTask(date(4, 8, yearOf(executionDate)), application, "ESP-1", SeasonReference.Current, 0));
        application.taskHub().add(new NewSeasonTask(date(1, 8, yearOf(executionDate) + 1), application));
    }

    private Instant date(int day, int month, int year) {
        return getInstantOf(year, month, day);
    }
}
