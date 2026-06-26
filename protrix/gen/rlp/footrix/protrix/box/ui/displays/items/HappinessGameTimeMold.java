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

public class HappinessGameTimeMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public HappinessGameTime happinessGameTime;

	public HappinessGameTimeMold(ProtrixBox box) {
		super(box);
		id("a_1685662537");
	}

	@Override
	public void init() {
		super.init();
		if (happinessGameTime == null) happinessGameTime = register(new HappinessGameTime(box()).<HappinessGameTime>id("a1185328798").owner(HappinessGameTimeMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (happinessGameTime != null) happinessGameTime.unregister();
	}

	public class HappinessGameTime extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public HappinessGameTime(ProtrixBox box) {
			super(box);
			_value(0.0);
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