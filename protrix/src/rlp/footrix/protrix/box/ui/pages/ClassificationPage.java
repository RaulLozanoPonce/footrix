package rlp.footrix.protrix.box.ui.pages;

import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import rlp.footrix.protrix.box.ui.displays.templates.*;

public class ClassificationPage extends AbstractClassificationPage {
	public String competitionId;

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
		return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				ClassificationTemplate component = new ClassificationTemplate(box);
				register(component);
				component.init();
			}
		};
	}
}