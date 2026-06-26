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

public abstract class AbstractMatchesTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _6_1_0567341441 _6_1_0567341441;
	public MatchesTemplate._6_1_0567341441. _7_2_01848426253 _7_2_01848426253;
	public MatchesTemplate._6_1_0567341441. Date date;
	public MatchTable matchTable;

	public AbstractMatchesTemplate(B box) {
		super(box);
		id("matchesTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_0567341441 == null) _6_1_0567341441 = register(new _6_1_0567341441(box()).<_6_1_0567341441>id("a1265984364").owner(AbstractMatchesTemplate.this));
		if (_6_1_0567341441 != null) _7_2_01848426253 = _6_1_0567341441._7_2_01848426253;
		if (_6_1_0567341441 != null) date = _6_1_0567341441.date;
		if (matchTable == null) matchTable = register(new MatchTable(box()).<MatchTable>id("a239085914").owner(AbstractMatchesTemplate.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_0567341441 != null) _6_1_0567341441.unregister();
		if (matchTable != null) matchTable.unregister();
	}

	public class _6_1_0567341441 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchesTemplate._6_1_0567341441. _7_2_01848426253 _7_2_01848426253;
		public MatchesTemplate._6_1_0567341441. Date date;

		public _6_1_0567341441(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_7_2_01848426253 == null) _7_2_01848426253 = register(new _7_2_01848426253(box()).<_7_2_01848426253>id("a774845893").owner(AbstractMatchesTemplate.this));
			if (date == null) date = register(new Date(box()).<Date>id("a945963668").owner(AbstractMatchesTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_7_2_01848426253 != null) _7_2_01848426253.unregister();
			if (date != null) date.unregister();
		}

		public class _7_2_01848426253 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _7_2_01848426253(B box) {
				super(box);
				_value("Partidos");
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

		public class Date extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

			public Date(B box) {
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

	public class MatchTable extends io.intino.alexandria.ui.displays.components.List<B, MatchTableMold, rlp.footrix.protrix.model.Match> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public MatchTable(B box) {
			super(box);

			_pageSize(10);
		}

		@Override
		public void init() {
			super.init();
		}

		@Override
		public void unregister() {
			super.unregister();
		}
		public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
			super.addSelectionListener(listener);
		}
		public MatchTableMold create(rlp.footrix.protrix.model.Match element) {
			MatchTableMold result = new MatchTableMold((ProtrixBox)box());
			result.id(java.util.UUID.randomUUID().toString());
			result.item(element);
			result.section(source().section(element));
			return result;
		}
	}
}