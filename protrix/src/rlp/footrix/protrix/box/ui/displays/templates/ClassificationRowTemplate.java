package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.var.TeamResult;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;

public class ClassificationRowTemplate extends AbstractClassificationRowTemplate<ProtrixBox> {

	public ClassificationRowTemplate(ProtrixBox box) {
		super(box);
	}

	public ClassificationRowTemplate results(int position, String teamId, List<TeamResult> results) {
		Team team = box().application().teamManager().get(teamId);
		this.position.value(position);
		this.team.value(team.definition().name());
		this.playedMatches.value(results.size());
		this.winMatches.value(results.stream().filter(r -> r.points() == 3).count());
		this.drawMatches.value(results.stream().filter(r -> r.points() == 1).count());
		this.lostMatches.value(results.stream().filter(r -> r.points() == 0).count());
		this.goalsFor.value(results.stream().mapToInt(TeamResult::goalsFor).sum());
		this.goalsAgainst.value(results.stream().mapToInt(TeamResult::goalsAgainst).sum());
		this.goalsDifference.value(results.stream().mapToInt(r -> r.goalsFor() - r.goalsAgainst()).sum());
		this.points.value(results.stream().mapToInt(TeamResult::points).sum());
		return this;
	}
}