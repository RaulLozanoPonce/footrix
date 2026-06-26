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

public class PositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public Position position;

	public PositionMold(ProtrixBox box) {
		super(box);
		id("a_1861738126");
	}

	@Override
	public void init() {
		super.init();
		if (position == null) position = register(new Position(box()).<Position>id("a_1975965354").owner(PositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (position != null) position.unregister();
	}

	public class Position extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public Position(ProtrixBox box) {
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