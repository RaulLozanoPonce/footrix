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

public class TopScorersGoalsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopScorersGoals topScorersGoals;

	public TopScorersGoalsMold(ProtrixBox box) {
		super(box);
		id("a1446038179");
	}

	@Override
	public void init() {
		super.init();
		if (topScorersGoals == null) topScorersGoals = register(new TopScorersGoals(box()).<TopScorersGoals>id("a1755445126").owner(TopScorersGoalsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topScorersGoals != null) topScorersGoals.unregister();
	}

	public class TopScorersGoals extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopScorersGoals(ProtrixBox box) {
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