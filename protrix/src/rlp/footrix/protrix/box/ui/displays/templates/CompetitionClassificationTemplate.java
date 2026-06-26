package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.ClassificationDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.MatchCompetitionClassificationTableRow;
import rlp.footrix.protrix.model.Classification;

public class CompetitionClassificationTemplate extends AbstractCompetitionClassificationTemplate<ProtrixBox> {
    private ClassificationDatasource classificationDatasource;

    private Competition competition;
    private int season;

    public CompetitionClassificationTemplate(ProtrixBox box) {
		super(box);
        this.classificationDatasource = new ClassificationDatasource(box());
	}

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public CompetitionClassificationTemplate setup(Competition competition, int season) {
        this.competition = competition;
        this.season = season;
        refreshTable();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchCompetitionClassificationTable.source(classificationDatasource);
    }

    private void initTable() {
        matchCompetitionClassificationTable.onAddItem(this::addClassification);
    }

    private void refreshTable() {
        classificationDatasource.setup(competition.definition().id(), season);
        classificationDatasource.loadData();
        matchCompetitionClassificationTable.reload();
    }

    private void addClassification(AddCollectionItemEvent event) {
        Classification classification = event.item();
        MatchCompetitionClassificationTableRow item = event.component();
        item.matchCompetitionClassificationPositionMold.matchCompetitionClassificationPosition.value(String.valueOf(classificationDatasource.indexOf(classification) + 1));
        item.matchCompetitionClassificationTeamMold.matchCompetitionClassificationTeam.value(classification.teamName());
        item.matchCompetitionClassificationPlayedMatchesMold.matchCompetitionClassificationPlayedMatches.value(String.valueOf(classification.playedGames()));
        item.matchCompetitionClassificationWinMatchesMold.matchCompetitionClassificationWinMatches.value(String.valueOf(classification.wonGames()));
        item.matchCompetitionClassificationDrawMatchesMold.matchCompetitionClassificationDrawMatches.value(String.valueOf(classification.drawGames()));
        item.matchCompetitionClassificationLostMatchesMold.matchCompetitionClassificationLostMatches.value(String.valueOf(classification.lostGames()));
        item.matchCompetitionClassificationGoalsForMold.matchCompetitionClassificationGoalsFor.value(String.valueOf(classification.goalsFor()));
        item.matchCompetitionClassificationGoalsAgainstMold.matchCompetitionClassificationGoalsAgainst.value(String.valueOf(classification.goalsAgainst()));
        item.matchCompetitionClassificationGoalsDifferenceMold.matchCompetitionClassificationGoalsDifference.value(String.valueOf(classification.goalsDifference()));
        item.matchCompetitionClassificationPointsMold.matchCompetitionClassificationPoints.value(String.valueOf(classification.points()));
    }
}