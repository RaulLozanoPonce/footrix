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

public class TopAssistersAssistsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopAssistersAssists topAssistersAssists;

	public TopAssistersAssistsMold(ProtrixBox box) {
		super(box);
		id("a395601918");
	}

	@Override
	public void init() {
		super.init();
		if (topAssistersAssists == null) topAssistersAssists = register(new TopAssistersAssists(box()).<TopAssistersAssists>id("a1630385089").owner(TopAssistersAssistsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topAssistersAssists != null) topAssistersAssists.unregister();
	}

	public class TopAssistersAssists extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public TopAssistersAssists(ProtrixBox box) {
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