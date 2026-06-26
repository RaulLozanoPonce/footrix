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

public class MatchCompetitionClassificationPositionMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationPosition matchCompetitionClassificationPosition;

	public MatchCompetitionClassificationPositionMold(ProtrixBox box) {
		super(box);
		id("a2068751163");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationPosition == null) matchCompetitionClassificationPosition = register(new MatchCompetitionClassificationPosition(box()).<MatchCompetitionClassificationPosition>id("a_1550142451").owner(MatchCompetitionClassificationPositionMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationPosition != null) matchCompetitionClassificationPosition.unregister();
	}

	public class MatchCompetitionClassificationPosition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationPosition(ProtrixBox box) {
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