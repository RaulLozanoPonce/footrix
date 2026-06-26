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

public class DateTraceMinuteMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public DateTrace dateTrace;

	public DateTraceMinuteMold(ProtrixBox box) {
		super(box);
		id("a713245149");
	}

	@Override
	public void init() {
		super.init();
		if (dateTrace == null) dateTrace = register(new DateTrace(box()).<DateTrace>id("a1432615509").owner(DateTraceMinuteMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (dateTrace != null) dateTrace.unregister();
	}

	public class DateTrace extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, ProtrixBox>  {

		public DateTrace(ProtrixBox box) {
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