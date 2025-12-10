package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.PlayerMatchRecord;

import java.util.Comparator;
import java.util.List;

public class PlayerMatchRecordDatasource extends PageDatasource<PlayerMatchRecord> {
    private final ProtrixBox box;

    private Match match;
    private String team;

    private List<PlayerMatchRecord> playerMatchRecords;

    public PlayerMatchRecordDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<PlayerMatchRecord> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return playerMatchRecords.stream()
                .filter(PlayerMatchRecord::substitute)
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return playerMatchRecords.stream().filter(PlayerMatchRecord::substitute).count();
    }

    @Override
    public List<Group> groups(String s) {
        return List.of();
    }

    public void loadData() {
        this.playerMatchRecords = box.graph().playerMatchRecordList().stream()
                .filter(r -> r.matchId().equals(match.definition().id()))
                .filter(r -> r.teamId().equals(team))
                .sorted(Comparator.comparingInt(PlayerMatchRecord::number))
                .toList();
    }

    public void filter(Match match, String team) {
        this.match = match;
        this.team = team;
    }

    public PlayerMatchRecord recordOf(Player player) {
        //TODO DEBE SER POR ID
        return playerMatchRecords.stream().filter(r -> r.playerName().equals(player.definition().name())).findFirst().orElse(null);
    }
}
