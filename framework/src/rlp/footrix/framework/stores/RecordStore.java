package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.PlayerMinuteRecord;
import rlp.footrix.framework.types.records.TeamMatchRecord;

import java.time.Instant;
import java.util.List;

public interface RecordStore {
    List<PlayerMinuteRecord> playerMinuteRecords();
    List<PlayerMatchRecord> playerMatchRecords();
    List<TeamMatchRecord> teamMatchRecords();

    default List<PlayerMinuteRecord> playerMinuteRecords(String player) {
        return playerMinuteRecords().stream()
                .filter(r -> r.player().equals(player))
                .toList();
    }

    default List<PlayerMatchRecord> playerMatchRecords(String player, String team, String competition, int season) {
        return playerMatchRecords().stream()
                .filter(r -> r.player().equals(player))
                .filter(r -> r.team().equals(team))
                .filter(r -> r.competition().equals(competition))
                .filter(r -> r.season() == season)
                .toList();
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

    record Create(RecordStore store) {
        public PlayerMinuteRecord playerMinuteRecord(String matchId, String player, Instant date, int minute, double energy, double stamina) {
            PlayerMinuteRecord analysis = new PlayerMinuteRecord(matchId, player, date, minute, energy, stamina);
            store.playerMinuteRecords().add(analysis);
            return analysis;
        }

        public PlayerMatchRecord playerMatchRecord(String matchId, String player, String team, String competition, int season, Instant date, Integer enterMinute, Integer exitMinute, int maxMinutes, Double score, boolean injured, boolean expelled, int goals, int assists, int yellowCards, int redCards, double preEnergy) {
            PlayerMatchRecord analysis = new PlayerMatchRecord(matchId, player, team, competition, season, date, enterMinute, exitMinute, maxMinutes, score, injured, expelled, goals, assists, yellowCards, redCards, preEnergy);
            store.playerMatchRecords().add(analysis);
            return analysis;
        }

        public TeamMatchRecord teamMatchRecord(String team, String competition, int season, Instant date, int goalsFor, int goalsAgainst) {
            TeamMatchRecord analysis = new TeamMatchRecord(team, competition, season, date, goalsFor, goalsAgainst);
            store.teamMatchRecords().add(analysis);
            return analysis;
        }
    }
}