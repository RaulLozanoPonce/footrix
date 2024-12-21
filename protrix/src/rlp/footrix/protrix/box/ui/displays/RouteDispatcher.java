package rlp.footrix.protrix.box.ui.displays;

import io.intino.alexandria.ui.Soul;
import rlp.footrix.protrix.box.ui.displays.templates.ClassificationTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.PlayerTraceTemplate;

public class RouteDispatcher extends AbstractRouteDispatcher {

    @Override
    public void dispatchHome(Soul soul) {

    }

    @Override
    public void dispatchPlayerTrace(Soul soul, String playerId) {
        soul.display(PlayerTraceTemplate.class).setPlayer(playerId);
    }

    @Override
    public void dispatchClassification(Soul soul, String competitionId) {
        soul.display(ClassificationTemplate.class).setCompetition(competitionId);
    }
}