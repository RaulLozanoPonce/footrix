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

public abstract class AbstractCompetitionsTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _9_1_11316090840 _9_1_11316090840;
	public CompetitionsTemplate._9_1_11316090840. _10_2_01134602359 _10_2_01134602359;
	public CompetitionsTemplate._9_1_11316090840. _11_2_11288142427 _11_2_11288142427;
	public CompetitionsTemplate._9_1_11316090840._11_2_11288142427. _12_3_11554743587 _12_3_11554743587;
	public CompetitionsTemplate._9_1_11316090840._11_2_11288142427. Search search;
	public CompetitionsTable competitionsTable;

	public AbstractCompetitionsTemplate(B box) {
		super(box);
		id("competitionsTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_9_1_11316090840 == null) _9_1_11316090840 = register(new _9_1_11316090840(box()).<_9_1_11316090840>id("a_318733660").owner(AbstractCompetitionsTemplate.this));
		if (_9_1_11316090840 != null) _10_2_01134602359 = _9_1_11316090840._10_2_01134602359;
		if (_9_1_11316090840 != null) _11_2_11288142427 = _9_1_11316090840._11_2_11288142427;
		if (_11_2_11288142427 != null) _12_3_11554743587 = _9_1_11316090840._11_2_11288142427._12_3_11554743587;
		if (_11_2_11288142427 != null) search = _9_1_11316090840._11_2_11288142427.search;
		if (competitionsTable == null) competitionsTable = register(new CompetitionsTable(box()).<CompetitionsTable>id("a36904936").owner(AbstractCompetitionsTemplate.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (_9_1_11316090840 != null) _9_1_11316090840.unregister();
		if (competitionsTable != null) competitionsTable.unregister();
	}

	public class _9_1_11316090840 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public CompetitionsTemplate._9_1_11316090840. _10_2_01134602359 _10_2_01134602359;
		public CompetitionsTemplate._9_1_11316090840. _11_2_11288142427 _11_2_11288142427;

		public _9_1_11316090840(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_10_2_01134602359 == null) _10_2_01134602359 = register(new _10_2_01134602359(box()).<_10_2_01134602359>id("a805473571").owner(AbstractCompetitionsTemplate.this));
			if (_11_2_11288142427 == null) _11_2_11288142427 = register(new _11_2_11288142427(box()).<_11_2_11288142427>id("a_2051666736").owner(AbstractCompetitionsTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_10_2_01134602359 != null) _10_2_01134602359.unregister();
			if (_11_2_11288142427 != null) _11_2_11288142427.unregister();
		}

		public class _10_2_01134602359 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _10_2_01134602359(B box) {
				super(box);
				_value("Competiciones");
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

		public class _11_2_11288142427 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public CompetitionsTemplate._9_1_11316090840._11_2_11288142427. _12_3_11554743587 _12_3_11554743587;
			public CompetitionsTemplate._9_1_11316090840._11_2_11288142427. Search search;

			public _11_2_11288142427(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_12_3_11554743587 == null) _12_3_11554743587 = register(new _12_3_11554743587(box()).<_12_3_11554743587>id("a_1223889178").owner(AbstractCompetitionsTemplate.this));
				if (search == null) search = register(new Search(box()).<Search>id("a793583753").owner(AbstractCompetitionsTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_12_3_11554743587 != null) _12_3_11554743587.unregister();
				if (search != null) search.unregister();
			}

			public class _12_3_11554743587 extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, B>  {

				public _12_3_11554743587(B box) {
					super(box);
					_icon("Search");
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

			public class Search extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public Search(B box) {
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
	}

	public class CompetitionsTable extends io.intino.alexandria.ui.displays.components.List<B, CompetitionsTableMold, rlp.footrix.framework.types.entities.Competition> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public CompetitionsTable(B box) {
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
		public CompetitionsTableMold create(rlp.footrix.framework.types.entities.Competition element) {
			CompetitionsTableMold result = new CompetitionsTableMold((ProtrixBox)box());
			result.id(java.util.UUID.randomUUID().toString());
			result.item(element);
			result.section(source().section(element));
			return result;
		}
	}
}