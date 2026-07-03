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

public class TopScorersPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopScorersPosition topScorersPosition;

	public TopScorersPositionMold(ProtrixBox box) {
		super(box);
		id("a_890863818");
	}

	@Override
	public void init() {
		super.init();
		if (topScorersPosition == null) topScorersPosition = register(new TopScorersPosition(box()).<TopScorersPosition>id("a1737559088").owner(TopScorersPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topScorersPosition != null) topScorersPosition.unregister();
	}

	public class TopScorersPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopScorersPosition(ProtrixBox box) {
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