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

public class MinutesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public Minutes minutes;

	public MinutesMold(ProtrixBox box) {
		super(box);
		id("a_1928650418");
	}

	@Override
	public void init() {
		super.init();
		if (minutes == null) minutes = register(new Minutes(box()).<Minutes>id("a490518254").owner(MinutesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (minutes != null) minutes.unregister();
	}

	public class Minutes extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public Minutes(ProtrixBox box) {
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