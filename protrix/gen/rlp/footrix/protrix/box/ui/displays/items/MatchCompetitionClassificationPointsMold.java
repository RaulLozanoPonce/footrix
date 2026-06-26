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

public class MatchCompetitionClassificationPointsMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationPoints matchCompetitionClassificationPoints;

	public MatchCompetitionClassificationPointsMold(ProtrixBox box) {
		super(box);
		id("a_564627824");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationPoints == null) matchCompetitionClassificationPoints = register(new MatchCompetitionClassificationPoints(box()).<MatchCompetitionClassificationPoints>id("a316796562").owner(MatchCompetitionClassificationPointsMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationPoints != null) matchCompetitionClassificationPoints.unregister();
	}

	public class MatchCompetitionClassificationPoints extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationPoints(ProtrixBox box) {
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