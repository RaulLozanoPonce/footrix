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

public class TopGoalkeepersPlayerMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopGoalkeepersPlayer topGoalkeepersPlayer;

	public TopGoalkeepersPlayerMold(ProtrixBox box) {
		super(box);
		id("a636064654");
	}

	@Override
	public void init() {
		super.init();
		if (topGoalkeepersPlayer == null) topGoalkeepersPlayer = register(new TopGoalkeepersPlayer(box()).<TopGoalkeepersPlayer>id("a_76194549").owner(TopGoalkeepersPlayerMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topGoalkeepersPlayer != null) topGoalkeepersPlayer.unregister();
	}

	public class TopGoalkeepersPlayer extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

		public TopGoalkeepersPlayer(ProtrixBox box) {
			super(box);
			_title("Cargando...");
			_color("white");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
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