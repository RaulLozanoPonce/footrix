package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.Comparator;
import java.util.List;

public class CompetitionsDatasource extends PageDatasource<Competition> {
    private final ProtrixBox box;
    private double seasonNumber;
    private String search;

    private List<Competition> competitions;

    public CompetitionsDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Competition> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return competitions.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return competitions.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.competitions = box.application().entityStore().competitions((int) seasonNumber).stream()
                .filter(c -> search.isBlank() || c.definition().name().contains(search) || search.contains(c.definition().name()))
                .sorted(Comparator.comparing(c -> c.definition().name()))
                .toList();
    }

    public void setup(double seasonNumber, String search) {
        this.seasonNumber = seasonNumber;
        this.search = search;
    }
}
