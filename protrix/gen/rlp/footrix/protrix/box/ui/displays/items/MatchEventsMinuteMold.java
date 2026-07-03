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

public class MatchEventsMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.entities.match.MatchEvent, ProtrixBox> {
	public _55_6_01365237416 _55_6_01365237416;
	public MatchEventsMinuteMold._55_6_01365237416. MatchEventsMinute matchEventsMinute;

	public MatchEventsMinuteMold(ProtrixBox box) {
		super(box);
		id("a_1340574950");
	}

	@Override
	public void init() {
		super.init();
		if (_55_6_01365237416 == null) _55_6_01365237416 = register(new _55_6_01365237416(box()).<_55_6_01365237416>id("a_571460122").owner(MatchEventsMinuteMold.this));
		if (_55_6_01365237416 != null) matchEventsMinute = _55_6_01365237416.matchEventsMinute;
	}

	@Override
	public void remove() {
		super.remove();
		if (_55_6_01365237416 != null) _55_6_01365237416.unregister();
	}

	public class _55_6_01365237416 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public MatchEventsMinuteMold._55_6_01365237416. MatchEventsMinute matchEventsMinute;

		public _55_6_01365237416(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (matchEventsMinute == null) matchEventsMinute = register(new MatchEventsMinute(box()).<MatchEventsMinute>id("a_1295277340").owner(MatchEventsMinuteMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchEventsMinute != null) matchEventsMinute.unregister();
		}

		public class MatchEventsMinute extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

			public MatchEventsMinute(ProtrixBox box) {
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
}