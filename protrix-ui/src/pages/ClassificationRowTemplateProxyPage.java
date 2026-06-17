package rlp.footrix.protrix.box.ui.pages;

import rlp.footrix.protrix.box.ProtrixBox;
import rlp.footrix.protrix.box.ui.displays.templates.ClassificationRowTemplate;
import io.intino.alexandria.ui.Soul;

public class ClassificationRowTemplateProxyPage extends io.intino.alexandria.ui.spark.pages.ProxyPage {
	public ProtrixBox box;
	public String results;
	public Soul soul;

	public void execute() {
		ClassificationRowTemplate display = new ClassificationRowTemplate(box);
		display.id(personifiedDisplay);
		display.results(results);
		soul.register(display);
		display.init();
		display.refresh();
	}
}