package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.MatchEventDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.MatchEventsTableRow;
import rlp.footrix.protrix.box.util.Resources;

import java.net.URL;

public class MatchInfoTemplate extends AbstractMatchInfoTemplate<ProtrixBox> {
    private final MatchEventDatasource matchEventDatasource;

    private Match match;

    public MatchInfoTemplate(ProtrixBox box) {
		super(box);
        this.matchEventDatasource = new MatchEventDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        matchEventsTable.onAddItem(this::addEvent);
    }

    public MatchInfoTemplate setup(Match match) {
        this.match = match;
        this.matchEventDatasource.filter(match);
        this.localMatchPlayersStamp.setup(match, match.definition().local());
        this.visitantMatchPlayersStamp.setup(match, match.definition().visitant());
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        localMatchPlayersStamp.refresh();
        visitantMatchPlayersStamp.refresh();
        matchEventDatasource.loadData();
        matchEventsTable.source(matchEventDatasource);
    }

    private void addEvent(AddCollectionItemEvent event) {
        Match.MatchEvent matchEvent = event.item();
        MatchEventsTableRow item = event.component();
        item.matchEventsMinuteMold.matchEventsMinute.value(matchEvent.minute() + "'");

        if (matchEvent.team().equals(match.definition().local())) {
            item.matchEventsLocalPlayerMold.matchEventsLocalFirstPlayer.value(nameOf(matchEvent.who()));
            item.matchEventsLocalPlayerMold.matchEventsLocalEventIcon.icon(iconOf(matchEvent));
            if (matchEvent.secondaryWho() != null) {
                item.matchEventsLocalPlayerMold.matchEventsLocalSecondPlayer.value(nameOf(matchEvent.secondaryWho()));
            }
        } else {
            item.matchEventsVisitantPlayerMold.matchEventsVisitantFirstPlayer.value(nameOf(matchEvent.who()));
            item.matchEventsVisitantPlayerMold.matchEventsVisitantEventIcon.icon(iconOf(matchEvent));
            if (matchEvent.secondaryWho() != null) {
                item.matchEventsVisitantPlayerMold.matchEventsVisitantSecondPlayer.value(nameOf(matchEvent.secondaryWho()));
            }
        }
    }

    private URL iconOf(Match.MatchEvent event) {
        if (event.type() == Match.MatchEvent.Type.Goal) return Resources.goalIconPath();
        if (event.type() == Match.MatchEvent.Type.Substitution) return Resources.substitutionIconPath();
        if (event.type() == Match.MatchEvent.Type.YellowCard) return Resources.yellowCardIconPath();
        if (event.type() == Match.MatchEvent.Type.RedCard) return Resources.redCardIconPath();
        if (event.type() == Match.MatchEvent.Type.Injury && event.metaInfo().get("level").getAsInt() == 1) return Resources.injury1IconPath();
        if (event.type() == Match.MatchEvent.Type.Injury && event.metaInfo().get("level").getAsInt() == 2) return Resources.injury2IconPath();
        if (event.type() == Match.MatchEvent.Type.Injury && event.metaInfo().get("level").getAsInt() == 3) return Resources.injury3IconPath();
        return null;
    }

    private String nameOf(String playerId) {
        return box().application().playerManager().definition(playerId).name();
    }
}