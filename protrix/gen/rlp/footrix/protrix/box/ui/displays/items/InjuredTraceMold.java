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

public class InjuredTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public InjuredTrace injuredTrace;

	public InjuredTraceMold(ProtrixBox box) {
		super(box);
		id("a_698092402");
	}

	@Override
	public void init() {
		super.init();
		if (injuredTrace == null) injuredTrace = register(new InjuredTrace(box()).<InjuredTrace>id("a_290194315").owner(InjuredTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (injuredTrace != null) injuredTrace.unregister();
	}

	public class InjuredTrace extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public InjuredTrace(ProtrixBox box) {
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