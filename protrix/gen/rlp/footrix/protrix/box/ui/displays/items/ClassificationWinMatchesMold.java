package rlp.footrix.protrix.box.ui.displays.items;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.ItemNotifier;

public class ClassificationWinMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationWinMatches classificationWinMatches;

	public ClassificationWinMatchesMold(ProtrixBox box) {
		super(box);
		id("a1888069432");
	}

	@Override
	public void init() {
		super.init();
		if (classificationWinMatches == null) classificationWinMatches = register(new ClassificationWinMatches(box()).<ClassificationWinMatches>id("a1254451556").owner(ClassificationWinMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationWinMatches != null) classificationWinMatches.unregister();
	}

	public class ClassificationWinMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationWinMatches(ProtrixBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}

		@Override
		public void unregister() {
			super.unregister();
		}
	}
}