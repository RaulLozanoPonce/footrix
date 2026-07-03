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

public class TopAssistersPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopAssistersPosition topAssistersPosition;

	public TopAssistersPositionMold(ProtrixBox box) {
		super(box);
		id("a_1314024316");
	}

	@Override
	public void init() {
		super.init();
		if (topAssistersPosition == null) topAssistersPosition = register(new TopAssistersPosition(box()).<TopAssistersPosition>id("a1287374508").owner(TopAssistersPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topAssistersPosition != null) topAssistersPosition.unregister();
	}

	public class TopAssistersPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopAssistersPosition(ProtrixBox box) {
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