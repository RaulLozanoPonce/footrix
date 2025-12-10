package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.ClassificationDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.ClassificationTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.MatchCompetitionClassificationTableRow;
import rlp.footrix.protrix.model.Classification;

public class MatchCompetitionTemplate extends AbstractMatchCompetitionTemplate<ProtrixBox> {
    private ClassificationDatasource classificationDatasource;

    public MatchCompetitionTemplate(ProtrixBox box) {
		super(box);
	}

    @Override
    public void init() {
        super.init();
        initTables();
    }

    public MatchCompetitionTemplate setup(Match match) {
        CompetitionDefinition competition = box().application().competitionManager().definition(match.definition().competition());
        matchesStamp.setup(competition);
        this.classificationDatasource = new ClassificationDatasource(box()).filter(competition.id()).loadData();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchesStamp.refresh();
        matchCompetitionClassificationTable.source(classificationDatasource);
    }

    private void initTables() {
        matchCompetitionClassificationTable.onAddItem(this::addClassification);
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