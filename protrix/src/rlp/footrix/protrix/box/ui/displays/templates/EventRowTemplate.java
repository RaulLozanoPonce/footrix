package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.types.Match;
import rlp.footrix.protrix.box.ProtrixBox;

public class EventRowTemplate extends AbstractEventRowTemplate<ProtrixBox> {

	public EventRowTemplate(ProtrixBox box) {
		super(box);
	}

	public void event(boolean isLocal, Match.MatchEvent event) {
		String playerName = box().application().playerManager().get(event.who()).definition().name();
		this.minute.value(event.minute() + "'");
		this.type.value(event.type().name());
		this.localWho.value(isLocal ? playerName : "");
		this.visitantWho.value(!isLocal ? playerName : "");
	}
}