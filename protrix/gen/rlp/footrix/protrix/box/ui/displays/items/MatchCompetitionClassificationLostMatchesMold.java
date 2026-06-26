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

public class MatchCompetitionClassificationLostMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationLostMatches matchCompetitionClassificationLostMatches;

	public MatchCompetitionClassificationLostMatchesMold(ProtrixBox box) {
		super(box);
		id("a_506754571");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationLostMatches == null) matchCompetitionClassificationLostMatches = register(new MatchCompetitionClassificationLostMatches(box()).<MatchCompetitionClassificationLostMatches>id("a_1121324475").owner(MatchCompetitionClassificationLostMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationLostMatches != null) matchCompetitionClassificationLostMatches.unregister();
	}

	public class MatchCompetitionClassificationLostMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationLostMatches(ProtrixBox box) {
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