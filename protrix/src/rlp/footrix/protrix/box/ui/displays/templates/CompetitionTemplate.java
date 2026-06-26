package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.protrix.box.ProtrixBox;

public class CompetitionTemplate extends AbstractCompetitionTemplate<ProtrixBox> {
    private Competition competition;
    private int season;

    private String selectedOption = "classificationOpt";

    public CompetitionTemplate(ProtrixBox box) {
		super(box);
	}

    @Override
    public void init() {
        super.init();
        tabs.onSelect(l -> {
            selectedOption = l.first();
            openView(selectedOption);
        });
        competitionClassificationBlock.onShow(s -> competitionClassificationStamp.setup(competition, season).refresh());
        competitionTeamsBlock.onShow(s -> competitionTeamsStamp.setup(competition, season).refresh());
        competitionMatchesBlock.onShow(s -> competitionMatchesStamp.setup(competition, season).refresh());
        competitionRankingsBlock.onShow(s -> competitionRankingsStamp.setup(competition, season).refresh());
    }

    public void setup(Competition competition, int season) {
        this.competition = competition;
        this.season = season;
        setupHeader();
    }

    @Override
    public void refresh() {
        super.refresh();
        openView(selectedOption);
    }

    private void setupHeader() {
        this.competitionName.value(competition.definition().name());
    }

    private void openView(String selectedOption) {
        tabs.selection(selectedOption);
        competitionClassificationBlock.hide();
        competitionTeamsBlock.hide();
        competitionMatchesBlock.hide();
        competitionRankingsBlock.hide();
        if (selectedOption.equals("classificationOpt")) competitionClassificationBlock.show();
        else if (selectedOption.equals("teamsOpt")) competitionTeamsBlock.show();
        else if (selectedOption.equals("matchesOpt")) competitionMatchesBlock.show();
        else if (selectedOption.equals("rankingsOpt")) competitionRankingsBlock.show();
    }
}