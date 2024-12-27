package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.Match;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;
import java.util.function.Consumer;

public class MatchRowTemplate extends AbstractMatchRowTemplate<ProtrixBox> {

	public MatchRowTemplate(ProtrixBox box) {
		super(box);
	}

	public MatchRowTemplate match(Match match, Consumer<Match> consumer) {
		this.localTeam.value(match.definition().local());
		this.result.title(goalsOf(match.definition().local(), match.events()) + " - " + goalsOf(match.definition().visitant(), match.events()));
		this.visitantTeam.value(match.definition().visitant());
		result.onExecute(l -> consumer.accept(match));
		return this;
	}

	private int goalsOf(String teamId, List<Match.MatchEvent> events) {
		return (int) events.stream().filter(e -> e.type() == Match.MatchEvent.Type.Goal).filter(e -> e.team().equals(teamId)).count();
	}
}