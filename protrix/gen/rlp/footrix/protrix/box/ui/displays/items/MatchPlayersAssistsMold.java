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

public class MatchPlayersAssistsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersAssists matchPlayersAssists;

	public MatchPlayersAssistsMold(ProtrixBox box) {
		super(box);
		id("a2042350659");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersAssists == null) matchPlayersAssists = register(new MatchPlayersAssists(box()).<MatchPlayersAssists>id("a_1826883519").owner(MatchPlayersAssistsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersAssists != null) matchPlayersAssists.unregister();
	}

	public class MatchPlayersAssists extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersAssists(ProtrixBox box) {
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