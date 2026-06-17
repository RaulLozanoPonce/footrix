package rlp.footrix.framework.commands;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.SeasonReference;
import rlp.footrix.framework.types.entities.team.Team;

public abstract class Command {
    protected final Application application;

    public Command(Application application) {
        this.application = application;
    }

    protected Competition competition(String competitionId, SeasonReference season) {
        return application.entityStore().competition(competitionId, seasonNumber(season));
    }

    private int seasonNumber(SeasonReference season) {
        return application.game().seasonNumber(season);
    }

    protected Team team(String teamId) {
        return application.entityStore().team(teamId);
    }
}
