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

public class TopGoalkeepersGoalsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopGoalkeepersGoals topGoalkeepersGoals;

	public TopGoalkeepersGoalsMold(ProtrixBox box) {
		super(box);
		id("a2003318955");
	}

	@Override
	public void init() {
		super.init();
		if (topGoalkeepersGoals == null) topGoalkeepersGoals = register(new TopGoalkeepersGoals(box()).<TopGoalkeepersGoals>id("a_2145343245").owner(TopGoalkeepersGoalsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topGoalkeepersGoals != null) topGoalkeepersGoals.unregister();
	}

	public class TopGoalkeepersGoals extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopGoalkeepersGoals(ProtrixBox box) {
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