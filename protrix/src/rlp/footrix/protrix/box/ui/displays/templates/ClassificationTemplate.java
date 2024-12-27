package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.TeamClassification;
import rlp.footrix.framework.var.TeamResult;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassificationTemplate extends AbstractClassificationTemplate<ProtrixBox> {

	public ClassificationTemplate(ProtrixBox box) {
		super(box);
	}

	public void setCompetition(String competitionId) {
		Competition competition = box().application().competitionManager().get(competitionId, "season1");
		Map<String, List<TeamResult>> results = box().application().var().revisions(TeamResult.class).stream().collect(Collectors.groupingBy(TeamResult::teamId));
		List<TeamClassification> classifications = results.keySet().stream().map(t -> classificationOf(t, results.get(t), competition)).toList();
		List<String> teams = competition.definition().phases().getFirst().classify(classifications);
		for (int i = 0; i < teams.size(); i++) classificationRowStamp.add().results(i + 1, teams.get(i), results.get(teams.get(i)));
	}

	private TeamClassification classificationOf(String teamId, List<TeamResult> teamResults, Competition competition) {
		return new TeamClassification(
				teamId,
				teamResults.stream().mapToInt(TeamResult::points).sum(),
				teamResults.stream().mapToInt(TeamResult::goalsFor).sum(),
				teamResults.stream().mapToInt(TeamResult::goalsAgainst).sum()
		);
	}
}