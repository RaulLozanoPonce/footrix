package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.protrix.box.ProtrixBox;

public class CompetitionRankingsTemplate extends AbstractCompetitionRankingsTemplate<ProtrixBox> {

	public CompetitionRankingsTemplate(ProtrixBox box) {
		super(box);
	}

    public CompetitionRankingsTemplate setup(Competition competition, int season) {
        competitionGoalRankingStamp.setup(competition.definition().id(), season);
        competitionAssistRankingStamp.setup(competition.definition().id(), season);
        competitionReceivedGoalRankingStamp.setup(competition.definition().id(), season);
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        competitionGoalRankingStamp.refresh();
        competitionAssistRankingStamp.refresh();
        competitionReceivedGoalRankingStamp.refresh();
    }
}