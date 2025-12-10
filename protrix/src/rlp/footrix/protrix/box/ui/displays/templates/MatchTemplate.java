package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.protrix.box.ProtrixBox;

public class MatchTemplate extends AbstractMatchTemplate<ProtrixBox> {
    private Match match;

    private String selectedOption = "infoOpt";

    public MatchTemplate(ProtrixBox box) {
		super(box);
	}

    @Override
    public void init() {
        super.init();
        tabs.onSelect(l -> {
            selectedOption = l.first();
            openView(selectedOption);
        });
        infoBlock.onShow(s -> matchInfoStamp.setup(match).refresh());
        competitionBlock.onShow(s -> matchCompetitionStamp.setup(match).refresh());
    }

    public void setup(Match match) {
        this.match = match;
        setupHeader();
    }

    @Override
    public void refresh() {
        super.refresh();
        openView(selectedOption);
    }

    private void setupHeader() {
        CompetitionDefinition competition = box().application().competitionManager().definition(match.definition().competition());
        TeamDefinition local = box().application().teamManager().definition(match.definition().local());
        TeamDefinition visitant = box().application().teamManager().definition(match.definition().visitant());
        this.competition.value(competition.name());
        this.localTeam.value(local.name());
        this.result.value(match.localGoals() + " - " + match.visitantGoals());
        this.visitantTeam.value(visitant.name());
        this.matchDay.value(match.definition().matchDay());
        this.day.value(TimeHelper.shortDayStyled(match.date()));
    }

    private void openView(String selectedOption) {
        tabs.selection(selectedOption);
        infoBlock.hide();
        competitionBlock.hide();
        if (selectedOption.equals("infoOpt")) infoBlock.show();
        else if (selectedOption.equals("competitionOpt")) competitionBlock.show();
    }
}