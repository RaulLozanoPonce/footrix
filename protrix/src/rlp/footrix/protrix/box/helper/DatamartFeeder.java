package rlp.footrix.protrix.box.helper;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.TeamMatchRecord;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.model.PlayerRecord;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DatamartFeeder {
    private final ProtrixBox box;

    public DatamartFeeder(ProtrixBox box) {
        this.box = box;
    }

    public void feedMatches() {
        CompetitionDefinition competition = box.application().competitionManager().definition("ESP-1");
        for (Match match : box.application().entityStore().matches(competition.id(), 0)) {
            Team local = box.application().teamManager().get(match.definition().local());
            Team visitant = box.application().teamManager().get(match.definition().visitant());
            box.graph().create().match(match.definition().id(), competition.name(), match.date(), local.definition().name(), visitant.definition().name(), match.localGoals(), match.visitantGoals());
        }
    }

    public void feedClassifications() {
        box.application().recordStore().teamMatchRecords().stream()
                .collect(Collectors.groupingBy(TeamMatchRecord::team))
                .values().forEach(this::feedClassifications);
    }

    private void feedClassifications(List<TeamMatchRecord> records) {
        TeamDefinition team = box.application().teamManager().definition(records.getFirst().team());
        box.graph().create().classification(
                records.getFirst().competition(),
                0,  //TODO
                records.getFirst().team(),
                team.name(),
                records.size(),
                (int) records.stream().filter(r -> r.streak() == 1).count(),
                (int) records.stream().filter(r -> r.streak() == 0).count(),
                (int) records.stream().filter(r -> r.streak() == -1).count(),
                records.stream().mapToInt(TeamMatchRecord::goalsFor).sum(),
                records.stream().mapToInt(TeamMatchRecord::goalsAgainst).sum(),
                records.stream().mapToInt(TeamMatchRecord::goalsFor).sum() - records.stream().mapToInt(TeamMatchRecord::goalsAgainst).sum(),
                records.stream().mapToInt(TeamMatchRecord::points).sum()
        );
    }

    public void feedPlayerRecords() {
        for (PlayerMatchRecord playerMatchRecord : box.application().recordStore().playerMatchRecords()) {
            Player player = box.application().entityStore().player(playerMatchRecord.player());
            feedPlayerRecords(PlayerRecord.Type.Goal, playerMatchRecord, PlayerMatchRecord::goals, player);
            feedPlayerRecords(PlayerRecord.Type.Assist, playerMatchRecord, PlayerMatchRecord::assists, player);
            feedPlayerRecords(PlayerRecord.Type.YellowCard, playerMatchRecord, PlayerMatchRecord::yellowCards, player);
            feedPlayerRecords(PlayerRecord.Type.RedCard, playerMatchRecord, PlayerMatchRecord::redCards, player);
            if (player.mainPosition() == Positions.PT && playerMatchRecord.playedMinutes() >= 60) feedPlayerRecords(PlayerRecord.Type.ReceivedGoals, playerMatchRecord, PlayerMatchRecord::receivedGoals, player);
            feedPlayerMatchRecord(playerMatchRecord, player);
        }
    }

    private void feedPlayerRecords(PlayerRecord.Type type, PlayerMatchRecord playerMatchRecord, Function<PlayerMatchRecord, Integer> function, Player player) {
        PlayerRecord playerRecord = box.graph().playerRecord(playerMatchRecord.competition(), playerMatchRecord.player(), type);
        if (playerRecord == null) {
            playerRecord = box.graph().create()
                    .playerRecord(playerMatchRecord.competition(), playerMatchRecord.team(), playerMatchRecord.player(), player.definition().name(), type, 0, 0, 0);
        }
        playerRecord.amount(playerRecord.amount() + function.apply(playerMatchRecord))
                .playedMatches(playerRecord.playedMatches() + (playerMatchRecord.playedMinutes() > 0 ? 1 : 0))
                .playedMinutes(playerRecord.playedMinutes() + playerMatchRecord.playedMinutes());
    }

    private void feedPlayerMatchRecord(PlayerMatchRecord playerMatchRecord, Player player) {
        boolean substitute = playerMatchRecord.enterMinute() == null || playerMatchRecord.enterMinute() > 0;
        String enterMinute = playerMatchRecord.enterMinute() == null ? null : String.valueOf(playerMatchRecord.enterMinute());
        String exitMinute = playerMatchRecord.exitMinute() == null || playerMatchRecord.exitMinute() == 90 ? null : String.valueOf(playerMatchRecord.exitMinute());
        String score = playerMatchRecord.score() == null ? null : String.valueOf(playerMatchRecord.score());
        box.graph().create().playerMatchRecord(playerMatchRecord.matchId(), player.team().definition().id(), 99, player.definition().name(), player.mainPosition().id(), enterMinute, exitMinute, playerMatchRecord.goals(), playerMatchRecord.assists(), playerMatchRecord.yellowCards(), playerMatchRecord.redCards(), score, substitute);
    }
}
