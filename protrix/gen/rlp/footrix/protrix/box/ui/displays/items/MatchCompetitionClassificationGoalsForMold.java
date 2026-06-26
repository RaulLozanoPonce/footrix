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

public class MatchCompetitionClassificationGoalsForMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationGoalsFor matchCompetitionClassificationGoalsFor;

	public MatchCompetitionClassificationGoalsForMold(ProtrixBox box) {
		super(box);
		id("a1673975348");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationGoalsFor == null) matchCompetitionClassificationGoalsFor = register(new MatchCompetitionClassificationGoalsFor(box()).<MatchCompetitionClassificationGoalsFor>id("a1943341748").owner(MatchCompetitionClassificationGoalsForMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationGoalsFor != null) matchCompetitionClassificationGoalsFor.unregister();
	}

	public class MatchCompetitionClassificationGoalsFor extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationGoalsFor(ProtrixBox box) {
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