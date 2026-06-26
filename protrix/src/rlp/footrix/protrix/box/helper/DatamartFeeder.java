package rlp.footrix.protrix.box.helper;

import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.protrix.box.ProtrixBox;

public class DatamartFeeder {
    private final ProtrixBox box;

    public DatamartFeeder(ProtrixBox box) {
        this.box = box;
    }

    public void feedMatches() {
        CompetitionDefinition competition = box.application().competitionManager().definition("ESP-1");
        for (Match match : box.application().entityStore().matches(competition.id(), 0)) {
            Team local = box.application().teamManager().get(match.definition().local());
            Team visitant = box.application().teamManager().get(match.definition().visitant());
            box.graph().create().match(match.definition().id(), competition.name(), match.date(), match.definition().matchDay(), local.definition().name(), visitant.definition().name(), String.valueOf(match.localGoals()), String.valueOf(match.visitantGoals()));
        }

        for (Event event : box.application().taskHub().tasksFrom(box.application().game().date())) {
            if (event instanceof ScheduledMatchEvent scheduled) {
                Team local = box.application().teamManager().get(scheduled.definition().local());
                Team visitant = box.application().teamManager().get(scheduled.definition().visitant());
                box.graph().create().match(scheduled.definition().id(), competition.name(), scheduled.date(), scheduled.definition().matchDay(), local.definition().name(), visitant.definition().name(), "", "");
            }
        }
    }
}
