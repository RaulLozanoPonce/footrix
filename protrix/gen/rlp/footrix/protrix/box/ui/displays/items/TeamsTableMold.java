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

public class TeamsTableMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Team, ProtrixBox> {
	public _16_4_123033413 _16_4_123033413;
	public TeamsTableMold._16_4_123033413. _17_5_0732886962 _17_5_0732886962;
	public TeamsTableMold._16_4_123033413._17_5_0732886962. _18_6_0199745308 _18_6_0199745308;
	public TeamsTableMold._16_4_123033413._17_5_0732886962._18_6_0199745308. _19_7_0855106525 _19_7_0855106525;
	public TeamsTableMold._16_4_123033413._17_5_0732886962. _20_6_1345780411 _20_6_1345780411;
	public TeamsTableMold._16_4_123033413._17_5_0732886962._20_6_1345780411. TeamName teamName;

	public TeamsTableMold(ProtrixBox box) {
		super(box);
		id("a_1338223420");
	}

	@Override
	public void init() {
		super.init();
		if (_16_4_123033413 == null) _16_4_123033413 = register(new _16_4_123033413(box()).<_16_4_123033413>id("a438944951").owner(TeamsTableMold.this));
		if (_16_4_123033413 != null) _17_5_0732886962 = _16_4_123033413._17_5_0732886962;
		if (_17_5_0732886962 != null) _18_6_0199745308 = _16_4_123033413._17_5_0732886962._18_6_0199745308;
		if (_18_6_0199745308 != null) _19_7_0855106525 = _16_4_123033413._17_5_0732886962._18_6_0199745308._19_7_0855106525;
		if (_17_5_0732886962 != null) _20_6_1345780411 = _16_4_123033413._17_5_0732886962._20_6_1345780411;
		if (_20_6_1345780411 != null) teamName = _16_4_123033413._17_5_0732886962._20_6_1345780411.teamName;
	}

	@Override
	public void remove() {
		super.remove();
		if (_16_4_123033413 != null) _16_4_123033413.unregister();
	}

	public class _16_4_123033413 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public TeamsTableMold._16_4_123033413. _17_5_0732886962 _17_5_0732886962;

		public _16_4_123033413(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_17_5_0732886962 == null) _17_5_0732886962 = register(new _17_5_0732886962(box()).<_17_5_0732886962>id("a487915063").owner(TeamsTableMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_17_5_0732886962 != null) _17_5_0732886962.unregister();
		}

		public class _17_5_0732886962 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public TeamsTableMold._16_4_123033413._17_5_0732886962. _18_6_0199745308 _18_6_0199745308;
			public TeamsTableMold._16_4_123033413._17_5_0732886962. _20_6_1345780411 _20_6_1345780411;

			public _17_5_0732886962(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_18_6_0199745308 == null) _18_6_0199745308 = register(new _18_6_0199745308(box()).<_18_6_0199745308>id("a417494386").owner(TeamsTableMold.this));
				if (_20_6_1345780411 == null) _20_6_1345780411 = register(new _20_6_1345780411(box()).<_20_6_1345780411>id("a_1512492929").owner(TeamsTableMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_18_6_0199745308 != null) _18_6_0199745308.unregister();
				if (_20_6_1345780411 != null) _20_6_1345780411.unregister();
			}

			public class _18_6_0199745308 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public TeamsTableMold._16_4_123033413._17_5_0732886962._18_6_0199745308. _19_7_0855106525 _19_7_0855106525;

				public _18_6_0199745308(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_19_7_0855106525 == null) _19_7_0855106525 = register(new _19_7_0855106525(box()).<_19_7_0855106525>id("a1056051155").owner(TeamsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_19_7_0855106525 != null) _19_7_0855106525.unregister();
				}

				public class _19_7_0855106525 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

					public _19_7_0855106525(ProtrixBox box) {
						super(box);
						_icon(TeamsTableMold.class.getResource("/icons/flags/0.png"));
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

			public class _20_6_1345780411 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public TeamsTableMold._16_4_123033413._17_5_0732886962._20_6_1345780411. TeamName teamName;

				public _20_6_1345780411(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (teamName == null) teamName = register(new TeamName(box()).<TeamName>id("a_812518437").owner(TeamsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (teamName != null) teamName.unregister();
				}

				public class TeamName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

					public TeamName(ProtrixBox box) {
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
}