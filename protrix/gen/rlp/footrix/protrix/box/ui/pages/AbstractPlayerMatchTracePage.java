package rlp.footrix.protrix.box.ui.pages;

import rlp.footrix.protrix.box.ProtrixBox;
import io.intino.alexandria.exceptions.*;
import java.util.*;

public abstract class AbstractPlayerMatchTracePage extends io.intino.alexandria.ui.spark.pages.WebPage {
	public ProtrixBox box;

	public AbstractPlayerMatchTracePage() { super("protrix-ui"); }

	public String execute() {
		return super.template("playerMatchTraceTemplate");
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