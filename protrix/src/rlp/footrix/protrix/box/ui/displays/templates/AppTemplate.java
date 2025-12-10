package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.BlockConditional;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.ArrayList;

public class AppTemplate extends AbstractAppTemplate<ProtrixBox> {
    public enum View {Overview, Match;}

    private View current = null;

    public AppTemplate(ProtrixBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        menu.onSelect(l -> {
            if (l.first().equals("overviewOpt")) notifier.redirect("http://localhost:9001/");
        });
    }

    public void openHome() {
        openView(View.Overview);
        overviewStamp.refresh();
    }

    public void openMatch(String matchId) {
        openView(View.Match);
        Match match = box().application().entityStore().match(matchId);
        if (match == null) {
            notifier.redirect("http://localhost:9001/");
        } else {
            matchStamp.setup(match);
            matchStamp.refresh();
        }
    }

    private void openView(View view) {
        sleep(); //TODO Remove when solved
        loading.visible(false);
        selectMenuOption(view);
        if (current == view) return;
        if (current != null) blockOf(current).hide();
        header.refresh();
        BlockConditional block = blockOf(view);
        if (block != null) block.show();
        current = view;
    }

    private void selectMenuOption(View view) {
        if (view == View.Overview) menu.selection("overviewOpt");
        else menu.selection(new ArrayList<>());
    }

    private BlockConditional blockOf(View view) {
        if (view == View.Overview) return overviewPage;
        if (view == View.Match) return matchPage;
        return null;
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}