package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.framework.types.records.PlayerMinuteRecord;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.protrix.box.*;

import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.datasources.PlayerMinuteTraceDatasource;
import rlp.footrix.protrix.box.ui.datasources.PlayerTraceDatasource;
import rlp.footrix.protrix.box.ui.displays.rows.MinuteTraceTableRow;
import rlp.footrix.protrix.box.ui.displays.rows.TraceTableRow;
import rlp.footrix.protrix.box.ui.displays.templates.AbstractPlayerMatchTraceTemplate;

public class PlayerMatchTraceTemplate extends AbstractPlayerMatchTraceTemplate<ProtrixBox> {
    private Pes6Player player;

	public PlayerMatchTraceTemplate(ProtrixBox box) {
		super(box);
	}

    public PlayerMatchTraceTemplate setPlayer(String playerId) {
        this.player = (Pes6Player) box().application().playerManager().get(playerId);
        initHeader();
        initTable();
        return this;
    }

    private void initHeader() {
        name.value(player.definition().name());
    }

    private void initTable() {
        minuteTraceTable.source(new PlayerMinuteTraceDatasource(box(), player.definition().id()));
        minuteTraceTable.onAddItem(this::renderTableItem);
    }

    private void renderTableItem(AddCollectionItemEvent event) {
        PlayerMinuteRecord record = event.item();
        MinuteTraceTableRow row = event.component();
        row.matchTraceMinuteMold.matchTrace.value(record.matchId());
        row.dateTraceMinuteMold.dateTrace.value(record.date());
        row.minuteTraceMinuteMold.minuteTrace.value(String.valueOf(record.minute()));
        row.staminaTraceMinuteMold.staminaTrace.value(record.stamina());
        row.energyTraceMinuteMold.energyTrace.value(record.energy());
    }
}