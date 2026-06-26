package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractMatchPlayersTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _67_1_179868665 _67_1_179868665;
	public MatchPlayersTemplate._67_1_179868665. FieldImage fieldImage;
	public MatchPlayersTemplate._67_1_179868665. P1 p1;
	public MatchLineupPinTemplate player1;
	public MatchPlayersTemplate._67_1_179868665. P2 p2;
	public MatchLineupPinTemplate player2;
	public MatchPlayersTemplate._67_1_179868665. P3 p3;
	public MatchLineupPinTemplate player3;
	public MatchPlayersTemplate._67_1_179868665. P4 p4;
	public MatchLineupPinTemplate player4;
	public MatchPlayersTemplate._67_1_179868665. P5 p5;
	public MatchLineupPinTemplate player5;
	public MatchPlayersTemplate._67_1_179868665. P6 p6;
	public MatchLineupPinTemplate player6;
	public MatchPlayersTemplate._67_1_179868665. P7 p7;
	public MatchLineupPinTemplate player7;
	public MatchPlayersTemplate._67_1_179868665. P8 p8;
	public MatchLineupPinTemplate player8;
	public MatchPlayersTemplate._67_1_179868665. P9 p9;
	public MatchLineupPinTemplate player9;
	public MatchPlayersTemplate._67_1_179868665. P10 p10;
	public MatchLineupPinTemplate player10;
	public MatchPlayersTemplate._67_1_179868665. P11 p11;
	public MatchLineupPinTemplate player11;
	public MatchPlayersTable matchPlayersTable;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersNumberHeading matchPlayersNumberHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersNumberHeading. _84_39_01781183210 _84_39_01781183210;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersNameHeading matchPlayersNameHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersNameHeading. _87_37_1770141361 _87_37_1770141361;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersPositionHeading matchPlayersPositionHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersPositionHeading. _90_41_12104284611 _90_41_12104284611;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersEntersHeading matchPlayersEntersHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersEntersHeading. _93_39_11590267194 _93_39_11590267194;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersExitsHeading matchPlayersExitsHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersExitsHeading. _96_38_01006738291 _96_38_01006738291;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersGoalsHeading matchPlayersGoalsHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersGoalsHeading. _99_38_11198996748 _99_38_11198996748;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersAssistsHeading matchPlayersAssistsHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersAssistsHeading. _102_40_11654373010 _102_40_11654373010;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersYellowCardsHeading matchPlayersYellowCardsHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersYellowCardsHeading. _105_44_1288404048 _105_44_1288404048;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersRedCardsHeading matchPlayersRedCardsHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersRedCardsHeading. _108_41_1429827071 _108_41_1429827071;
	public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersScoreHeading matchPlayersScoreHeading;
	public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersScoreHeading. _111_38_160995056 _111_38_160995056;

	public AbstractMatchPlayersTemplate(B box) {
		super(box);
		id("matchPlayersTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_67_1_179868665 == null) _67_1_179868665 = register(new _67_1_179868665(box()).<_67_1_179868665>id("a_1450009016").owner(AbstractMatchPlayersTemplate.this));
		if (_67_1_179868665 != null) fieldImage = _67_1_179868665.fieldImage;
		if (_67_1_179868665 != null) p1 = _67_1_179868665.p1;
		if (p1 != null) player1 = _67_1_179868665.p1.player1;
		if (_67_1_179868665 != null) p2 = _67_1_179868665.p2;
		if (p2 != null) player2 = _67_1_179868665.p2.player2;
		if (_67_1_179868665 != null) p3 = _67_1_179868665.p3;
		if (p3 != null) player3 = _67_1_179868665.p3.player3;
		if (_67_1_179868665 != null) p4 = _67_1_179868665.p4;
		if (p4 != null) player4 = _67_1_179868665.p4.player4;
		if (_67_1_179868665 != null) p5 = _67_1_179868665.p5;
		if (p5 != null) player5 = _67_1_179868665.p5.player5;
		if (_67_1_179868665 != null) p6 = _67_1_179868665.p6;
		if (p6 != null) player6 = _67_1_179868665.p6.player6;
		if (_67_1_179868665 != null) p7 = _67_1_179868665.p7;
		if (p7 != null) player7 = _67_1_179868665.p7.player7;
		if (_67_1_179868665 != null) p8 = _67_1_179868665.p8;
		if (p8 != null) player8 = _67_1_179868665.p8.player8;
		if (_67_1_179868665 != null) p9 = _67_1_179868665.p9;
		if (p9 != null) player9 = _67_1_179868665.p9.player9;
		if (_67_1_179868665 != null) p10 = _67_1_179868665.p10;
		if (p10 != null) player10 = _67_1_179868665.p10.player10;
		if (_67_1_179868665 != null) p11 = _67_1_179868665.p11;
		if (p11 != null) player11 = _67_1_179868665.p11.player11;
		if (matchPlayersTable == null) matchPlayersTable = register(new MatchPlayersTable(box()).<MatchPlayersTable>id("a477952584").owner(AbstractMatchPlayersTemplate.this));
		if (matchPlayersTable != null) matchPlayersNumberHeading = matchPlayersTable.matchPlayersNumberHeading;
		if (matchPlayersNumberHeading != null) _84_39_01781183210 = matchPlayersTable.matchPlayersNumberHeading._84_39_01781183210;
		if (matchPlayersTable != null) matchPlayersNameHeading = matchPlayersTable.matchPlayersNameHeading;
		if (matchPlayersNameHeading != null) _87_37_1770141361 = matchPlayersTable.matchPlayersNameHeading._87_37_1770141361;
		if (matchPlayersTable != null) matchPlayersPositionHeading = matchPlayersTable.matchPlayersPositionHeading;
		if (matchPlayersPositionHeading != null) _90_41_12104284611 = matchPlayersTable.matchPlayersPositionHeading._90_41_12104284611;
		if (matchPlayersTable != null) matchPlayersEntersHeading = matchPlayersTable.matchPlayersEntersHeading;
		if (matchPlayersEntersHeading != null) _93_39_11590267194 = matchPlayersTable.matchPlayersEntersHeading._93_39_11590267194;
		if (matchPlayersTable != null) matchPlayersExitsHeading = matchPlayersTable.matchPlayersExitsHeading;
		if (matchPlayersExitsHeading != null) _96_38_01006738291 = matchPlayersTable.matchPlayersExitsHeading._96_38_01006738291;
		if (matchPlayersTable != null) matchPlayersGoalsHeading = matchPlayersTable.matchPlayersGoalsHeading;
		if (matchPlayersGoalsHeading != null) _99_38_11198996748 = matchPlayersTable.matchPlayersGoalsHeading._99_38_11198996748;
		if (matchPlayersTable != null) matchPlayersAssistsHeading = matchPlayersTable.matchPlayersAssistsHeading;
		if (matchPlayersAssistsHeading != null) _102_40_11654373010 = matchPlayersTable.matchPlayersAssistsHeading._102_40_11654373010;
		if (matchPlayersTable != null) matchPlayersYellowCardsHeading = matchPlayersTable.matchPlayersYellowCardsHeading;
		if (matchPlayersYellowCardsHeading != null) _105_44_1288404048 = matchPlayersTable.matchPlayersYellowCardsHeading._105_44_1288404048;
		if (matchPlayersTable != null) matchPlayersRedCardsHeading = matchPlayersTable.matchPlayersRedCardsHeading;
		if (matchPlayersRedCardsHeading != null) _108_41_1429827071 = matchPlayersTable.matchPlayersRedCardsHeading._108_41_1429827071;
		if (matchPlayersTable != null) matchPlayersScoreHeading = matchPlayersTable.matchPlayersScoreHeading;
		if (matchPlayersScoreHeading != null) _111_38_160995056 = matchPlayersTable.matchPlayersScoreHeading._111_38_160995056;
	}

	@Override
	public void remove() {
		super.remove();
		if (_67_1_179868665 != null) _67_1_179868665.unregister();
		if (matchPlayersTable != null) matchPlayersTable.unregister();
	}

	public class _67_1_179868665 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchPlayersTemplate._67_1_179868665. FieldImage fieldImage;
		public MatchPlayersTemplate._67_1_179868665. P1 p1;
		public MatchPlayersTemplate._67_1_179868665. P2 p2;
		public MatchPlayersTemplate._67_1_179868665. P3 p3;
		public MatchPlayersTemplate._67_1_179868665. P4 p4;
		public MatchPlayersTemplate._67_1_179868665. P5 p5;
		public MatchPlayersTemplate._67_1_179868665. P6 p6;
		public MatchPlayersTemplate._67_1_179868665. P7 p7;
		public MatchPlayersTemplate._67_1_179868665. P8 p8;
		public MatchPlayersTemplate._67_1_179868665. P9 p9;
		public MatchPlayersTemplate._67_1_179868665. P10 p10;
		public MatchPlayersTemplate._67_1_179868665. P11 p11;

		public _67_1_179868665(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (fieldImage == null) fieldImage = register(new FieldImage(box()).<FieldImage>id("a380377971").owner(AbstractMatchPlayersTemplate.this));
			if (p1 == null) p1 = register(new P1(box()).<P1>id("a_337996109").owner(AbstractMatchPlayersTemplate.this));
			if (p2 == null) p2 = register(new P2(box()).<P2>id("a_337996108").owner(AbstractMatchPlayersTemplate.this));
			if (p3 == null) p3 = register(new P3(box()).<P3>id("a_337996107").owner(AbstractMatchPlayersTemplate.this));
			if (p4 == null) p4 = register(new P4(box()).<P4>id("a_337996106").owner(AbstractMatchPlayersTemplate.this));
			if (p5 == null) p5 = register(new P5(box()).<P5>id("a_337996105").owner(AbstractMatchPlayersTemplate.this));
			if (p6 == null) p6 = register(new P6(box()).<P6>id("a_337996104").owner(AbstractMatchPlayersTemplate.this));
			if (p7 == null) p7 = register(new P7(box()).<P7>id("a_337996103").owner(AbstractMatchPlayersTemplate.this));
			if (p8 == null) p8 = register(new P8(box()).<P8>id("a_337996102").owner(AbstractMatchPlayersTemplate.this));
			if (p9 == null) p9 = register(new P9(box()).<P9>id("a_337996101").owner(AbstractMatchPlayersTemplate.this));
			if (p10 == null) p10 = register(new P10(box()).<P10>id("a_1887944739").owner(AbstractMatchPlayersTemplate.this));
			if (p11 == null) p11 = register(new P11(box()).<P11>id("a_1887944738").owner(AbstractMatchPlayersTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (fieldImage != null) fieldImage.unregister();
			if (p1 != null) p1.unregister();
			if (p2 != null) p2.unregister();
			if (p3 != null) p3.unregister();
			if (p4 != null) p4.unregister();
			if (p5 != null) p5.unregister();
			if (p6 != null) p6.unregister();
			if (p7 != null) p7.unregister();
			if (p8 != null) p8.unregister();
			if (p9 != null) p9.unregister();
			if (p10 != null) p10.unregister();
			if (p11 != null) p11.unregister();
		}

		public class FieldImage extends io.intino.alexandria.ui.displays.components.Image<io.intino.alexandria.ui.displays.notifiers.ImageNotifier, B>  {

			public FieldImage(B box) {
				super(box);
				_value(AbstractMatchPlayersTemplate.class.getResource("/images/field.jpg"));
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

		public class P1 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player1;

			public P1(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player1 == null) player1 = AbstractMatchPlayersTemplate.this.player1 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_1511875612"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player1 != null) player1.unregister();
			}
		}

		public class P2 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player2;

			public P2(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player2 == null) player2 = AbstractMatchPlayersTemplate.this.player2 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a975637222"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player2 != null) player2.unregister();
			}
		}

		public class P3 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player3;

			public P3(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player3 == null) player3 = AbstractMatchPlayersTemplate.this.player3 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_831817240"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player3 != null) player3.unregister();
			}
		}

		public class P4 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player4;

			public P4(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player4 == null) player4 = AbstractMatchPlayersTemplate.this.player4 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a1655695594"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player4 != null) player4.unregister();
			}
		}

		public class P5 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player5;

			public P5(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player5 == null) player5 = AbstractMatchPlayersTemplate.this.player5 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_151758868"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player5 != null) player5.unregister();
			}
		}

		public class P6 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player6;

			public P6(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player6 == null) player6 = AbstractMatchPlayersTemplate.this.player6 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_1959213330"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player6 != null) player6.unregister();
			}
		}

		public class P7 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player7;

			public P7(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player7 == null) player7 = AbstractMatchPlayersTemplate.this.player7 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a528299504"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player7 != null) player7.unregister();
			}
		}

		public class P8 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player8;

			public P8(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player8 == null) player8 = AbstractMatchPlayersTemplate.this.player8 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_1279154958"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player8 != null) player8.unregister();
			}
		}

		public class P9 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player9;

			public P9(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player9 == null) player9 = AbstractMatchPlayersTemplate.this.player9 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a1208357876"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player9 != null) player9.unregister();
			}
		}

		public class P10 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player10;

			public P10(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player10 == null) player10 = AbstractMatchPlayersTemplate.this.player10 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_1020401950"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player10 != null) player10.unregister();
			}
		}

		public class P11 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchLineupPinTemplate player11;

			public P11(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (player11 == null) player11 = AbstractMatchPlayersTemplate.this.player11 = register(new MatchLineupPinTemplate((ProtrixBox)box()).id("a_1216915454"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (player11 != null) player11.unregister();
			}
		}
	}

	public class MatchPlayersTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.protrix.model.PlayerMatchRecord>  {
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersNumberHeading matchPlayersNumberHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersNameHeading matchPlayersNameHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersPositionHeading matchPlayersPositionHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersEntersHeading matchPlayersEntersHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersExitsHeading matchPlayersExitsHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersGoalsHeading matchPlayersGoalsHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersAssistsHeading matchPlayersAssistsHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersYellowCardsHeading matchPlayersYellowCardsHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersRedCardsHeading matchPlayersRedCardsHeading;
		public MatchPlayersTemplate.MatchPlayersTable. MatchPlayersScoreHeading matchPlayersScoreHeading;

		public MatchPlayersTable(B box) {
			super(box);

			_pageSize(25);
		}

		@Override
		public void init() {
			super.init();
			if (matchPlayersNumberHeading == null) matchPlayersNumberHeading = register(new MatchPlayersNumberHeading(box()).<MatchPlayersNumberHeading>id("a831831061").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersNameHeading == null) matchPlayersNameHeading = register(new MatchPlayersNameHeading(box()).<MatchPlayersNameHeading>id("a1935325142").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersPositionHeading == null) matchPlayersPositionHeading = register(new MatchPlayersPositionHeading(box()).<MatchPlayersPositionHeading>id("a153705659").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersEntersHeading == null) matchPlayersEntersHeading = register(new MatchPlayersEntersHeading(box()).<MatchPlayersEntersHeading>id("a1324534177").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersExitsHeading == null) matchPlayersExitsHeading = register(new MatchPlayersExitsHeading(box()).<MatchPlayersExitsHeading>id("a_1509313712").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersGoalsHeading == null) matchPlayersGoalsHeading = register(new MatchPlayersGoalsHeading(box()).<MatchPlayersGoalsHeading>id("a124176994").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersAssistsHeading == null) matchPlayersAssistsHeading = register(new MatchPlayersAssistsHeading(box()).<MatchPlayersAssistsHeading>id("a722870201").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersYellowCardsHeading == null) matchPlayersYellowCardsHeading = register(new MatchPlayersYellowCardsHeading(box()).<MatchPlayersYellowCardsHeading>id("a_1005031471").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersRedCardsHeading == null) matchPlayersRedCardsHeading = register(new MatchPlayersRedCardsHeading(box()).<MatchPlayersRedCardsHeading>id("a_1623046731").owner(AbstractMatchPlayersTemplate.this));
			if (matchPlayersScoreHeading == null) matchPlayersScoreHeading = register(new MatchPlayersScoreHeading(box()).<MatchPlayersScoreHeading>id("a_1157660493").owner(AbstractMatchPlayersTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchPlayersNumberHeading != null) matchPlayersNumberHeading.unregister();
			if (matchPlayersNameHeading != null) matchPlayersNameHeading.unregister();
			if (matchPlayersPositionHeading != null) matchPlayersPositionHeading.unregister();
			if (matchPlayersEntersHeading != null) matchPlayersEntersHeading.unregister();
			if (matchPlayersExitsHeading != null) matchPlayersExitsHeading.unregister();
			if (matchPlayersGoalsHeading != null) matchPlayersGoalsHeading.unregister();
			if (matchPlayersAssistsHeading != null) matchPlayersAssistsHeading.unregister();
			if (matchPlayersYellowCardsHeading != null) matchPlayersYellowCardsHeading.unregister();
			if (matchPlayersRedCardsHeading != null) matchPlayersRedCardsHeading.unregister();
			if (matchPlayersScoreHeading != null) matchPlayersScoreHeading.unregister();
		}


		public MatchPlayersTableRow create(rlp.footrix.protrix.model.PlayerMatchRecord item) {
			MatchPlayersTableRow row = new MatchPlayersTableRow((ProtrixBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class MatchPlayersNumberHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersNumberHeading. _84_39_01781183210 _84_39_01781183210;

			public MatchPlayersNumberHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_84_39_01781183210 == null) _84_39_01781183210 = register(new _84_39_01781183210(box()).<_84_39_01781183210>id("a_1203942103").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_84_39_01781183210 != null) _84_39_01781183210.unregister();
			}

			public class _84_39_01781183210 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _84_39_01781183210(B box) {
					super(box);
					_value("Dor.");
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

		public class MatchPlayersNameHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersNameHeading. _87_37_1770141361 _87_37_1770141361;

			public MatchPlayersNameHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_87_37_1770141361 == null) _87_37_1770141361 = register(new _87_37_1770141361(box()).<_87_37_1770141361>id("a_1112417552").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_87_37_1770141361 != null) _87_37_1770141361.unregister();
			}

			public class _87_37_1770141361 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _87_37_1770141361(B box) {
					super(box);
					_value("Jugador");
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

		public class MatchPlayersPositionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersPositionHeading. _90_41_12104284611 _90_41_12104284611;

			public MatchPlayersPositionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_90_41_12104284611 == null) _90_41_12104284611 = register(new _90_41_12104284611(box()).<_90_41_12104284611>id("a1915739015").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_90_41_12104284611 != null) _90_41_12104284611.unregister();
			}

			public class _90_41_12104284611 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _90_41_12104284611(B box) {
					super(box);
					_value("Pos.");
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

		public class MatchPlayersEntersHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersEntersHeading. _93_39_11590267194 _93_39_11590267194;

			public MatchPlayersEntersHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_93_39_11590267194 == null) _93_39_11590267194 = register(new _93_39_11590267194(box()).<_93_39_11590267194>id("a646748912").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_93_39_11590267194 != null) _93_39_11590267194.unregister();
			}

			public class _93_39_11590267194 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _93_39_11590267194(B box) {
					super(box);
					_value("Ent.");
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

		public class MatchPlayersExitsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersExitsHeading. _96_38_01006738291 _96_38_01006738291;

			public MatchPlayersExitsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_96_38_01006738291 == null) _96_38_01006738291 = register(new _96_38_01006738291(box()).<_96_38_01006738291>id("a1514507931").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_96_38_01006738291 != null) _96_38_01006738291.unregister();
			}

			public class _96_38_01006738291 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _96_38_01006738291(B box) {
					super(box);
					_value("Sal.");
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

		public class MatchPlayersGoalsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersGoalsHeading. _99_38_11198996748 _99_38_11198996748;

			public MatchPlayersGoalsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_99_38_11198996748 == null) _99_38_11198996748 = register(new _99_38_11198996748(box()).<_99_38_11198996748>id("a_272672840").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_99_38_11198996748 != null) _99_38_11198996748.unregister();
			}

			public class _99_38_11198996748 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _99_38_11198996748(B box) {
					super(box);
					_value("G");
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

		public class MatchPlayersAssistsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersAssistsHeading. _102_40_11654373010 _102_40_11654373010;

			public MatchPlayersAssistsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_102_40_11654373010 == null) _102_40_11654373010 = register(new _102_40_11654373010(box()).<_102_40_11654373010>id("a1772735671").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_102_40_11654373010 != null) _102_40_11654373010.unregister();
			}

			public class _102_40_11654373010 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _102_40_11654373010(B box) {
					super(box);
					_value("A");
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

		public class MatchPlayersYellowCardsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersYellowCardsHeading. _105_44_1288404048 _105_44_1288404048;

			public MatchPlayersYellowCardsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_105_44_1288404048 == null) _105_44_1288404048 = register(new _105_44_1288404048(box()).<_105_44_1288404048>id("a704999394").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_105_44_1288404048 != null) _105_44_1288404048.unregister();
			}

			public class _105_44_1288404048 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _105_44_1288404048(B box) {
					super(box);
					_value("TA");
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

		public class MatchPlayersRedCardsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersRedCardsHeading. _108_41_1429827071 _108_41_1429827071;

			public MatchPlayersRedCardsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_108_41_1429827071 == null) _108_41_1429827071 = register(new _108_41_1429827071(box()).<_108_41_1429827071>id("a_1554861794").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_108_41_1429827071 != null) _108_41_1429827071.unregister();
			}

			public class _108_41_1429827071 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _108_41_1429827071(B box) {
					super(box);
					_value("TR");
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

		public class MatchPlayersScoreHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public MatchPlayersTemplate.MatchPlayersTable.MatchPlayersScoreHeading. _111_38_160995056 _111_38_160995056;

			public MatchPlayersScoreHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_111_38_160995056 == null) _111_38_160995056 = register(new _111_38_160995056(box()).<_111_38_160995056>id("a_212068370").owner(AbstractMatchPlayersTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_111_38_160995056 != null) _111_38_160995056.unregister();
			}

			public class _111_38_160995056 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _111_38_160995056(B box) {
					super(box);
					_value("Punt.");
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