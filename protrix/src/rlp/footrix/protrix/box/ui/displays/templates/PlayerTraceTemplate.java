package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayerTraceDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TraceTableRow;
import rlp.footrix.protrix.model.PlayerDayRecord;

public class PlayerTraceTemplate extends AbstractPlayerTraceTemplate<ProtrixBox> {
	private Pes6Player player;

	public PlayerTraceTemplate(ProtrixBox box) {
		super(box);
	}

	public PlayerTraceTemplate setPlayer(String playerId) {
		this.player = (Pes6Player) box().application().playerManager().get(playerId);
		initHeader();
		initTable();
		return this;
	}

	private void initHeader() {
		Team playerTeam = box().application().teamManager().get(player.team().definition().id());
		name.value(player.definition().name());
		team.value(playerTeam.definition().name());
	}

	private void initTable() {
		traceTable.source(new PlayerTraceDatasource(box(), player.definition().id()));
		traceTable.onAddItem(this::renderTableItem);
	}

	private void renderTableItem(AddCollectionItemEvent event) {
        PlayerDayRecord record = event.item();
		TraceTableRow row = event.component();
		row.dateTraceMold.dateTrace.value(record.ts());
        row.energyTraceMold.energyTrace.value(record.energy());
        row.physicalConditionTraceMold.physicalConditionTrace.value(record.physical());
        row.selfConfidenceTraceMold.selfConfidenceTrace.value(record.selfConfidence());
        row.contractSatisfactionTraceMold.contractSatisfactionTrace.value(record.contractSatisfaction());
        row.gameTimeSatisfactionTraceMold.gameTimeSatisfactionTrace.value(record.gameTimeSatisfaction());
        row.collectivePerformanceTraceMold.collectivePerformanceTrace.value(record.collectivePerformance());
        row.minuteTraceMold.minuteTrace.value(record.minutes());
        row.staminaTraceMold.staminaTrace.value(record.stamina());
		row.injuredTraceMold.injuredTrace.value(record.injured() ? "Sí" : "");
	}
}