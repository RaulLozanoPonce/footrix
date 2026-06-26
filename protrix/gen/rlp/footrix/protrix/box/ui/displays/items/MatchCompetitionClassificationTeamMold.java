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

public class MatchCompetitionClassificationTeamMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.protrix.model.Classification, ProtrixBox> {
	public MatchCompetitionClassificationTeam matchCompetitionClassificationTeam;

	public MatchCompetitionClassificationTeamMold(ProtrixBox box) {
		super(box);
		id("a_71836212");
	}

	@Override
	public void init() {
		super.init();
		if (matchCompetitionClassificationTeam == null) matchCompetitionClassificationTeam = register(new MatchCompetitionClassificationTeam(box()).<MatchCompetitionClassificationTeam>id("a_1464671472").owner(MatchCompetitionClassificationTeamMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (matchCompetitionClassificationTeam != null) matchCompetitionClassificationTeam.unregister();
	}

	public class MatchCompetitionClassificationTeam extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, ProtrixBox>  {

		public MatchCompetitionClassificationTeam(ProtrixBox box) {
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