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

public class MatchPlayersNumberMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersNumber matchPlayersNumber;

	public MatchPlayersNumberMold(ProtrixBox box) {
		super(box);
		id("a1762520423");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersNumber == null) matchPlayersNumber = register(new MatchPlayersNumber(box()).<MatchPlayersNumber>id("a_438725714").owner(MatchPlayersNumberMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersNumber != null) matchPlayersNumber.unregister();
	}

	public class MatchPlayersNumber extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersNumber(ProtrixBox box) {
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