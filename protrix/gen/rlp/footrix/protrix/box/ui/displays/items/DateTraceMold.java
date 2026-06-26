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

public class DateTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public DateTrace dateTrace;

	public DateTraceMold(ProtrixBox box) {
		super(box);
		id("a_869127257");
	}

	@Override
	public void init() {
		super.init();
		if (dateTrace == null) dateTrace = register(new DateTrace(box()).<DateTrace>id("a_658985057").owner(DateTraceMold.this));
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