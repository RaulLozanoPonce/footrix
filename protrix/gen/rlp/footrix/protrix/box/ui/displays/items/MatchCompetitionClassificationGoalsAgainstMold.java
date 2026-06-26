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

public class MatchCompetitionClassificationGoalsAgainstMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationGoalsAgainst matchCompetitionClassificationGoalsAgainst;

	public MatchCompetitionClassificationGoalsAgainstMold(ProtrixBox box) {
		super(box);
		id("a1419020692");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationGoalsAgainst == null) matchCompetitionClassificationGoalsAgainst = register(new MatchCompetitionClassificationGoalsAgainst(box()).<MatchCompetitionClassificationGoalsAgainst>id("a_659789108").owner(MatchCompetitionClassificationGoalsAgainstMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationGoalsAgainst != null) matchCompetitionClassificationGoalsAgainst.unregister();
	}

	public class MatchCompetitionClassificationGoalsAgainst extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationGoalsAgainst(ProtrixBox box) {
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