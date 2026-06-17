package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayerTraceDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TraceTableRow;
import rlp.footrix.protrix.types.ProtrixPlayer;
import rlp.footrix.protrix.types.player.ProtrixSkills;

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
		Team playerTeam = box().application().teamManager().get(player.team().definition().id());
		name.value(player.definition().name());
		team.value(playerTeam.definition().name());
		position.value(player.mainPosition().id());
		role.value(playerTeam.contractOf(player.definition().id()).role().name());
		stamina.value(((ProtrixSkills) player.skills()).stamina());
		injuryResistance.value(player.definition().injuryResistance().name());
	}

	private void initTable() {
		traceTable.source(new PlayerTraceDatasource(box(), player.definition().id()));
		traceTable.onAddItem(this::renderTableItem);
	}

	private void renderTableItem(AddCollectionItemEvent event) {
		PlayerMatchRecord record = event.item();
		TraceTableRow row = event.component();
		//row.matchTraceMold.matchTrace.value(record.match());
		row.dateTraceMold.dateTrace.value(record.date());
		//row.positionTraceMold.positionTrace.value(record.position() == null ? "" : record.position().id());
		row.preEnergyTraceMold.preEnergyTrace.value(record.preEnergy());
		//row.postEnergyTraceMold.postEnergyTrace.value(record.postEnergy());
		//row.preHappinessTraceMold.preHappinessTrace.value(record.preHappiness());
		//row.postHappinessTraceMold.postHappinessTrace.value(record.postHappiness());
		row.expelledTraceMold.expelledTrace.value(record.expelled() ? "Sí" : "");
		row.injuredTraceMold.injuredTrace.value(record.injured() ? "Sí" : "");
		row.enterMinuteTraceMold.enterMinuteTrace.value(record.enterMinute() == null ? "" : String.valueOf(record.enterMinute()));
		row.exitMinuteTraceMold.exitMinuteTrace.value(record.exitMinute() == null ? "" : String.valueOf(record.exitMinute()));
		//row.noteTraceMold.noteTrace.value(record.note());
	}
}