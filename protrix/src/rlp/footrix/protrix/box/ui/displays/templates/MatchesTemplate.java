package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.Base64;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.MatchDatasource;
import rlp.footrix.protrix.box.ui.displays.items.MatchTableMold;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Set;

public class MatchesTemplate extends AbstractMatchesTemplate<ProtrixBox> {
    private final MatchDatasource matchDatasource;

    private Competition competition;
    private Integer season;
    private Pes6Team team;

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
        return setup(competition, season, null);
    }

    public MatchesTemplate setup(Competition competition, int season, Pes6Team team) {
        this.competition = competition;
        this.season = season;
        this.team = team;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshTable(box().application().game().date());
        matchTable.source(matchDatasource);
    }

    private void initDate() {
        date.value(box().application().game().date());
        date.onChange(v -> refreshTable(v.value()));
    }

    private void initTable() {
        matchTable.onAddItem(this::addMatch);
        matchTable.onSelect(this::selectMatch);
    }

    private void refreshTable(Instant date) {
        matchDatasource.setup(competition, season, team, date);
        matchDatasource.loadData();
        matchTable.reload();
    }

    private void addMatch(AddCollectionItemEvent event) {
        MatchDefinition definition = event.item();
        Match match = box().application().entityStore().match(definition);
        String competitionName = box().application().competitionManager().definition(definition.competition()).name();
        String localName = box().application().teamManager().definition(definition.local()).name();
        String visitantName = box().application().teamManager().definition(definition.visitant()).name();
        MatchTableMold item = event.component();
        if (team != null && match != null) item.matchBlock.formats(colorOfMatch(match));
        item.day.value(TimeHelper.shortDayStyled(dateOf(definition, match)));
        item.matchDay.value(definition.matchDay());
        item.competitionLink.title(competitionName);
        item.competitionLink.onExecute(e -> selectCompetition(definition));
        item.localLink.title(localName);
        item.localLink.onExecute(e -> selectTeam(definition.local()));
        item.match.value(resultOf(match));
        item.visitantLink.title(visitantName);
        item.visitantLink.onExecute(e -> selectTeam(definition.visitant()));
    }

    private Set<String> colorOfMatch(Match match) {
        if (match.isDraw()) return Set.of("greyBackground", "rounded");
        if (match.winner().equals(team.definition().id())) return Set.of("greenBackground", "rounded");
        return Set.of("redBackground", "rounded");
    }

    private Instant dateOf(MatchDefinition definition, Match match) {
        if (match != null) return match.date();

        for (Event event : box().application().taskHub().tasksFrom(box().application().game().date())) {
            if (event instanceof ScheduledMatchEvent scheduled) {
                if (scheduled.definition().id().equals(definition.id())) return scheduled.date();
            }
        }

        return null;
    }

    private void selectCompetition(MatchDefinition definition) {
        notifier.redirect("/competitions/" + definition.competition() + "/" + definition.season());
    }

    private void selectTeam(String team) {
        notifier.redirect("/teams/" + team);
    }

    private void selectMatch(SelectionEvent event) {
        if (event.first() == null) return;
        notifier.redirect("/matches/" + encode(((MatchDefinition) event.first()).id()));
    }

    private String resultOf(Match match) {
        if (match != null) return match.localGoals() + " - " + match.visitantGoals();
        return "-";
    }

    private String encode(String text) {
        return Base64.encode(text.getBytes(StandardCharsets.UTF_8));
    }
}