package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.helper.Math;
import rlp.footrix.protrix.model.PlayerMatchRecord;

public class MatchLineupPinTemplate extends AbstractMatchLineupPinTemplate<ProtrixBox> {
    private Player player;
    private PlayerMatchRecord record;

    public MatchLineupPinTemplate(ProtrixBox box) {
		super(box);
	}

    public MatchLineupPinTemplate setup(Player player, PlayerMatchRecord record) {
        this.player = player;
        this.record = record;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        goalsIcon.visible(record.goals() > 0);
        goals.visible(record.goals() > 1 || (record.goals() > 0 && record.assists() > 0));
        goals.value(String.valueOf(record.goals()));
        assistsIcon.visible(record.assists() > 0 && record.goals() == 0);
        assists.visible(record.assists() > 1 || (record.assists() > 0 && record.goals() > 0));
        assists.value(String.valueOf(record.assists()));
        position.backgroundColor(colorOfPosition(record.position()));
        position.value(record.position());
        score.backgroundColor(colorOfScore(Double.parseDouble(record.score())));
        score.value(String.valueOf(Math.round(Double.parseDouble(record.score()), 1)));
        exits.visible(record.exits() != null);
        exits.value(record.exits() + "'");
        number.value("99");
        yellowCardsIcon.visible(record.yellowCards() == 1 && record.redCards() == 0);
        redCardsIcon.visible(record.redCards() > 0 || record.yellowCards() > 1);
        name.value(player.definition().name());
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