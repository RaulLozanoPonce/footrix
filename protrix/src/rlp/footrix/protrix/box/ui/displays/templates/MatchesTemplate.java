package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.MatchDatasource;
import rlp.footrix.protrix.box.ui.displays.items.MatchTableMold;
import rlp.footrix.protrix.model.Match;

public class MatchesTemplate extends AbstractMatchesTemplate<ProtrixBox> {
    private final MatchDatasource matchDatasource;

    private CompetitionDefinition competition;

    public MatchesTemplate(ProtrixBox box) {
		super(box);
        this.matchDatasource = new MatchDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public void setup(CompetitionDefinition competition) {
        this.competition = competition;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchTable.source(matchDatasource);
    }

    private void initTable() {
        matchTable.onAddItem(this::addMatch);
        matchTable.onSelect(this::selectMatch);
        matchDatasource.loadData();
    }

    private void addMatch(AddCollectionItemEvent event) {
        Match match = event.item();
        MatchTableMold item = event.component();
        item.day.value(TimeHelper.shortDayStyled(match.date()));
        item.competition.value(match.competitionName());
        item.localLink.title(match.localName());
        item.localLink.onExecute(e -> notifier.redirect(""));
        item.match.value(match.localGoals() + " - " + match.visitantGoals());
        item.visitantLink.title(match.visitantName());
        item.visitantLink.onExecute(e -> notifier.redirect(""));
    }

    private void selectMatch(SelectionEvent event) {
        notifier.redirect("/matches/" + ((Match) event.first()).matchId());
    }
}