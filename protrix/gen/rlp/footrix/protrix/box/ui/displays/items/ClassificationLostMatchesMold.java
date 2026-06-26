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

public class ClassificationLostMatchesMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationLostMatches classificationLostMatches;

	public ClassificationLostMatchesMold(ProtrixBox box) {
		super(box);
		id("a_1065640099");
	}

	@Override
	public void init() {
		super.init();
		if (classificationLostMatches == null) classificationLostMatches = register(new ClassificationLostMatches(box()).<ClassificationLostMatches>id("a_23543993").owner(ClassificationLostMatchesMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationLostMatches != null) classificationLostMatches.unregister();
	}

	public class ClassificationLostMatches extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationLostMatches(ProtrixBox box) {
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