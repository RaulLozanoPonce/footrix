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

public class TopScorersTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopScorersPositionMold topScorersPositionMold;
	public TopScorersPlayerMold topScorersPlayerMold;
	public TopScorersGoalsMold topScorersGoalsMold;
	public TopScorersPlayedMatchesMold topScorersPlayedMatchesMold;

	public TopScorersTableRow(ProtrixBox box) {
		super(box);
		id("a_1628154717");
	}

	@Override
	public void init() {
		super.init();
		if (topScorersPositionMold == null) topScorersPositionMold = register(new TopScorersPositionMold((ProtrixBox)box()).<TopScorersPositionMold>id("a_890863818").<TopScorersPositionMold>item(TopScorersTableRow.this.item()).owner(TopScorersTableRow.this));
		if (topScorersPlayerMold == null) topScorersPlayerMold = register(new TopScorersPlayerMold((ProtrixBox)box()).<TopScorersPlayerMold>id("a1196452427").<TopScorersPlayerMold>item(TopScorersTableRow.this.item()).owner(TopScorersTableRow.this));
		if (topScorersGoalsMold == null) topScorersGoalsMold = register(new TopScorersGoalsMold((ProtrixBox)box()).<TopScorersGoalsMold>id("a201273698").<TopScorersGoalsMold>item(TopScorersTableRow.this.item()).owner(TopScorersTableRow.this));
		if (topScorersPlayedMatchesMold == null) topScorersPlayedMatchesMold = register(new TopScorersPlayedMatchesMold((ProtrixBox)box()).<TopScorersPlayedMatchesMold>id("a1638625605").<TopScorersPlayedMatchesMold>item(TopScorersTableRow.this.item()).owner(TopScorersTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}