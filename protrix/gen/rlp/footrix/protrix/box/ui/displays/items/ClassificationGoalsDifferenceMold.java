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

public class ClassificationGoalsDifferenceMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationGoalsDifference classificationGoalsDifference;

	public ClassificationGoalsDifferenceMold(ProtrixBox box) {
		super(box);
		id("a_1581607794");
	}

	@Override
	public void init() {
		super.init();
		if (classificationGoalsDifference == null) classificationGoalsDifference = register(new ClassificationGoalsDifference(box()).<ClassificationGoalsDifference>id("a_73918362").owner(ClassificationGoalsDifferenceMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationGoalsDifference != null) classificationGoalsDifference.unregister();
	}

	public class ClassificationGoalsDifference extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationGoalsDifference(ProtrixBox box) {
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