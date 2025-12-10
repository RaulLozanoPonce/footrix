package rlp.footrix.protrix.box.ui.displays;

import io.intino.alexandria.ui.Soul;
import rlp.footrix.protrix.box.ui.displays.templates.AppTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.PlayerTraceTemplate;
import rlp.footrix.protrix.box.ui.displays.templates.TraceTemplate;

public class RouteDispatcher extends AbstractRouteDispatcher {

    @Override
    public void dispatchHome(Soul soul) {
        soul.display(AppTemplate.class).openHome();
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
}