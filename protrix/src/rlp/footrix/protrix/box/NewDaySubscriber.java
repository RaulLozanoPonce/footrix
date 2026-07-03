package rlp.footrix.protrix.box;

import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.model.TeamOut;

public class NewDaySubscriber implements Subscriber<NewDayEvent> {
    private final ProtrixApplication application;
    private final ProtrixBox box;

    public NewDaySubscriber(ProtrixApplication application, ProtrixBox box) {
        this.application = application;
        this.box = box;
    }

    @Override
    public void receive(NewDayEvent event) {
        for (Team team : box.application().teamManager().teams()) {
            registerOuts(team);
        }
    }

    private void registerOuts(Team team) {
        for (Player player : team.players()) {
            registerInjuryOuts(player, team);
            registerSanctionsOuts(player, team);
        }
    }

    private void registerInjuryOuts(Player player, Team team) {
        TeamOut active = getActiveTeamOut(player.definition().id(), TeamOut.Type.Injury, null);
        if (!player.isInjured()) {
            if (active == null) return;
            active.to(box.application().game().date()).closed(true);
        } else {
            if (active == null) {
                active = box.graph().create().teamOut(box.application().game().date(), player.recoveryDate(), team.definition().id(), player.definition().id(), false, TeamOut.Type.Injury, null, 0);
            }
            active.to(player.recoveryDate());
        }
    }

    private void registerSanctionsOuts(Player player, Team team) {
        for (String competition : player.sanctions().keySet()) {
            registerSanctionsOuts(player, team, competition);
        }
    }

    private void registerSanctionsOuts(Player player, Team team, String competition) {
        TeamOut active = getActiveTeamOut(player.definition().id(), TeamOut.Type.Sanction, competition);
        if (!player.sanctions().containsKey(competition) || player.sanctions().get(competition) == 0) {
            if (active == null) return;
            active.to(box.application().game().date()).closed(true);
        } else {
            if (active == null) {
                active = box.graph().create().teamOut(box.application().game().date(), null, team.definition().id(), player.definition().id(), false, TeamOut.Type.Sanction, competition, player.sanctions().get(competition));
            }
        }
    }

    private TeamOut getActiveTeamOut(String player, TeamOut.Type type, String competition) {
        return box.graph().teamOutList().stream()
                .filter(to -> !to.closed())
                .filter(to -> to.playerId().equals(player))
                .filter(to -> to.type() == type)
                .filter(to -> (to.competition() == null && competition == null) || to.competition().equals(competition))
                .findFirst()
                .orElse(null);
    }
}
