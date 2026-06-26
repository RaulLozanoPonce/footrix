package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import rlp.footrix.framework.types.entities.Competition;

import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.CompetitionsDatasource;
import rlp.footrix.protrix.box.ui.displays.items.CompetitionsTableMold;

public class CompetitionsTemplate extends AbstractCompetitionsTemplate<ProtrixBox> {
    private final CompetitionsDatasource competitionsDatasource;

	public CompetitionsTemplate(ProtrixBox box) {
		super(box);
        this.competitionsDatasource = new CompetitionsDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        initTable();
        initSearch();
        refreshTable("");
    }

    @Override
    public void refresh() {
        super.refresh();
        competitionsTable.source(competitionsDatasource);
    }

    private void initSearch() {
        search.onChange(v -> refreshTable(v.value()));
    }

    private void initTable() {
        competitionsTable.onAddItem(this::addMatch);
        competitionsTable.onSelect(this::selectCompetition);
    }

    private void refreshTable(String search) {
        competitionsDatasource.setup(box().application().game().seasonNumber(), search);
        competitionsDatasource.loadData();
        competitionsTable.reload();
    }

    private void addMatch(AddCollectionItemEvent event) {
        Competition competition = event.item();
        CompetitionsTableMold item = event.component();
        item.competitionName.value(competition.definition().name());
    }

    private void selectCompetition(SelectionEvent event) {
        if (event.first() == null) return;
        Competition competition = event.first();
        notifier.redirect("/competitions/" + competition.definition().id() + "/" + box().application().game().seasonNumber());
    }
}