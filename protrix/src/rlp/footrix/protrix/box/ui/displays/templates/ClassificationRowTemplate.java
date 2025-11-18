package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.protrix.box.ProtrixBox;

public class ClassificationRowTemplate extends AbstractClassificationRowTemplate<ProtrixBox> {

	public ClassificationRowTemplate(ProtrixBox box) {
		super(box);
	}

	public ClassificationRowTemplate results(int position, TeamMatchRecordRow record) {
		Team team = box().application().teamManager().get(record.team());
		this.position.value(position);
		this.team.value(team.definition().name());
		this.playedMatches.value(record.wins() + record.draws() + record.lost());
		this.winMatches.value(record.wins());
		this.drawMatches.value(record.draws());
		this.lostMatches.value(record.lost());
		this.goalsFor.value(record.goalsFor());
		this.goalsAgainst.value(record.goalsAgainst());
		this.goalsDifference.value(record.goalsFor() - record.goalsAgainst());
		this.points.value(record.points());
		return this;
	}

    public record TeamMatchRecordRow(String team, int wins, int draws, int lost, int goalsFor, int goalsAgainst, int points) {}
}