package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchesTemplate extends AbstractMatchesTemplate<ProtrixBox> {

	public MatchesTemplate(ProtrixBox box) {
		super(box);
	}

	public void setCompetition(String competitionId, String matchDayId) {
		Competition competition = box().application().competitionManager().get(competitionId, 0);
		Map<String, List<Match>> matchDay = box().application().entityStore().matches(competitionId, 0).stream().collect(Collectors.groupingBy(m -> m.definition().matchDay()));
		String matchDayName = competition.phase(0).definition().matchDayName(Integer.parseInt(matchDayId));
		for (Match match : matchDay.get(matchDayName)) {
			matchRowStamp.add().match(match, this::seeMatch);
		}
	}

	private void seeMatch(Match match) {
		eventRowStamp.clear();
		for (Match.MatchEvent event : match.events()) {
			if (event.type() == Match.MatchEvent.Type.Expulsion || (event.type() == Match.MatchEvent.Type.Substitution && event.metaInfo() != null)) continue;
			eventRowStamp.add().event(event.team().equals(match.definition().local()), event);
		}
	}
}