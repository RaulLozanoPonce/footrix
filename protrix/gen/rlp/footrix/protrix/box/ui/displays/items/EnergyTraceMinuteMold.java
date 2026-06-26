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

public class EnergyTraceMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public EnergyTrace energyTrace;

	public EnergyTraceMinuteMold(ProtrixBox box) {
		super(box);
		id("a_233097247");
	}

	@Override
	public void init() {
		super.init();
		if (energyTrace == null) energyTrace = register(new EnergyTrace(box()).<EnergyTrace>id("a_686428097").owner(EnergyTraceMinuteMold.this));
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