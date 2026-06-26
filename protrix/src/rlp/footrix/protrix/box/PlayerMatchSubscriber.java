package rlp.footrix.protrix.box;

import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.model.Classification;
import rlp.footrix.protrix.model.PlayerRecord;

import java.util.List;

public class PlayerMatchSubscriber implements Subscriber<PlayedMatchEvent> {
    private final ProtrixApplication application;
    private final ProtrixBox box;

    public PlayerMatchSubscriber(ProtrixApplication application, ProtrixBox box) {
        this.application = application;
        this.box = box;
    }

    @Override
    public void receive(PlayedMatchEvent event) {
        Match match = box.application().entityStore().match(MatchDefinition.of(event.matchId()));
        updateClassificationsOf(match);
        updatePlayerRecordsOf(match);
    }

    private void updateClassificationsOf(Match match) {
        updateClassificationsOf(match.definition().local(), match);
        updateClassificationsOf(match.definition().visitant(), match);
    }

    private void updateClassificationsOf(String teamId, Match match) {

        TeamDefinition team = box.application().teamManager().definition(teamId);
        List<Classification> classifications = box.graph().classificationList().stream()
                .filter(c -> c.competitionId().equals(match.definition().competition()))
                .filter(c ->  c.phase() == match.definition().phase())
                .filter(c -> c.team().equals(teamId))
                .toList();
        if (classifications.size() > 1) throw new RuntimeException("Error");
        Classification classification;
        if (!classifications.isEmpty()) {
            classification = classifications.getFirst();
        } else {
            classification = box.graph().create().classification(match.definition().competition(), match.definition().phase(), teamId,
                    team.name(), 0, 0, 0, 0, 0, 0);
        }
        //TODO FALTA EL .SAVE
        classification.teamName(team.name())
                .playedGames(classification.playedGames() + 1)
                .wonGames(classification.wonGames() + countIf(match.streak(teamId) == 1))
                .drawGames(classification.drawGames() + countIf(match.streak(teamId) == 0))
                .lostGames(classification.lostGames() + countIf(match.streak(teamId) == -1))
                .goalsFor(classification.goalsFor() + match.goalsFor(teamId))
                .goalsAgainst(classification.goalsAgainst() + match.goalsAgainst(teamId));
    }

    private void updatePlayerRecordsOf(Match match) {
        for (String team : match.playerStatistics().keySet()) {
            for (String playerId : match.playerStatistics().get(team).keySet()) {
                Player player = application.entityStore().player(playerId);
                Match.PlayerStatistics statistics = match.playerStatistics().get(team).get(playerId);
                feedPlayerRecords(PlayerRecord.Type.Goal, match.definition().competition(), team, player, statistics.minutes(), statistics.goals());
                feedPlayerRecords(PlayerRecord.Type.Assist, match.definition().competition(), team, player, statistics.minutes(), statistics.assists());
                feedPlayerRecords(PlayerRecord.Type.YellowCard, match.definition().competition(), team, player, statistics.minutes(), statistics.yellowCards());
                feedPlayerRecords(PlayerRecord.Type.RedCard, match.definition().competition(), team, player, statistics.minutes(), statistics.redCards());
                feedPlayerRecords(PlayerRecord.Type.ReceivedGoals, match.definition().competition(), team, player, statistics.minutes(), statistics.receivedGoals());
                feedPlayerMatchRecord(match.definition().id(), statistics, player);
            }
        }
    }

    private void feedPlayerRecords(PlayerRecord.Type type, String competition, String team, Player player, int playedMinutes, Integer value) {
        if (value == null) return;
        PlayerRecord playerRecord = box.graph().playerRecord(competition, player.definition().id(), type);
        if (playerRecord == null) {
            playerRecord = box.graph().create()
                    .playerRecord(competition, team, player.definition().id(), player.definition().name(), type, 0, 0, 0);
        }
        playerRecord.amount(playerRecord.amount() + value)
                .playedMatches(playerRecord.playedMatches() + (playedMinutes > 0 ? 1 : 0))
                .playedMinutes(playerRecord.playedMinutes() + playedMinutes);
    }

    private void feedPlayerMatchRecord(String matchId, Match.PlayerStatistics statistics, Player player) {
        boolean substitute = statistics.enterMinute() == null || statistics.enterMinute() > 0;
        String enterMinute = statistics.enterMinute() == null ? null : String.valueOf(statistics.enterMinute());
        String exitMinute = statistics.exitMinute() == null || statistics.exitMinute() == 90 ? null : String.valueOf(statistics.exitMinute());
        String score = statistics.score() == null ? null : String.valueOf(statistics.score());
        box.graph().create().playerMatchRecord(matchId, player.team().definition().id(), 99, player.definition().name(), player.mainPosition().id(), enterMinute, exitMinute, statistics.goals(), statistics.assists(), statistics.yellowCards(), statistics.redCards(), score, substitute);
    }

    private int countIf(boolean predicate) {
        return predicate ? 1 : 0;
    }
}
