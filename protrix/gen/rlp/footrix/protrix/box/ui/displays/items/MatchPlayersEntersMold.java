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

public class MatchPlayersEntersMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersEnters matchPlayersEnters;

	public MatchPlayersEntersMold(ProtrixBox box) {
		super(box);
		id("a_2010535077");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersEnters == null) matchPlayersEnters = register(new MatchPlayersEnters(box()).<MatchPlayersEnters>id("a883425932").owner(MatchPlayersEntersMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersEnters != null) matchPlayersEnters.unregister();
	}

	public class MatchPlayersEnters extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersEnters(ProtrixBox box) {
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