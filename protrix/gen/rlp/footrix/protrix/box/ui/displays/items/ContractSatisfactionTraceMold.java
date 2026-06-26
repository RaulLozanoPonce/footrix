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

public class ContractSatisfactionTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public ContractSatisfactionTrace contractSatisfactionTrace;

	public ContractSatisfactionTraceMold(ProtrixBox box) {
		super(box);
		id("a_487771464");
	}

	@Override
	public void init() {
		super.init();
		if (contractSatisfactionTrace == null) contractSatisfactionTrace = register(new ContractSatisfactionTrace(box()).<ContractSatisfactionTrace>id("a1589064288").owner(ContractSatisfactionTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (contractSatisfactionTrace != null) contractSatisfactionTrace.unregister();
	}

	public class ContractSatisfactionTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public ContractSatisfactionTrace(ProtrixBox box) {
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