package rlp.footrix.protrix.box.ui.displays.rows;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.RowNotifier;

public class MinuteTraceTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.framework.types.records.PlayerMinuteRecord, ProtrixBox> {
	public MatchTraceMinuteMold matchTraceMinuteMold;
	public DateTraceMinuteMold dateTraceMinuteMold;
	public MinuteTraceMinuteMold minuteTraceMinuteMold;
	public StaminaTraceMinuteMold staminaTraceMinuteMold;
	public EnergyTraceMinuteMold energyTraceMinuteMold;

	public MinuteTraceTableRow(ProtrixBox box) {
		super(box);
		id("a_458556273");
	}

	@Override
	public void init() {
		super.init();
		if (matchTraceMinuteMold == null) matchTraceMinuteMold = register(new MatchTraceMinuteMold((ProtrixBox)box()).<MatchTraceMinuteMold>id("a_1326924199").<MatchTraceMinuteMold>item(MinuteTraceTableRow.this.item()).owner(MinuteTraceTableRow.this));
		if (dateTraceMinuteMold == null) dateTraceMinuteMold = register(new DateTraceMinuteMold((ProtrixBox)box()).<DateTraceMinuteMold>id("a713245149").<DateTraceMinuteMold>item(MinuteTraceTableRow.this.item()).owner(MinuteTraceTableRow.this));
		if (minuteTraceMinuteMold == null) minuteTraceMinuteMold = register(new MinuteTraceMinuteMold((ProtrixBox)box()).<MinuteTraceMinuteMold>id("a_510682182").<MinuteTraceMinuteMold>item(MinuteTraceTableRow.this.item()).owner(MinuteTraceTableRow.this));
		if (staminaTraceMinuteMold == null) staminaTraceMinuteMold = register(new StaminaTraceMinuteMold((ProtrixBox)box()).<StaminaTraceMinuteMold>id("a844122961").<StaminaTraceMinuteMold>item(MinuteTraceTableRow.this.item()).owner(MinuteTraceTableRow.this));
		if (energyTraceMinuteMold == null) energyTraceMinuteMold = register(new EnergyTraceMinuteMold((ProtrixBox)box()).<EnergyTraceMinuteMold>id("a_233097247").<EnergyTraceMinuteMold>item(MinuteTraceTableRow.this.item()).owner(MinuteTraceTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}