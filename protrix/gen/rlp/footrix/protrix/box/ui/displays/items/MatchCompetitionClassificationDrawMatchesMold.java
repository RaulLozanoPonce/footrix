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

public class MatchCompetitionClassificationDrawMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationDrawMatches matchCompetitionClassificationDrawMatches;

	public MatchCompetitionClassificationDrawMatchesMold(ProtrixBox box) {
		super(box);
		id("a197870034");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationDrawMatches == null) matchCompetitionClassificationDrawMatches = register(new MatchCompetitionClassificationDrawMatches(box()).<MatchCompetitionClassificationDrawMatches>id("a_1466172478").owner(MatchCompetitionClassificationDrawMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationDrawMatches != null) matchCompetitionClassificationDrawMatches.unregister();
	}

	public class MatchCompetitionClassificationDrawMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationDrawMatches(ProtrixBox box) {
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