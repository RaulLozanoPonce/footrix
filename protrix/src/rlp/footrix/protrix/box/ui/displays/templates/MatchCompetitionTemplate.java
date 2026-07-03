package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.protrix.box.ProtrixBox;

public class MatchCompetitionTemplate extends AbstractMatchCompetitionTemplate<ProtrixBox> {

    public MatchCompetitionTemplate(ProtrixBox box) {
		super(box);
	}

    public MatchCompetitionTemplate setup(MatchDefinition definition) {
        Competition competition = box().application().entityStore().competition(definition.competition(), definition.season());
        matchesStamp.setup(competition, definition.season()).refresh();
        classificationStamp.setup(competition, definition.season()).refresh();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchesStamp.refresh();
        classificationStamp.refresh();
    }
}