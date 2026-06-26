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

public class MatchPlayersScoreMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersScore matchPlayersScore;

	public MatchPlayersScoreMold(ProtrixBox box) {
		super(box);
		id("a1039441289");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersScore == null) matchPlayersScore = register(new MatchPlayersScore(box()).<MatchPlayersScore>id("a_1631383249").owner(MatchPlayersScoreMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersScore != null) matchPlayersScore.unregister();
	}

	public class MatchPlayersScore extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersScore(ProtrixBox box) {
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
		public MatchPlayersScore textColor(String color) {
			this._textColor(color);
			this._refreshHighlight();
			return this;
		}

		public MatchPlayersScore backgroundColor(String color) {
			this._backgroundColor(color);
			this._refreshHighlight();
			return this;
		}
	}
}