package rlp.footrix.framework.tasks.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.types.InitPhaseEvent;
import rlp.footrix.framework.tasks.Task;
import rlp.footrix.framework.types.entities.SeasonReference;

import java.time.Instant;
import java.util.List;

public class InitPhaseTask extends Task {
    private final String competitionId;
    private final SeasonReference season;
    private final int nPhase;
    private final List<String> rulesIds;
    private final List<String> teamIds;

    public InitPhaseTask(Instant executionDate, Application application, String competitionId, SeasonReference season, int nPhase, List<String> rulesIds, List<String> teamIds) {
        super(executionDate, application);
        this.competitionId = competitionId;
        this.season = season;
        this.nPhase = nPhase;
        this.rulesIds = rulesIds;
        this.teamIds = teamIds;
    }

    @Override
    public void execute() {
        InitPhaseEvent event = new InitPhaseEvent();
        event.competition(application.competitionManager().get(competitionId, application.game().seasonNumber(season)));
        event.nPhase(nPhase);
        event.teamRules(application.rulesManager().get(rulesIds));
        event.teams(teamIds.stream().map(id -> application.teamManager().get(id)).toList());
        application.eventHub().publish(event);
    }
}
