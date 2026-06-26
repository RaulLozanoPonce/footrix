package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.Comparator;
import java.util.List;

public class TeamsDatasource extends PageDatasource<Pes6Team> {
    private final ProtrixBox box;
    private Competition competition;
    private Integer season;
    private String search;

    private List<Pes6Team> teams;

    public TeamsDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Pes6Team> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return teams.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return teams.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.teams = box.application().entityStore().teams().stream()
                .filter(t -> competition == null || competition.compete(t))
                .filter(t -> search.isBlank() || t.definition().name().contains(search) || search.contains(t.definition().name()))
                .sorted(Comparator.comparing(t -> t.definition().name()))
                .map(t -> (Pes6Team) t)
                .toList();
    }

    public void setup(Competition competition, Integer season, String search) {
        this.competition = competition;
        this.season = season;
        this.search = search;
    }
}
