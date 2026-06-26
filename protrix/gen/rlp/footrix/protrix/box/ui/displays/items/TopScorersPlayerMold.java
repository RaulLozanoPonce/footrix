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

public class TopScorersPlayerMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopScorersPlayer topScorersPlayer;

	public TopScorersPlayerMold(ProtrixBox box) {
		super(box);
		id("a_277696139");
	}

	@Override
	public void init() {
		super.init();
		if (topScorersPlayer == null) topScorersPlayer = register(new TopScorersPlayer(box()).<TopScorersPlayer>id("a_58665143").owner(TopScorersPlayerMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topScorersPlayer != null) topScorersPlayer.unregister();
	}

	public class TopScorersPlayer extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

		public TopScorersPlayer(ProtrixBox box) {
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