package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;

public class TeamTemplate extends AbstractTeamTemplate<ProtrixBox> {
    private Pes6Team team;

    private String selectedOption = "infoOpt";

    public TeamTemplate(ProtrixBox box) {
		super(box);
	}

    @Override
    public void init() {
        super.init();
        tabs.onSelect(l -> {
            selectedOption = l.first();
            openView(selectedOption);
        });
        Competition competition = box().application().competitionManager().get("ESP-1");    //TODO
        teamMatchesBlock.onShow(s -> teamMatchesStamp.setup(competition, box().application().game().seasonNumber(), team).refresh());
        teamSquadBlock.onShow(s -> teamSquadStamp.setup(box().application().game().seasonNumber(), team).refresh());
        teamClassificationBlock.onShow(s -> teamClassificationStamp.setup(competition, box().application().game().seasonNumber(), team).refresh());
        teamOutBlock.onShow(s -> teamOutStamp.setup(TimeHelper.previousInstant(box().application().game().date(), TimeHelper.Scale.Year), team).refresh());
    }

    public void setup(Pes6Team team) {
        this.team = team;
        setupHeader();
    }

    @Override
    public void refresh() {
        super.refresh();
        openView(selectedOption);
    }

    private void setupHeader() {
        this.teamName.value(team.definition().name());
    }

    private void openView(String selectedOption) {
        tabs.selection(selectedOption);
        teamMatchesBlock.hide();
        teamSquadBlock.hide();
        teamClassificationBlock.hide();
        teamOutBlock.hide();
        if (selectedOption.equals("matchesOpt")) teamMatchesBlock.show();
        else if (selectedOption.equals("squadOpt")) teamSquadBlock.show();
        else if (selectedOption.equals("classificationOpt")) teamClassificationBlock.show();
        else if (selectedOption.equals("outOpt")) teamOutBlock.show();
    }
}