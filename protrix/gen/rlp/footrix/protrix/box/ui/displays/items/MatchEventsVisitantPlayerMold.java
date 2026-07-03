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

public class MatchEventsVisitantPlayerMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.entities.match.MatchEvent, ProtrixBox> {
	public _59_6_1639586916 _59_6_1639586916;
	public MatchEventsVisitantPlayerMold._59_6_1639586916. _60_7_0914718224 _60_7_0914718224;
	public MatchEventsVisitantPlayerMold._59_6_1639586916._60_7_0914718224. MatchEventsVisitantEventIcon matchEventsVisitantEventIcon;
	public MatchEventsVisitantPlayerMold._59_6_1639586916. _62_7_1279430335 _62_7_1279430335;
	public MatchEventsVisitantPlayerMold._59_6_1639586916._62_7_1279430335. MatchEventsVisitantFirstPlayer matchEventsVisitantFirstPlayer;
	public MatchEventsVisitantPlayerMold._59_6_1639586916._62_7_1279430335. MatchEventsVisitantSecondPlayer matchEventsVisitantSecondPlayer;

	public MatchEventsVisitantPlayerMold(ProtrixBox box) {
		super(box);
		id("a491676487");
	}

	@Override
	public void init() {
		super.init();
		if (_59_6_1639586916 == null) _59_6_1639586916 = register(new _59_6_1639586916(box()).<_59_6_1639586916>id("a579242355").owner(MatchEventsVisitantPlayerMold.this));
		if (_59_6_1639586916 != null) _60_7_0914718224 = _59_6_1639586916._60_7_0914718224;
		if (_60_7_0914718224 != null) matchEventsVisitantEventIcon = _59_6_1639586916._60_7_0914718224.matchEventsVisitantEventIcon;
		if (_59_6_1639586916 != null) _62_7_1279430335 = _59_6_1639586916._62_7_1279430335;
		if (_62_7_1279430335 != null) matchEventsVisitantFirstPlayer = _59_6_1639586916._62_7_1279430335.matchEventsVisitantFirstPlayer;
		if (_62_7_1279430335 != null) matchEventsVisitantSecondPlayer = _59_6_1639586916._62_7_1279430335.matchEventsVisitantSecondPlayer;
	}

	@Override
	public void remove() {
		super.remove();
		if (_59_6_1639586916 != null) _59_6_1639586916.unregister();
	}

	public class _59_6_1639586916 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public MatchEventsVisitantPlayerMold._59_6_1639586916. _60_7_0914718224 _60_7_0914718224;
		public MatchEventsVisitantPlayerMold._59_6_1639586916. _62_7_1279430335 _62_7_1279430335;

		public _59_6_1639586916(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_60_7_0914718224 == null) _60_7_0914718224 = register(new _60_7_0914718224(box()).<_60_7_0914718224>id("a_2115388166").owner(MatchEventsVisitantPlayerMold.this));
			if (_62_7_1279430335 == null) _62_7_1279430335 = register(new _62_7_1279430335(box()).<_62_7_1279430335>id("a_1630538787").owner(MatchEventsVisitantPlayerMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_60_7_0914718224 != null) _60_7_0914718224.unregister();
			if (_62_7_1279430335 != null) _62_7_1279430335.unregister();
		}

		public class _60_7_0914718224 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public MatchEventsVisitantPlayerMold._59_6_1639586916._60_7_0914718224. MatchEventsVisitantEventIcon matchEventsVisitantEventIcon;

			public _60_7_0914718224(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (matchEventsVisitantEventIcon == null) matchEventsVisitantEventIcon = register(new MatchEventsVisitantEventIcon(box()).<MatchEventsVisitantEventIcon>id("a1370742348").owner(MatchEventsVisitantPlayerMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (matchEventsVisitantEventIcon != null) matchEventsVisitantEventIcon.unregister();
			}

			public class MatchEventsVisitantEventIcon extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

				public MatchEventsVisitantEventIcon(ProtrixBox box) {
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

		public class _62_7_1279430335 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public MatchEventsVisitantPlayerMold._59_6_1639586916._62_7_1279430335. MatchEventsVisitantFirstPlayer matchEventsVisitantFirstPlayer;
			public MatchEventsVisitantPlayerMold._59_6_1639586916._62_7_1279430335. MatchEventsVisitantSecondPlayer matchEventsVisitantSecondPlayer;

			public _62_7_1279430335(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (matchEventsVisitantFirstPlayer == null) matchEventsVisitantFirstPlayer = register(new MatchEventsVisitantFirstPlayer(box()).<MatchEventsVisitantFirstPlayer>id("a_152497208").owner(MatchEventsVisitantPlayerMold.this));
				if (matchEventsVisitantSecondPlayer == null) matchEventsVisitantSecondPlayer = register(new MatchEventsVisitantSecondPlayer(box()).<MatchEventsVisitantSecondPlayer>id("a_657790658").owner(MatchEventsVisitantPlayerMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (matchEventsVisitantFirstPlayer != null) matchEventsVisitantFirstPlayer.unregister();
				if (matchEventsVisitantSecondPlayer != null) matchEventsVisitantSecondPlayer.unregister();
			}

			public class MatchEventsVisitantFirstPlayer extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

				public MatchEventsVisitantFirstPlayer(ProtrixBox box) {
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

			public class MatchEventsVisitantSecondPlayer extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

				public MatchEventsVisitantSecondPlayer(ProtrixBox box) {
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