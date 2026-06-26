package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.TopPlayerRecordDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TopScorersTableRow;
import rlp.footrix.protrix.model.PlayerRecord;

public class CompetitionGoalRankingTemplate extends AbstractCompetitionGoalRankingTemplate<ProtrixBox> {
    private final TopPlayerRecordDatasource datasource;

    private String competitionId;
    private int season;

    public CompetitionGoalRankingTemplate(ProtrixBox box) {
		super(box);
        this.datasource = new TopPlayerRecordDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public CompetitionGoalRankingTemplate setup(String competitionId, int season) {
        this.competitionId = competitionId;
        this.season = season;
        refreshTable();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        topScorersTable.source(datasource);
    }

    private void initTable() {
        topScorersTable.onAddItem(this::addTop);
    }

    private void refreshTable() {
        datasource.setup(competitionId, season, PlayerRecord.Type.Goal);
        datasource.loadData();
        topScorersTable.reload();
    }

    private void addTop(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopScorersTableRow item = event.component();
        item.topScorersPositionMold.topScorersPosition.value(String.valueOf(datasource.indexOf(record) + 1));
        item.topScorersPlayerMold.topScorersPlayer.title(String.valueOf(record.playerName()));
        item.topScorersPlayerMold.topScorersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topScorersTeamMold.classificationTeam.value(record.teamName());
        item.topScorersPlayedMatchesMold.topScorersPlayedMatches.value(String.valueOf(record.playedMatches()));
        item.topScorersGoalsMold.topScorersGoals.value(String.valueOf(record.amount()));
    }
}