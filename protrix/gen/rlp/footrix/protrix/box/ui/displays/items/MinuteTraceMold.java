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

public class MinuteTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public MinuteTrace minuteTrace;

	public MinuteTraceMold(ProtrixBox box) {
		super(box);
		id("a_451519348");
	}

	@Override
	public void init() {
		super.init();
		if (minuteTrace == null) minuteTrace = register(new MinuteTrace(box()).<MinuteTrace>id("a_984461218").owner(MinuteTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (minuteTrace != null) minuteTrace.unregister();
	}

	public class MinuteTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public MinuteTrace(ProtrixBox box) {
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