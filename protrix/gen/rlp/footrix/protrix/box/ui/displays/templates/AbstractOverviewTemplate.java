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

public abstract class AbstractOverviewTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _8_1_11371965115 _8_1_11371965115;
	public MatchesTemplate matchesStamp;
	public _10_1_0807785531 _10_1_0807785531;
	public OverviewTemplate._10_1_0807785531. _11_2_01769375537 _11_2_01769375537;
	public _12_1_0371112067 _12_1_0371112067;
	public OverviewTemplate._12_1_0371112067. _13_2_11061856315 _13_2_11061856315;
	public OverviewTemplate._12_1_0371112067. ClassificationTable classificationTable;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPositionHeading classificationPositionHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPositionHeading. _18_44_12104284611 _18_44_12104284611;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationTeamHeading classificationTeamHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationTeamHeading. _21_40_11136748382 _21_40_11136748382;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPlayedMatchesHeading classificationPlayedMatchesHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPlayedMatchesHeading. _24_49_11858170243 _24_49_11858170243;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationWinMatchesHeading classificationWinMatchesHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationWinMatchesHeading. _27_46_160556093 _27_46_160556093;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationDrawMatchesHeading classificationDrawMatchesHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationDrawMatchesHeading. _30_47_080866930 _30_47_080866930;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationLostMatchesHeading classificationLostMatchesHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationLostMatchesHeading. _33_47_11426684879 _33_47_11426684879;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationGoalsDifferenceHeading classificationGoalsDifferenceHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationGoalsDifferenceHeading. _36_51_1254415546 _36_51_1254415546;
	public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPointsHeading classificationPointsHeading;
	public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPointsHeading. _39_42_0367296578 _39_42_0367296578;
	public OverviewTemplate._12_1_0371112067. _41_2_0132762623 _41_2_0132762623;
	public CompetitionGoalRankingTemplate competitionGoalRankingStamp;
	public OverviewTemplate._12_1_0371112067. _43_2_0454141285 _43_2_0454141285;
	public CompetitionAssistRankingTemplate competitionAssistRankingStamp;

	public AbstractOverviewTemplate(B box) {
		super(box);
		id("overviewTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_8_1_11371965115 == null) _8_1_11371965115 = register(new _8_1_11371965115(box()).<_8_1_11371965115>id("a776469731").owner(AbstractOverviewTemplate.this));
		if (_8_1_11371965115 != null) matchesStamp = _8_1_11371965115.matchesStamp;
		if (_10_1_0807785531 == null) _10_1_0807785531 = register(new _10_1_0807785531(box()).<_10_1_0807785531>id("a_800844790").owner(AbstractOverviewTemplate.this));
		if (_10_1_0807785531 != null) _11_2_01769375537 = _10_1_0807785531._11_2_01769375537;
		if (_12_1_0371112067 == null) _12_1_0371112067 = register(new _12_1_0371112067(box()).<_12_1_0371112067>id("a1036725014").owner(AbstractOverviewTemplate.this));
		if (_12_1_0371112067 != null) _13_2_11061856315 = _12_1_0371112067._13_2_11061856315;
		if (_12_1_0371112067 != null) classificationTable = _12_1_0371112067.classificationTable;
		if (classificationTable != null) classificationPositionHeading = _12_1_0371112067.classificationTable.classificationPositionHeading;
		if (classificationPositionHeading != null) _18_44_12104284611 = _12_1_0371112067.classificationTable.classificationPositionHeading._18_44_12104284611;
		if (classificationTable != null) classificationTeamHeading = _12_1_0371112067.classificationTable.classificationTeamHeading;
		if (classificationTeamHeading != null) _21_40_11136748382 = _12_1_0371112067.classificationTable.classificationTeamHeading._21_40_11136748382;
		if (classificationTable != null) classificationPlayedMatchesHeading = _12_1_0371112067.classificationTable.classificationPlayedMatchesHeading;
		if (classificationPlayedMatchesHeading != null) _24_49_11858170243 = _12_1_0371112067.classificationTable.classificationPlayedMatchesHeading._24_49_11858170243;
		if (classificationTable != null) classificationWinMatchesHeading = _12_1_0371112067.classificationTable.classificationWinMatchesHeading;
		if (classificationWinMatchesHeading != null) _27_46_160556093 = _12_1_0371112067.classificationTable.classificationWinMatchesHeading._27_46_160556093;
		if (classificationTable != null) classificationDrawMatchesHeading = _12_1_0371112067.classificationTable.classificationDrawMatchesHeading;
		if (classificationDrawMatchesHeading != null) _30_47_080866930 = _12_1_0371112067.classificationTable.classificationDrawMatchesHeading._30_47_080866930;
		if (classificationTable != null) classificationLostMatchesHeading = _12_1_0371112067.classificationTable.classificationLostMatchesHeading;
		if (classificationLostMatchesHeading != null) _33_47_11426684879 = _12_1_0371112067.classificationTable.classificationLostMatchesHeading._33_47_11426684879;
		if (classificationTable != null) classificationGoalsDifferenceHeading = _12_1_0371112067.classificationTable.classificationGoalsDifferenceHeading;
		if (classificationGoalsDifferenceHeading != null) _36_51_1254415546 = _12_1_0371112067.classificationTable.classificationGoalsDifferenceHeading._36_51_1254415546;
		if (classificationTable != null) classificationPointsHeading = _12_1_0371112067.classificationTable.classificationPointsHeading;
		if (classificationPointsHeading != null) _39_42_0367296578 = _12_1_0371112067.classificationTable.classificationPointsHeading._39_42_0367296578;
		if (_12_1_0371112067 != null) _41_2_0132762623 = _12_1_0371112067._41_2_0132762623;
		if (_41_2_0132762623 != null) competitionGoalRankingStamp = _12_1_0371112067._41_2_0132762623.competitionGoalRankingStamp;
		if (_12_1_0371112067 != null) _43_2_0454141285 = _12_1_0371112067._43_2_0454141285;
		if (_43_2_0454141285 != null) competitionAssistRankingStamp = _12_1_0371112067._43_2_0454141285.competitionAssistRankingStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_8_1_11371965115 != null) _8_1_11371965115.unregister();
		if (_10_1_0807785531 != null) _10_1_0807785531.unregister();
		if (_12_1_0371112067 != null) _12_1_0371112067.unregister();
	}

	public class _8_1_11371965115 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchesTemplate matchesStamp;

		public _8_1_11371965115(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (matchesStamp == null) matchesStamp = AbstractOverviewTemplate.this.matchesStamp = register(new MatchesTemplate((ProtrixBox)box()).id("a1719165035"));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchesStamp != null) matchesStamp.unregister();
		}
	}

	public class _10_1_0807785531 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public OverviewTemplate._10_1_0807785531. _11_2_01769375537 _11_2_01769375537;

		public _10_1_0807785531(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_11_2_01769375537 == null) _11_2_01769375537 = register(new _11_2_01769375537(box()).<_11_2_01769375537>id("a_752866580").owner(AbstractOverviewTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_11_2_01769375537 != null) _11_2_01769375537.unregister();
		}

		public class _11_2_01769375537 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _11_2_01769375537(B box) {
				super(box);
				_value("Noticias");
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

	public class _12_1_0371112067 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public OverviewTemplate._12_1_0371112067. _13_2_11061856315 _13_2_11061856315;
		public OverviewTemplate._12_1_0371112067. ClassificationTable classificationTable;
		public OverviewTemplate._12_1_0371112067. _41_2_0132762623 _41_2_0132762623;
		public OverviewTemplate._12_1_0371112067. _43_2_0454141285 _43_2_0454141285;

		public _12_1_0371112067(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_13_2_11061856315 == null) _13_2_11061856315 = register(new _13_2_11061856315(box()).<_13_2_11061856315>id("a_2008468776").owner(AbstractOverviewTemplate.this));
			if (classificationTable == null) classificationTable = register(new ClassificationTable(box()).<ClassificationTable>id("a_1344226622").owner(AbstractOverviewTemplate.this));
			if (_41_2_0132762623 == null) _41_2_0132762623 = register(new _41_2_0132762623(box()).<_41_2_0132762623>id("a1140574330").owner(AbstractOverviewTemplate.this));
			if (_43_2_0454141285 == null) _43_2_0454141285 = register(new _43_2_0454141285(box()).<_43_2_0454141285>id("a_205933672").owner(AbstractOverviewTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_13_2_11061856315 != null) _13_2_11061856315.unregister();
			if (classificationTable != null) classificationTable.unregister();
			if (_41_2_0132762623 != null) _41_2_0132762623.unregister();
			if (_43_2_0454141285 != null) _43_2_0454141285.unregister();
		}

		public class _13_2_11061856315 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _13_2_11061856315(B box) {
				super(box);
				_value("Clasificación");
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

		public class ClassificationTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.protrix.model.Classification>  {
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPositionHeading classificationPositionHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationTeamHeading classificationTeamHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPlayedMatchesHeading classificationPlayedMatchesHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationWinMatchesHeading classificationWinMatchesHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationDrawMatchesHeading classificationDrawMatchesHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationLostMatchesHeading classificationLostMatchesHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationGoalsDifferenceHeading classificationGoalsDifferenceHeading;
			public OverviewTemplate._12_1_0371112067.ClassificationTable. ClassificationPointsHeading classificationPointsHeading;

			public ClassificationTable(B box) {
				super(box);

				_pageSize(20);
			}

			@Override
			public void init() {
				super.init();
				if (classificationPositionHeading == null) classificationPositionHeading = register(new ClassificationPositionHeading(box()).<ClassificationPositionHeading>id("a318580500").owner(AbstractOverviewTemplate.this));
				if (classificationTeamHeading == null) classificationTeamHeading = register(new ClassificationTeamHeading(box()).<ClassificationTeamHeading>id("a513957112").owner(AbstractOverviewTemplate.this));
				if (classificationPlayedMatchesHeading == null) classificationPlayedMatchesHeading = register(new ClassificationPlayedMatchesHeading(box()).<ClassificationPlayedMatchesHeading>id("a_1842932180").owner(AbstractOverviewTemplate.this));
				if (classificationWinMatchesHeading == null) classificationWinMatchesHeading = register(new ClassificationWinMatchesHeading(box()).<ClassificationWinMatchesHeading>id("a145843364").owner(AbstractOverviewTemplate.this));
				if (classificationDrawMatchesHeading == null) classificationDrawMatchesHeading = register(new ClassificationDrawMatchesHeading(box()).<ClassificationDrawMatchesHeading>id("a1891574679").owner(AbstractOverviewTemplate.this));
				if (classificationLostMatchesHeading == null) classificationLostMatchesHeading = register(new ClassificationLostMatchesHeading(box()).<ClassificationLostMatchesHeading>id("a1475165791").owner(AbstractOverviewTemplate.this));
				if (classificationGoalsDifferenceHeading == null) classificationGoalsDifferenceHeading = register(new ClassificationGoalsDifferenceHeading(box()).<ClassificationGoalsDifferenceHeading>id("a1969516430").owner(AbstractOverviewTemplate.this));
				if (classificationPointsHeading == null) classificationPointsHeading = register(new ClassificationPointsHeading(box()).<ClassificationPointsHeading>id("a1579174105").owner(AbstractOverviewTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (classificationPositionHeading != null) classificationPositionHeading.unregister();
				if (classificationTeamHeading != null) classificationTeamHeading.unregister();
				if (classificationPlayedMatchesHeading != null) classificationPlayedMatchesHeading.unregister();
				if (classificationWinMatchesHeading != null) classificationWinMatchesHeading.unregister();
				if (classificationDrawMatchesHeading != null) classificationDrawMatchesHeading.unregister();
				if (classificationLostMatchesHeading != null) classificationLostMatchesHeading.unregister();
				if (classificationGoalsDifferenceHeading != null) classificationGoalsDifferenceHeading.unregister();
				if (classificationPointsHeading != null) classificationPointsHeading.unregister();
			}


			public ClassificationTableRow create(rlp.footrix.protrix.model.Classification item) {
				ClassificationTableRow row = new ClassificationTableRow((ProtrixBox)box());
				row.id(java.util.UUID.randomUUID().toString());
				row.item(item);
				return row;
			}
			public class ClassificationPositionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPositionHeading. _18_44_12104284611 _18_44_12104284611;

				public ClassificationPositionHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_18_44_12104284611 == null) _18_44_12104284611 = register(new _18_44_12104284611(box()).<_18_44_12104284611>id("a112225025").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_18_44_12104284611 != null) _18_44_12104284611.unregister();
				}

				public class _18_44_12104284611 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _18_44_12104284611(B box) {
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

			public class ClassificationTeamHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationTeamHeading. _21_40_11136748382 _21_40_11136748382;

				public ClassificationTeamHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_21_40_11136748382 == null) _21_40_11136748382 = register(new _21_40_11136748382(box()).<_21_40_11136748382>id("a898164139").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_21_40_11136748382 != null) _21_40_11136748382.unregister();
				}

				public class _21_40_11136748382 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _21_40_11136748382(B box) {
						super(box);
						_value("Equipo");
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

			public class ClassificationPlayedMatchesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPlayedMatchesHeading. _24_49_11858170243 _24_49_11858170243;

				public ClassificationPlayedMatchesHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_24_49_11858170243 == null) _24_49_11858170243 = register(new _24_49_11858170243(box()).<_24_49_11858170243>id("a_1325969159").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_24_49_11858170243 != null) _24_49_11858170243.unregister();
				}

				public class _24_49_11858170243 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _24_49_11858170243(B box) {
						super(box);
						_value("PJ");
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

			public class ClassificationWinMatchesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationWinMatchesHeading. _27_46_160556093 _27_46_160556093;

				public ClassificationWinMatchesHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_27_46_160556093 == null) _27_46_160556093 = register(new _27_46_160556093(box()).<_27_46_160556093>id("a_1504689512").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_27_46_160556093 != null) _27_46_160556093.unregister();
				}

				public class _27_46_160556093 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _27_46_160556093(B box) {
						super(box);
						_value("V");
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

			public class ClassificationDrawMatchesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationDrawMatchesHeading. _30_47_080866930 _30_47_080866930;

				public ClassificationDrawMatchesHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_30_47_080866930 == null) _30_47_080866930 = register(new _30_47_080866930(box()).<_30_47_080866930>id("a_1735774507").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_30_47_080866930 != null) _30_47_080866930.unregister();
				}

				public class _30_47_080866930 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _30_47_080866930(B box) {
						super(box);
						_value("E");
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

			public class ClassificationLostMatchesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationLostMatchesHeading. _33_47_11426684879 _33_47_11426684879;

				public ClassificationLostMatchesHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_33_47_11426684879 == null) _33_47_11426684879 = register(new _33_47_11426684879(box()).<_33_47_11426684879>id("a_1336519964").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_33_47_11426684879 != null) _33_47_11426684879.unregister();
				}

				public class _33_47_11426684879 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _33_47_11426684879(B box) {
						super(box);
						_value("D");
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

			public class ClassificationGoalsDifferenceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationGoalsDifferenceHeading. _36_51_1254415546 _36_51_1254415546;

				public ClassificationGoalsDifferenceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_36_51_1254415546 == null) _36_51_1254415546 = register(new _36_51_1254415546(box()).<_36_51_1254415546>id("a1584399924").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_36_51_1254415546 != null) _36_51_1254415546.unregister();
				}

				public class _36_51_1254415546 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _36_51_1254415546(B box) {
						super(box);
						_value("DG");
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

			public class ClassificationPointsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public OverviewTemplate._12_1_0371112067.ClassificationTable.ClassificationPointsHeading. _39_42_0367296578 _39_42_0367296578;

				public ClassificationPointsHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_39_42_0367296578 == null) _39_42_0367296578 = register(new _39_42_0367296578(box()).<_39_42_0367296578>id("a646544492").owner(AbstractOverviewTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_39_42_0367296578 != null) _39_42_0367296578.unregister();
				}

				public class _39_42_0367296578 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _39_42_0367296578(B box) {
						super(box);
						_value("Pts.");
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

		public class _41_2_0132762623 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public CompetitionGoalRankingTemplate competitionGoalRankingStamp;

			public _41_2_0132762623(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (competitionGoalRankingStamp == null) competitionGoalRankingStamp = AbstractOverviewTemplate.this.competitionGoalRankingStamp = register(new CompetitionGoalRankingTemplate((ProtrixBox)box()).id("a_1455119146"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (competitionGoalRankingStamp != null) competitionGoalRankingStamp.unregister();
			}
		}

		public class _43_2_0454141285 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public CompetitionAssistRankingTemplate competitionAssistRankingStamp;

			public _43_2_0454141285(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (competitionAssistRankingStamp == null) competitionAssistRankingStamp = AbstractOverviewTemplate.this.competitionAssistRankingStamp = register(new CompetitionAssistRankingTemplate((ProtrixBox)box()).id("a1526229422"));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (competitionAssistRankingStamp != null) competitionAssistRankingStamp.unregister();
			}
		}
	}
}