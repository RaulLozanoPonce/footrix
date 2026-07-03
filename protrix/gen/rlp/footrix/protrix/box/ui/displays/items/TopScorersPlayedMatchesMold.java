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

public class TopScorersPlayedMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopScorersPlayedMatches topScorersPlayedMatches;

	public TopScorersPlayedMatchesMold(ProtrixBox box) {
		super(box);
		id("a1638625605");
	}

	@Override
	public void init() {
		super.init();
		if (topScorersPlayedMatches == null) topScorersPlayedMatches = register(new TopScorersPlayedMatches(box()).<TopScorersPlayedMatches>id("a1364595016").owner(TopScorersPlayedMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topScorersPlayedMatches != null) topScorersPlayedMatches.unregister();
	}

	public class TopScorersPlayedMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopScorersPlayedMatches(ProtrixBox box) {
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