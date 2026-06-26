package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.protrix.box.*;

import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.TopPlayerRecordDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TopGoalkeepersTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TopScorersTableRow;
import rlp.footrix.protrix.box.ui.displays.templates.AbstractCompetitionReceivedGoalRankingTemplate;
import rlp.footrix.protrix.model.PlayerRecord;

public class CompetitionReceivedGoalRankingTemplate extends AbstractCompetitionReceivedGoalRankingTemplate<ProtrixBox> {
    private final TopPlayerRecordDatasource datasource;

    private String competitionId;
    private int season;

    public CompetitionReceivedGoalRankingTemplate(ProtrixBox box) {
        super(box);
        this.datasource = new TopPlayerRecordDatasource(box);
    }

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public CompetitionReceivedGoalRankingTemplate setup(String competitionId, int season) {
        this.competitionId = competitionId;
        this.season = season;
        refreshTable();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        topGoalkeepersTable.source(datasource);
    }

    private void initTable() {
        topGoalkeepersTable.onAddItem(this::addTop);
    }

    private void refreshTable() {
        datasource.setup(competitionId, season, PlayerRecord.Type.ReceivedGoals);
        datasource.loadData();
        topGoalkeepersTable.reload();
    }

    private void addTop(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopGoalkeepersTableRow item = event.component();
        item.topGoalkeepersPositionMold.topGoalkeepersPosition.value(String.valueOf(datasource.indexOf(record) + 1));
        item.topGoalkeepersPlayerMold.topGoalkeepersPlayer.title(String.valueOf(record.playerName()));
        item.topGoalkeepersPlayerMold.topGoalkeepersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topGoalkeepersTeamMold.classificationTeam.value(record.teamName());
        item.topGoalkeepersPlayedMinutesMold.topGoalkeepersPlayedMinutes.value(String.valueOf((int) record.playedMinutes()));
        item.topGoalkeepersGoalsMold.topGoalkeepersGoals.value(String.valueOf(record.amount()));
    }
}