package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.ClassificationDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.FullClassificationTableRow;
import rlp.footrix.protrix.model.Classification;

public class FullClassificationTemplate extends AbstractFullClassificationTemplate<ProtrixBox> {
    private ClassificationDatasource classificationDatasource;

    private Competition competition;
    private int season;
    private Pes6Team team;

    public FullClassificationTemplate(ProtrixBox box) {
        super(box);
        this.classificationDatasource = new ClassificationDatasource(box());
    }

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public FullClassificationTemplate setup(Competition competition, int season) {
        return setup(competition, season, null);
    }

    public FullClassificationTemplate setup(Competition competition, int season, Pes6Team team) {
        this.competition = competition;
        this.season = season;
        this.team = team;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshTable();
        fullClassificationTable.source(classificationDatasource);
    }

    private void initTable() {
        fullClassificationTable.onAddItem(this::addClassification);
    }

    private void refreshTable() {
        classificationDatasource.setup(competition.definition().id(), season);
        classificationDatasource.loadData();
        fullClassificationTable.reload();
    }

    private void addClassification(AddCollectionItemEvent event) {
        Classification classification = event.item();
        FullClassificationTableRow item = event.component();
        if (team != null && classification.team().equals(team.definition().id())) item.color("#ae2e24");
        item.fullClassificationPositionMold.fullClassificationPosition.value(String.valueOf(classificationDatasource.indexOf(classification) + 1));
        item.fullClassificationTeamMold.fullClassificationTeam.value(classification.teamName());
        item.fullClassificationPlayedMatchesMold.fullClassificationPlayedMatches.value(String.valueOf(classification.playedGames()));
        item.fullClassificationWinMatchesMold.fullClassificationWinMatches.value(String.valueOf(classification.wonGames()));
        item.fullClassificationDrawMatchesMold.fullClassificationDrawMatches.value(String.valueOf(classification.drawGames()));
        item.fullClassificationLostMatchesMold.fullClassificationLostMatches.value(String.valueOf(classification.lostGames()));
        item.fullClassificationGoalsForMold.fullClassificationGoalsFor.value(String.valueOf(classification.goalsFor()));
        item.fullClassificationGoalsAgainstMold.fullClassificationGoalsAgainst.value(String.valueOf(classification.goalsAgainst()));
        item.fullClassificationGoalsDifferenceMold.fullClassificationGoalsDifference.value(String.valueOf(classification.goalsDifference()));
        item.fullClassificationPointsMold.fullClassificationPoints.value(String.valueOf(classification.points()));
    }
}