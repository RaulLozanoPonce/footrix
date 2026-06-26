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
	public _16_4_1595815687 _16_4_1595815687;
	public TeamsTableMold._16_4_1595815687. _17_5_11021908368 _17_5_11021908368;
	public TeamsTableMold._16_4_1595815687._17_5_11021908368. _18_6_0805800026 _18_6_0805800026;
	public TeamsTableMold._16_4_1595815687._17_5_11021908368._18_6_0805800026. _19_7_01437157531 _19_7_01437157531;
	public TeamsTableMold._16_4_1595815687._17_5_11021908368. _20_6_1345780411 _20_6_1345780411;
	public TeamsTableMold._16_4_1595815687._17_5_11021908368._20_6_1345780411. TeamName teamName;

	public TeamsTableMold(ProtrixBox box) {
		super(box);
		id("a_1338223420");
	}

	@Override
	public void init() {
		super.init();
		if (_16_4_1595815687 == null) _16_4_1595815687 = register(new _16_4_1595815687(box()).<_16_4_1595815687>id("a1745807546").owner(TeamsTableMold.this));
		if (_16_4_1595815687 != null) _17_5_11021908368 = _16_4_1595815687._17_5_11021908368;
		if (_17_5_11021908368 != null) _18_6_0805800026 = _16_4_1595815687._17_5_11021908368._18_6_0805800026;
		if (_18_6_0805800026 != null) _19_7_01437157531 = _16_4_1595815687._17_5_11021908368._18_6_0805800026._19_7_01437157531;
		if (_17_5_11021908368 != null) _20_6_1345780411 = _16_4_1595815687._17_5_11021908368._20_6_1345780411;
		if (_20_6_1345780411 != null) teamName = _16_4_1595815687._17_5_11021908368._20_6_1345780411.teamName;
	}

	@Override
	public void remove() {
		super.remove();
		if (_16_4_1595815687 != null) _16_4_1595815687.unregister();
	}

	public class _16_4_1595815687 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public TeamsTableMold._16_4_1595815687. _17_5_11021908368 _17_5_11021908368;

		public _16_4_1595815687(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_17_5_11021908368 == null) _17_5_11021908368 = register(new _17_5_11021908368(box()).<_17_5_11021908368>id("a855487889").owner(TeamsTableMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_17_5_11021908368 != null) _17_5_11021908368.unregister();
		}

		public class _17_5_11021908368 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public TeamsTableMold._16_4_1595815687._17_5_11021908368. _18_6_0805800026 _18_6_0805800026;
			public TeamsTableMold._16_4_1595815687._17_5_11021908368. _20_6_1345780411 _20_6_1345780411;

			public _17_5_11021908368(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_18_6_0805800026 == null) _18_6_0805800026 = register(new _18_6_0805800026(box()).<_18_6_0805800026>id("a_1380440233").owner(TeamsTableMold.this));
				if (_20_6_1345780411 == null) _20_6_1345780411 = register(new _20_6_1345780411(box()).<_20_6_1345780411>id("a_1512492929").owner(TeamsTableMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_18_6_0805800026 != null) _18_6_0805800026.unregister();
				if (_20_6_1345780411 != null) _20_6_1345780411.unregister();
			}

			public class _18_6_0805800026 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public TeamsTableMold._16_4_1595815687._17_5_11021908368._18_6_0805800026. _19_7_01437157531 _19_7_01437157531;

				public _18_6_0805800026(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_19_7_01437157531 == null) _19_7_01437157531 = register(new _19_7_01437157531(box()).<_19_7_01437157531>id("a_866901363").owner(TeamsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_19_7_01437157531 != null) _19_7_01437157531.unregister();
				}

				public class _19_7_01437157531 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

					public _19_7_01437157531(ProtrixBox box) {
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
				public TeamsTableMold._16_4_1595815687._17_5_11021908368._20_6_1345780411. TeamName teamName;

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