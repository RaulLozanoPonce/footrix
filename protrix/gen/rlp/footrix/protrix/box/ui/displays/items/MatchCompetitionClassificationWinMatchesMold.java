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

public class MatchCompetitionClassificationWinMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationWinMatches matchCompetitionClassificationWinMatches;

	public MatchCompetitionClassificationWinMatchesMold(ProtrixBox box) {
		super(box);
		id("a1534964640");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationWinMatches == null) matchCompetitionClassificationWinMatches = register(new MatchCompetitionClassificationWinMatches(box()).<MatchCompetitionClassificationWinMatches>id("a_1968481066").owner(MatchCompetitionClassificationWinMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationWinMatches != null) matchCompetitionClassificationWinMatches.unregister();
	}

	public class MatchCompetitionClassificationWinMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationWinMatches(ProtrixBox box) {
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