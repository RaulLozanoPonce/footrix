package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.ClassificationDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.ClassificationTableRow;
import rlp.footrix.protrix.model.Classification;

public class OverviewTemplate extends AbstractOverviewTemplate<ProtrixBox> {
    private final ClassificationDatasource classificationDatasource;

    public OverviewTemplate(ProtrixBox box) {
        super(box);
        this.classificationDatasource = new ClassificationDatasource(box).setup("ESP-1", box.application().game().seasonNumber());
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
        competitionGoalRankingStamp.refresh();
        competitionAssistRankingStamp.refresh();
    }

    private void initTables() {
        classificationTable.onAddItem(this::addClassification);
        classificationDatasource.loadData();
        competitionGoalRankingStamp.setup("ESP-1", box().application().game().seasonNumber());
        competitionAssistRankingStamp.setup("ESP-1", box().application().game().seasonNumber());
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
}