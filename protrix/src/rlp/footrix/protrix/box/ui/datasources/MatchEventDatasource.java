package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;

public class MatchEventDatasource extends PageDatasource<Match.MatchEvent> {
    private final ProtrixBox box;

    private Match match;

    private List<Match.MatchEvent> events;

    public MatchEventDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Match.MatchEvent> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return events.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return events.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.events = match.events().stream().filter(e -> e.type() != Match.MatchEvent.Type.Expulsion).toList();
    }

    public void filter(Match match) {
        this.match = match;
    }
}
