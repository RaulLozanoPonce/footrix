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

public class MinuteTraceMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public MinuteTrace minuteTrace;

	public MinuteTraceMinuteMold(ProtrixBox box) {
		super(box);
		id("a_510682182");
	}

	@Override
	public void init() {
		super.init();
		if (minuteTrace == null) minuteTrace = register(new MinuteTrace(box()).<MinuteTrace>id("a_294634868").owner(MinuteTraceMinuteMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (minuteTrace != null) minuteTrace.unregister();
	}

	public class MinuteTrace extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MinuteTrace(ProtrixBox box) {
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