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

public class TopGoalkeepersPlayedMinutesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopGoalkeepersPlayedMinutes topGoalkeepersPlayedMinutes;

	public TopGoalkeepersPlayedMinutesMold(ProtrixBox box) {
		super(box);
		id("a_779510129");
	}

	@Override
	public void init() {
		super.init();
		if (topGoalkeepersPlayedMinutes == null) topGoalkeepersPlayedMinutes = register(new TopGoalkeepersPlayedMinutes(box()).<TopGoalkeepersPlayedMinutes>id("a_217603933").owner(TopGoalkeepersPlayedMinutesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topGoalkeepersPlayedMinutes != null) topGoalkeepersPlayedMinutes.unregister();
	}

	public class TopGoalkeepersPlayedMinutes extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopGoalkeepersPlayedMinutes(ProtrixBox box) {
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