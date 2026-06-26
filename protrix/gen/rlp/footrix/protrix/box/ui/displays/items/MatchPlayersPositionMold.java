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

public class MatchPlayersPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersPosition matchPlayersPosition;

	public MatchPlayersPositionMold(ProtrixBox box) {
		super(box);
		id("a_808485247");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersPosition == null) matchPlayersPosition = register(new MatchPlayersPosition(box()).<MatchPlayersPosition>id("a_420556940").owner(MatchPlayersPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersPosition != null) matchPlayersPosition.unregister();
	}

	public class MatchPlayersPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersPosition(ProtrixBox box) {
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
		public MatchPlayersPosition textColor(String color) {
			this._textColor(color);
			this._refreshHighlight();
			return this;
		}

		public MatchPlayersPosition backgroundColor(String color) {
			this._backgroundColor(color);
			this._refreshHighlight();
			return this;
		}
	}
}