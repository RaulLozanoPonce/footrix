package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.PlayerRecord;

import java.util.Comparator;
import java.util.List;

public class TopPlayerRecordDatasource extends PageDatasource<PlayerRecord> {
    private final ProtrixBox box;
    private String competitionId;
    private int season;
    private PlayerRecord.Type type;

    private List<PlayerRecord> records;

    public TopPlayerRecordDatasource(ProtrixBox box) {
        this.box = box;
    }

    @Override
    public List<PlayerRecord> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return records.stream()
                .skip(start)
                .limit(count)
                .toList();
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return records.size();
    }

    @Override
    public List<Group> groups(String key) {
        return List.of();
    }

    public void loadData() {
        this.records = box.graph().playerRecordList().stream()
                .filter(r -> r.competitionId().equals(competitionId))
                .filter(r -> r.type() == type)
                .filter(r -> filter(r, type))
                .sorted(sort(type))
                .limit(5)
                .toList();
    }

    private boolean filter(PlayerRecord record, PlayerRecord.Type type) {
        if (type == PlayerRecord.Type.ReceivedGoals) return record.playedMatches() >= 28;   //TODO DEPENDE DE LOS PARTIDOS
        return true;
    }

    private static Comparator<PlayerRecord> sort(PlayerRecord.Type type) {
        if (type == PlayerRecord.Type.ReceivedGoals) return Comparator.comparingDouble(r -> r.amount() / r.playedMinutes());
        return (r1, r2) -> Integer.compare(r2.amount(), r1.amount());
    }

    public int indexOf(PlayerRecord record) {
        return records.indexOf(record);
    }

    public void setup(String competitionId, int season, PlayerRecord.Type type) {
        this.competitionId = competitionId;
        this.season = season;
        this.type = type;
    }
}
