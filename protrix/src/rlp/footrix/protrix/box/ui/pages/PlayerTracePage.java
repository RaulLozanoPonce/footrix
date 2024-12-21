package rlp.footrix.protrix.box.ui.pages;

import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import rlp.footrix.protrix.box.ui.displays.templates.*;

public class PlayerTracePage extends AbstractPlayerTracePage {
	public String playerId;

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
		return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				PlayerTraceTemplate component = new PlayerTraceTemplate(box);
				register(component);
				component.init();
			}
		};
	}
}