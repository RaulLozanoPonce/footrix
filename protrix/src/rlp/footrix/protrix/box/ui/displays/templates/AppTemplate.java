package rlp.footrix.protrix.box.ui.displays.templates;

import io.intino.alexandria.Base64;
import io.intino.alexandria.ui.displays.components.BlockConditional;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.pes6.types.Pes6Team;
import rlp.footrix.protrix.box.ProtrixBox;

import java.util.ArrayList;

public class AppTemplate extends AbstractAppTemplate<ProtrixBox> {
    public enum View {Overview, Competitions, Competition, Teams, Team, Match;}

    private View current = null;

    public AppTemplate(ProtrixBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        menu.onSelect(l -> {
            if (l.first().equals("overviewOpt")) notifier.redirect("http://localhost:9001/");
            else if (l.first().equals("competitionsOpt")) notifier.redirect("http://localhost:9001/competitions");
            else if (l.first().equals("teamsOpt")) notifier.redirect("http://localhost:9001/teams");
        });
    }

    public void openHome() {
        openView(View.Overview);
        overviewStamp.refresh();
    }

    public void openCompetitions() {
        openView(View.Competitions);
        competitionsStamp.refresh();
    }

    public void openCompetition(String competitionId, int season) {
        openView(View.Competition);
        Competition competition = box().application().entityStore().competition(competitionId, season);
        if (competition == null) {
            notifier.redirect("http://localhost:9001/");
        } else {
            competitionStamp.setup(competition, season);
            competitionStamp.refresh();
        }
    }

    public void openTeams() {
        openView(View.Teams);
        teamsStamp.refresh();
    }

    public void openTeam(String teamId) {
        openView(View.Team);
        Pes6Team team = (Pes6Team) box().application().entityStore().team(teamId);
        if (team == null) {
            notifier.redirect("http://localhost:9001/");
        } else {
            teamStamp.setup(team);
            teamStamp.refresh();
        }
    }

    public void openMatch(String matchId) {
        openView(View.Match);
        MatchDefinition definition = MatchDefinition.of(decode(matchId));
        matchStamp.setup(definition);
        matchStamp.refresh();
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
        else if (view == View.Competitions) menu.selection("competitionsOpt");
        else if (view == View.Competition) menu.selection("competitionsOpt");
        else if (view == View.Teams) menu.selection("teamsOpt");
        else if (view == View.Team) menu.selection("teamsOpt");
        else menu.selection(new ArrayList<>());
    }

    private BlockConditional blockOf(View view) {
        if (view == View.Overview) return overviewPage;
        if (view == View.Competitions) return competitionsPage;
        if (view == View.Competition) return competitionPage;
        if (view == View.Teams) return teamsPage;
        if (view == View.Team) return teamPage;
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

    private String decode(String text) {
        return new String(Base64.decode(text));
    }
}