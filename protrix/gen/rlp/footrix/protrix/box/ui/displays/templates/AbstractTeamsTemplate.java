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

public abstract class AbstractTeamsTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _6_1_0584557236 _6_1_0584557236;
	public TeamsTemplate._6_1_0584557236. _7_2_11757772671 _7_2_11757772671;
	public TeamsTemplate._6_1_0584557236. _8_2_0193886823 _8_2_0193886823;
	public TeamsTemplate._6_1_0584557236._8_2_0193886823. _9_3_01562438943 _9_3_01562438943;
	public TeamsTemplate._6_1_0584557236._8_2_0193886823. Search search;
	public TeamsTable teamsTable;

	public AbstractTeamsTemplate(B box) {
		super(box);
		id("teamsTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_0584557236 == null) _6_1_0584557236 = register(new _6_1_0584557236(box()).<_6_1_0584557236>id("a1825991303").owner(AbstractTeamsTemplate.this));
		if (_6_1_0584557236 != null) _7_2_11757772671 = _6_1_0584557236._7_2_11757772671;
		if (_6_1_0584557236 != null) _8_2_0193886823 = _6_1_0584557236._8_2_0193886823;
		if (_8_2_0193886823 != null) _9_3_01562438943 = _6_1_0584557236._8_2_0193886823._9_3_01562438943;
		if (_8_2_0193886823 != null) search = _6_1_0584557236._8_2_0193886823.search;
		if (teamsTable == null) teamsTable = register(new TeamsTable(box()).<TeamsTable>id("a_1343891866").owner(AbstractTeamsTemplate.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_0584557236 != null) _6_1_0584557236.unregister();
		if (teamsTable != null) teamsTable.unregister();
	}

	public class _6_1_0584557236 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TeamsTemplate._6_1_0584557236. _7_2_11757772671 _7_2_11757772671;
		public TeamsTemplate._6_1_0584557236. _8_2_0193886823 _8_2_0193886823;

		public _6_1_0584557236(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_7_2_11757772671 == null) _7_2_11757772671 = register(new _7_2_11757772671(box()).<_7_2_11757772671>id("a_1204841359").owner(AbstractTeamsTemplate.this));
			if (_8_2_0193886823 == null) _8_2_0193886823 = register(new _8_2_0193886823(box()).<_8_2_0193886823>id("a1253683523").owner(AbstractTeamsTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_7_2_11757772671 != null) _7_2_11757772671.unregister();
			if (_8_2_0193886823 != null) _8_2_0193886823.unregister();
		}

		public class _7_2_11757772671 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _7_2_11757772671(B box) {
				super(box);
				_value("Equipos");
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

		public class _8_2_0193886823 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TeamsTemplate._6_1_0584557236._8_2_0193886823. _9_3_01562438943 _9_3_01562438943;
			public TeamsTemplate._6_1_0584557236._8_2_0193886823. Search search;

			public _8_2_0193886823(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_9_3_01562438943 == null) _9_3_01562438943 = register(new _9_3_01562438943(box()).<_9_3_01562438943>id("a_1965076631").owner(AbstractTeamsTemplate.this));
				if (search == null) search = register(new Search(box()).<Search>id("a_1574689709").owner(AbstractTeamsTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_9_3_01562438943 != null) _9_3_01562438943.unregister();
				if (search != null) search.unregister();
			}

			public class _9_3_01562438943 extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, B>  {

				public _9_3_01562438943(B box) {
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

	public class TeamsTable extends io.intino.alexandria.ui.displays.components.List<B, TeamsTableMold, rlp.footrix.pes6.types.Pes6Team> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public TeamsTable(B box) {
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
		public TeamsTableMold create(rlp.footrix.pes6.types.Pes6Team element) {
			TeamsTableMold result = new TeamsTableMold((ProtrixBox)box());
			result.id(java.util.UUID.randomUUID().toString());
			result.item(element);
			result.section(source().section(element));
			return result;
		}
	}
}