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

public class MatchPlayersNameMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersName matchPlayersName;

	public MatchPlayersNameMold(ProtrixBox box) {
		super(box);
		id("a1404727622");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersName == null) matchPlayersName = register(new MatchPlayersName(box()).<MatchPlayersName>id("a_1115759055").owner(MatchPlayersNameMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersName != null) matchPlayersName.unregister();
	}

	public class MatchPlayersName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersName(ProtrixBox box) {
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