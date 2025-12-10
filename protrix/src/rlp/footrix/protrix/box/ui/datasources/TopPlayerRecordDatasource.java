package rlp.footrix.protrix.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.PlayerRecord;

import java.util.List;

public class TopPlayerRecordDatasource extends PageDatasource<PlayerRecord> {
    private final ProtrixBox box;

    private String competition;
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

    public TopPlayerRecordDatasource filter(String competition, PlayerRecord.Type type) {
        this.competition = competition;
        this.type = type;
        return this;
    }

    public void loadData() {
        this.records = box.graph().playerRecordList().stream()
                .filter(r -> r.competitionId().equals(competition))
                .filter(r -> r.type() == type)
                .sorted((r1, r2) -> Integer.compare(r2.amount(), r1.amount()))
                .limit(5)
                .toList();
    }

    public int indexOf(PlayerRecord record) {
        return records.indexOf(record);
    }
}
