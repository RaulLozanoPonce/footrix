package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.List;

public class SquadTeamDatasource extends PageDatasource<Pes6Player> {
    private final ProtrixBox box;
    private Integer season;
    private Pes6Team team;

    private List<Pes6Player> players;

    public SquadTeamDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<Pes6Player> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return players.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return players.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.players = team.players().stream()
                .map(p -> (Pes6Player) p)
                .sorted((p1, p2) -> Positions.compare(p1.mainPosition(), p2.mainPosition()))    //TODO USAR DORSAL EN SEGUNDA INSTANCIA
                .toList();
    }

    public void setup(Integer season, Pes6Team team) {
        this.season = season;
        this.team = team;
    }
}
