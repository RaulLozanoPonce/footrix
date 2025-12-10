package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.Classification;

import java.util.List;

public class ClassificationDatasource extends PageDatasource<Classification> {
    private final ProtrixBox box;

    private String competitionId;

    private List<Classification> classifications;

    public ClassificationDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Classification> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return classifications;
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return classifications.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public ClassificationDatasource loadData() {
        this.classifications = box.graph().classificationList().stream()
                .filter(c -> c.competitionId().equals(competitionId))
                .sorted((c1, c2) -> Integer.compare(c2.points(), c1.points()))
                .toList();
        return this;
    }

    public ClassificationDatasource filter(String competitionId) {
        this.competitionId = competitionId;
        return this;
    }

    public int indexOf(Classification classification) {
        return classifications.indexOf(classification);
    }
}
