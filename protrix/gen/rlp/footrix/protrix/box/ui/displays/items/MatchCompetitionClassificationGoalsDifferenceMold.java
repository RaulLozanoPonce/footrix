package rlp.footrix.protrix.box.ui.displays.items;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.ItemNotifier;

public class MatchCompetitionClassificationGoalsDifferenceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationGoalsDifference matchCompetitionClassificationGoalsDifference;

	public MatchCompetitionClassificationGoalsDifferenceMold(ProtrixBox box) {
		super(box);
		id("a_1085487679");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationGoalsDifference == null) matchCompetitionClassificationGoalsDifference = register(new MatchCompetitionClassificationGoalsDifference(box()).<MatchCompetitionClassificationGoalsDifference>id("a_1758361153").owner(MatchCompetitionClassificationGoalsDifferenceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationGoalsDifference != null) matchCompetitionClassificationGoalsDifference.unregister();
	}

	public class MatchCompetitionClassificationGoalsDifference extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationGoalsDifference(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}

		@Override
		public void unregister() {
			super.unregister();
		}
	}
}