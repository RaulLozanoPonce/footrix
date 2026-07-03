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

public class TopAssistersPlayedMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopAssistersPlayedMatches topAssistersPlayedMatches;

	public TopAssistersPlayedMatchesMold(ProtrixBox box) {
		super(box);
		id("a1176767799");
	}

	@Override
	public void init() {
		super.init();
		if (topAssistersPlayedMatches == null) topAssistersPlayedMatches = register(new TopAssistersPlayedMatches(box()).<TopAssistersPlayedMatches>id("a_1115406800").owner(TopAssistersPlayedMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topAssistersPlayedMatches != null) topAssistersPlayedMatches.unregister();
	}

	public class TopAssistersPlayedMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopAssistersPlayedMatches(ProtrixBox box) {
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