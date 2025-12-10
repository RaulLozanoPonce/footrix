package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.Match;

import java.util.List;

public class MatchDatasource extends PageDatasource<Match> {
    private final ProtrixBox box;

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
                .sorted((m1, m2) -> m2.date().compareTo(m1.date()))
                .toList();
    }
}
