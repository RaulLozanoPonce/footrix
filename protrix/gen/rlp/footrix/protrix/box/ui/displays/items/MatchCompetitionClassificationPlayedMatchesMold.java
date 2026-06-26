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

public class MatchCompetitionClassificationPlayedMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationPlayedMatches matchCompetitionClassificationPlayedMatches;

	public MatchCompetitionClassificationPlayedMatchesMold(ProtrixBox box) {
		super(box);
		id("a1262306120");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationPlayedMatches == null) matchCompetitionClassificationPlayedMatches = register(new MatchCompetitionClassificationPlayedMatches(box()).<MatchCompetitionClassificationPlayedMatches>id("a698406665").owner(MatchCompetitionClassificationPlayedMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationPlayedMatches != null) matchCompetitionClassificationPlayedMatches.unregister();
	}

	public class MatchCompetitionClassificationPlayedMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationPlayedMatches(ProtrixBox box) {
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