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

public class CollectivePerformanceTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public CollectivePerformanceTrace collectivePerformanceTrace;

	public CollectivePerformanceTraceMold(ProtrixBox box) {
		super(box);
		id("a_1544895605");
	}

	@Override
	public void init() {
		super.init();
		if (collectivePerformanceTrace == null) collectivePerformanceTrace = register(new CollectivePerformanceTrace(box()).<CollectivePerformanceTrace>id("a_81429577").owner(CollectivePerformanceTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (collectivePerformanceTrace != null) collectivePerformanceTrace.unregister();
	}

	public class CollectivePerformanceTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public CollectivePerformanceTrace(ProtrixBox box) {
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