package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.var.PlayerMatchPerformance;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayerTraceDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TraceTableRow;
import rlp.footrix.protrix.model.ProtrixPlayer;

public class PlayerTraceTemplate extends AbstractPlayerTraceTemplate<ProtrixBox> {

	private ProtrixPlayer player;

	public PlayerTraceTemplate(ProtrixBox box) {
		super(box);
	}

	public PlayerTraceTemplate setPlayer(String playerId) {
		this.player = (ProtrixPlayer) box().application().playerManager().get(playerId);
		initHeader();
		initTable();
		return this;
	}

	private void initHeader() {
		Team playerTeam = box().application().teamManager().get(player.team());
		name.value(player.definition().name());
		team.value(playerTeam.definition().name());
		position.value(player.mainPosition().name());
		role.value(playerTeam.contractOf(player.definition().id()).role().name());
		stamina.value(player.stamina());
		injuryResistance.value(player.definition().injuryResistance().name());
	}

	private void initTable() {
		traceTable.source(new PlayerTraceDatasource(box(), player.definition().id()));
		traceTable.onAddItem(this::renderTableItem);
	}

	private void renderTableItem(AddCollectionItemEvent event) {
		PlayerMatchPerformance performance = event.item();
		TraceTableRow row = event.component();
		row.matchTraceMold.matchTrace.value(performance.match());
		row.dateTraceMold.dateTrace.value(performance.date());
		row.positionTraceMold.positionTrace.value(performance.position() == null ? "" : performance.position().name());
		row.preEnergyTraceMold.preEnergyTrace.value(performance.preEnergy());
		row.postEnergyTraceMold.postEnergyTrace.value(performance.postEnergy());
		row.preHappinessTraceMold.preHappinessTrace.value(performance.preHappiness());
		row.postHappinessTraceMold.postHappinessTrace.value(performance.postHappiness());
		row.expelledTraceMold.expelledTrace.value(performance.expelled() ? "Sí" : "");
		row.injuredTraceMold.injuredTrace.value(performance.injured() ? "Sí" : "");
		row.enterMinuteTraceMold.enterMinuteTrace.value(performance.enterMinute() == null ? "" : String.valueOf(performance.enterMinute()));
		row.exitMinuteTraceMold.exitMinuteTrace.value(performance.exitMinute() == null ? "" : String.valueOf(performance.exitMinute()));
		row.noteTraceMold.noteTrace.value(performance.note());
	}
}