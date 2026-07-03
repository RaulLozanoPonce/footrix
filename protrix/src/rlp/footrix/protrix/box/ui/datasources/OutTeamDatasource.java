package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.TeamOut;

import java.time.Instant;
import java.util.List;

public class OutTeamDatasource extends PageDatasource<TeamOut> {
    private final ProtrixBox box;
    private Instant from;
    private Pes6Team team;

    private List<TeamOut> outs;

    public OutTeamDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<TeamOut> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return outs.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return outs.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.outs = box.graph().teamOutList().stream()
                .filter(o -> o.teamId().equals(team.definition().id()))
                .filter(o -> o.to() == null || !o.to().isBefore(from))
                .sorted((o1, o2) -> {
                    if (o1.to() == null && o2.to() == null) return 0;
                    if (o1.to() == null && o2.to() != null) return -1;
                    if (o1.to() != null && o2.to() == null) return 1;
                    return o2.to().compareTo(o1.to());
                })
                .toList();
    }

    public void setup(Instant from, Pes6Team team) {
        this.from = from;
        this.team = team;
    }
}
