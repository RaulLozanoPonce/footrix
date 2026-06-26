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

public class ClassificationPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationPosition classificationPosition;

	public ClassificationPositionMold(ProtrixBox box) {
		super(box);
		id("a_93685048");
	}

	@Override
	public void init() {
		super.init();
		if (classificationPosition == null) classificationPosition = register(new ClassificationPosition(box()).<ClassificationPosition>id("a_891572602").owner(ClassificationPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationPosition != null) classificationPosition.unregister();
	}

	public class ClassificationPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationPosition(ProtrixBox box) {
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