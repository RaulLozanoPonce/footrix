package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.protrix.box.ProtrixBox;

import java.time.Instant;

public class MatchTemplate extends AbstractMatchTemplate<ProtrixBox> {
    private MatchDefinition definition;
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
        infoBlock.onShow(s -> matchInfoStamp.setup(definition, match).refresh());
        competitionBlock.onShow(s -> matchCompetitionStamp.setup(definition).refresh());
    }

    public void setup(MatchDefinition definition) {
        this.definition = definition;
        this.match = box().application().entityStore().match(definition);
        setupHeader();
    }

    @Override
    public void refresh() {
        super.refresh();
        openView(selectedOption);
    }

    private void setupHeader() {
        CompetitionDefinition competition = box().application().competitionManager().definition(definition.competition());
        TeamDefinition local = box().application().teamManager().definition(definition.local());
        TeamDefinition visitant = box().application().teamManager().definition(definition.visitant());
        this.competition.value(competition.name());
        this.localTeam.value(local.name());
        this.result.value(localGoals() + " - " + visitantGoals());
        this.visitantTeam.value(visitant.name());
        this.matchDay.value(definition.matchDay());
        this.day.value(TimeHelper.shortDayStyled(date()));
    }

    private void openView(String selectedOption) {
        tabs.selection(selectedOption);
        infoBlock.hide();
        competitionBlock.hide();
        if (selectedOption.equals("infoOpt")) infoBlock.show();
        else if (selectedOption.equals("competitionOpt")) competitionBlock.show();
    }

    private String localGoals() {
        if (match != null) {
            return String.valueOf(match.localGoals());
        } else {
            return "";
        }
    }

    private String visitantGoals() {
        if (match != null) {
            return String.valueOf(match.visitantGoals());
        } else {
            return "";
        }
    }

    private Instant date() {
        if (match != null) {
            return match.date();
        } else {
            return box().application().taskHub().tasksFrom(box().application().getDate()).stream()
                    .filter(t -> t instanceof ScheduledMatchEvent)
                    .map(t -> (ScheduledMatchEvent) t)
                    .filter(t -> t.definition().id().equals(definition.id()))
                    .map(ScheduledMatchEvent::date)
                    .findFirst().orElse(null);
        }
    }
}