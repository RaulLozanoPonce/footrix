package rlp.footrix.framework.stores.types;

import rlp.footrix.framework.stores.RecordStore;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.TeamMatchRecord;

import java.util.ArrayList;
import java.util.List;

public class MemoryRecordStore implements RecordStore {
    private final List<PlayerMatchRecord> playerMatchRecords = new ArrayList<>();
    private final List<TeamMatchRecord> teamMatchRecord = new ArrayList<>();

    @Override
    public List<PlayerMatchRecord> playerMatchRecords() {
        return playerMatchRecords;
    }

    @Override
    public List<TeamMatchRecord> teamMatchRecords() {
        return teamMatchRecord;
    }
}
