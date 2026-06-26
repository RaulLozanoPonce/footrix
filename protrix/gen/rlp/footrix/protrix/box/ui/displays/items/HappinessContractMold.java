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

public class HappinessContractMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public HappinessContract happinessContract;

	public HappinessContractMold(ProtrixBox box) {
		super(box);
		id("a770794343");
	}

	@Override
	public void init() {
		super.init();
		if (happinessContract == null) happinessContract = register(new HappinessContract(box()).<HappinessContract>id("a26556545").owner(HappinessContractMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (happinessContract != null) happinessContract.unregister();
	}

	public class HappinessContract extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public HappinessContract(ProtrixBox box) {
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