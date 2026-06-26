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

public class MatchPlayersYellowCardsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersYellowCards matchPlayersYellowCards;

	public MatchPlayersYellowCardsMold(ProtrixBox box) {
		super(box);
		id("a_1319029973");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersYellowCards == null) matchPlayersYellowCards = register(new MatchPlayersYellowCards(box()).<MatchPlayersYellowCards>id("a223163342").owner(MatchPlayersYellowCardsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersYellowCards != null) matchPlayersYellowCards.unregister();
	}

	public class MatchPlayersYellowCards extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersYellowCards(ProtrixBox box) {
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