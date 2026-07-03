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

public class TopAssistersPlayerMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.PlayerRecord, ProtrixBox> {
	public TopAssistersPlayer topAssistersPlayer;

	public TopAssistersPlayerMold(ProtrixBox box) {
		super(box);
		id("a1096796121");
	}

	@Override
	public void init() {
		super.init();
		if (topAssistersPlayer == null) topAssistersPlayer = register(new TopAssistersPlayer(box()).<TopAssistersPlayer>id("a457861039").owner(TopAssistersPlayerMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (topAssistersPlayer != null) topAssistersPlayer.unregister();
	}

	public class TopAssistersPlayer extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

		public TopAssistersPlayer(ProtrixBox box) {
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