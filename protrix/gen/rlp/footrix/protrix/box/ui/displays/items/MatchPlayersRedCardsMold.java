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

public class MatchPlayersRedCardsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersRedCards matchPlayersRedCards;

	public MatchPlayersRedCardsMold(ProtrixBox box) {
		super(box);
		id("a_1622816825");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersRedCards == null) matchPlayersRedCards = register(new MatchPlayersRedCards(box()).<MatchPlayersRedCards>id("a185370135").owner(MatchPlayersRedCardsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersRedCards != null) matchPlayersRedCards.unregister();
	}

	public class MatchPlayersRedCards extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersRedCards(ProtrixBox box) {
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