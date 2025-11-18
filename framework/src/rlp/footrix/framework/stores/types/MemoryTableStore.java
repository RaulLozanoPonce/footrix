package rlp.footrix.framework.stores.types;

import rlp.footrix.framework.stores.TableStore;
import rlp.footrix.framework.types.tables.TeamElo;

import java.util.ArrayList;
import java.util.List;

public class MemoryTableStore implements TableStore {
    private final List<TeamElo> teamElo = new ArrayList<>();

    @Override
    public void setup(List<TeamElo> teamElo) {
        this.teamElo.addAll(teamElo);
    }

    @Override
    public List<TeamElo> teamElo() {
        return teamElo;
    }
}
