package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.TeamClassification;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.var.MatchResult;
import rlp.footrix.framework.var.VarTerminal;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.ArrayList;
import java.util.List;

public class ClassificationTemplate extends AbstractClassificationTemplate<ProtrixBox> {

	public ClassificationTemplate(ProtrixBox box) {
		super(box);
	}

	public void setCompetition(String competitionId) {
		Competition competition = box().application().competitionManager().get(competitionId, "season1");
		List<MatchResult> results = VarTerminal.revisions(MatchResult.class);
		List<Team> teams = competition.phase(0).group(0).teams();
		List<TeamClassification> classifications = competition.definition().phases().getFirst()
				.classify(teams.stream().map(t -> classificationOf(t.definition().id(), results)).toList());
		for (int i = 0; i < classifications.size(); i++) classificationRowStamp.add().results(i + 1, classifications.get(i));
	}

	private TeamClassification classificationOf(String teamId, List<MatchResult> results) {
		List<Integer> points = new ArrayList<>();
		int goalsFor = 0;
		int goalsAgainst = 0;
		for (MatchResult result : results) {
			if (!result.local().equals(teamId) && !result.visitant().equals(teamId)) continue;
			int resultGoalsFor;
			int resultGoalsAgainst;
			if (teamId.equals(result.local())) {
				resultGoalsFor = result.localGoals();
				resultGoalsAgainst = result.visitantGoals();
			} else {
				resultGoalsFor = result.visitantGoals();
				resultGoalsAgainst = result.localGoals();
			}
			points.add(pointsOf(resultGoalsFor, resultGoalsAgainst));
			goalsFor += resultGoalsFor;
			goalsAgainst += resultGoalsAgainst;
		}

		return new TeamClassification(
				teamId,
				points.stream().mapToInt(p -> p).sum(),
				(int) points.stream().filter(r -> r == 3).count(),
				(int) points.stream().filter(r -> r == 1).count(),
				(int) points.stream().filter(r -> r == 0).count(),
				goalsFor,
				goalsAgainst
		);
	}

	private Integer pointsOf(int goalsFor, int goalsAgainst) {
		if (goalsFor > goalsAgainst) return 3;
		if (goalsFor < goalsAgainst) return 0;
		return 1;
	}
}