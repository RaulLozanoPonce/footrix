package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;

import java.time.Instant;
import java.util.List;

public class MatchDatasource extends PageDatasource<MatchDefinition> {
    private final ProtrixBox box;
    private Competition competition;
    private Integer season;
    private Pes6Team team;
    private Instant date;

    private List<MatchDefinition> matches;

    public MatchDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<MatchDefinition> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
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
        this.matches = box.application().matchManager().get(Instant.ofEpochMilli(0), date, season, competition(), List.of(this::filter));
    }

    private String competition() {
        if (competition == null) return null;
        return competition.definition().id();
    }

    private boolean filter(MatchDefinition definition) {
        return team == null || team.definition().id().equals(definition.local()) || team.definition().id().equals(definition.visitant());
    }

    public void setup(Competition competition, Integer season, Pes6Team team, Instant date) {
        this.competition = competition;
        this.season = season;
        this.team = team;
        this.date = date;
    }
}
