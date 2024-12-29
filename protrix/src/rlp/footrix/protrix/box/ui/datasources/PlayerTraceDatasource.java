package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.var.PlayerMatchPerformance;
import rlp.footrix.framework.var.VarTerminal;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerTraceDatasource extends PageDatasource<PlayerMatchPerformance> {

    //TODO OPTIMIZAR
    private final List<PlayerMatchPerformance> trace;

    public PlayerTraceDatasource(ProtrixBox box, String player) {
        this.trace = VarTerminal
                .revisions(PlayerMatchPerformance.class).stream().filter(r -> r.player().equals(player))
                .sorted(Comparator.comparing(PlayerMatchPerformance::date))
                .toList();
    }

    @Override
    public List<PlayerMatchPerformance> items(int start, int count, String condition, List<Filter> filters, List<String> sorting) {
        if (start > trace.size()) return Collections.emptyList();
        int end = Math.min(start + count, trace.size());
        return trace.subList(start, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return trace.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }
}
