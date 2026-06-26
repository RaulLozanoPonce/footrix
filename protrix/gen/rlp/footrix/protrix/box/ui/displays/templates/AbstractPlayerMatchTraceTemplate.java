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

public abstract class AbstractPlayerMatchTraceTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _6_1_01792067350 _6_1_01792067350;
	public PlayerMatchTraceTemplate._6_1_01792067350. Name name;
	public PlayerMatchTraceTemplate._6_1_01792067350. Stamina stamina;
	public _9_1_11980922182 _9_1_11980922182;
	public PlayerMatchTraceTemplate._9_1_11980922182. MinuteTraceTable minuteTraceTable;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. MatchTraceHeading matchTraceHeading;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.MatchTraceHeading. _14_32_1338067379 _14_32_1338067379;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. DateTraceHeading dateTraceHeading;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.DateTraceHeading. _17_31_11963926487 _17_31_11963926487;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. MinuteTraceHeading minuteTraceHeading;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.MinuteTraceHeading. _20_33_11854794784 _20_33_11854794784;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. StaminaTraceHeading staminaTraceHeading;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.StaminaTraceHeading. _23_34_1819618469 _23_34_1819618469;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. EnergyTraceHeading energyTraceHeading;
	public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.EnergyTraceHeading. _26_33_0543109713 _26_33_0543109713;

	public AbstractPlayerMatchTraceTemplate(B box) {
		super(box);
		id("playerMatchTraceTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_01792067350 == null) _6_1_01792067350 = register(new _6_1_01792067350(box()).<_6_1_01792067350>id("a234232571").owner(AbstractPlayerMatchTraceTemplate.this));
		if (_6_1_01792067350 != null) name = _6_1_01792067350.name;
		if (_6_1_01792067350 != null) stamina = _6_1_01792067350.stamina;
		if (_9_1_11980922182 == null) _9_1_11980922182 = register(new _9_1_11980922182(box()).<_9_1_11980922182>id("a375994805").owner(AbstractPlayerMatchTraceTemplate.this));
		if (_9_1_11980922182 != null) minuteTraceTable = _9_1_11980922182.minuteTraceTable;
		if (minuteTraceTable != null) matchTraceHeading = _9_1_11980922182.minuteTraceTable.matchTraceHeading;
		if (matchTraceHeading != null) _14_32_1338067379 = _9_1_11980922182.minuteTraceTable.matchTraceHeading._14_32_1338067379;
		if (minuteTraceTable != null) dateTraceHeading = _9_1_11980922182.minuteTraceTable.dateTraceHeading;
		if (dateTraceHeading != null) _17_31_11963926487 = _9_1_11980922182.minuteTraceTable.dateTraceHeading._17_31_11963926487;
		if (minuteTraceTable != null) minuteTraceHeading = _9_1_11980922182.minuteTraceTable.minuteTraceHeading;
		if (minuteTraceHeading != null) _20_33_11854794784 = _9_1_11980922182.minuteTraceTable.minuteTraceHeading._20_33_11854794784;
		if (minuteTraceTable != null) staminaTraceHeading = _9_1_11980922182.minuteTraceTable.staminaTraceHeading;
		if (staminaTraceHeading != null) _23_34_1819618469 = _9_1_11980922182.minuteTraceTable.staminaTraceHeading._23_34_1819618469;
		if (minuteTraceTable != null) energyTraceHeading = _9_1_11980922182.minuteTraceTable.energyTraceHeading;
		if (energyTraceHeading != null) _26_33_0543109713 = _9_1_11980922182.minuteTraceTable.energyTraceHeading._26_33_0543109713;
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_01792067350 != null) _6_1_01792067350.unregister();
		if (_9_1_11980922182 != null) _9_1_11980922182.unregister();
	}

	public class _6_1_01792067350 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public PlayerMatchTraceTemplate._6_1_01792067350. Name name;
		public PlayerMatchTraceTemplate._6_1_01792067350. Stamina stamina;

		public _6_1_01792067350(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (name == null) name = register(new Name(box()).<Name>id("a762272800").owner(AbstractPlayerMatchTraceTemplate.this));
			if (stamina == null) stamina = register(new Stamina(box()).<Stamina>id("a2052656314").owner(AbstractPlayerMatchTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (name != null) name.unregister();
			if (stamina != null) stamina.unregister();
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

		public class Stamina extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, B>  {

			public Stamina(B box) {
				super(box);
				label("Resistencia:");
				_value(0.0);
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

	public class _9_1_11980922182 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public PlayerMatchTraceTemplate._9_1_11980922182. MinuteTraceTable minuteTraceTable;

		public _9_1_11980922182(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (minuteTraceTable == null) minuteTraceTable = register(new MinuteTraceTable(box()).<MinuteTraceTable>id("a_1078918161").owner(AbstractPlayerMatchTraceTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (minuteTraceTable != null) minuteTraceTable.unregister();
		}

		public class MinuteTraceTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.framework.types.records.PlayerMinuteRecord>  {
			public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. MatchTraceHeading matchTraceHeading;
			public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. DateTraceHeading dateTraceHeading;
			public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. MinuteTraceHeading minuteTraceHeading;
			public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. StaminaTraceHeading staminaTraceHeading;
			public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable. EnergyTraceHeading energyTraceHeading;

			public MinuteTraceTable(B box) {
				super(box);

				_pageSize(90);
			}

			@Override
			public void init() {
				super.init();
				if (matchTraceHeading == null) matchTraceHeading = register(new MatchTraceHeading(box()).<MatchTraceHeading>id("a_1962766761").owner(AbstractPlayerMatchTraceTemplate.this));
				if (dateTraceHeading == null) dateTraceHeading = register(new DateTraceHeading(box()).<DateTraceHeading>id("a1976457555").owner(AbstractPlayerMatchTraceTemplate.this));
				if (minuteTraceHeading == null) minuteTraceHeading = register(new MinuteTraceHeading(box()).<MinuteTraceHeading>id("a_1355639658").owner(AbstractPlayerMatchTraceTemplate.this));
				if (staminaTraceHeading == null) staminaTraceHeading = register(new StaminaTraceHeading(box()).<StaminaTraceHeading>id("a876012639").owner(AbstractPlayerMatchTraceTemplate.this));
				if (energyTraceHeading == null) energyTraceHeading = register(new EnergyTraceHeading(box()).<EnergyTraceHeading>id("a2085994959").owner(AbstractPlayerMatchTraceTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (matchTraceHeading != null) matchTraceHeading.unregister();
				if (dateTraceHeading != null) dateTraceHeading.unregister();
				if (minuteTraceHeading != null) minuteTraceHeading.unregister();
				if (staminaTraceHeading != null) staminaTraceHeading.unregister();
				if (energyTraceHeading != null) energyTraceHeading.unregister();
			}


			public MinuteTraceTableRow create(rlp.footrix.framework.types.records.PlayerMinuteRecord item) {
				MinuteTraceTableRow row = new MinuteTraceTableRow((ProtrixBox)box());
				row.id(java.util.UUID.randomUUID().toString());
				row.item(item);
				return row;
			}
			public class MatchTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.MatchTraceHeading. _14_32_1338067379 _14_32_1338067379;

				public MatchTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_14_32_1338067379 == null) _14_32_1338067379 = register(new _14_32_1338067379(box()).<_14_32_1338067379>id("a1076454342").owner(AbstractPlayerMatchTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_14_32_1338067379 != null) _14_32_1338067379.unregister();
				}

				public class _14_32_1338067379 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _14_32_1338067379(B box) {
						super(box);
						_value("Partido");
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

			public class DateTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.DateTraceHeading. _17_31_11963926487 _17_31_11963926487;

				public DateTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_17_31_11963926487 == null) _17_31_11963926487 = register(new _17_31_11963926487(box()).<_17_31_11963926487>id("a1775376817").owner(AbstractPlayerMatchTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_17_31_11963926487 != null) _17_31_11963926487.unregister();
				}

				public class _17_31_11963926487 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _17_31_11963926487(B box) {
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

			public class MinuteTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.MinuteTraceHeading. _20_33_11854794784 _20_33_11854794784;

				public MinuteTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_20_33_11854794784 == null) _20_33_11854794784 = register(new _20_33_11854794784(box()).<_20_33_11854794784>id("a1914480804").owner(AbstractPlayerMatchTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_20_33_11854794784 != null) _20_33_11854794784.unregister();
				}

				public class _20_33_11854794784 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _20_33_11854794784(B box) {
						super(box);
						_value("Minuto");
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
				public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.StaminaTraceHeading. _23_34_1819618469 _23_34_1819618469;

				public StaminaTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_23_34_1819618469 == null) _23_34_1819618469 = register(new _23_34_1819618469(box()).<_23_34_1819618469>id("a437397736").owner(AbstractPlayerMatchTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_23_34_1819618469 != null) _23_34_1819618469.unregister();
				}

				public class _23_34_1819618469 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _23_34_1819618469(B box) {
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

			public class EnergyTraceHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public PlayerMatchTraceTemplate._9_1_11980922182.MinuteTraceTable.EnergyTraceHeading. _26_33_0543109713 _26_33_0543109713;

				public EnergyTraceHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (_26_33_0543109713 == null) _26_33_0543109713 = register(new _26_33_0543109713(box()).<_26_33_0543109713>id("a772846870").owner(AbstractPlayerMatchTraceTemplate.this));
				}

				@Override
				public void unregister() {
					super.unregister();
					if (_26_33_0543109713 != null) _26_33_0543109713.unregister();
				}

				public class _26_33_0543109713 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public _26_33_0543109713(B box) {
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
		}
	}
}