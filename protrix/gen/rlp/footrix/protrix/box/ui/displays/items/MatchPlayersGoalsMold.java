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

public class MatchPlayersGoalsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerMatchRecord, ProtrixBox> {
	public MatchPlayersGoals matchPlayersGoals;

	public MatchPlayersGoalsMold(ProtrixBox box) {
		super(box);
		id("a1634617914");
	}

	@Override
	public void init() {
		super.init();
		if (matchPlayersGoals == null) matchPlayersGoals = register(new MatchPlayersGoals(box()).<MatchPlayersGoals>id("a_506234674").owner(MatchPlayersGoalsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchPlayersGoals != null) matchPlayersGoals.unregister();
	}

	public class MatchPlayersGoals extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchPlayersGoals(ProtrixBox box) {
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