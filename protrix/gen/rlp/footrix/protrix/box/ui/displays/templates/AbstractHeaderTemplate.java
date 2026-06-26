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

public abstract class AbstractHeaderTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public _58_1_01288406767 _58_1_01288406767;
	public HeaderTemplate._58_1_01288406767. _59_2_0974672517 _59_2_0974672517;
	public HeaderTemplate._58_1_01288406767. _64_2_0653993958 _64_2_0653993958;
	public _65_1_1289796408 _65_1_1289796408;
	public HeaderTemplate._65_1_1289796408. Date date;

	public AbstractHeaderTemplate(B box) {
		super(box);
		id("headerTemplate");
	}

	@Override
	public void init() {
		super.init();
		if (_58_1_01288406767 == null) _58_1_01288406767 = register(new _58_1_01288406767(box()).<_58_1_01288406767>id("a829337867").owner(AbstractHeaderTemplate.this));
		if (_58_1_01288406767 != null) _59_2_0974672517 = _58_1_01288406767._59_2_0974672517;
		if (_58_1_01288406767 != null) _64_2_0653993958 = _58_1_01288406767._64_2_0653993958;
		if (_65_1_1289796408 == null) _65_1_1289796408 = register(new _65_1_1289796408(box()).<_65_1_1289796408>id("a_1210095246").owner(AbstractHeaderTemplate.this));
		if (_65_1_1289796408 != null) date = _65_1_1289796408.date;
	}

	@Override
	public void remove() {
		super.remove();
		if (_58_1_01288406767 != null) _58_1_01288406767.unregister();
		if (_65_1_1289796408 != null) _65_1_1289796408.unregister();
	}

	public class _58_1_01288406767 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public HeaderTemplate._58_1_01288406767. _59_2_0974672517 _59_2_0974672517;
		public HeaderTemplate._58_1_01288406767. _64_2_0653993958 _64_2_0653993958;

		public _58_1_01288406767(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (_59_2_0974672517 == null) _59_2_0974672517 = register(new _59_2_0974672517(box()).<_59_2_0974672517>id("a118895544").owner(AbstractHeaderTemplate.this));
			if (_64_2_0653993958 == null) _64_2_0653993958 = register(new _64_2_0653993958(box()).<_64_2_0653993958>id("a996280475").owner(AbstractHeaderTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (_59_2_0974672517 != null) _59_2_0974672517.unregister();
			if (_64_2_0653993958 != null) _64_2_0653993958.unregister();
		}

		public class _59_2_0974672517 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {

			public _59_2_0974672517(B box) {
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

		public class _64_2_0653993958 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public _64_2_0653993958(B box) {
				super(box);
				_value("Tagoror: El metaverso de fútbol");
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

	public class _65_1_1289796408 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public HeaderTemplate._65_1_1289796408. Date date;

		public _65_1_1289796408(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (date == null) date = register(new Date(box()).<Date>id("a1828236433").owner(AbstractHeaderTemplate.this));
		}

		@Override
		public void unregister() {
			super.unregister();
			if (date != null) date.unregister();
		}

		public class Date extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Date(B box) {
				super(box);
				_value("Cargando...");
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