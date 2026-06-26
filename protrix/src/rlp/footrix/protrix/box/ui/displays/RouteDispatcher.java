package rlp.footrix.protrix.box.ui.displays;

import io.intino.alexandria.ui.Soul;
import rlp.footrix.protrix.box.ui.displays.templates.AppTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.PlayerMatchTraceTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.PlayerTraceTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.TraceTemplate;

public class RouteDispatcher extends AbstractRouteDispatcher {

    @Override
    public void dispatchHome(Soul soul) {
        soul.display(AppTemplate.class).openHome();
    }

    @Override
    public void dispatchCompetitions(Soul soul) {
        soul.display(AppTemplate.class).openCompetitions();
    }

    @Override
    public void dispatchCompetition(Soul soul, String competitionId, String season) {
        soul.display(AppTemplate.class).openCompetition(competitionId, Integer.parseInt(season));
    }

    @Override
    public void dispatchTeams(Soul soul) {
        soul.display(AppTemplate.class).openTeams();
    }

    @Override
    public void dispatchTeam(Soul soul, String teamId) {
        soul.display(AppTemplate.class).openTeam(teamId);
    }

    @Override
    public void dispatchMatch(Soul soul, String matchId) {
        soul.display(AppTemplate.class).openMatch(matchId);
    }

    @Override
    public void dispatchTrace(Soul soul) {
        soul.display(TraceTemplate.class);
    }

    @Override
    public void dispatchPlayerTrace(Soul soul, String playerId) {
        soul.display(PlayerTraceTemplate.class).setPlayer(playerId);
    }

    @Override
    public void dispatchPlayerMatchTrace(Soul soul, String playerId) {
        soul.display(PlayerMatchTraceTemplate.class).setPlayer(playerId);
    }
}