package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.pes6.types.Pes6Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersDatasource extends PageDatasource<Pes6Player> {

    public static final String TeamGroup = "Equipo";
    public static final String RoleGroup = "Rol";
    public static final String RetiredGroup = "Retirado";
    public static final String PositionGroup = "Posicion";

    private final ProtrixBox box;

    public PlayersDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Pes6Player> items(int start, int count, String condition, List<Filter> filters, List<String> sorting) {
        List<Pes6Player> events = filterAndSort(box.application().playerManager().players().stream().map(p -> (Pes6Player) p).toList(), filters);
        if (start > events.size()) return Collections.emptyList();
        int end = Math.min(start + count, events.size());
        return events.subList(start, end);

    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return filterAndSort(box.application().playerManager().players().stream().map(p -> (Pes6Player) p).toList(), filters).size();
    }

    @Override
    public List<Group> groups(String key) {
        if (key.equalsIgnoreCase(TeamGroup))
            return box.application().teamManager().teamDefinitions().stream().map(t -> new Group().label(t.name()).name(t.name())).toList();
        if (key.equalsIgnoreCase(PositionGroup))
            return Positions.values().stream().map(p -> new Group().name(p.id()).label(p.id())).toList();
        if (key.equalsIgnoreCase(RoleGroup))
            return Arrays.stream(PlayerContract.Role.values()).map(p -> new Group().name(p.name()).label(p.name())).toList();
        if (key.equalsIgnoreCase(RetiredGroup))
            return List.of(new Group().name("true").label("Sí"), new Group().name("false").label("No"));
        return Collections.emptyList();
    }

    private List<Pes6Player> filterAndSort(List<Pes6Player> players, List<Filter> filters) {
        List<Pes6Player> result = players.stream().filter(player -> filterPlayer(player, filters)).collect(Collectors.toList());
        sort(result);
        return result;
    }

    private boolean filterPlayer(Pes6Player player, List<Filter> filters) {
        Team team = player.team();
        if (team == null) return false;
        String teamName = team.definition().name();
        for (Filter filter : filters) {
            if (filter.grouping().equalsIgnoreCase(TeamGroup) && !((GroupFilter)filter).groups().contains(teamName))
                return false;
            if (filter.grouping().equalsIgnoreCase(PositionGroup) && !((GroupFilter)filter).groups().contains(player.mainPosition().id()))
                return false;
            if (filter.grouping().equalsIgnoreCase(RoleGroup) && (player.contract() == null || !((GroupFilter)filter).groups().contains(player.contract().role().name())))
                return false;
            if (filter.grouping().equalsIgnoreCase(RetiredGroup) && !((GroupFilter)filter).groups().contains(retired(player)))
                return false;
        }
        return true;
    }

    private String retired(Pes6Player player) {
        if (player.active()) return "false";
        return "true";
    }

    private void sort(List<Pes6Player> result) {
        result.sort(Comparator.comparing(p -> p.psychophysics().gameTimeSatisfaction()));
    }
}
