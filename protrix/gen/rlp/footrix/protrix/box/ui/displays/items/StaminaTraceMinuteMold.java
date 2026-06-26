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

public class StaminaTraceMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public StaminaTrace staminaTrace;

	public StaminaTraceMinuteMold(ProtrixBox box) {
		super(box);
		id("a844122961");
	}

	@Override
	public void init() {
		super.init();
		if (staminaTrace == null) staminaTrace = register(new StaminaTrace(box()).<StaminaTrace>id("a_1583929788").owner(StaminaTraceMinuteMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (staminaTrace != null) staminaTrace.unregister();
	}

	public class StaminaTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public StaminaTrace(ProtrixBox box) {
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