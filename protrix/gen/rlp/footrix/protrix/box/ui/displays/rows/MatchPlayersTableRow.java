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

public class MatchPlayersTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersNumberMold matchPlayersNumberMold;
	public MatchPlayersNameMold matchPlayersNameMold;
	public MatchPlayersPositionMold matchPlayersPositionMold;
	public MatchPlayersEntersMold matchPlayersEntersMold;
	public MatchPlayersExitsMold matchPlayersExitsMold;
	public MatchPlayersGoalsMold matchPlayersGoalsMold;
	public MatchPlayersAssistsMold matchPlayersAssistsMold;
	public MatchPlayersYellowCardsMold matchPlayersYellowCardsMold;
	public MatchPlayersRedCardsMold matchPlayersRedCardsMold;
	public MatchPlayersScoreMold matchPlayersScoreMold;

	public MatchPlayersTableRow(ProtrixBox box) {
		super(box);
		id("a_482595246");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersNumberMold == null) matchPlayersNumberMold = register(new MatchPlayersNumberMold((ProtrixBox)box()).<MatchPlayersNumberMold>id("a1762520423").<MatchPlayersNumberMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersNameMold == null) matchPlayersNameMold = register(new MatchPlayersNameMold((ProtrixBox)box()).<MatchPlayersNameMold>id("a1404727622").<MatchPlayersNameMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersPositionMold == null) matchPlayersPositionMold = register(new MatchPlayersPositionMold((ProtrixBox)box()).<MatchPlayersPositionMold>id("a_808485247").<MatchPlayersPositionMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersEntersMold == null) matchPlayersEntersMold = register(new MatchPlayersEntersMold((ProtrixBox)box()).<MatchPlayersEntersMold>id("a_2010535077").<MatchPlayersEntersMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersExitsMold == null) matchPlayersExitsMold = register(new MatchPlayersExitsMold((ProtrixBox)box()).<MatchPlayersExitsMold>id("a135772172").<MatchPlayersExitsMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersGoalsMold == null) matchPlayersGoalsMold = register(new MatchPlayersGoalsMold((ProtrixBox)box()).<MatchPlayersGoalsMold>id("a1634617914").<MatchPlayersGoalsMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersAssistsMold == null) matchPlayersAssistsMold = register(new MatchPlayersAssistsMold((ProtrixBox)box()).<MatchPlayersAssistsMold>id("a2042350659").<MatchPlayersAssistsMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersYellowCardsMold == null) matchPlayersYellowCardsMold = register(new MatchPlayersYellowCardsMold((ProtrixBox)box()).<MatchPlayersYellowCardsMold>id("a_1319029973").<MatchPlayersYellowCardsMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersRedCardsMold == null) matchPlayersRedCardsMold = register(new MatchPlayersRedCardsMold((ProtrixBox)box()).<MatchPlayersRedCardsMold>id("a_1622816825").<MatchPlayersRedCardsMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
		if (matchPlayersScoreMold == null) matchPlayersScoreMold = register(new MatchPlayersScoreMold((ProtrixBox)box()).<MatchPlayersScoreMold>id("a1039441289").<MatchPlayersScoreMold>item(MatchPlayersTableRow.this.item()).owner(MatchPlayersTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}