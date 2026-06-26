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

public class PhysicalConditionTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public PhysicalConditionTrace physicalConditionTrace;

	public PhysicalConditionTraceMold(ProtrixBox box) {
		super(box);
		id("a_1380611286");
	}

	@Override
	public void init() {
		super.init();
		if (physicalConditionTrace == null) physicalConditionTrace = register(new PhysicalConditionTrace(box()).<PhysicalConditionTrace>id("a642964054").owner(PhysicalConditionTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (physicalConditionTrace != null) physicalConditionTrace.unregister();
	}

	public class PhysicalConditionTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public PhysicalConditionTrace(ProtrixBox box) {
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