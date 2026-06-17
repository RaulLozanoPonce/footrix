package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayersDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.PlayersTableRow;
import rlp.footrix.protrix.types.ProtrixPlayer;

import java.util.ArrayList;
import java.util.List;

public class TraceTemplate extends AbstractTraceTemplate<ProtrixBox> {
    private final PlayersDatasource datasource;

	public TraceTemplate(ProtrixBox box) {
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
        Team team = player.team();
        List<PlayerMatchRecord> records = team == null ? new ArrayList<>() : box().application().recordStore().playerMatchRecords(player.definition().id(), team.definition().id(), "ESP-1", 0);
        double score = records.stream().filter(e -> e.score() != null).mapToDouble(PlayerMatchRecord::score).average().orElse(0);
        double minutes = records.stream().filter(r -> r.playedAvailableMinutesPercent() != null).mapToDouble(PlayerMatchRecord::playedAvailableMinutesPercent).average().orElse(0.0);
        row.idMold.id.value(player.definition().id());
        row.nameMold.name.title(player.definition().name());
        row.nameMold.name.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + player.definition().id()));
        row.teamMold.team.value(team == null ? "Agente Libre" : team.definition().name());
        row.ageMold.age.value(String.valueOf(player.definition().age(box().application().getDate())));
        row.roleMold.role.value(team == null ? "" : team.contractOf(player.definition().id()).role().name());
        row.overallMold.overall.value(player.overall());
        row.positionMold.position.value(player.mainPosition().id());
        row.happinessGameTimeMold.happinessGameTime.value(Math.round(player.mood().gameTime() * 100.0) / 100.0);
        row.happinessContractMold.happinessContract.value(Math.round(player.mood().contract() * 100.0) / 100.0);
        row.happinessIndividualMold.happinessIndividual.value(Math.round(player.mood().individualPerformance() * 100.0) / 100.0);
        row.happinessCollectiveMold.happinessCollective.value(Math.round(player.mood().collectivePerformance() * 100.0) / 100.0);
        row.minutesMold.minutes.value(Math.round(minutes * 100.0) / 100.0);
        row.scoreMold.score.value(Math.round(score * 100.0) / 100.0);
        row.cacheIniMold.cacheIni.value(box().initialCaches().get(player.definition().id()));
        row.cacheMold.cache.value(player.cache().absoluteCache());
    }
}