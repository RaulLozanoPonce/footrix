package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.ClassificationDatasource;
import rlp.footrix.protrix.box.ui.datasources.TopPlayerRecordDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.ClassificationTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TopAssistersTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TopGoalkeepersTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TopScorersTableRow;
import rlp.footrix.protrix.model.Classification;
import rlp.footrix.protrix.model.PlayerRecord;

public class OverviewTemplate extends AbstractOverviewTemplate<ProtrixBox> {
    private final ClassificationDatasource classificationDatasource;
    private final TopPlayerRecordDatasource topScorersDatasource;
    private final TopPlayerRecordDatasource topAssistersDatasource;
    private final TopPlayerRecordDatasource topGoalkeepersDatasource;

    public OverviewTemplate(ProtrixBox box) {
        super(box);
        this.classificationDatasource = new ClassificationDatasource(box).filter("ESP-1");
        this.topScorersDatasource = new TopPlayerRecordDatasource(box).filter("ESP-1", PlayerRecord.Type.Goal);
        this.topAssistersDatasource = new TopPlayerRecordDatasource(box).filter("ESP-1", PlayerRecord.Type.Assist);
        this.topGoalkeepersDatasource = new TopPlayerRecordDatasource(box).filter("ESP-1", PlayerRecord.Type.ReceivedGoals);
    }

    @Override
    public void init() {
        super.init();
        initTables();
    }

    @Override
    public void refresh() {
        super.refresh();
        matchesStamp.refresh();
        classificationTable.source(classificationDatasource);
        topScorersTable.source(topScorersDatasource);
        topAssistersTable.source(topAssistersDatasource);
        topGoalkeepersTable.source(topGoalkeepersDatasource);
    }

    private void initTables() {
        classificationTable.onAddItem(this::addClassification);
        classificationDatasource.loadData();

        topScorersTable.onAddItem(this::addTopScorer);
        topScorersDatasource.loadData();

        topAssistersTable.onAddItem(this::addTopAssister);
        topAssistersDatasource.loadData();

        topGoalkeepersTable.onAddItem(this::addTopGoalkeeper);
        topGoalkeepersDatasource.loadData();
    }

    private void addClassification(AddCollectionItemEvent event) {
        Classification classification = event.item();
        ClassificationTableRow item = event.component();
        item.classificationPositionMold.classificationPosition.value(String.valueOf(classificationDatasource.indexOf(classification) + 1));
        item.classificationTeamMold.classificationTeam.value(classification.teamName());
        item.classificationPlayedMatchesMold.classificationPlayedMatches.value(String.valueOf(classification.playedGames()));
        item.classificationWinMatchesMold.classificationWinMatches.value(String.valueOf(classification.wonGames()));
        item.classificationDrawMatchesMold.classificationDrawMatches.value(String.valueOf(classification.drawGames()));
        item.classificationLostMatchesMold.classificationLostMatches.value(String.valueOf(classification.lostGames()));
        item.classificationGoalsDifferenceMold.classificationGoalsDifference.value(String.valueOf(classification.goalsDifference()));
        item.classificationPointsMold.classificationPoints.value(String.valueOf(classification.points()));
    }

    private void addTopScorer(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopScorersTableRow item = event.component();
        item.topScorersPositionMold.topScorersPosition.value(String.valueOf(topScorersDatasource.indexOf(record) + 1));
        item.topScorersPlayerMold.topScorersPlayer.title(String.valueOf(record.playerName()));
        item.topScorersPlayerMold.topScorersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topScorersTeamMold.classificationTeam.value(record.teamName());
        item.topScorersPlayedMatchesMold.topScorersPlayedMatches.value(String.valueOf(record.playedMatches()));
        item.topScorersGoalsMold.topScorersGoals.value(String.valueOf(record.amount()));
    }

    private void addTopAssister(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopAssistersTableRow item = event.component();
        item.topAssistersPositionMold.topAssistersPosition.value(String.valueOf(topAssistersDatasource.indexOf(record) + 1));
        item.topAssistersPlayerMold.topAssistersPlayer.title(String.valueOf(record.playerName()));
        item.topAssistersPlayerMold.topAssistersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topAssistersTeamMold.classificationTeam.value(record.teamName());
        item.topAssistersPlayedMatchesMold.topAssistersPlayedMatches.value(String.valueOf(record.playedMatches()));
        item.topAssistersAssistsMold.topAssistersAssists.value(String.valueOf(record.amount()));
    }

    private void addTopGoalkeeper(AddCollectionItemEvent event) {
        PlayerRecord record = event.item();
        TopGoalkeepersTableRow item = event.component();
        item.topGoalkeepersPositionMold.topGoalkeepersPosition.value(String.valueOf(topGoalkeepersDatasource.indexOf(record) + 1));
        item.topGoalkeepersPlayerMold.topGoalkeepersPlayer.title(String.valueOf(record.playerName()));
        item.topGoalkeepersPlayerMold.topGoalkeepersPlayer.onExecute(l -> notifier.redirect("http://localhost:9001/player-trace/" + record.playerId()));
        //item.topGoalkeepersTeamMold.classificationTeam.value(record.teamName());
        item.topGoalkeepersPlayedMinutesMold.topGoalkeepersPlayedMinutes.value(String.valueOf(record.playedMinutes()));
        item.topGoalkeepersGoalsMold.topGoalkeepersGoals.value(String.valueOf(record.amount()));
    }
}