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

public class CompetitionsTableMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.framework.types.entities.Competition, ProtrixBox> {
	public _19_4_01883789413 _19_4_01883789413;
	public CompetitionsTableMold._19_4_01883789413. _20_5_11096110070 _20_5_11096110070;
	public CompetitionsTableMold._19_4_01883789413._20_5_11096110070. _21_6_0805800026 _21_6_0805800026;
	public CompetitionsTableMold._19_4_01883789413._20_5_11096110070._21_6_0805800026. _22_7_01437157531 _22_7_01437157531;
	public CompetitionsTableMold._19_4_01883789413._20_5_11096110070. _23_6_1163073903 _23_6_1163073903;
	public CompetitionsTableMold._19_4_01883789413._20_5_11096110070._23_6_1163073903. CompetitionName competitionName;

	public CompetitionsTableMold(ProtrixBox box) {
		super(box);
		id("a1614006361");
	}

	@Override
	public void init() {
		super.init();
		if (_19_4_01883789413 == null) _19_4_01883789413 = register(new _19_4_01883789413(box()).<_19_4_01883789413>id("a1693066631").owner(CompetitionsTableMold.this));
		if (_19_4_01883789413 != null) _20_5_11096110070 = _19_4_01883789413._20_5_11096110070;
		if (_20_5_11096110070 != null) _21_6_0805800026 = _19_4_01883789413._20_5_11096110070._21_6_0805800026;
		if (_21_6_0805800026 != null) _22_7_01437157531 = _19_4_01883789413._20_5_11096110070._21_6_0805800026._22_7_01437157531;
		if (_20_5_11096110070 != null) _23_6_1163073903 = _19_4_01883789413._20_5_11096110070._23_6_1163073903;
		if (_23_6_1163073903 != null) competitionName = _19_4_01883789413._20_5_11096110070._23_6_1163073903.competitionName;
	}

	@Override
	public void remove() {
		super.remove();
		if (_19_4_01883789413 != null) _19_4_01883789413.unregister();
	}

	public class _19_4_01883789413 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public CompetitionsTableMold._19_4_01883789413. _20_5_11096110070 _20_5_11096110070;

		public _19_4_01883789413(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_20_5_11096110070 == null) _20_5_11096110070 = register(new _20_5_11096110070(box()).<_20_5_11096110070>id("a_610489981").owner(CompetitionsTableMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_20_5_11096110070 != null) _20_5_11096110070.unregister();
		}

		public class _20_5_11096110070 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public CompetitionsTableMold._19_4_01883789413._20_5_11096110070. _21_6_0805800026 _21_6_0805800026;
			public CompetitionsTableMold._19_4_01883789413._20_5_11096110070. _23_6_1163073903 _23_6_1163073903;

			public _20_5_11096110070(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_21_6_0805800026 == null) _21_6_0805800026 = register(new _21_6_0805800026(box()).<_21_6_0805800026>id("a_844042733").owner(CompetitionsTableMold.this));
				if (_23_6_1163073903 == null) _23_6_1163073903 = register(new _23_6_1163073903(box()).<_23_6_1163073903>id("a1880022613").owner(CompetitionsTableMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_21_6_0805800026 != null) _21_6_0805800026.unregister();
				if (_23_6_1163073903 != null) _23_6_1163073903.unregister();
			}

			public class _21_6_0805800026 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public CompetitionsTableMold._19_4_01883789413._20_5_11096110070._21_6_0805800026. _22_7_01437157531 _22_7_01437157531;

				public _21_6_0805800026(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_22_7_01437157531 == null) _22_7_01437157531 = register(new _22_7_01437157531(box()).<_22_7_01437157531>id("a_1418448047").owner(CompetitionsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_22_7_01437157531 != null) _22_7_01437157531.unregister();
				}

				public class _22_7_01437157531 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

					public _22_7_01437157531(ProtrixBox box) {
						super(box);
						_icon(CompetitionsTableMold.class.getResource("/icons/flags/0.png"));
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

			public class _23_6_1163073903 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public CompetitionsTableMold._19_4_01883789413._20_5_11096110070._23_6_1163073903. CompetitionName competitionName;

				public _23_6_1163073903(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (competitionName == null) competitionName = register(new CompetitionName(box()).<CompetitionName>id("a_1351185138").owner(CompetitionsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (competitionName != null) competitionName.unregister();
				}

				public class CompetitionName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

					public CompetitionName(ProtrixBox box) {
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