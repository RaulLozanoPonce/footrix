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

public class MatchPlayersExitsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersExits matchPlayersExits;

	public MatchPlayersExitsMold(ProtrixBox box) {
		super(box);
		id("a135772172");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersExits == null) matchPlayersExits = register(new MatchPlayersExits(box()).<MatchPlayersExits>id("a_779625099").owner(MatchPlayersExitsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersExits != null) matchPlayersExits.unregister();
	}

	public class MatchPlayersExits extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersExits(ProtrixBox box) {
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