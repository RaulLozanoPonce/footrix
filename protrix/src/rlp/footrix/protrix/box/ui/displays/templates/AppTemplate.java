package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.PlayerRegistration;
import rlp.footrix.framework.types.Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayersDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.PlayersTableRow;
import rlp.footrix.protrix.model.ProtrixPlayer;

public class AppTemplate extends AbstractAppTemplate<ProtrixBox> {

	private final PlayersDatasource datasource;

	public AppTemplate(ProtrixBox box) {
		super(box);
		this.datasource = new PlayersDatasource(box);
	}

	@Override
	public void init() {
		super.init();
		initTable();
	}

	private void initTable() {
		playersTable.source(datasource);
		playersTable.onAddItem(this::renderTableItem);
	}

	private void renderTableItem(AddCollectionItemEvent event) {
		ProtrixPlayer player = event.item();
		PlayersTableRow row = event.component();
		Team team = box().application().teamManager().get(player.team());
		PlayerRegistration registration = team == null ? null : team.registrationOf(player.definition().id());
		row.idMold.id.value(Double.parseDouble(player.definition().id()));
		row.nameMold.name.title(player.definition().name());
		row.nameMold.name.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + player.definition().id()));
		row.teamMold.team.value(team == null ? "Agente Libre" : team.definition().name());
		row.roleMold.role.value(team == null ? "" : team.contractOf(player.definition().id()).role().name());
		row.overallMold.overall.value(player.overall());
		row.positionMold.position.value(player.mainPosition().name());
		row.staminaMold.stamina.value(player.stamina());
		row.happinessMold.happiness.value(Math.round(player.mood().gameTime() * 100.0) / 100.0);
		row.minutesMold.minutes.value(registration == null ? null : registration.percentMinutes("ESP-1"));
	}
}