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

public class ClassificationPointsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationPoints classificationPoints;

	public ClassificationPointsMold(ProtrixBox box) {
		super(box);
		id("a_1821952221");
	}

	@Override
	public void init() {
		super.init();
		if (classificationPoints == null) classificationPoints = register(new ClassificationPoints(box()).<ClassificationPoints>id("a2044674053").owner(ClassificationPointsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationPoints != null) classificationPoints.unregister();
	}

	public class ClassificationPoints extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationPoints(ProtrixBox box) {
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