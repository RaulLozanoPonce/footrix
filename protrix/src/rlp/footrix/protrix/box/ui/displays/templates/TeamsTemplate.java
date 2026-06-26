package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.TeamsDatasource;
import rlp.footrix.protrix.box.ui.displays.items.TeamsTableMold;

import java.time.zone.ZoneRulesProvider;

public class TeamsTemplate extends AbstractTeamsTemplate<ProtrixBox> {
    private final TeamsDatasource teamsDatasource;
    private Competition competition;
    private Integer season;

    public TeamsTemplate(ProtrixBox box) {
		super(box);
        this.teamsDatasource = new TeamsDatasource(box);
	}

    public TeamsTemplate setup(Competition competition, int season) {
        this.competition = competition;
        this.season = season;
        return this;
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
        teamsTable.source(teamsDatasource);
    }

    private void initSearch() {
        search.onChange(v -> refreshTable(v.value()));
    }

    private void initTable() {
        teamsTable.onAddItem(this::addTeam);
        teamsTable.onSelect(this::selectTeam);
    }

    private void refreshTable(String search) {
        teamsDatasource.setup(competition, season, search);
        teamsDatasource.loadData();
        teamsTable.reload();
    }

    private void addTeam(AddCollectionItemEvent event) {
        Pes6Team team = event.item();
        TeamsTableMold item = event.component();
        item.teamName.value(team.definition().name());
    }

    private void selectTeam(SelectionEvent event) {
        if (event.first() == null) return;
        Pes6Team team = event.first();
        notifier.redirect("/teams/" + team.definition().id());
    }
}