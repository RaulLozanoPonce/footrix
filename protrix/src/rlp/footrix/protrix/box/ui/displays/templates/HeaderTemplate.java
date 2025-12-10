package rlp.footrix.protrix.box.ui.displays.templates;

import rlp.footrix.framework.utils.TimeHelper;
import rlp.footrix.protrix.box.ProtrixBox;

import java.time.Instant;

public class HeaderTemplate extends AbstractHeaderTemplate<ProtrixBox> {

	public HeaderTemplate(ProtrixBox box) {
		super(box);
	}

    @Override
    public void refresh() {
        super.refresh();
        date.value(dateLabelOf(box().application().getDate()));
    }

    private String dateLabelOf(Instant date) {
        return TimeHelper.shortDayStyled(date);
    }
}