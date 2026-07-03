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

public class MatchEventsLocalPlayerMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.entities.match.MatchEvent, ProtrixBox> {
	public _47_6_0697523672 _47_6_0697523672;
	public MatchEventsLocalPlayerMold._47_6_0697523672. _48_7_11326757210 _48_7_11326757210;
	public MatchEventsLocalPlayerMold._47_6_0697523672._48_7_11326757210. MatchEventsLocalFirstPlayer matchEventsLocalFirstPlayer;
	public MatchEventsLocalPlayerMold._47_6_0697523672._48_7_11326757210. MatchEventsLocalSecondPlayer matchEventsLocalSecondPlayer;
	public MatchEventsLocalPlayerMold._47_6_0697523672. _51_7_1745987991 _51_7_1745987991;
	public MatchEventsLocalPlayerMold._47_6_0697523672._51_7_1745987991. MatchEventsLocalEventIcon matchEventsLocalEventIcon;

	public MatchEventsLocalPlayerMold(ProtrixBox box) {
		super(box);
		id("a1501116695");
	}

	@Override
	public void init() {
		super.init();
		if (_47_6_0697523672 == null) _47_6_0697523672 = register(new _47_6_0697523672(box()).<_47_6_0697523672>id("a_1970519795").owner(MatchEventsLocalPlayerMold.this));
		if (_47_6_0697523672 != null) _48_7_11326757210 = _47_6_0697523672._48_7_11326757210;
		if (_48_7_11326757210 != null) matchEventsLocalFirstPlayer = _47_6_0697523672._48_7_11326757210.matchEventsLocalFirstPlayer;
		if (_48_7_11326757210 != null) matchEventsLocalSecondPlayer = _47_6_0697523672._48_7_11326757210.matchEventsLocalSecondPlayer;
		if (_47_6_0697523672 != null) _51_7_1745987991 = _47_6_0697523672._51_7_1745987991;
		if (_51_7_1745987991 != null) matchEventsLocalEventIcon = _47_6_0697523672._51_7_1745987991.matchEventsLocalEventIcon;
	}

	@Override
	public void remove() {
		super.remove();
		if (_47_6_0697523672 != null) _47_6_0697523672.unregister();
	}

	public class _47_6_0697523672 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public MatchEventsLocalPlayerMold._47_6_0697523672. _48_7_11326757210 _48_7_11326757210;
		public MatchEventsLocalPlayerMold._47_6_0697523672. _51_7_1745987991 _51_7_1745987991;

		public _47_6_0697523672(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_48_7_11326757210 == null) _48_7_11326757210 = register(new _48_7_11326757210(box()).<_48_7_11326757210>id("a1205622944").owner(MatchEventsLocalPlayerMold.this));
			if (_51_7_1745987991 == null) _51_7_1745987991 = register(new _51_7_1745987991(box()).<_51_7_1745987991>id("a1780861847").owner(MatchEventsLocalPlayerMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_48_7_11326757210 != null) _48_7_11326757210.unregister();
			if (_51_7_1745987991 != null) _51_7_1745987991.unregister();
		}

		public class _48_7_11326757210 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public MatchEventsLocalPlayerMold._47_6_0697523672._48_7_11326757210. MatchEventsLocalFirstPlayer matchEventsLocalFirstPlayer;
			public MatchEventsLocalPlayerMold._47_6_0697523672._48_7_11326757210. MatchEventsLocalSecondPlayer matchEventsLocalSecondPlayer;

			public _48_7_11326757210(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (matchEventsLocalFirstPlayer == null) matchEventsLocalFirstPlayer = register(new MatchEventsLocalFirstPlayer(box()).<MatchEventsLocalFirstPlayer>id("a754471803").owner(MatchEventsLocalPlayerMold.this));
				if (matchEventsLocalSecondPlayer == null) matchEventsLocalSecondPlayer = register(new MatchEventsLocalSecondPlayer(box()).<MatchEventsLocalSecondPlayer>id("a1688444907").owner(MatchEventsLocalPlayerMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (matchEventsLocalFirstPlayer != null) matchEventsLocalFirstPlayer.unregister();
				if (matchEventsLocalSecondPlayer != null) matchEventsLocalSecondPlayer.unregister();
			}

			public class MatchEventsLocalFirstPlayer extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

				public MatchEventsLocalFirstPlayer(ProtrixBox box) {
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

			public class MatchEventsLocalSecondPlayer extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

				public MatchEventsLocalSecondPlayer(ProtrixBox box) {
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

		public class _51_7_1745987991 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public MatchEventsLocalPlayerMold._47_6_0697523672._51_7_1745987991. MatchEventsLocalEventIcon matchEventsLocalEventIcon;

			public _51_7_1745987991(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (matchEventsLocalEventIcon == null) matchEventsLocalEventIcon = register(new MatchEventsLocalEventIcon(box()).<MatchEventsLocalEventIcon>id("a_1111270763").owner(MatchEventsLocalPlayerMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (matchEventsLocalEventIcon != null) matchEventsLocalEventIcon.unregister();
			}

			public class MatchEventsLocalEventIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

				public MatchEventsLocalEventIcon(ProtrixBox box) {
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
	}
}