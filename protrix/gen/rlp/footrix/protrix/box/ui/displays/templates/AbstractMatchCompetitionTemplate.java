package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import rlp.footrix.protrix.box.ui.*;

import rlp.footrix.protrix.box.ProtrixBox;

import rlp.footrix.protrix.box.ui.displays.templates.*;






import rlp.footrix.protrix.box.ui.displays.items.*;
import rlp.footrix.protrix.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractMatchCompetitionTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _137_1_11371965115 _137_1_11371965115;
	public MatchesTemplate matchesStamp;
	public _139_1_01859859097 _139_1_01859859097;
	public FullClassificationTemplate classificationStamp;

	public AbstractMatchCompetitionTemplate(B box) {
		super(box);
		id("matchCompetitionTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_137_1_11371965115 == null) _137_1_11371965115 = register(new _137_1_11371965115(box()).<_137_1_11371965115>id("a_932308513").owner(AbstractMatchCompetitionTemplate.this));
		if (_137_1_11371965115 != null) matchesStamp = _137_1_11371965115.matchesStamp;
		if (_139_1_01859859097 == null) _139_1_01859859097 = register(new _139_1_01859859097(box()).<_139_1_01859859097>id("a_1572551292").owner(AbstractMatchCompetitionTemplate.this));
		if (_139_1_01859859097 != null) classificationStamp = _139_1_01859859097.classificationStamp;
	}

	@Override
	public void remove() {
		super.remove();
		if (_137_1_11371965115 != null) _137_1_11371965115.unregister();
		if (_139_1_01859859097 != null) _139_1_01859859097.unregister();
	}

	public class _137_1_11371965115 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchesTemplate matchesStamp;

		public _137_1_11371965115(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (matchesStamp == null) matchesStamp = AbstractMatchCompetitionTemplate.this.matchesStamp = register(new MatchesTemplate((ProtrixBox)box()).id("a_67922014"));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (matchesStamp != null) matchesStamp.unregister();
		}
	}

	public class _139_1_01859859097 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public FullClassificationTemplate classificationStamp;

		public _139_1_01859859097(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (classificationStamp == null) classificationStamp = AbstractMatchCompetitionTemplate.this.classificationStamp = register(new FullClassificationTemplate((ProtrixBox)box()).id("a_646017939"));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (classificationStamp != null) classificationStamp.unregister();
		}
	}
}