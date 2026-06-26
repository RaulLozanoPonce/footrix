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

public class ClassificationPlayedMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationPlayedMatches classificationPlayedMatches;

	public ClassificationPlayedMatchesMold(ProtrixBox box) {
		super(box);
		id("a455385776");
	}

	@Override
	public void init() {
		super.init();
		if (classificationPlayedMatches == null) classificationPlayedMatches = register(new ClassificationPlayedMatches(box()).<ClassificationPlayedMatches>id("a1068415883").owner(ClassificationPlayedMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationPlayedMatches != null) classificationPlayedMatches.unregister();
	}

	public class ClassificationPlayedMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationPlayedMatches(ProtrixBox box) {
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