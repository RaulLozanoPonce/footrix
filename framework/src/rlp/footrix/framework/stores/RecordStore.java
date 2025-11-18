package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.TeamMatchRecord;

import java.time.Instant;
import java.util.List;

public interface RecordStore {
    List<PlayerMatchRecord> playerMatchRecords();
    List<TeamMatchRecord> teamMatchRecords();

    default PlayerMatchRecord playerMatchRecord(String player, String team, String competition, int season) {
        return playerMatchRecords().stream()
                .filter(r -> r.player().equals(player))
                .filter(r -> r.team().equals(team))
                .filter(r -> r.competition().equals(competition))
                .filter(r -> r.season() == season)
                .findFirst().orElse(null);
    }

    default List<TeamMatchRecord> teamMatchRecords(String team) {
        return teamMatchRecords().stream()
                .filter(r -> r.team().equals(team))
                .toList();
    }

    default TeamMatchRecord teamMatchRecord(String team, String competition, int season) {
        return teamMatchRecords(team).stream()
                .filter(r -> r.competition().equals(competition))
                .filter(r -> r.season() == season)
                .findFirst().orElse(null);
    }

    default Create create() {
        return new Create(this);
    }

    default void playerMatchRecord(PlayerMatchRecord analysis) {
        playerMatchRecords().add(analysis);
    }

    default void teamMatchRecord(TeamMatchRecord analysis) {
        teamMatchRecords().add(analysis);
    }

    record Create(RecordStore store) {
        public PlayerMatchRecord playerMatchRecord(String player, String team, String competition, int season) {
            PlayerMatchRecord analysis = new PlayerMatchRecord(player, team, competition, season);
            store.playerMatchRecords().add(analysis);
            return analysis;
        }

        public TeamMatchRecord teamMatchRecord(String team, String competition, int season, Instant date, int goalsFor, int goalsAgainst) {
            TeamMatchRecord analysis = new TeamMatchRecord(team, competition, season, date, goalsFor, goalsAgainst);
            store.teamMatchRecord(analysis);
            return analysis;
        }
    }
}