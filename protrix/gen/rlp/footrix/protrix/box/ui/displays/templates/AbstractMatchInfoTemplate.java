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

public abstract class AbstractMatchInfoTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _33_1_1242467398 _33_1_1242467398;
	public MatchInfoTemplate._33_1_1242467398. _34_2_11533510070 _34_2_11533510070;
	public MatchPlayersTemplate localMatchPlayersStamp;
	public _36_1_0636403011 _36_1_0636403011;
	public MatchInfoTemplate._36_1_0636403011. _37_2_0829405132 _37_2_0829405132;
	public MatchPlayersTemplate visitantMatchPlayersStamp;
	public _39_1_11387591269 _39_1_11387591269;
	public MatchInfoTemplate._39_1_11387591269. _40_2_01326655879 _40_2_01326655879;
	public MatchInfoTemplate._39_1_11387591269._40_2_01326655879. _41_3_0489841367 _41_3_0489841367;
	public MatchInfoTemplate._39_1_11387591269._40_2_01326655879. MatchEventsTable matchEventsTable;

	public AbstractMatchInfoTemplate(B box) {
		super(box);
		id("matchInfoTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_33_1_1242467398 == null) _33_1_1242467398 = register(new _33_1_1242467398(box()).<_33_1_1242467398>id("a823007387").owner(AbstractMatchInfoTemplate.this));
		if (_33_1_1242467398 != null) _34_2_11533510070 = _33_1_1242467398._34_2_11533510070;
		if (_33_1_1242467398 != null) localMatchPlayersStamp = _33_1_1242467398.localMatchPlayersStamp;
		if (_36_1_0636403011 == null) _36_1_0636403011 = register(new _36_1_0636403011(box()).<_36_1_0636403011>id("a_1630464578").owner(AbstractMatchInfoTemplate.this));
		if (_36_1_0636403011 != null) _37_2_0829405132 = _36_1_0636403011._37_2_0829405132;
		if (_36_1_0636403011 != null) visitantMatchPlayersStamp = _36_1_0636403011.visitantMatchPlayersStamp;
		if (_39_1_11387591269 == null) _39_1_11387591269 = register(new _39_1_11387591269(box()).<_39_1_11387591269>id("a_1884575103").owner(AbstractMatchInfoTemplate.this));
		if (_39_1_11387591269 != null) _40_2_01326655879 = _39_1_11387591269._40_2_01326655879;
		if (_40_2_01326655879 != null) _41_3_0489841367 = _39_1_11387591269._40_2_01326655879._41_3_0489841367;
		if (_40_2_01326655879 != null) matchEventsTable = _39_1_11387591269._40_2_01326655879.matchEventsTable;
	}

	@Override
	public void remove() {
		super.remove();
		if (_33_1_1242467398 != null) _33_1_1242467398.unregister();
		if (_36_1_0636403011 != null) _36_1_0636403011.unregister();
		if (_39_1_11387591269 != null) _39_1_11387591269.unregister();
	}

	public class _33_1_1242467398 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchInfoTemplate._33_1_1242467398. _34_2_11533510070 _34_2_11533510070;
		public MatchPlayersTemplate localMatchPlayersStamp;

		public _33_1_1242467398(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_34_2_11533510070 == null) _34_2_11533510070 = register(new _34_2_11533510070(box()).<_34_2_11533510070>id("a_2027795381").owner(AbstractMatchInfoTemplate.this));
			if (localMatchPlayersStamp == null) localMatchPlayersStamp = AbstractMatchInfoTemplate.this.localMatchPlayersStamp = register(new MatchPlayersTemplate((ProtrixBox)box()).id("a2018107550"));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_34_2_11533510070 != null) _34_2_11533510070.unregister();
			if (localMatchPlayersStamp != null) localMatchPlayersStamp.unregister();
		}

		public class _34_2_11533510070 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _34_2_11533510070(B box) {
				super(box);
				_value("Local");
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

	public class _36_1_0636403011 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchInfoTemplate._36_1_0636403011. _37_2_0829405132 _37_2_0829405132;
		public MatchPlayersTemplate visitantMatchPlayersStamp;

		public _36_1_0636403011(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_37_2_0829405132 == null) _37_2_0829405132 = register(new _37_2_0829405132(box()).<_37_2_0829405132>id("a_1427320321").owner(AbstractMatchInfoTemplate.this));
			if (visitantMatchPlayersStamp == null) visitantMatchPlayersStamp = AbstractMatchInfoTemplate.this.visitantMatchPlayersStamp = register(new MatchPlayersTemplate((ProtrixBox)box()).id("a_666875478"));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_37_2_0829405132 != null) _37_2_0829405132.unregister();
			if (visitantMatchPlayersStamp != null) visitantMatchPlayersStamp.unregister();
		}

		public class _37_2_0829405132 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _37_2_0829405132(B box) {
				super(box);
				_value("Visitante");
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

	public class _39_1_11387591269 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public MatchInfoTemplate._39_1_11387591269. _40_2_01326655879 _40_2_01326655879;

		public _39_1_11387591269(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_40_2_01326655879 == null) _40_2_01326655879 = register(new _40_2_01326655879(box()).<_40_2_01326655879>id("a_936390436").owner(AbstractMatchInfoTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_40_2_01326655879 != null) _40_2_01326655879.unregister();
		}

		public class _40_2_01326655879 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public MatchInfoTemplate._39_1_11387591269._40_2_01326655879. _41_3_0489841367 _41_3_0489841367;
			public MatchInfoTemplate._39_1_11387591269._40_2_01326655879. MatchEventsTable matchEventsTable;

			public _40_2_01326655879(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (_41_3_0489841367 == null) _41_3_0489841367 = register(new _41_3_0489841367(box()).<_41_3_0489841367>id("a1239826793").owner(AbstractMatchInfoTemplate.this));
				if (matchEventsTable == null) matchEventsTable = register(new MatchEventsTable(box()).<MatchEventsTable>id("a1767618342").owner(AbstractMatchInfoTemplate.this));
			}

			@Override
			public void unregister() {
				super.unregister();
				if (_41_3_0489841367 != null) _41_3_0489841367.unregister();
				if (matchEventsTable != null) matchEventsTable.unregister();
			}

			public class _41_3_0489841367 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public _41_3_0489841367(B box) {
					super(box);
					_value("Eventos");
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

			public class MatchEventsTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, rlp.footrix.framework.types.entities.match.MatchEvent>  {

				public MatchEventsTable(B box) {
					super(box);

					_pageSize(20);
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public void unregister() {
					super.unregister();
				}


				public MatchEventsTableRow create(rlp.footrix.framework.types.entities.match.MatchEvent item) {
					MatchEventsTableRow row = new MatchEventsTableRow((ProtrixBox)box());
					row.id(java.util.UUID.randomUUID().toString());
					row.item(item);
					return row;
				}
			}
		}
	}
}