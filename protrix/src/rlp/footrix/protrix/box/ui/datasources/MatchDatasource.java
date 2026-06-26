package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.Match;

import java.time.Instant;
import java.util.List;

public class MatchDatasource extends PageDatasource<Match> {
    private final ProtrixBox box;
    private Competition competition;
    private Integer season;
    private Instant date;

    private List<Match> matches;

    public MatchDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Match> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return matches.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return matches.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.matches = box.graph().matchList().stream()
                .filter(m -> competition == null || competition.definition().id().equals(MatchDefinition.of(m.matchId()).competition()))
                .filter(m -> season == null || season == MatchDefinition.of(m.matchId()).season())
                .filter(m -> !m.date().isAfter(date))
                .sorted((m1, m2) -> m2.date().compareTo(m1.date()))
                .toList();
    }

    public void setup(Competition competition, Integer season, Instant date) {
        this.competition = competition;
        this.season = season;
        this.date = date;
    }
}
