package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.ProtrixPlayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersDatasource extends PageDatasource<ProtrixPlayer> {

    public static final String TeamGroup = "Equipo";
    public static final String PositionGroup = "Posicion";

    private final ProtrixBox box;

    public PlayersDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<ProtrixPlayer> items(int start, int count, String condition, List<Filter> filters, List<String> sorting) {
        List<ProtrixPlayer> events = filterAndSort(box.application().playerManager().players().stream().map(p -> (ProtrixPlayer) p).toList(), filters);
        if (start > events.size()) return Collections.emptyList();
        int end = Math.min(start + count, events.size());
        return events.subList(start, end);

    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return filterAndSort(box.application().playerManager().players().stream().map(p -> (ProtrixPlayer) p).toList(), filters).size();
    }

    @Override
    public List<Group> groups(String key) {
        if (key.equalsIgnoreCase(TeamGroup))
            return box.application().teamManager().teams().stream().map(t -> new Group().label(t.definition().name()).name(t.definition().name())).toList();
        if (key.equalsIgnoreCase(PositionGroup))
            return Arrays.stream(Position.values()).map(p -> new Group().name(p.name()).label(p.name())).toList();
        return Collections.emptyList();
    }

    private List<ProtrixPlayer> filterAndSort(List<ProtrixPlayer> players, List<Filter> filters) {
        List<ProtrixPlayer> result = players.stream().filter(player -> filterPlayer(player, filters)).collect(Collectors.toList());
        sort(result);
        return result;
    }

    private boolean filterPlayer(ProtrixPlayer player, List<Filter> filters) {
        String teamId = player.team();
        if (teamId == null) return false;
        String teamName = box.application().teamManager().get(teamId).definition().name();
        for (Filter filter : filters) {
            if (filter.grouping().equalsIgnoreCase(TeamGroup) && !((GroupFilter)filter).groups().contains(teamName))
                return false;
            if (filter.grouping().equalsIgnoreCase(PositionGroup) && !((GroupFilter)filter).groups().contains(player.mainPosition().name()))
                return false;
        }
        return true;
    }

    private void sort(List<ProtrixPlayer> result) {
        result.sort(Comparator.comparing(p -> p.mood().gameTime()));
    }
}
