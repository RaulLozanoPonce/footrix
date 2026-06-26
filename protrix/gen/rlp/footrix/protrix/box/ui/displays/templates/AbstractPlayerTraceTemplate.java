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

public abstract class AbstractPlayerTraceTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _6_1_11927463111 _6_1_11927463111;
	public PlayerTraceTemplate._6_1_11927463111. Name name;
	public PlayerTraceTemplate._6_1_11927463111. Team team;
	public _13_1_1772695501 _13_1_1772695501;
	public PlayerTraceTemplate._13_1_1772695501. TraceTable traceTable;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. DateTraceHeading dateTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.DateTraceHeading. _18_31_11963926487 _18_31_11963926487;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. EnergyTraceHeading energyTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.EnergyTraceHeading. _21_33_0543109713 _21_33_0543109713;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. PhysicalConditionTraceHeading physicalConditionTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.PhysicalConditionTraceHeading. _24_44_11186804819 _24_44_11186804819;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. SelfConfidenceTraceHeading selfConfidenceTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.SelfConfidenceTraceHeading. _27_41_0595313285 _27_41_0595313285;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. ContractSatisfactionTraceHeading contractSatisfactionTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.ContractSatisfactionTraceHeading. _30_47_11291196770 _30_47_11291196770;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. GameTimeSatisfactionTraceHeading gameTimeSatisfactionTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.GameTimeSatisfactionTraceHeading. _33_47_11374359407 _33_47_11374359407;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. CollectivePerformanceTraceHeading collectivePerformanceTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.CollectivePerformanceTraceHeading. _36_48_0481171246 _36_48_0481171246;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. MinuteTraceHeading minuteTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.MinuteTraceHeading. _39_33_11663985791 _39_33_11663985791;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. StaminaTraceHeading staminaTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.StaminaTraceHeading. _42_34_1819618469 _42_34_1819618469;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable. InjuredTraceHeading injuredTraceHeading;
	public PlayerTraceTemplate._13_1_1772695501.TraceTable.InjuredTraceHeading. _45_34_01148500010 _45_34_01148500010;

	public AbstractPlayerTraceTemplate(B box) {
		super(box);
		id("playerTraceTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_11927463111 == null) _6_1_11927463111 = register(new _6_1_11927463111(box()).<_6_1_11927463111>id("a1096816648").owner(AbstractPlayerTraceTemplate.this));
		if (_6_1_11927463111 != null) name = _6_1_11927463111.name;
		if (_6_1_11927463111 != null) team = _6_1_11927463111.team;
		if (_13_1_1772695501 == null) _13_1_1772695501 = register(new _13_1_1772695501(box()).<_13_1_1772695501>id("a_1029523023").owner(AbstractPlayerTraceTemplate.this));
		if (_13_1_1772695501 != null) traceTable = _13_1_1772695501.traceTable;
		if (traceTable != null) dateTraceHeading = _13_1_1772695501.traceTable.dateTraceHeading;
		if (dateTraceHeading != null) _18_31_11963926487 = _13_1_1772695501.traceTable.dateTraceHeading._18_31_11963926487;
		if (traceTable != null) energyTraceHeading = _13_1_1772695501.traceTable.energyTraceHeading;
		if (energyTraceHeading != null) _21_33_0543109713 = _13_1_1772695501.traceTable.energyTraceHeading._21_33_0543109713;
		if (traceTable != null) physicalConditionTraceHeading = _13_1_1772695501.traceTable.physicalConditionTraceHeading;
		if (physicalConditionTraceHeading != null) _24_44_11186804819 = _13_1_1772695501.traceTable.physicalConditionTraceHeading._24_44_11186804819;
		if (traceTable != null) selfConfidenceTraceHeading = _13_1_1772695501.traceTable.selfConfidenceTraceHeading;
		if (selfConfidenceTraceHeading != null) _27_41_0595313285 = _13_1_1772695501.traceTable.selfConfidenceTraceHeading._27_41_0595313285;
		if (traceTable != null) contractSatisfactionTraceHeading = _13_1_1772695501.traceTable.contractSatisfactionTraceHeading;
		if (contractSatisfactionTraceHeading != null) _30_47_11291196770 = _13_1_1772695501.traceTable.contractSatisfactionTraceHeading._30_47_11291196770;
		if (traceTable != null) gameTimeSatisfactionTraceHeading = _13_1_1772695501.traceTable.gameTimeSatisfactionTraceHeading;
		if (gameTimeSatisfactionTraceHeading != null) _33_47_11374359407 = _13_1_1772695501.traceTable.gameTimeSatisfactionTraceHeading._33_47_11374359407;
		if (traceTable != null) collectivePerformanceTraceHeading = _13_1_1772695501.traceTable.collectivePerformanceTraceHeading;
		if (collectivePerformanceTraceHeading != null) _36_48_0481171246 = _13_1_1772695501.traceTable.collectivePerformanceTraceHeading._36_48_0481171246;
		if (traceTable != null) minuteTraceHeading = _13_1_1772695501.traceTable.minuteTraceHeading;
		if (minuteTraceHeading != null) _39_33_11663985791 = _13_1_1772695501.traceTable.minuteTraceHeading._39_33_11663985791;
		if (traceTable != null) staminaTraceHeading = _13_1_1772695501.traceTable.staminaTraceHeading;
		if (staminaTraceHeading != null) _42_34_1819618469 = _13_1_1772695501.traceTable.staminaTraceHeading._42_34_1819618469;
		if (traceTable != null) injuredTraceHeading = _13_1_1772695501.traceTable.injuredTraceHeading;
		if (injuredTraceHeading != null) _45_34_01148500010 = _13_1_1772695501.traceTable.injuredTraceHeading._45_34_01148500010;
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_11927463111 != null) _6_1_11927463111.unregister();
		if (_13_1_1772695501 != null) _13_1_1772695501.unregister();
	}

	public class _6_1_11927463111 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public PlayerTraceTemplate._6_1_11927463111. Name name;
		public PlayerTraceTemplate._6_1_11927463111. Team team;

		public _6_1_11927463111(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (name == null) name = register(new Name(box()).<Name>id("a_528451299").owner(AbstractPlayerTraceTemplate.this));
			if (team == null) team = register(new Team(box()).<Team>id("a_528269073").owner(AbstractPlayerTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (name != null) name.unregister();
			if (team != null) team.unregister();
		}

		public class Name extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Name(B box) {
				super(box);
				label("Nombre:");
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

		public class Team extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Team(B box) {
				super(box);
				label("Equipo:");
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

	public class _13_1_1772695501 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public PlayerTraceTemplate._13_1_1772695501. TraceTable traceTable;

		public _13_1_1772695501(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (traceTable == null) traceTable = register(new TraceTable(box()).<TraceTable>id("a2088584665").owner(AbstractPlayerTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (traceTable != null) traceTable.unregister();
		}

		public class TraceTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.protrix.model.PlayerDayRecord>  {
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. DateTraceHeading dateTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. EnergyTraceHeading energyTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. PhysicalConditionTraceHeading physicalConditionTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. SelfConfidenceTraceHeading selfConfidenceTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. ContractSatisfactionTraceHeading contractSatisfactionTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. GameTimeSatisfactionTraceHeading gameTimeSatisfactionTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. CollectivePerformanceTraceHeading collectivePerformanceTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. MinuteTraceHeading minuteTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. StaminaTraceHeading staminaTraceHeading;
			public PlayerTraceTemplate._13_1_1772695501.TraceTable. InjuredTraceHeading injuredTraceHeading;

			public TraceTable(B box) {
				super(box);

				_pageSize(20);
			}

			@Override
			public void init() {
				super.init();
				if (dateTraceHeading == null) dateTraceHeading = register(new DateTraceHeading(box()).<DateTraceHeading>id("a1748817365").owner(AbstractPlayerTraceTemplate.this));
				if (energyTraceHeading == null) energyTraceHeading = register(new EnergyTraceHeading(box()).<EnergyTraceHeading>id("a1710540311").owner(AbstractPlayerTraceTemplate.this));
				if (physicalConditionTraceHeading == null) physicalConditionTraceHeading = register(new PhysicalConditionTraceHeading(box()).<PhysicalConditionTraceHeading>id("a_1622891662").owner(AbstractPlayerTraceTemplate.this));
				if (selfConfidenceTraceHeading == null) selfConfidenceTraceHeading = register(new SelfConfidenceTraceHeading(box()).<SelfConfidenceTraceHeading>id("a642329919").owner(AbstractPlayerTraceTemplate.this));
				if (contractSatisfactionTraceHeading == null) contractSatisfactionTraceHeading = register(new ContractSatisfactionTraceHeading(box()).<ContractSatisfactionTraceHeading>id("a_1764218588").owner(AbstractPlayerTraceTemplate.this));
				if (gameTimeSatisfactionTraceHeading == null) gameTimeSatisfactionTraceHeading = register(new GameTimeSatisfactionTraceHeading(box()).<GameTimeSatisfactionTraceHeading>id("a_232598567").owner(AbstractPlayerTraceTemplate.this));
				if (collectivePerformanceTraceHeading == null) collectivePerformanceTraceHeading = register(new CollectivePerformanceTraceHeading(box()).<CollectivePerformanceTraceHeading>id("a445678449").owner(AbstractPlayerTraceTemplate.this));
				if (minuteTraceHeading == null) minuteTraceHeading = register(new MinuteTraceHeading(box()).<MinuteTraceHeading>id("a185777872").owner(AbstractPlayerTraceTemplate.this));
				if (staminaTraceHeading == null) staminaTraceHeading = register(new StaminaTraceHeading(box()).<StaminaTraceHeading>id("a_1623069735").owner(AbstractPlayerTraceTemplate.this));
				if (injuredTraceHeading == null) injuredTraceHeading = register(new InjuredTraceHeading(box()).<InjuredTraceHeading>id("a_1077997682").owner(AbstractPlayerTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (dateTraceHeading != null) dateTraceHeading.unregister();
				if (energyTraceHeading != null) energyTraceHeading.unregister();
				if (physicalConditionTraceHeading != null) physicalConditionTraceHeading.unregister();
				if (selfConfidenceTraceHeading != null) selfConfidenceTraceHeading.unregister();
				if (contractSatisfactionTraceHeading != null) contractSatisfactionTraceHeading.unregister();
				if (gameTimeSatisfactionTraceHeading != null) gameTimeSatisfactionTraceHeading.unregister();
				if (collectivePerformanceTraceHeading != null) collectivePerformanceTraceHeading.unregister();
				if (minuteTraceHeading != null) minuteTraceHeading.unregister();
				if (staminaTraceHeading != null) staminaTraceHeading.unregister();
				if (injuredTraceHeading != null) injuredTraceHeading.unregister();
			}


			public TraceTableRow create(rlp.footrix.protrix.model.PlayerDayRecord item) {
				TraceTableRow row = new TraceTableRow((ProtrixBox)box());
				row.id(java.util.UUID.randomUUID().toString());
				row.item(item);
				return row;
			}
			public class DateTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.DateTraceHeading. _18_31_11963926487 _18_31_11963926487;

				public DateTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_18_31_11963926487 == null) _18_31_11963926487 = register(new _18_31_11963926487(box()).<_18_31_11963926487>id("a976934862").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_18_31_11963926487 != null) _18_31_11963926487.unregister();
				}

				public class _18_31_11963926487 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _18_31_11963926487(B box) {
						super(box);
						_value("Fecha");
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

			public class EnergyTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.EnergyTraceHeading. _21_33_0543109713 _21_33_0543109713;

				public EnergyTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_21_33_0543109713 == null) _21_33_0543109713 = register(new _21_33_0543109713(box()).<_21_33_0543109713>id("a1310270489").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_21_33_0543109713 != null) _21_33_0543109713.unregister();
				}

				public class _21_33_0543109713 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _21_33_0543109713(B box) {
						super(box);
						_value("Energía");
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

			public class PhysicalConditionTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.PhysicalConditionTraceHeading. _24_44_11186804819 _24_44_11186804819;

				public PhysicalConditionTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_24_44_11186804819 == null) _24_44_11186804819 = register(new _24_44_11186804819(box()).<_24_44_11186804819>id("a1762088959").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_24_44_11186804819 != null) _24_44_11186804819.unregister();
				}

				public class _24_44_11186804819 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _24_44_11186804819(B box) {
						super(box);
						_value("Estado fisico");
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

			public class SelfConfidenceTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.SelfConfidenceTraceHeading. _27_41_0595313285 _27_41_0595313285;

				public SelfConfidenceTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_27_41_0595313285 == null) _27_41_0595313285 = register(new _27_41_0595313285(box()).<_27_41_0595313285>id("a1078763010").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_27_41_0595313285 != null) _27_41_0595313285.unregister();
				}

				public class _27_41_0595313285 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _27_41_0595313285(B box) {
						super(box);
						_value("Confianza");
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

			public class ContractSatisfactionTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.ContractSatisfactionTraceHeading. _30_47_11291196770 _30_47_11291196770;

				public ContractSatisfactionTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_30_47_11291196770 == null) _30_47_11291196770 = register(new _30_47_11291196770(box()).<_30_47_11291196770>id("a_879068274").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_30_47_11291196770 != null) _30_47_11291196770.unregister();
				}

				public class _30_47_11291196770 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _30_47_11291196770(B box) {
						super(box);
						_value("Contrato");
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

			public class GameTimeSatisfactionTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.GameTimeSatisfactionTraceHeading. _33_47_11374359407 _33_47_11374359407;

				public GameTimeSatisfactionTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_33_47_11374359407 == null) _33_47_11374359407 = register(new _33_47_11374359407(box()).<_33_47_11374359407>id("a_789239906").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_33_47_11374359407 != null) _33_47_11374359407.unregister();
				}

				public class _33_47_11374359407 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _33_47_11374359407(B box) {
						super(box);
						_value("Tiempo de juego");
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

			public class CollectivePerformanceTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.CollectivePerformanceTraceHeading. _36_48_0481171246 _36_48_0481171246;

				public CollectivePerformanceTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_36_48_0481171246 == null) _36_48_0481171246 = register(new _36_48_0481171246(box()).<_36_48_0481171246>id("a_1548816746").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_36_48_0481171246 != null) _36_48_0481171246.unregister();
				}

				public class _36_48_0481171246 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _36_48_0481171246(B box) {
						super(box);
						_value("Rendimiento colectivo");
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

			public class MinuteTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.MinuteTraceHeading. _39_33_11663985791 _39_33_11663985791;

				public MinuteTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_39_33_11663985791 == null) _39_33_11663985791 = register(new _39_33_11663985791(box()).<_39_33_11663985791>id("a514563286").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_39_33_11663985791 != null) _39_33_11663985791.unregister();
				}

				public class _39_33_11663985791 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _39_33_11663985791(B box) {
						super(box);
						_value("Minutos");
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

			public class StaminaTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.StaminaTraceHeading. _42_34_1819618469 _42_34_1819618469;

				public StaminaTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_42_34_1819618469 == null) _42_34_1819618469 = register(new _42_34_1819618469(box()).<_42_34_1819618469>id("a226776927").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_42_34_1819618469 != null) _42_34_1819618469.unregister();
				}

				public class _42_34_1819618469 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _42_34_1819618469(B box) {
						super(box);
						_value("Stamina");
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

			public class InjuredTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerTraceTemplate._13_1_1772695501.TraceTable.InjuredTraceHeading. _45_34_01148500010 _45_34_01148500010;

				public InjuredTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_45_34_01148500010 == null) _45_34_01148500010 = register(new _45_34_01148500010(box()).<_45_34_01148500010>id("a_541375104").owner(AbstractPlayerTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_45_34_01148500010 != null) _45_34_01148500010.unregister();
				}

				public class _45_34_01148500010 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _45_34_01148500010(B box) {
						super(box);
						_value("Lesionado");
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