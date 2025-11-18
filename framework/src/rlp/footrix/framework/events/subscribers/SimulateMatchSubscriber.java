package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.types.PlaySimulatedMatchCommand;
import rlp.footrix.framework.commands.types.PostMatchCommand;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.SimulateMatchEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public class SimulateMatchSubscriber implements Subscriber<SimulateMatchEvent> {
    private final Application application;

    public SimulateMatchSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(SimulateMatchEvent event) {
        Competition competition = application.competitionManager().get(event.definition().competition(), event.definition().season());
        Team local = application.teamManager().get(event.definition().local());
        Team visitant = application.teamManager().get(event.definition().visitant());
        List<Player> localPlayers = availablePlayersOf(local, competition.definition().id());
        List<Player> visitantPlayers = availablePlayersOf(visitant, competition.definition().id());

        playSimulatedMatch(event, local, visitant, localPlayers, visitantPlayers);
        Match match = application.entityStore().match(event.definition());
        postMatch(match, local, visitant, localPlayers, visitantPlayers);
    }

    private void playSimulatedMatch(SimulateMatchEvent event, Team local, Team visitant, List<Player> localPlayers, List<Player> visitantPlayers) {
        PlaySimulatedMatchCommand command = new PlaySimulatedMatchCommand(application);
        command.definition = event.definition();
        command.date = event.ts();
        command.localLineupId = local.lineup();
        command.visitantLineupId = visitant.lineup();
        command.localPlayers = localPlayers;
        command.visitantPlayers = visitantPlayers;
        command.execute();
    }

    private void postMatch(Match match, Team local, Team visitant, List<Player> localPlayers, List<Player> visitantPlayers) {
        PostMatchCommand command = new PostMatchCommand(application);
        command.match = match;
        command.local = local;
        command.visitant = visitant;
        command.localPlayers = localPlayers;
        command.visitantPlayers = visitantPlayers;
        command.execute();
    }

    private List<Player> availablePlayersOf(Team team, String competition) {
        return team.players().stream()
                .filter(p -> !p.isInjured())
                .filter(p -> !p.hasSanction(competition))
                .toList();
    }
}
