package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.OutTeamDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.OutTeamTableRow;
import rlp.footrix.protrix.model.TeamOut;

import java.time.Instant;

public class OutTeamTemplate extends AbstractOutTeamTemplate<ProtrixBox> {
    private final OutTeamDatasource datasource;

    private Instant from;
    private Pes6Team team;

    public OutTeamTemplate(ProtrixBox box) {
        super(box);
        this.datasource = new OutTeamDatasource(box());
    }

    @Override
    public void init() {
        super.init();
        initTable();
    }

    public OutTeamTemplate setup(Instant from, Pes6Team team) {
        this.from = from;
        this.team = team;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshTable();
        outTeamTable.source(datasource);
    }

    private void initTable() {
        outTeamTable.onAddItem(this::addPlayer);
    }

    private void refreshTable() {
        datasource.setup(from, team);
        datasource.loadData();
        outTeamTable.reload();
    }

    private void addPlayer(AddCollectionItemEvent event) {
        TeamOut out = event.item();
        OutTeamTableRow item = event.component();
        Pes6Player player = (Pes6Player) box().application().playerManager().get(out.playerId());
        item.outTeamPositionMold.outTeamPosition.value(String.valueOf(player.mainPosition().id()));
        item.outTeamPositionMold.outTeamPosition.backgroundColor(colorOfPosition(player.mainPosition().id()));
        item.outTeamNameMold.outTeamName.value(player.definition().name());
        item.outTeamFromMold.outTeamFrom.value(out.from().toString());
        item.outTeamToMold.outTeamTo.value(out.to() == null ? "" : out.to().toString());
        item.outTeamDescriptionMold.outTeamDescription.value(description(out));
    }

    private String description(TeamOut out) {
        if (out.type() == TeamOut.Type.Injury) {
            return scale(out) + " lesionado";
        } else {
            int matches = out.matches();
            return matches + " partido" + (matches > 1 ? "s" : "") + " sancionado en " + box().application().competitionManager().definition(out.competition()).name();
        }
    }

    private String scale(TeamOut out) {
        if (TimeHelper.getInstantDiff(out.from(), out.to(), TimeHelper.Scale.Year) >= 1) return scale(out, TimeHelper.Scale.Year, "año", "s");
        if (TimeHelper.getInstantDiff(out.from(), out.to(), TimeHelper.Scale.Month) >= 1) return scale(out, TimeHelper.Scale.Month, "mes", "es");
        if (TimeHelper.getInstantDiff(out.from(), out.to(), TimeHelper.Scale.Week) >= 1) return scale(out, TimeHelper.Scale.Week, "semana", "s");
        return scale(out, TimeHelper.Scale.Day, "día", "s");
    }

    private String scale(TeamOut out, TimeHelper.Scale scale, String unit, String plural) {
        long diff = TimeHelper.getInstantDiff(out.from(), out.to(), scale);
        return diff + " " + unit + (diff > 1 ? plural : "");
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