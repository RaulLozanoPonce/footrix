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

public class MatchCompetitionClassificationTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationPositionMold matchCompetitionClassificationPositionMold;
	public MatchCompetitionClassificationTeamMold matchCompetitionClassificationTeamMold;
	public MatchCompetitionClassificationPlayedMatchesMold matchCompetitionClassificationPlayedMatchesMold;
	public MatchCompetitionClassificationWinMatchesMold matchCompetitionClassificationWinMatchesMold;
	public MatchCompetitionClassificationDrawMatchesMold matchCompetitionClassificationDrawMatchesMold;
	public MatchCompetitionClassificationLostMatchesMold matchCompetitionClassificationLostMatchesMold;
	public MatchCompetitionClassificationGoalsForMold matchCompetitionClassificationGoalsForMold;
	public MatchCompetitionClassificationGoalsAgainstMold matchCompetitionClassificationGoalsAgainstMold;
	public MatchCompetitionClassificationGoalsDifferenceMold matchCompetitionClassificationGoalsDifferenceMold;
	public MatchCompetitionClassificationPointsMold matchCompetitionClassificationPointsMold;

	public MatchCompetitionClassificationTableRow(ProtrixBox box) {
		super(box);
		id("a_1333392230");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationPositionMold == null) matchCompetitionClassificationPositionMold = register(new MatchCompetitionClassificationPositionMold((ProtrixBox)box()).<MatchCompetitionClassificationPositionMold>id("a2068751163").<MatchCompetitionClassificationPositionMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationTeamMold == null) matchCompetitionClassificationTeamMold = register(new MatchCompetitionClassificationTeamMold((ProtrixBox)box()).<MatchCompetitionClassificationTeamMold>id("a_71836212").<MatchCompetitionClassificationTeamMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationPlayedMatchesMold == null) matchCompetitionClassificationPlayedMatchesMold = register(new MatchCompetitionClassificationPlayedMatchesMold((ProtrixBox)box()).<MatchCompetitionClassificationPlayedMatchesMold>id("a1262306120").<MatchCompetitionClassificationPlayedMatchesMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationWinMatchesMold == null) matchCompetitionClassificationWinMatchesMold = register(new MatchCompetitionClassificationWinMatchesMold((ProtrixBox)box()).<MatchCompetitionClassificationWinMatchesMold>id("a1534964640").<MatchCompetitionClassificationWinMatchesMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationDrawMatchesMold == null) matchCompetitionClassificationDrawMatchesMold = register(new MatchCompetitionClassificationDrawMatchesMold((ProtrixBox)box()).<MatchCompetitionClassificationDrawMatchesMold>id("a197870034").<MatchCompetitionClassificationDrawMatchesMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationLostMatchesMold == null) matchCompetitionClassificationLostMatchesMold = register(new MatchCompetitionClassificationLostMatchesMold((ProtrixBox)box()).<MatchCompetitionClassificationLostMatchesMold>id("a_506754571").<MatchCompetitionClassificationLostMatchesMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationGoalsForMold == null) matchCompetitionClassificationGoalsForMold = register(new MatchCompetitionClassificationGoalsForMold((ProtrixBox)box()).<MatchCompetitionClassificationGoalsForMold>id("a1673975348").<MatchCompetitionClassificationGoalsForMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationGoalsAgainstMold == null) matchCompetitionClassificationGoalsAgainstMold = register(new MatchCompetitionClassificationGoalsAgainstMold((ProtrixBox)box()).<MatchCompetitionClassificationGoalsAgainstMold>id("a1419020692").<MatchCompetitionClassificationGoalsAgainstMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationGoalsDifferenceMold == null) matchCompetitionClassificationGoalsDifferenceMold = register(new MatchCompetitionClassificationGoalsDifferenceMold((ProtrixBox)box()).<MatchCompetitionClassificationGoalsDifferenceMold>id("a_1085487679").<MatchCompetitionClassificationGoalsDifferenceMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
		if (matchCompetitionClassificationPointsMold == null) matchCompetitionClassificationPointsMold = register(new MatchCompetitionClassificationPointsMold((ProtrixBox)box()).<MatchCompetitionClassificationPointsMold>id("a_564627824").<MatchCompetitionClassificationPointsMold>item(MatchCompetitionClassificationTableRow.this.item()).owner(MatchCompetitionClassificationTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}