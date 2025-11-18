package rlp.footrix.framework.tasks.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.types.SetPhaseCalendarEvent;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.time.Instant;

public class SetPhaseCalendarTask extends Task {
    private final Competition competition;
    private final SeasonReference season;
    private final int nPhase;

    public SetPhaseCalendarTask(Instant executionDate, Application application, String competitionId, SeasonReference season, int nPhase) {
        super(executionDate, application);
        this.competition = application.competitionManager().get(competitionId, application.game().seasonNumber(season));
        this.season = season;
        this.nPhase = nPhase;
    }

    @Override
    public boolean preconditions() {
        //TODO ESTA ES LA PHASE DEL EVENTO
        Competition.Phase phase = competition.phase(nPhase);
        return phase.groups().stream().noneMatch(g -> g.teams().size() % 2 == 1); //TODO POR AHORA
    }

    @Override
    public void execute() {
        SetPhaseCalendarEvent event = new SetPhaseCalendarEvent();
        event.competition(competition);
        event.season(season);
        event.nPhase(nPhase);
        event.ts(executionDate);
        application.eventHub().publish(event);
    }
}
