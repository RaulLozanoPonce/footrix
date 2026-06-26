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

public class TopGoalkeepersTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopGoalkeepersPositionMold topGoalkeepersPositionMold;
	public TopGoalkeepersPlayerMold topGoalkeepersPlayerMold;
	public TopGoalkeepersGoalsMold topGoalkeepersGoalsMold;
	public TopGoalkeepersPlayedMinutesMold topGoalkeepersPlayedMinutesMold;

	public TopGoalkeepersTableRow(ProtrixBox box) {
		super(box);
		id("a_115948781");
	}

	@Override
	public void init() {
		super.init();
		if (topGoalkeepersPositionMold == null) topGoalkeepersPositionMold = register(new TopGoalkeepersPositionMold((ProtrixBox)box()).<TopGoalkeepersPositionMold>id("a1812792792").<TopGoalkeepersPositionMold>item(TopGoalkeepersTableRow.this.item()).owner(TopGoalkeepersTableRow.this));
		if (topGoalkeepersPlayerMold == null) topGoalkeepersPlayerMold = register(new TopGoalkeepersPlayerMold((ProtrixBox)box()).<TopGoalkeepersPlayerMold>id("a381328109").<TopGoalkeepersPlayerMold>item(TopGoalkeepersTableRow.this.item()).owner(TopGoalkeepersTableRow.this));
		if (topGoalkeepersGoalsMold == null) topGoalkeepersGoalsMold = register(new TopGoalkeepersGoalsMold((ProtrixBox)box()).<TopGoalkeepersGoalsMold>id("a2003318955").<TopGoalkeepersGoalsMold>item(TopGoalkeepersTableRow.this.item()).owner(TopGoalkeepersTableRow.this));
		if (topGoalkeepersPlayedMinutesMold == null) topGoalkeepersPlayedMinutesMold = register(new TopGoalkeepersPlayedMinutesMold((ProtrixBox)box()).<TopGoalkeepersPlayedMinutesMold>id("a_779510129").<TopGoalkeepersPlayedMinutesMold>item(TopGoalkeepersTableRow.this.item()).owner(TopGoalkeepersTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}