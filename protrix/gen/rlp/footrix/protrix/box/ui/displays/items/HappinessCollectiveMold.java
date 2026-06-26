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

public class HappinessCollectiveMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public HappinessCollective happinessCollective;

	public HappinessCollectiveMold(ProtrixBox box) {
		super(box);
		id("a508997537");
	}

	@Override
	public void init() {
		super.init();
		if (happinessCollective == null) happinessCollective = register(new HappinessCollective(box()).<HappinessCollective>id("a1939382871").owner(HappinessCollectiveMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (happinessCollective != null) happinessCollective.unregister();
	}

	public class HappinessCollective extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public HappinessCollective(ProtrixBox box) {
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