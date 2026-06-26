package rlp.footrix.protrix.box.ui.displays.rows;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.RowNotifier;

public class MatchEventsTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.framework.types.entities.Match.MatchEvent, ProtrixBox> {
	public MatchEventsLocalPlayerMold matchEventsLocalPlayerMold;
	public MatchEventsMinuteMold matchEventsMinuteMold;
	public MatchEventsVisitantPlayerMold matchEventsVisitantPlayerMold;

	public MatchEventsTableRow(ProtrixBox box) {
		super(box);
		id("a_2089781444");
	}

	@Override
	public void init() {
		super.init();
		if (matchEventsLocalPlayerMold == null) matchEventsLocalPlayerMold = register(new MatchEventsLocalPlayerMold((ProtrixBox)box()).<MatchEventsLocalPlayerMold>id("a1501116695").<MatchEventsLocalPlayerMold>item(MatchEventsTableRow.this.item()).owner(MatchEventsTableRow.this));
		if (matchEventsMinuteMold == null) matchEventsMinuteMold = register(new MatchEventsMinuteMold((ProtrixBox)box()).<MatchEventsMinuteMold>id("a_1340574950").<MatchEventsMinuteMold>item(MatchEventsTableRow.this.item()).owner(MatchEventsTableRow.this));
		if (matchEventsVisitantPlayerMold == null) matchEventsVisitantPlayerMold = register(new MatchEventsVisitantPlayerMold((ProtrixBox)box()).<MatchEventsVisitantPlayerMold>id("a491676487").<MatchEventsVisitantPlayerMold>item(MatchEventsTableRow.this.item()).owner(MatchEventsTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}