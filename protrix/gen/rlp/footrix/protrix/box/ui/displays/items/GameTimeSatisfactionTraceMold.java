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

public class GameTimeSatisfactionTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public GameTimeSatisfactionTrace gameTimeSatisfactionTrace;

	public GameTimeSatisfactionTraceMold(ProtrixBox box) {
		super(box);
		id("a979930147");
	}

	@Override
	public void init() {
		super.init();
		if (gameTimeSatisfactionTrace == null) gameTimeSatisfactionTrace = register(new GameTimeSatisfactionTrace(box()).<GameTimeSatisfactionTrace>id("a_1979144482").owner(GameTimeSatisfactionTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (gameTimeSatisfactionTrace != null) gameTimeSatisfactionTrace.unregister();
	}

	public class GameTimeSatisfactionTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public GameTimeSatisfactionTrace(ProtrixBox box) {
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