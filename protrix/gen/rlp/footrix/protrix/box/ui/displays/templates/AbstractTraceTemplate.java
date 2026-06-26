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

public abstract class AbstractTraceTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _6_1_1358296697 _6_1_1358296697;
	public TraceTemplate._6_1_1358296697. TeamGroup teamGroup;
	public TraceTemplate._6_1_1358296697. RoleGroup roleGroup;
	public TraceTemplate._6_1_1358296697. RetiredGroup retiredGroup;
	public TraceTemplate._6_1_1358296697. PositionGroup positionGroup;
	public PlayersTable playersTable;
	public TraceTemplate.PlayersTable. IdHeading idHeading;
	public TraceTemplate.PlayersTable.IdHeading. _15_23_0528114973 _15_23_0528114973;
	public TraceTemplate.PlayersTable. NameHeading nameHeading;
	public TraceTemplate.PlayersTable.NameHeading. _18_25_0871825099 _18_25_0871825099;
	public TraceTemplate.PlayersTable. TeamHeading teamHeading;
	public TraceTemplate.PlayersTable.TeamHeading. _21_25_081889217 _21_25_081889217;
	public TraceTemplate.PlayersTable. AgeHeading ageHeading;
	public TraceTemplate.PlayersTable.AgeHeading. _24_24_0599766148 _24_24_0599766148;
	public TraceTemplate.PlayersTable. RoleHeading roleHeading;
	public TraceTemplate.PlayersTable.RoleHeading. _27_25_1799594693 _27_25_1799594693;
	public TraceTemplate.PlayersTable. OverallHeading overallHeading;
	public TraceTemplate.PlayersTable.OverallHeading. _30_28_145414704 _30_28_145414704;
	public TraceTemplate.PlayersTable. PositionHeading positionHeading;
	public TraceTemplate.PlayersTable.PositionHeading. _33_29_11021592868 _33_29_11021592868;
	public TraceTemplate.PlayersTable. HappinessContractHeading happinessContractHeading;
	public TraceTemplate.PlayersTable.HappinessContractHeading. _36_38_01137533486 _36_38_01137533486;
	public TraceTemplate.PlayersTable. HappinessGameTimeHeading happinessGameTimeHeading;
	public TraceTemplate.PlayersTable.HappinessGameTimeHeading. _39_38_12007587061 _39_38_12007587061;
	public TraceTemplate.PlayersTable. HappinessIndividualHeading happinessIndividualHeading;
	public TraceTemplate.PlayersTable.HappinessIndividualHeading. _42_40_02129723915 _42_40_02129723915;
	public TraceTemplate.PlayersTable. HappinessCollectiveHeading happinessCollectiveHeading;
	public TraceTemplate.PlayersTable.HappinessCollectiveHeading. _45_40_01135686444 _45_40_01135686444;
	public TraceTemplate.PlayersTable. MinutesHeading minutesHeading;
	public TraceTemplate.PlayersTable.MinutesHeading. _48_28_0525848540 _48_28_0525848540;
	public TraceTemplate.PlayersTable. ScoreHeading scoreHeading;
	public TraceTemplate.PlayersTable.ScoreHeading. _51_26_11210290641 _51_26_11210290641;
	public TraceTemplate.PlayersTable. CacheIniHeading cacheIniHeading;
	public TraceTemplate.PlayersTable.CacheIniHeading. _54_29_0474689590 _54_29_0474689590;
	public TraceTemplate.PlayersTable. CacheHeading cacheHeading;
	public TraceTemplate.PlayersTable.CacheHeading. _57_26_11940065268 _57_26_11940065268;

	public AbstractTraceTemplate(B box) {
		super(box);
		id("traceTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_1358296697 == null) _6_1_1358296697 = register(new _6_1_1358296697(box()).<_6_1_1358296697>id("a_1121862111").owner(AbstractTraceTemplate.this));
		if (_6_1_1358296697 != null) teamGroup = _6_1_1358296697.teamGroup;
		if (_6_1_1358296697 != null) roleGroup = _6_1_1358296697.roleGroup;
		if (_6_1_1358296697 != null) retiredGroup = _6_1_1358296697.retiredGroup;
		if (_6_1_1358296697 != null) positionGroup = _6_1_1358296697.positionGroup;
		if (playersTable == null) playersTable = register(new PlayersTable(box()).<PlayersTable>id("a1279557691").owner(AbstractTraceTemplate.this));
		if (playersTable != null) idHeading = playersTable.idHeading;
		if (idHeading != null) _15_23_0528114973 = playersTable.idHeading._15_23_0528114973;
		if (playersTable != null) nameHeading = playersTable.nameHeading;
		if (nameHeading != null) _18_25_0871825099 = playersTable.nameHeading._18_25_0871825099;
		if (playersTable != null) teamHeading = playersTable.teamHeading;
		if (teamHeading != null) _21_25_081889217 = playersTable.teamHeading._21_25_081889217;
		if (playersTable != null) ageHeading = playersTable.ageHeading;
		if (ageHeading != null) _24_24_0599766148 = playersTable.ageHeading._24_24_0599766148;
		if (playersTable != null) roleHeading = playersTable.roleHeading;
		if (roleHeading != null) _27_25_1799594693 = playersTable.roleHeading._27_25_1799594693;
		if (playersTable != null) overallHeading = playersTable.overallHeading;
		if (overallHeading != null) _30_28_145414704 = playersTable.overallHeading._30_28_145414704;
		if (playersTable != null) positionHeading = playersTable.positionHeading;
		if (positionHeading != null) _33_29_11021592868 = playersTable.positionHeading._33_29_11021592868;
		if (playersTable != null) happinessContractHeading = playersTable.happinessContractHeading;
		if (happinessContractHeading != null) _36_38_01137533486 = playersTable.happinessContractHeading._36_38_01137533486;
		if (playersTable != null) happinessGameTimeHeading = playersTable.happinessGameTimeHeading;
		if (happinessGameTimeHeading != null) _39_38_12007587061 = playersTable.happinessGameTimeHeading._39_38_12007587061;
		if (playersTable != null) happinessIndividualHeading = playersTable.happinessIndividualHeading;
		if (happinessIndividualHeading != null) _42_40_02129723915 = playersTable.happinessIndividualHeading._42_40_02129723915;
		if (playersTable != null) happinessCollectiveHeading = playersTable.happinessCollectiveHeading;
		if (happinessCollectiveHeading != null) _45_40_01135686444 = playersTable.happinessCollectiveHeading._45_40_01135686444;
		if (playersTable != null) minutesHeading = playersTable.minutesHeading;
		if (minutesHeading != null) _48_28_0525848540 = playersTable.minutesHeading._48_28_0525848540;
		if (playersTable != null) scoreHeading = playersTable.scoreHeading;
		if (scoreHeading != null) _51_26_11210290641 = playersTable.scoreHeading._51_26_11210290641;
		if (playersTable != null) cacheIniHeading = playersTable.cacheIniHeading;
		if (cacheIniHeading != null) _54_29_0474689590 = playersTable.cacheIniHeading._54_29_0474689590;
		if (playersTable != null) cacheHeading = playersTable.cacheHeading;
		if (cacheHeading != null) _57_26_11940065268 = playersTable.cacheHeading._57_26_11940065268;

		if (teamGroup != null) teamGroup.bindTo(playersTable);
		if (roleGroup != null) roleGroup.bindTo(playersTable);
		if (retiredGroup != null) retiredGroup.bindTo(playersTable);
		if (positionGroup != null) positionGroup.bindTo(playersTable);
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_1358296697 != null) _6_1_1358296697.unregister();
		if (playersTable != null) playersTable.unregister();
	}

	public class _6_1_1358296697 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TraceTemplate._6_1_1358296697. TeamGroup teamGroup;
		public TraceTemplate._6_1_1358296697. RoleGroup roleGroup;
		public TraceTemplate._6_1_1358296697. RetiredGroup retiredGroup;
		public TraceTemplate._6_1_1358296697. PositionGroup positionGroup;

		public _6_1_1358296697(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (teamGroup == null) teamGroup = register(new TeamGroup(box()).<TeamGroup>id("a_1844878515").owner(AbstractTraceTemplate.this));
			if (roleGroup == null) roleGroup = register(new RoleGroup(box()).<RoleGroup>id("a_1333130028").owner(AbstractTraceTemplate.this));
			if (retiredGroup == null) retiredGroup = register(new RetiredGroup(box()).<RetiredGroup>id("a_514870453").owner(AbstractTraceTemplate.this));
			if (positionGroup == null) positionGroup = register(new PositionGroup(box()).<PositionGroup>id("a1909382785").owner(AbstractTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (teamGroup != null) teamGroup.unregister();
			if (roleGroup != null) roleGroup.unregister();
			if (retiredGroup != null) retiredGroup.unregister();
			if (positionGroup != null) positionGroup.unregister();
		}

		public class TeamGroup extends io.intino.alexandria.ui.displays.components.Grouping<io.intino.alexandria.ui.displays.notifiers.GroupingNotifier, B>  {

			public TeamGroup(B box) {
				super(box);
				label("Equipo");
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

		public class RoleGroup extends io.intino.alexandria.ui.displays.components.Grouping<io.intino.alexandria.ui.displays.notifiers.GroupingNotifier, B>  {

			public RoleGroup(B box) {
				super(box);
				label("Rol");
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

		public class RetiredGroup extends io.intino.alexandria.ui.displays.components.Grouping<io.intino.alexandria.ui.displays.notifiers.GroupingNotifier, B>  {

			public RetiredGroup(B box) {
				super(box);
				label("Retirado");
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

		public class PositionGroup extends io.intino.alexandria.ui.displays.components.Grouping<io.intino.alexandria.ui.displays.notifiers.GroupingNotifier, B>  {

			public PositionGroup(B box) {
				super(box);
				label("Posicion");
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

	public class PlayersTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.pes6.types.Pes6Player>  {
		public TraceTemplate.PlayersTable. IdHeading idHeading;
		public TraceTemplate.PlayersTable. NameHeading nameHeading;
		public TraceTemplate.PlayersTable. TeamHeading teamHeading;
		public TraceTemplate.PlayersTable. AgeHeading ageHeading;
		public TraceTemplate.PlayersTable. RoleHeading roleHeading;
		public TraceTemplate.PlayersTable. OverallHeading overallHeading;
		public TraceTemplate.PlayersTable. PositionHeading positionHeading;
		public TraceTemplate.PlayersTable. HappinessContractHeading happinessContractHeading;
		public TraceTemplate.PlayersTable. HappinessGameTimeHeading happinessGameTimeHeading;
		public TraceTemplate.PlayersTable. HappinessIndividualHeading happinessIndividualHeading;
		public TraceTemplate.PlayersTable. HappinessCollectiveHeading happinessCollectiveHeading;
		public TraceTemplate.PlayersTable. MinutesHeading minutesHeading;
		public TraceTemplate.PlayersTable. ScoreHeading scoreHeading;
		public TraceTemplate.PlayersTable. CacheIniHeading cacheIniHeading;
		public TraceTemplate.PlayersTable. CacheHeading cacheHeading;

		public PlayersTable(B box) {
			super(box);

			_pageSize(30);
		}

		@Override
		public void init() {
			super.init();
			if (idHeading == null) idHeading = register(new IdHeading(box()).<IdHeading>id("a1999198844").owner(AbstractTraceTemplate.this));
			if (nameHeading == null) nameHeading = register(new NameHeading(box()).<NameHeading>id("a_1340998513").owner(AbstractTraceTemplate.this));
			if (teamHeading == null) teamHeading = register(new TeamHeading(box()).<TeamHeading>id("a_1225123179").owner(AbstractTraceTemplate.this));
			if (ageHeading == null) ageHeading = register(new AgeHeading(box()).<AgeHeading>id("a_845841104").owner(AbstractTraceTemplate.this));
			if (roleHeading == null) roleHeading = register(new RoleHeading(box()).<RoleHeading>id("a1394277346").owner(AbstractTraceTemplate.this));
			if (overallHeading == null) overallHeading = register(new OverallHeading(box()).<OverallHeading>id("a664278108").owner(AbstractTraceTemplate.this));
			if (positionHeading == null) positionHeading = register(new PositionHeading(box()).<PositionHeading>id("a1728251946").owner(AbstractTraceTemplate.this));
			if (happinessContractHeading == null) happinessContractHeading = register(new HappinessContractHeading(box()).<HappinessContractHeading>id("a1400210965").owner(AbstractTraceTemplate.this));
			if (happinessGameTimeHeading == null) happinessGameTimeHeading = register(new HappinessGameTimeHeading(box()).<HappinessGameTimeHeading>id("a_1253911867").owner(AbstractTraceTemplate.this));
			if (happinessIndividualHeading == null) happinessIndividualHeading = register(new HappinessIndividualHeading(box()).<HappinessIndividualHeading>id("a_753644749").owner(AbstractTraceTemplate.this));
			if (happinessCollectiveHeading == null) happinessCollectiveHeading = register(new HappinessCollectiveHeading(box()).<HappinessCollectiveHeading>id("a1872172955").owner(AbstractTraceTemplate.this));
			if (minutesHeading == null) minutesHeading = register(new MinutesHeading(box()).<MinutesHeading>id("a1208986318").owner(AbstractTraceTemplate.this));
			if (scoreHeading == null) scoreHeading = register(new ScoreHeading(box()).<ScoreHeading>id("a_147176093").owner(AbstractTraceTemplate.this));
			if (cacheIniHeading == null) cacheIniHeading = register(new CacheIniHeading(box()).<CacheIniHeading>id("a1267380400").owner(AbstractTraceTemplate.this));
			if (cacheHeading == null) cacheHeading = register(new CacheHeading(box()).<CacheHeading>id("a1571035565").owner(AbstractTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (idHeading != null) idHeading.unregister();
			if (nameHeading != null) nameHeading.unregister();
			if (teamHeading != null) teamHeading.unregister();
			if (ageHeading != null) ageHeading.unregister();
			if (roleHeading != null) roleHeading.unregister();
			if (overallHeading != null) overallHeading.unregister();
			if (positionHeading != null) positionHeading.unregister();
			if (happinessContractHeading != null) happinessContractHeading.unregister();
			if (happinessGameTimeHeading != null) happinessGameTimeHeading.unregister();
			if (happinessIndividualHeading != null) happinessIndividualHeading.unregister();
			if (happinessCollectiveHeading != null) happinessCollectiveHeading.unregister();
			if (minutesHeading != null) minutesHeading.unregister();
			if (scoreHeading != null) scoreHeading.unregister();
			if (cacheIniHeading != null) cacheIniHeading.unregister();
			if (cacheHeading != null) cacheHeading.unregister();
		}


		public PlayersTableRow create(rlp.footrix.pes6.types.Pes6Player item) {
			PlayersTableRow row = new PlayersTableRow((ProtrixBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class IdHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.IdHeading. _15_23_0528114973 _15_23_0528114973;

			public IdHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_15_23_0528114973 == null) _15_23_0528114973 = register(new _15_23_0528114973(box()).<_15_23_0528114973>id("a1865070155").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_15_23_0528114973 != null) _15_23_0528114973.unregister();
			}

			public class _15_23_0528114973 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _15_23_0528114973(B box) {
					super(box);
					_value("Id");
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

		public class NameHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.NameHeading. _18_25_0871825099 _18_25_0871825099;

			public NameHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_18_25_0871825099 == null) _18_25_0871825099 = register(new _18_25_0871825099(box()).<_18_25_0871825099>id("a_831420310").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_18_25_0871825099 != null) _18_25_0871825099.unregister();
			}

			public class _18_25_0871825099 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _18_25_0871825099(B box) {
					super(box);
					_value("Nombre");
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

		public class TeamHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.TeamHeading. _21_25_081889217 _21_25_081889217;

			public TeamHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_21_25_081889217 == null) _21_25_081889217 = register(new _21_25_081889217(box()).<_21_25_081889217>id("a158445463").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_21_25_081889217 != null) _21_25_081889217.unregister();
			}

			public class _21_25_081889217 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _21_25_081889217(B box) {
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

		public class AgeHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.AgeHeading. _24_24_0599766148 _24_24_0599766148;

			public AgeHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_24_24_0599766148 == null) _24_24_0599766148 = register(new _24_24_0599766148(box()).<_24_24_0599766148>id("a1700394483").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_24_24_0599766148 != null) _24_24_0599766148.unregister();
			}

			public class _24_24_0599766148 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _24_24_0599766148(B box) {
					super(box);
					_value("Edad");
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

		public class RoleHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.RoleHeading. _27_25_1799594693 _27_25_1799594693;

			public RoleHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_27_25_1799594693 == null) _27_25_1799594693 = register(new _27_25_1799594693(box()).<_27_25_1799594693>id("a2131353418").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_27_25_1799594693 != null) _27_25_1799594693.unregister();
			}

			public class _27_25_1799594693 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _27_25_1799594693(B box) {
					super(box);
					_value("Rol");
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

		public class OverallHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.OverallHeading. _30_28_145414704 _30_28_145414704;

			public OverallHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_30_28_145414704 == null) _30_28_145414704 = register(new _30_28_145414704(box()).<_30_28_145414704>id("a_258489373").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_30_28_145414704 != null) _30_28_145414704.unregister();
			}

			public class _30_28_145414704 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _30_28_145414704(B box) {
					super(box);
					_value("Media");
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

		public class PositionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.PositionHeading. _33_29_11021592868 _33_29_11021592868;

			public PositionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_33_29_11021592868 == null) _33_29_11021592868 = register(new _33_29_11021592868(box()).<_33_29_11021592868>id("a1406718648").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_33_29_11021592868 != null) _33_29_11021592868.unregister();
			}

			public class _33_29_11021592868 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _33_29_11021592868(B box) {
					super(box);
					_value("Posicion");
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

		public class HappinessContractHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.HappinessContractHeading. _36_38_01137533486 _36_38_01137533486;

			public HappinessContractHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_36_38_01137533486 == null) _36_38_01137533486 = register(new _36_38_01137533486(box()).<_36_38_01137533486>id("a1103462622").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_36_38_01137533486 != null) _36_38_01137533486.unregister();
			}

			public class _36_38_01137533486 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _36_38_01137533486(B box) {
					super(box);
					_value("Fel (Con.)");
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

		public class HappinessGameTimeHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.HappinessGameTimeHeading. _39_38_12007587061 _39_38_12007587061;

			public HappinessGameTimeHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_39_38_12007587061 == null) _39_38_12007587061 = register(new _39_38_12007587061(box()).<_39_38_12007587061>id("a_1744562745").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_39_38_12007587061 != null) _39_38_12007587061.unregister();
			}

			public class _39_38_12007587061 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _39_38_12007587061(B box) {
					super(box);
					_value("Fel (TJu.)");
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

		public class HappinessIndividualHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.HappinessIndividualHeading. _42_40_02129723915 _42_40_02129723915;

			public HappinessIndividualHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_42_40_02129723915 == null) _42_40_02129723915 = register(new _42_40_02129723915(box()).<_42_40_02129723915>id("a_1844568698").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_42_40_02129723915 != null) _42_40_02129723915.unregister();
			}

			public class _42_40_02129723915 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _42_40_02129723915(B box) {
					super(box);
					_value("Fel (Ind.)");
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

		public class HappinessCollectiveHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.HappinessCollectiveHeading. _45_40_01135686444 _45_40_01135686444;

			public HappinessCollectiveHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_45_40_01135686444 == null) _45_40_01135686444 = register(new _45_40_01135686444(box()).<_45_40_01135686444>id("a_1506521198").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_45_40_01135686444 != null) _45_40_01135686444.unregister();
			}

			public class _45_40_01135686444 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _45_40_01135686444(B box) {
					super(box);
					_value("Fel (Col.)");
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

		public class MinutesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.MinutesHeading. _48_28_0525848540 _48_28_0525848540;

			public MinutesHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_48_28_0525848540 == null) _48_28_0525848540 = register(new _48_28_0525848540(box()).<_48_28_0525848540>id("a2010885257").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_48_28_0525848540 != null) _48_28_0525848540.unregister();
			}

			public class _48_28_0525848540 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _48_28_0525848540(B box) {
					super(box);
					_value("Min. (%)");
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

		public class ScoreHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.ScoreHeading. _51_26_11210290641 _51_26_11210290641;

			public ScoreHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_51_26_11210290641 == null) _51_26_11210290641 = register(new _51_26_11210290641(box()).<_51_26_11210290641>id("a_1901586144").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_51_26_11210290641 != null) _51_26_11210290641.unregister();
			}

			public class _51_26_11210290641 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _51_26_11210290641(B box) {
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

		public class CacheIniHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.CacheIniHeading. _54_29_0474689590 _54_29_0474689590;

			public CacheIniHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_54_29_0474689590 == null) _54_29_0474689590 = register(new _54_29_0474689590(box()).<_54_29_0474689590>id("a1405743102").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_54_29_0474689590 != null) _54_29_0474689590.unregister();
			}

			public class _54_29_0474689590 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _54_29_0474689590(B box) {
					super(box);
					_value("Cache Ini (%)");
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

		public class CacheHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TraceTemplate.PlayersTable.CacheHeading. _57_26_11940065268 _57_26_11940065268;

			public CacheHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_57_26_11940065268 == null) _57_26_11940065268 = register(new _57_26_11940065268(box()).<_57_26_11940065268>id("a_615924017").owner(AbstractTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_57_26_11940065268 != null) _57_26_11940065268.unregister();
			}

			public class _57_26_11940065268 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _57_26_11940065268(B box) {
					super(box);
					_value("Cache (%)");
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