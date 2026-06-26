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

public class ClassificationTeamMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public ClassificationTeam classificationTeam;

	public ClassificationTeamMold(ProtrixBox box) {
		super(box);
		id("a412069732");
	}

	@Override
	public void init() {
		super.init();
		if (classificationTeam == null) classificationTeam = register(new ClassificationTeam(box()).<ClassificationTeam>id("a_1822983138").owner(ClassificationTeamMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (classificationTeam != null) classificationTeam.unregister();
	}

	public class ClassificationTeam extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public ClassificationTeam(ProtrixBox box) {
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