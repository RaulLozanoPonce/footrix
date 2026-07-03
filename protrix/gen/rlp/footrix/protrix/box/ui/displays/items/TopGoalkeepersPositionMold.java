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

public class TopGoalkeepersPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopGoalkeepersPosition topGoalkeepersPosition;

	public TopGoalkeepersPositionMold(ProtrixBox box) {
		super(box);
		id("a1801476665");
	}

	@Override
	public void init() {
		super.init();
		if (topGoalkeepersPosition == null) topGoalkeepersPosition = register(new TopGoalkeepersPosition(box()).<TopGoalkeepersPosition>id("a796287432").owner(TopGoalkeepersPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topGoalkeepersPosition != null) topGoalkeepersPosition.unregister();
	}

	public class TopGoalkeepersPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopGoalkeepersPosition(ProtrixBox box) {
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