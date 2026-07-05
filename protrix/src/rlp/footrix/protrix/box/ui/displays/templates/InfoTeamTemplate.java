package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;

public class InfoTeamTemplate extends AbstractInfoTeamTemplate<ProtrixBox> {
    private Pes6Team team;

    public InfoTeamTemplate(ProtrixBox box) {
		super(box);
	}

    public InfoTeamTemplate setup(Competition competition, int phase, Pes6Team team) {
        this.team = team;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        fans.value(team.fans().totalFans());
        subscribers.value(team.fans().totalSubscribers());
        elo.value(team.elo().quantity());
        eloPercentage.value(box().application().eloManager().percentElo(team.definition().id()));
    }
}