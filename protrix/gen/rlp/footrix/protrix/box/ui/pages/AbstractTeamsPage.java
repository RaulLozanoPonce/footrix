package rlp.footrix.protrix.box.ui.pages;

import rlp.footrix.protrix.box.ProtrixBox;
import io.intino.alexandria.exceptions.*;
import java.util.*;

public abstract class AbstractTeamsPage extends io.intino.alexandria.ui.spark.pages.WebPage {
	public ProtrixBox box;

	public AbstractTeamsPage() { super("protrix-ui"); }

	public String execute() {
		return super.template("appTemplate");
	}

	@Override
	protected String title() {
		return "Protrix";
	}

	@Override
	protected java.net.URL favicon() {
		return this.getClass().getResource("");
	}
}