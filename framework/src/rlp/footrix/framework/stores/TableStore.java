package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.tables.TeamElo;

import java.util.List;

public interface TableStore {
    void setup(List<TeamElo> teamElo);
    List<TeamElo> teamElo();

    default TeamElo teamElo(String team) {
        return teamElo().stream()
                .filter(r -> r.team().equals(team))
                .findFirst().orElse(null);
    }

    default TeamElo maxElo() {
        return teamElo().stream().reduce((te1, te2) -> {
            if (te1.elo() > te2.elo()) return te1;
            return te2;
        }).orElse(null);
    }

    default Create create() {
        return new Create(this);
    }

    default void teamElo(TeamElo analysis) {
        teamElo().add(analysis);
    }

    record Create(TableStore store) {
        public TeamElo teamElo(String team) {
            TeamElo analysis = new TeamElo(team, 0);
            store.teamElo(analysis);
            return analysis;
        }
    }
}
