package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.Base64;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.MatchDatasource;
import rlp.footrix.protrix.box.ui.displays.items.MatchTableMold;
import rlp.footrix.protrix.model.Match;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class MatchesTemplate extends AbstractMatchesTemplate<ProtrixBox> {
    private final MatchDatasource matchDatasource;

    private Competition competition;
    private Integer season;

    public MatchesTemplate(ProtrixBox box) {
		super(box);
        this.matchDatasource = new MatchDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        initTable();
        initDate();
    }

    public MatchesTemplate setup(Competition competition, int season) {
        this.competition = competition;
        this.season = season;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        matchTable.source(matchDatasource);
    }

    private void initDate() {
        date.value(box().application().game().date());
        date.onChange(v -> refreshTable(v.value()));
        refreshTable(box().application().game().date());
    }

    private void initTable() {
        matchTable.onAddItem(this::addMatch);
        matchTable.onSelect(this::selectMatch);
    }

    private void refreshTable(Instant date) {
        matchDatasource.setup(competition, season, date);
        matchDatasource.loadData();
        matchTable.reload();
    }

    private void addMatch(AddCollectionItemEvent event) {
        Match match = event.item();
        MatchTableMold item = event.component();
        item.day.value(TimeHelper.shortDayStyled(match.date()));
        item.matchDay.value(match.matchDay());
        item.competitionLink.title(match.competitionName());
        item.competitionLink.onExecute(e -> selectCompetition(MatchDefinition.of(match.matchId())));
        item.localLink.title(match.localName());
        item.localLink.onExecute(e -> selectTeam(MatchDefinition.of(match.matchId()).local()));
        item.match.value(match.localGoals() + " - " + match.visitantGoals());
        item.visitantLink.title(match.visitantName());
        item.visitantLink.onExecute(e -> selectTeam(MatchDefinition.of(match.matchId()).visitant()));
    }

    private void selectCompetition(MatchDefinition definition) {
        notifier.redirect("/competitions/" + definition.competition() + "/" + definition.season());
    }

    private void selectTeam(String team) {
        notifier.redirect("/teams/" + team);
    }

    private void selectMatch(SelectionEvent event) {
        if (event.first() == null) return;
        notifier.redirect("/matches/" + encode(((Match) event.first()).matchId()));
    }

    private String encode(String text) {
        return Base64.encode(text.getBytes(StandardCharsets.UTF_8));
    }
}