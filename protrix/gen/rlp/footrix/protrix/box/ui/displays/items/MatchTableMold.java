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

public class MatchTableMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Match, ProtrixBox> {
	public _14_4_1505764404 _14_4_1505764404;
	public MatchTableMold._14_4_1505764404. _15_5_1549340999 _15_5_1549340999;
	public MatchTableMold._14_4_1505764404._15_5_1549340999. _16_6_0308402801 _16_6_0308402801;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _17_7_0896608022 _17_7_0896608022;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._17_7_0896608022. Day day;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _18_7_11567399895 _18_7_11567399895;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._18_7_11567399895. MatchDay matchDay;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _19_7_11303616147 _19_7_11303616147;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._19_7_11303616147. CompetitionLink competitionLink;
	public MatchTableMold._14_4_1505764404._15_5_1549340999. _20_6_01319919341 _20_6_01319919341;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _21_7_11016386267 _21_7_11016386267;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._21_7_11016386267. LocalLink localLink;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _22_7_11132785025 _22_7_11132785025;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._22_7_11132785025. Match match;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _23_7_01940714705 _23_7_01940714705;
	public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._23_7_01940714705. VisitantLink visitantLink;

	public MatchTableMold(ProtrixBox box) {
		super(box);
		id("a60322431");
	}

	@Override
	public void init() {
		super.init();
		if (_14_4_1505764404 == null) _14_4_1505764404 = register(new _14_4_1505764404(box()).<_14_4_1505764404>id("a1766560084").owner(MatchTableMold.this));
		if (_14_4_1505764404 != null) _15_5_1549340999 = _14_4_1505764404._15_5_1549340999;
		if (_15_5_1549340999 != null) _16_6_0308402801 = _14_4_1505764404._15_5_1549340999._16_6_0308402801;
		if (_16_6_0308402801 != null) _17_7_0896608022 = _14_4_1505764404._15_5_1549340999._16_6_0308402801._17_7_0896608022;
		if (_17_7_0896608022 != null) day = _14_4_1505764404._15_5_1549340999._16_6_0308402801._17_7_0896608022.day;
		if (_16_6_0308402801 != null) _18_7_11567399895 = _14_4_1505764404._15_5_1549340999._16_6_0308402801._18_7_11567399895;
		if (_18_7_11567399895 != null) matchDay = _14_4_1505764404._15_5_1549340999._16_6_0308402801._18_7_11567399895.matchDay;
		if (_16_6_0308402801 != null) _19_7_11303616147 = _14_4_1505764404._15_5_1549340999._16_6_0308402801._19_7_11303616147;
		if (_19_7_11303616147 != null) competitionLink = _14_4_1505764404._15_5_1549340999._16_6_0308402801._19_7_11303616147.competitionLink;
		if (_15_5_1549340999 != null) _20_6_01319919341 = _14_4_1505764404._15_5_1549340999._20_6_01319919341;
		if (_20_6_01319919341 != null) _21_7_11016386267 = _14_4_1505764404._15_5_1549340999._20_6_01319919341._21_7_11016386267;
		if (_21_7_11016386267 != null) localLink = _14_4_1505764404._15_5_1549340999._20_6_01319919341._21_7_11016386267.localLink;
		if (_20_6_01319919341 != null) _22_7_11132785025 = _14_4_1505764404._15_5_1549340999._20_6_01319919341._22_7_11132785025;
		if (_22_7_11132785025 != null) match = _14_4_1505764404._15_5_1549340999._20_6_01319919341._22_7_11132785025.match;
		if (_20_6_01319919341 != null) _23_7_01940714705 = _14_4_1505764404._15_5_1549340999._20_6_01319919341._23_7_01940714705;
		if (_23_7_01940714705 != null) visitantLink = _14_4_1505764404._15_5_1549340999._20_6_01319919341._23_7_01940714705.visitantLink;
	}

	@Override
	public void remove() {
		super.remove();
		if (_14_4_1505764404 != null) _14_4_1505764404.unregister();
	}

	public class _14_4_1505764404 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
		public MatchTableMold._14_4_1505764404. _15_5_1549340999 _15_5_1549340999;

		public _14_4_1505764404(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_15_5_1549340999 == null) _15_5_1549340999 = register(new _15_5_1549340999(box()).<_15_5_1549340999>id("a1476669745").owner(MatchTableMold.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_15_5_1549340999 != null) _15_5_1549340999.unregister();
		}

		public class _15_5_1549340999 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
			public MatchTableMold._14_4_1505764404._15_5_1549340999. _16_6_0308402801 _16_6_0308402801;
			public MatchTableMold._14_4_1505764404._15_5_1549340999. _20_6_01319919341 _20_6_01319919341;

			public _15_5_1549340999(ProtrixBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_16_6_0308402801 == null) _16_6_0308402801 = register(new _16_6_0308402801(box()).<_16_6_0308402801>id("a_33064632").owner(MatchTableMold.this));
				if (_20_6_01319919341 == null) _20_6_01319919341 = register(new _20_6_01319919341(box()).<_20_6_01319919341>id("a_1640730808").owner(MatchTableMold.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_16_6_0308402801 != null) _16_6_0308402801.unregister();
				if (_20_6_01319919341 != null) _20_6_01319919341.unregister();
			}

			public class _16_6_0308402801 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _17_7_0896608022 _17_7_0896608022;
				public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _18_7_11567399895 _18_7_11567399895;
				public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801. _19_7_11303616147 _19_7_11303616147;

				public _16_6_0308402801(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_17_7_0896608022 == null) _17_7_0896608022 = register(new _17_7_0896608022(box()).<_17_7_0896608022>id("a_1179961651").owner(MatchTableMold.this));
					if (_18_7_11567399895 == null) _18_7_11567399895 = register(new _18_7_11567399895(box()).<_18_7_11567399895>id("a_1518405758").owner(MatchTableMold.this));
					if (_19_7_11303616147 == null) _19_7_11303616147 = register(new _19_7_11303616147(box()).<_19_7_11303616147>id("a_1734484133").owner(MatchTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_17_7_0896608022 != null) _17_7_0896608022.unregister();
					if (_18_7_11567399895 != null) _18_7_11567399895.unregister();
					if (_19_7_11303616147 != null) _19_7_11303616147.unregister();
				}

				public class _17_7_0896608022 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._17_7_0896608022. Day day;

					public _17_7_0896608022(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (day == null) day = register(new Day(box()).<Day>id("a961291178").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (day != null) day.unregister();
					}

					public class Day extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

						public Day(ProtrixBox box) {
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

				public class _18_7_11567399895 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._18_7_11567399895. MatchDay matchDay;

					public _18_7_11567399895(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (matchDay == null) matchDay = register(new MatchDay(box()).<MatchDay>id("a1033960872").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (matchDay != null) matchDay.unregister();
					}

					public class MatchDay extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

						public MatchDay(ProtrixBox box) {
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

				public class _19_7_11303616147 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._16_6_0308402801._19_7_11303616147. CompetitionLink competitionLink;

					public _19_7_11303616147(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (competitionLink == null) competitionLink = register(new CompetitionLink(box()).<CompetitionLink>id("a_2029617943").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (competitionLink != null) competitionLink.unregister();
					}

					public class CompetitionLink extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

						public CompetitionLink(ProtrixBox box) {
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
			}

			public class _20_6_01319919341 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
				public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _21_7_11016386267 _21_7_11016386267;
				public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _22_7_11132785025 _22_7_11132785025;
				public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341. _23_7_01940714705 _23_7_01940714705;

				public _20_6_01319919341(ProtrixBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_21_7_11016386267 == null) _21_7_11016386267 = register(new _21_7_11016386267(box()).<_21_7_11016386267>id("a726603027").owner(MatchTableMold.this));
					if (_22_7_11132785025 == null) _22_7_11132785025 = register(new _22_7_11132785025(box()).<_22_7_11132785025>id("a476791084").owner(MatchTableMold.this));
					if (_23_7_01940714705 == null) _23_7_01940714705 = register(new _23_7_01940714705(box()).<_23_7_01940714705>id("a_2127091660").owner(MatchTableMold.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_21_7_11016386267 != null) _21_7_11016386267.unregister();
					if (_22_7_11132785025 != null) _22_7_11132785025.unregister();
					if (_23_7_01940714705 != null) _23_7_01940714705.unregister();
				}

				public class _21_7_11016386267 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._21_7_11016386267. LocalLink localLink;

					public _21_7_11016386267(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (localLink == null) localLink = register(new LocalLink(box()).<LocalLink>id("a1717294636").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (localLink != null) localLink.unregister();
					}

					public class LocalLink extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

						public LocalLink(ProtrixBox box) {
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

				public class _22_7_11132785025 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._22_7_11132785025. Match match;

					public _22_7_11132785025(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (match == null) match = register(new Match(box()).<Match>id("a641987693").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (match != null) match.unregister();
					}

					public class Match extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

						public Match(ProtrixBox box) {
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

				public class _23_7_01940714705 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, ProtrixBox>  {
					public MatchTableMold._14_4_1505764404._15_5_1549340999._20_6_01319919341._23_7_01940714705. VisitantLink visitantLink;

					public _23_7_01940714705(ProtrixBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (visitantLink == null) visitantLink = register(new VisitantLink(box()).<VisitantLink>id("a_1320189683").owner(MatchTableMold.this));
					}

					@Override
					public void unregister() {
						super.unregister();
						if (visitantLink != null) visitantLink.unregister();
					}

					public class VisitantLink extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, ProtrixBox>  {

						public VisitantLink(ProtrixBox box) {
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
			}
		}
	}
}