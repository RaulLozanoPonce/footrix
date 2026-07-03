package rlp.footrix.protrix.box.ui.displays.rows;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.RowNotifier;

public class PlayersTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public IdMold idMold;
	public NameMold nameMold;
	public TeamMold teamMold;
	public AgeMold ageMold;
	public RoleMold roleMold;
	public OverallMold overallMold;
	public PositionMold positionMold;
	public HappinessContractMold happinessContractMold;
	public HappinessGameTimeMold happinessGameTimeMold;
	public HappinessIndividualMold happinessIndividualMold;
	public HappinessCollectiveMold happinessCollectiveMold;
	public MinutesMold minutesMold;
	public ScoreMold scoreMold;
	public CacheIniMold cacheIniMold;
	public CacheMold cacheMold;

	public PlayersTableRow(ProtrixBox box) {
		super(box);
		id("a_590690427");
	}

	@Override
	public void init() {
		super.init();
		if (idMold == null) idMold = register(new IdMold((ProtrixBox)box()).<IdMold>id("a_1638842272").<IdMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (nameMold == null) nameMold = register(new NameMold((ProtrixBox)box()).<NameMold>id("a80416557").<NameMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (teamMold == null) teamMold = register(new TeamMold((ProtrixBox)box()).<TeamMold>id("a_330752281").<TeamMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (ageMold == null) ageMold = register(new AgeMold((ProtrixBox)box()).<AgeMold>id("a_36488660").<AgeMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (roleMold == null) roleMold = register(new RoleMold((ProtrixBox)box()).<RoleMold>id("a1845725370").<RoleMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (overallMold == null) overallMold = register(new OverallMold((ProtrixBox)box()).<OverallMold>id("a_1081093504").<OverallMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (positionMold == null) positionMold = register(new PositionMold((ProtrixBox)box()).<PositionMold>id("a_1861738126").<PositionMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (happinessContractMold == null) happinessContractMold = register(new HappinessContractMold((ProtrixBox)box()).<HappinessContractMold>id("a770794343").<HappinessContractMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (happinessGameTimeMold == null) happinessGameTimeMold = register(new HappinessGameTimeMold((ProtrixBox)box()).<HappinessGameTimeMold>id("a_1685662537").<HappinessGameTimeMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (happinessIndividualMold == null) happinessIndividualMold = register(new HappinessIndividualMold((ProtrixBox)box()).<HappinessIndividualMold>id("a1587012361").<HappinessIndividualMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (happinessCollectiveMold == null) happinessCollectiveMold = register(new HappinessCollectiveMold((ProtrixBox)box()).<HappinessCollectiveMold>id("a508997537").<HappinessCollectiveMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (minutesMold == null) minutesMold = register(new MinutesMold((ProtrixBox)box()).<MinutesMold>id("a_1928650418").<MinutesMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (scoreMold == null) scoreMold = register(new ScoreMold((ProtrixBox)box()).<ScoreMold>id("a_858810663").<ScoreMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (cacheIniMold == null) cacheIniMold = register(new CacheIniMold((ProtrixBox)box()).<CacheIniMold>id("a_40454484").<CacheIniMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
		if (cacheMold == null) cacheMold = register(new CacheMold((ProtrixBox)box()).<CacheMold>id("a_1006815537").<CacheMold>item(PlayersTableRow.this.item()).owner(PlayersTableRow.this));
	}

	@Override
	public void remove() {
		super.remove();
	}
}