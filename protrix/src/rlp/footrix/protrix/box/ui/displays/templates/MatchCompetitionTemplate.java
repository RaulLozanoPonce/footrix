package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.protrix.box.ProtrixBox;

public class MatchCompetitionTemplate extends AbstractMatchCompetitionTemplate<ProtrixBox> {

    public MatchCompetitionTemplate(ProtrixBox box) {
		super(box);
	}

    public MatchCompetitionTemplate setup(Match match) {
        Competition competition = box().application().entityStore().competition(match.definition().competition(), match.definition().season());
        matchesStamp.setup(competition, match.definition().season());
        classificationStamp.setup(competition, match.definition().season());
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchesStamp.refresh();
        classificationStamp.refresh();
    }
}