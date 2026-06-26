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

public class MatchTraceMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public MatchTrace matchTrace;

	public MatchTraceMinuteMold(ProtrixBox box) {
		super(box);
		id("a_1326924199");
	}

	@Override
	public void init() {
		super.init();
		if (matchTrace == null) matchTrace = register(new MatchTrace(box()).<MatchTrace>id("a1661390886").owner(MatchTraceMinuteMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchTrace != null) matchTrace.unregister();
	}

	public class MatchTrace extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchTrace(ProtrixBox box) {
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