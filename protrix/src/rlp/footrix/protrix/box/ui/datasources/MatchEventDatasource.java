package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.ArrayList;
import java.util.List;

public class MatchEventDatasource extends PageDatasource<MatchEvent> {
    private final ProtrixBox box;

    private Match match;

    private List<MatchEvent> events;

    public MatchEventDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<MatchEvent> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
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
        if (match == null) this.events = new ArrayList<>();
        else this.events = match.events().stream()
                .filter(this::filter)
                .toList();
    }

    public void setup(Match match) {
        this.match = match;
    }

    private boolean filter(MatchEvent event) {
        if (event.type() == MatchEvent.Type.Save && event.metaInfo().get("type").getAsString().equals("penalty")) return true;
        if (event.type() == MatchEvent.Type.Fail && event.metaInfo().get("type").getAsString().equals("penalty")) return true;
        if (event.type() == MatchEvent.Type.Goal) return true;
        if (event.type() == MatchEvent.Type.Substitution) return true;
        if (event.type() == MatchEvent.Type.YellowCard) return true;
        if (event.type() == MatchEvent.Type.RedCard) return true;
        if (event.type() == MatchEvent.Type.Injury) return true;
        return false;
    }
}
