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

public class HappinessIndividualMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public HappinessIndividual happinessIndividual;

	public HappinessIndividualMold(ProtrixBox box) {
		super(box);
		id("a1587012361");
	}

	@Override
	public void init() {
		super.init();
		if (happinessIndividual == null) happinessIndividual = register(new HappinessIndividual(box()).<HappinessIndividual>id("a91096298").owner(HappinessIndividualMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (happinessIndividual != null) happinessIndividual.unregister();
	}

	public class HappinessIndividual extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public HappinessIndividual(ProtrixBox box) {
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