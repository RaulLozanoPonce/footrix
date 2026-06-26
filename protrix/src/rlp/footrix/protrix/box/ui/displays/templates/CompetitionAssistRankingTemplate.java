package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.protrix.box.*;

import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.TopPlayerRecordDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.TopAssistersTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TopScorersTableRow;
import rlp.footrix.protrix.box.ui.displays.templates.AbstractCompetitionAssistRankingTemplate;
import rlp.footrix.protrix.model.PlayerRecord;

public class CompetitionAssistRankingTemplate extends AbstractCompetitionAssistRankingTemplate<ProtrixBox> {
    private final TopPlayerRecordDatasource datasource;

    private String competitionId;
    private int season;

    public CompetitionAssistRankingTemplate(ProtrixBox box) {
        super(box);
        this.datasource = new TopPlayerRecordDatasource(box);
    }

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public CompetitionAssistRankingTemplate setup(String competitionId, int season) {
        this.competitionId = competitionId;
        this.season = season;
        refreshTable();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        topAssistersTable.source(datasource);
    }

    private void initTable() {
        topAssistersTable.onAddItem(this::addTop);
    }

    private void refreshTable() {
        datasource.setup(competitionId, season, PlayerRecord.Type.Assist);
        datasource.loadData();
        topAssistersTable.reload();
    }

    private void addTop(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopAssistersTableRow item = event.component();
        item.topAssistersPositionMold.topAssistersPosition.value(String.valueOf(datasource.indexOf(record) + 1));
        item.topAssistersPlayerMold.topAssistersPlayer.title(String.valueOf(record.playerName()));
        item.topAssistersPlayerMold.topAssistersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topAssistersTeamMold.classificationTeam.value(record.teamName());
        item.topAssistersPlayedMatchesMold.topAssistersPlayedMatches.value(String.valueOf(record.playedMatches()));
        item.topAssistersAssistsMold.topAssistersAssists.value(String.valueOf(record.amount()));
    }
}