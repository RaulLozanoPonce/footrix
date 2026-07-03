package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;

import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.helper.Math;
import rlp.footrix.protrix.box.ui.datasources.PlayerMatchRecordDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.MatchPlayersTableRow;
import rlp.footrix.protrix.model.PlayerMatchRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchPlayersTemplate extends AbstractMatchPlayersTemplate<ProtrixBox> {
    private final PlayerMatchRecordDatasource playerMatchRecordDatasource;
    private Map<Player, Integer[]> lineup = new HashMap<>();

    public MatchPlayersTemplate(ProtrixBox box) {
		super(box);
        this.playerMatchRecordDatasource = new PlayerMatchRecordDatasource(box);
	}

    @Override
    public void init() {
        super.init();
        matchPlayersTable.onAddItem(this::addPlayer);
    }

    public MatchPlayersTemplate setup(MatchDefinition definition, Match match, String team) {
        this.playerMatchRecordDatasource.filter(definition, team);
        if (match != null) {
            this.lineup = team.equals(definition.local()) ? match.localLineup() : match.visitantLineup();
        }
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        fieldImage.refresh();
        playerMatchRecordDatasource.loadData();
        refreshFields();
        matchPlayersTable.source(playerMatchRecordDatasource);
    }

    private void addPlayer(AddCollectionItemEvent event) {
        PlayerMatchRecord playerMatchRecord = event.item();
        MatchPlayersTableRow item = event.component();
        item.matchPlayersNumberMold.matchPlayersNumber.value(String.valueOf(playerMatchRecord.number()));
        item.matchPlayersNameMold.matchPlayersName.value(playerMatchRecord.playerName());
        item.matchPlayersPositionMold.matchPlayersPosition.backgroundColor(colorOfPosition(playerMatchRecord.position()));
        item.matchPlayersPositionMold.matchPlayersPosition.value(playerMatchRecord.position());
        item.matchPlayersEntersMold.matchPlayersEnters.value(playerMatchRecord.enters());
        item.matchPlayersExitsMold.matchPlayersExits.value(playerMatchRecord.exits());
        item.matchPlayersGoalsMold.matchPlayersGoals.value(String.valueOf(playerMatchRecord.goals()));
        item.matchPlayersAssistsMold.matchPlayersAssists.value(String.valueOf(playerMatchRecord.assists()));
        item.matchPlayersYellowCardsMold.matchPlayersYellowCards.value(String.valueOf(playerMatchRecord.yellowCards()));
        item.matchPlayersRedCardsMold.matchPlayersRedCards.value(String.valueOf(playerMatchRecord.redCards()));
        if (playerMatchRecord.score() != null) {
            item.matchPlayersScoreMold.matchPlayersScore.backgroundColor(colorOfScore(Double.parseDouble(playerMatchRecord.score())));
            item.matchPlayersScoreMold.matchPlayersScore.value(String.valueOf(Math.round(Double.parseDouble(playerMatchRecord.score()), 1)));
        }
    }

    private void refreshFields() {
        int i = 1;
        for (Player player : lineup.keySet()) {
            Integer[] position = lineup.get(player);
            if (i == 1) {
                p1.formats(Set.of("p" + position[0] + position[1]));
                player1.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 2) {
                p2.formats(Set.of("p" + position[0] + position[1]));
                player2.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 3) {
                p3.formats(Set.of("p" + position[0] + position[1]));
                player3.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 4) {
                p4.formats(Set.of("p" + position[0] + position[1]));
                player4.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 5) {
                p5.formats(Set.of("p" + position[0] + position[1]));
                player5.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 6) {
                p6.formats(Set.of("p" + position[0] + position[1]));
                player6.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 7) {
                p7.formats(Set.of("p" + position[0] + position[1]));
                player7.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 8) {
                p8.formats(Set.of("p" + position[0] + position[1]));
                player8.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 9) {
                p9.formats(Set.of("p" + position[0] + position[1]));
                player9.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 10) {
                p10.formats(Set.of("p" + position[0] + position[1]));
                player10.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            if (i == 11) {
                p11.formats(Set.of("p" + position[0] + position[1]));
                player11.setup(player, playerMatchRecordDatasource.recordOf(player)).refresh();
            }
            i++;
        }
    }

    private String colorOfPosition(String positionId) {
        return switch (positionId) {
            case "PT" -> "#ffa400";
            case "CT", "CAR" -> "#00afda";
            case "LAT", "CCD", "CC", "MP", "VOL" -> "#7ab504";
            case "EXT", "SS", "DL" -> "#f83333";
            default -> "black";
        };
    }

    private String colorOfScore(double score) {
        if (score < 5) return "#f83333";
        if (score < 5.7) return "#ffa400";
        if (score < 7) return "#7ab504";
        if (score < 8.5) return "#145600";
        return "#00afda";
    }
}