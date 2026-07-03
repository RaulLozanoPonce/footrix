package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.SquadTeamDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.SquadTeamTableRow;
import rlp.footrix.protrix.model.PlayerRecord;

public class SquadTeamTemplate extends AbstractSquadTeamTemplate<ProtrixBox> {
    private final SquadTeamDatasource datasource;

    private int season;
    private Pes6Team team;

    public SquadTeamTemplate(ProtrixBox box) {
		super(box);
        this.datasource = new SquadTeamDatasource(box());
	}

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public SquadTeamTemplate setup(int season, Pes6Team team) {
        this.season = season;
        this.team = team;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshTable();
        squadTeamTable.source(datasource);
    }

    private void initTable() {
        squadTeamTable.onAddItem(this::addPlayer);
    }

    private void refreshTable() {
        datasource.setup(season, team);
        datasource.loadData();
        squadTeamTable.reload();
    }

    private void addPlayer(AddCollectionItemEvent event) {
        Pes6Player player = event.item();
        SquadTeamTableRow item = event.component();
        item.squadTeamNumberMold.squadTeamNumber.value("99");
        item.squadTeamPositionMold.squadTeamPosition.value(String.valueOf(player.mainPosition().id()));
        item.squadTeamPositionMold.squadTeamPosition.backgroundColor(colorOfPosition(player.mainPosition().id()));
        item.squadTeamNameMold.squadTeamName.value(player.definition().name());
        //item.squadTeamCountryMold.squadTeamCountry.value(String.valueOf(player.playedGames()));
        item.squadTeamMatchesMold.squadTeamMatches.value(String.valueOf(matchesOf(player)));
        item.squadTeamMinutesMold.squadTeamMinutes.value(minutesOf(player) + "'");
        item.squadTeamGoalsMold.squadTeamGoals.value(String.valueOf(goalsOf(player)));
        item.squadTeamAssistsMold.squadTeamAssists.value(String.valueOf(assistsOf(player)));
        item.squadTeamYellowCardsMold.squadTeamYellowCards.value(String.valueOf(yellowCardsOf(player)));
        item.squadTeamRedCardsMold.squadTeamRedCards.value(String.valueOf(redCardsOf(player)));
    }

    private int matchesOf(Pes6Player player) {
        return box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .mapToInt(PlayerRecord::playedMatches)
                .max().orElse(0);
    }

    private int minutesOf(Pes6Player player) {
        return (int) box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .mapToDouble(PlayerRecord::playedMinutes)
                .max().orElse(0.0);
    }

    private int goalsOf(Pes6Player player) {
        return box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .filter(r -> r.type() == PlayerRecord.Type.Goal)
                .mapToInt(PlayerRecord::amount)
                .max().orElse(0);
    }

    private int assistsOf(Pes6Player player) {
        return box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .filter(r -> r.type() == PlayerRecord.Type.Assist)
                .mapToInt(PlayerRecord::amount)
                .max().orElse(0);
    }

    private int yellowCardsOf(Pes6Player player) {
        return box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .filter(r -> r.type() == PlayerRecord.Type.YellowCard)
                .mapToInt(PlayerRecord::amount)
                .max().orElse(0);
    }

    private int redCardsOf(Pes6Player player) {
        return box().graph().playerRecordList().stream()
                .filter(r -> r.playerId().equals(player.definition().id())) //TODO FALTA SEASON
                .filter(r -> r.teamName().equals(team.definition().id()))
                .filter(r -> r.type() == PlayerRecord.Type.RedCard)
                .mapToInt(PlayerRecord::amount)
                .max().orElse(0);
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
}