package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.PlayerClassification;
import rlp.footrix.framework.types.PlayerRegistration;
import rlp.footrix.framework.types.Team;
import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayersDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.PlayersTableRow;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.Statistics;

import java.time.Instant;

public class AppTemplate extends AbstractAppTemplate<ProtrixBox> {

	private final PlayersDatasource datasource;

	public AppTemplate(ProtrixBox box) {
		super(box);
		this.datasource = new PlayersDatasource(box);
	}

	@Override
	public void init() {
		super.init();
		initButtons();
		initTable();
	}

	private void initButtons() {
		oneDay.onExecute(e -> {
			box().application().setDate(Instant.ofEpochMilli(box().application().getDate().toEpochMilli() + 24 * 60 * 60 * 1000));
			playersTable.reload();
		});
		oneSeason.onExecute(e -> {
			box().application().setDate(Instant.parse("2025-08-01T00:00:00Z"));
			System.out.println(Statistics.toText());
			System.out.println("-----------------------------------------------------------------------------------------");
			for (CompetitionDefinition.PhaseDefinition.GroupDefinition.TeamClassification classification : box().application().competitionManager().classificationOf("ESP-1", "season1", 0, 0)) {
				System.out.println(classification.teamName() + " - " + classification.points() + " - " + classification.goalsFor() + " - " + classification.goalsAgainst());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : box().application().statisticTables().scorersOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + classification.score());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : box().application().statisticTables().assistantsOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + classification.score());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : box().application().statisticTables().bestGoalkeepersOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + (classification.score() * 90));
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : box().application().statisticTables().bestPlayer("season1", 10)) {
				System.out.println(classification.id() + " - " + classification.name() + " - " + classification.score());
			}
			playersTable.reload();
		});
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
		row.nameMold.name.value(player.definition().name());
		row.teamMold.team.value(team == null ? "Agente Libre" : team.definition().name());
		row.roleMold.role.value(team == null ? "" : team.contractOf(player.definition().id()).role().name());
		row.overallMold.overall.value(player.overall());
		row.positionMold.position.value(player.mainPosition().name());
		row.energyMold.energy.value(player.energy());
		row.staminaMold.stamina.value(player.stamina());
		row.happinessMold.happiness.value(Math.round(player.mood().gameTime() * 100.0) / 100.0);
		row.minutesMold.minutes.value(registration == null ? null : registration.percentMinutes("ESP-1"));
		row.injuriesMold.injuries.value(registration == null ? null : registration.injuries());
		row.sanctionsMold.sanctions.value(registration == null ? null : registration.sanctions());
	}
}