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

public class EnergyTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public EnergyTrace energyTrace;

	public EnergyTraceMold(ProtrixBox box) {
		super(box);
		id("a_1479544155");
	}

	@Override
	public void init() {
		super.init();
		if (energyTrace == null) energyTrace = register(new EnergyTrace(box()).<EnergyTrace>id("a1842652419").owner(EnergyTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (energyTrace != null) energyTrace.unregister();
	}

	public class EnergyTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public EnergyTrace(ProtrixBox box) {
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