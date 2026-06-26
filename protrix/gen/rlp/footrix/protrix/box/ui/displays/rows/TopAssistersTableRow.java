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

public class TopAssistersTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopAssistersPositionMold topAssistersPositionMold;
	public TopAssistersPlayerMold topAssistersPlayerMold;
	public TopAssistersAssistsMold topAssistersAssistsMold;
	public TopAssistersPlayedMatchesMold topAssistersPlayedMatchesMold;

	public TopAssistersTableRow(ProtrixBox box) {
		super(box);
		id("a149333858");
	}

	@Override
	public void init() {
		super.init();
		if (topAssistersPositionMold == null) topAssistersPositionMold = register(new TopAssistersPositionMold((ProtrixBox)box()).<TopAssistersPositionMold>id("a_1568760861").<TopAssistersPositionMold>item(TopAssistersTableRow.this.item()).owner(TopAssistersTableRow.this));
		if (topAssistersPlayerMold == null) topAssistersPlayerMold = register(new TopAssistersPlayerMold((ProtrixBox)box()).<TopAssistersPlayerMold>id("a1127815928").<TopAssistersPlayerMold>item(TopAssistersTableRow.this.item()).owner(TopAssistersTableRow.this));
		if (topAssistersAssistsMold == null) topAssistersAssistsMold = register(new TopAssistersAssistsMold((ProtrixBox)box()).<TopAssistersAssistsMold>id("a1357215935").<TopAssistersAssistsMold>item(TopAssistersTableRow.this.item()).owner(TopAssistersTableRow.this));
		if (topAssistersPlayedMatchesMold == null) topAssistersPlayedMatchesMold = register(new TopAssistersPlayedMatchesMold((ProtrixBox)box()).<TopAssistersPlayedMatchesMold>id("a_1006909128").<TopAssistersPlayedMatchesMold>item(TopAssistersTableRow.this.item()).owner(TopAssistersTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}