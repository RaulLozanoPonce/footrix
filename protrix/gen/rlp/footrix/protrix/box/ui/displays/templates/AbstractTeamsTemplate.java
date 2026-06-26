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
	public _6_1_12029611022 _6_1_12029611022;
	public TeamsTemplate._6_1_12029611022. _7_2_11757772671 _7_2_11757772671;
	public TeamsTemplate._6_1_12029611022. _8_2_11288142427 _8_2_11288142427;
	public TeamsTemplate._6_1_12029611022._8_2_11288142427. _9_3_11554743587 _9_3_11554743587;
	public TeamsTemplate._6_1_12029611022._8_2_11288142427. Search search;
	public TeamsTable teamsTable;

	public AbstractTeamsTemplate(B box) {
		super(box);
		id("teamsTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_6_1_12029611022 == null) _6_1_12029611022 = register(new _6_1_12029611022(box()).<_6_1_12029611022>id("a1225927848").owner(AbstractTeamsTemplate.this));
		if (_6_1_12029611022 != null) _7_2_11757772671 = _6_1_12029611022._7_2_11757772671;
		if (_6_1_12029611022 != null) _8_2_11288142427 = _6_1_12029611022._8_2_11288142427;
		if (_8_2_11288142427 != null) _9_3_11554743587 = _6_1_12029611022._8_2_11288142427._9_3_11554743587;
		if (_8_2_11288142427 != null) search = _6_1_12029611022._8_2_11288142427.search;
		if (teamsTable == null) teamsTable = register(new TeamsTable(box()).<TeamsTable>id("a_1343891866").owner(AbstractTeamsTemplate.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (_6_1_12029611022 != null) _6_1_12029611022.unregister();
		if (teamsTable != null) teamsTable.unregister();
	}

	public class _6_1_12029611022 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TeamsTemplate._6_1_12029611022. _7_2_11757772671 _7_2_11757772671;
		public TeamsTemplate._6_1_12029611022. _8_2_11288142427 _8_2_11288142427;

		public _6_1_12029611022(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_7_2_11757772671 == null) _7_2_11757772671 = register(new _7_2_11757772671(box()).<_7_2_11757772671>id("a_1204841359").owner(AbstractTeamsTemplate.this));
			if (_8_2_11288142427 == null) _8_2_11288142427 = register(new _8_2_11288142427(box()).<_8_2_11288142427>id("a_1898499273").owner(AbstractTeamsTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_7_2_11757772671 != null) _7_2_11757772671.unregister();
			if (_8_2_11288142427 != null) _8_2_11288142427.unregister();
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

		public class _8_2_11288142427 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TeamsTemplate._6_1_12029611022._8_2_11288142427. _9_3_11554743587 _9_3_11554743587;
			public TeamsTemplate._6_1_12029611022._8_2_11288142427. Search search;

			public _8_2_11288142427(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_9_3_11554743587 == null) _9_3_11554743587 = register(new _9_3_11554743587(box()).<_9_3_11554743587>id("a651794636").owner(AbstractTeamsTemplate.this));
				if (search == null) search = register(new Search(box()).<Search>id("a_1574689709").owner(AbstractTeamsTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_9_3_11554743587 != null) _9_3_11554743587.unregister();
				if (search != null) search.unregister();
			}

			public class _9_3_11554743587 extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, B>  {

				public _9_3_11554743587(B box) {
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