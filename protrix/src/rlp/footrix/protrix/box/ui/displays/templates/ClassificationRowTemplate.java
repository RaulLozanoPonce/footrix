package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.protrix.box.ProtrixBox;

public class ClassificationRowTemplate extends AbstractClassificationRowTemplate<ProtrixBox> {

	public ClassificationRowTemplate(ProtrixBox box) {
		super(box);
	}

	public ClassificationRowTemplate results(int position, CompetitionDefinition.PhaseDefinition.TeamClassification classification) {
		Team team = box().application().teamManager().get(classification.teamId());
		this.position.value(position);
		this.team.value(team.definition().name());
		this.playedMatches.value(classification.wonMatches() + classification.drawMatches() + classification.lostMatches());
		this.winMatches.value(classification.wonMatches());
		this.drawMatches.value(classification.drawMatches());
		this.lostMatches.value(classification.lostMatches());
		this.goalsFor.value(classification.goalsFor());
		this.goalsAgainst.value(classification.goalsAgainst());
		this.goalsDifference.value(classification.goalsFor() - classification.goalsAgainst());
		this.points.value(classification.points());
		return this;
	}
}