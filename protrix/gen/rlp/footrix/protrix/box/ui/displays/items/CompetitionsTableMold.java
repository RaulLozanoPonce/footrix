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
	public _19_4_1133743261 _19_4_1133743261;
	public CompetitionsTableMold._19_4_1133743261. _20_5_0906776712 _20_5_0906776712;
	public CompetitionsTableMold._19_4_1133743261._20_5_0906776712. _21_6_0199745308 _21_6_0199745308;
	public CompetitionsTableMold._19_4_1133743261._20_5_0906776712._21_6_0199745308. _22_7_0855106525 _22_7_0855106525;
	public CompetitionsTableMold._19_4_1133743261._20_5_0906776712. _23_6_1163073903 _23_6_1163073903;
	public CompetitionsTableMold._19_4_1133743261._20_5_0906776712._23_6_1163073903. CompetitionName competitionName;

	public CompetitionsTableMold(ProtrixBox box) {
		super(box);
		id("a1614006361");
	}

	@Override
	public void init() {
		super.init();
		if (_19_4_1133743261 == null) _19_4_1133743261 = register(new _19_4_1133743261(box()).<_19_4_1133743261>id("a811402432").owner(CompetitionsTableMold.this));
		if (_19_4_1133743261 != null) _20_5_0906776712 = _19_4_1133743261._20_5_0906776712;
		if (_20_5_0906776712 != null) _21_6_0199745308 = _19_4_1133743261._20_5_0906776712._21_6_0199745308;
		if (_21_6_0199745308 != null) _22_7_0855106525 = _19_4_1133743261._20_5_0906776712._21_6_0199745308._22_7_0855106525;
		if (_20_5_0906776712 != null) _23_6_1163073903 = _19_4_1133743261._20_5_0906776712._23_6_1163073903;
		if (_23_6_1163073903 != null) competitionName = _19_4_1133743261._20_5_0906776712._23_6_1163073903.competitionName;
	}

	@Override
	public void remove() {
		super.remove();
		if (_19_4_1133743261 != null) _19_4_1133743261.unregister();
	}

	public class _19_4_1133743261 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public CompetitionsTableMold._19_4_1133743261. _20_5_0906776712 _20_5_0906776712;

		public _19_4_1133743261(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_20_5_0906776712 == null) _20_5_0906776712 = register(new _20_5_0906776712(box()).<_20_5_0906776712>id("a_8225964").owner(CompetitionsTableMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_20_5_0906776712 != null) _20_5_0906776712.unregister();
		}

		public class _20_5_0906776712 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public CompetitionsTableMold._19_4_1133743261._20_5_0906776712. _21_6_0199745308 _21_6_0199745308;
			public CompetitionsTableMold._19_4_1133743261._20_5_0906776712. _23_6_1163073903 _23_6_1163073903;

			public _20_5_0906776712(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_21_6_0199745308 == null) _21_6_0199745308 = register(new _21_6_0199745308(box()).<_21_6_0199745308>id("a953891886").owner(CompetitionsTableMold.this));
				if (_23_6_1163073903 == null) _23_6_1163073903 = register(new _23_6_1163073903(box()).<_23_6_1163073903>id("a1880022613").owner(CompetitionsTableMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_21_6_0199745308 != null) _21_6_0199745308.unregister();
				if (_23_6_1163073903 != null) _23_6_1163073903.unregister();
			}

			public class _21_6_0199745308 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public CompetitionsTableMold._19_4_1133743261._20_5_0906776712._21_6_0199745308. _22_7_0855106525 _22_7_0855106525;

				public _21_6_0199745308(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_22_7_0855106525 == null) _22_7_0855106525 = register(new _22_7_0855106525(box()).<_22_7_0855106525>id("a1592448655").owner(CompetitionsTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_22_7_0855106525 != null) _22_7_0855106525.unregister();
				}

				public class _22_7_0855106525 extends io.intino.alexandria.ui.displays.components.Icon<io.intino.alexandria.ui.displays.notifiers.IconNotifier, ProtrixBox>  {

					public _22_7_0855106525(ProtrixBox box) {
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
				public CompetitionsTableMold._19_4_1133743261._20_5_0906776712._23_6_1163073903. CompetitionName competitionName;

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