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

public class SelfConfidenceTraceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public SelfConfidenceTrace selfConfidenceTrace;

	public SelfConfidenceTraceMold(ProtrixBox box) {
		super(box);
		id("a_1797186435");
	}

	@Override
	public void init() {
		super.init();
		if (selfConfidenceTrace == null) selfConfidenceTrace = register(new SelfConfidenceTrace(box()).<SelfConfidenceTrace>id("a_788817619").owner(SelfConfidenceTraceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (selfConfidenceTrace != null) selfConfidenceTrace.unregister();
	}

	public class SelfConfidenceTrace extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public SelfConfidenceTrace(ProtrixBox box) {
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