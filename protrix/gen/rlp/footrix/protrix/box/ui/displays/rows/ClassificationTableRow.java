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

public class ClassificationTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationPositionMold classificationPositionMold;
	public ClassificationTeamMold classificationTeamMold;
	public ClassificationPlayedMatchesMold classificationPlayedMatchesMold;
	public ClassificationWinMatchesMold classificationWinMatchesMold;
	public ClassificationDrawMatchesMold classificationDrawMatchesMold;
	public ClassificationLostMatchesMold classificationLostMatchesMold;
	public ClassificationGoalsDifferenceMold classificationGoalsDifferenceMold;
	public ClassificationPointsMold classificationPointsMold;

	public ClassificationTableRow(ProtrixBox box) {
		super(box);
		id("a1054416587");
	}

	@Override
	public void init() {
		super.init();
		if (classificationPositionMold == null) classificationPositionMold = register(new ClassificationPositionMold((ProtrixBox)box()).<ClassificationPositionMold>id("a_93685048").<ClassificationPositionMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationTeamMold == null) classificationTeamMold = register(new ClassificationTeamMold((ProtrixBox)box()).<ClassificationTeamMold>id("a412069732").<ClassificationTeamMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationPlayedMatchesMold == null) classificationPlayedMatchesMold = register(new ClassificationPlayedMatchesMold((ProtrixBox)box()).<ClassificationPlayedMatchesMold>id("a455385776").<ClassificationPlayedMatchesMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationWinMatchesMold == null) classificationWinMatchesMold = register(new ClassificationWinMatchesMold((ProtrixBox)box()).<ClassificationWinMatchesMold>id("a1888069432").<ClassificationWinMatchesMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationDrawMatchesMold == null) classificationDrawMatchesMold = register(new ClassificationDrawMatchesMold((ProtrixBox)box()).<ClassificationDrawMatchesMold>id("a484345125").<ClassificationDrawMatchesMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationLostMatchesMold == null) classificationLostMatchesMold = register(new ClassificationLostMatchesMold((ProtrixBox)box()).<ClassificationLostMatchesMold>id("a_1065640099").<ClassificationLostMatchesMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationGoalsDifferenceMold == null) classificationGoalsDifferenceMold = register(new ClassificationGoalsDifferenceMold((ProtrixBox)box()).<ClassificationGoalsDifferenceMold>id("a_1581607794").<ClassificationGoalsDifferenceMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
		if (classificationPointsMold == null) classificationPointsMold = register(new ClassificationPointsMold((ProtrixBox)box()).<ClassificationPointsMold>id("a_1821952221").<ClassificationPointsMold>item(ClassificationTableRow.this.item()).owner(ClassificationTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}