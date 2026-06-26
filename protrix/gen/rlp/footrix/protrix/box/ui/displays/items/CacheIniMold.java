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

public class CacheIniMold extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, rlp.footrix.pes6.types.Pes6Player, ProtrixBox> {
	public CacheIni cacheIni;

	public CacheIniMold(ProtrixBox box) {
		super(box);
		id("a_40454484");
	}

	@Override
	public void init() {
		super.init();
		if (cacheIni == null) cacheIni = register(new CacheIni(box()).<CacheIni>id("a779904309").owner(CacheIniMold.this));
	}

	@Override
	public void remove() {
		super.remove();
		if (cacheIni != null) cacheIni.unregister();
	}

	public class CacheIni extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, ProtrixBox>  {

		public CacheIni(ProtrixBox box) {
			super(box);
			_value(0.0);
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