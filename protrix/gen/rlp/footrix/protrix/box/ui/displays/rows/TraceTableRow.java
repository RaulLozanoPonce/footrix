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

public class TraceTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.protrix.model.PlayerDayRecord, ProtrixBox> {
	public DateTraceMold dateTraceMold;
	public EnergyTraceMold energyTraceMold;
	public PhysicalConditionTraceMold physicalConditionTraceMold;
	public SelfConfidenceTraceMold selfConfidenceTraceMold;
	public ContractSatisfactionTraceMold contractSatisfactionTraceMold;
	public GameTimeSatisfactionTraceMold gameTimeSatisfactionTraceMold;
	public CollectivePerformanceTraceMold collectivePerformanceTraceMold;
	public MinuteTraceMold minuteTraceMold;
	public StaminaTraceMold staminaTraceMold;
	public InjuredTraceMold injuredTraceMold;

	public TraceTableRow(ProtrixBox box) {
		super(box);
		id("a1044982232");
	}

	@Override
	public void init() {
		super.init();
		if (dateTraceMold == null) dateTraceMold = register(new DateTraceMold((ProtrixBox)box()).<DateTraceMold>id("a_869127257").<DateTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (energyTraceMold == null) energyTraceMold = register(new EnergyTraceMold((ProtrixBox)box()).<EnergyTraceMold>id("a_1479544155").<EnergyTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (physicalConditionTraceMold == null) physicalConditionTraceMold = register(new PhysicalConditionTraceMold((ProtrixBox)box()).<PhysicalConditionTraceMold>id("a_1380611286").<PhysicalConditionTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (selfConfidenceTraceMold == null) selfConfidenceTraceMold = register(new SelfConfidenceTraceMold((ProtrixBox)box()).<SelfConfidenceTraceMold>id("a_1797186435").<SelfConfidenceTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (contractSatisfactionTraceMold == null) contractSatisfactionTraceMold = register(new ContractSatisfactionTraceMold((ProtrixBox)box()).<ContractSatisfactionTraceMold>id("a_487771464").<ContractSatisfactionTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (gameTimeSatisfactionTraceMold == null) gameTimeSatisfactionTraceMold = register(new GameTimeSatisfactionTraceMold((ProtrixBox)box()).<GameTimeSatisfactionTraceMold>id("a979930147").<GameTimeSatisfactionTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (collectivePerformanceTraceMold == null) collectivePerformanceTraceMold = register(new CollectivePerformanceTraceMold((ProtrixBox)box()).<CollectivePerformanceTraceMold>id("a_1544895605").<CollectivePerformanceTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (minuteTraceMold == null) minuteTraceMold = register(new MinuteTraceMold((ProtrixBox)box()).<MinuteTraceMold>id("a_451519348").<MinuteTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (staminaTraceMold == null) staminaTraceMold = register(new StaminaTraceMold((ProtrixBox)box()).<StaminaTraceMold>id("a_1084197853").<StaminaTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
		if (injuredTraceMold == null) injuredTraceMold = register(new InjuredTraceMold((ProtrixBox)box()).<InjuredTraceMold>id("a_698092402").<InjuredTraceMold>item(TraceTableRow.this.item()).owner(TraceTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}