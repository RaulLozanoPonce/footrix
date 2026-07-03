package rlp.footrix.framework.events.subscribers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.Subscriber;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.framework.events.types.SimulateMatchEvent;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.framework.types.entities.team.Team;

import java.time.Instant;
import java.util.List;

import static rlp.footrix.framework.generators.LineupGenerator.playersLineup;

public class SimulateMatchSubscriber implements Subscriber<SimulateMatchEvent> {
    private final Application application;

    public SimulateMatchSubscriber(Application application) {
        this.application = application;
    }

    @Override
    public void receive(SimulateMatchEvent event) {
        //TODO PASAR A COMMAND
        Competition competition = application.competitionManager().get(event.definition().competition(), event.definition().season());
        Team local = application.teamManager().get(event.definition().local());
        Team visitant = application.teamManager().get(event.definition().visitant());
        Match match = simulate(event.definition(), event.date(), local.lineup(), visitant.lineup(), availablePlayersOf(local, competition.definition().id()), availablePlayersOf(visitant, competition.definition().id()));
        application.entityStore().match(match);
        application.eventHub().publish(new PlayedMatchEvent().matchId(match.definition().id()));
    }

    private List<String> availablePlayersOf(Team team, String competition) {
        return team.players().stream()
                .filter(p -> !p.isInjured())
                .filter(p -> !p.hasSanction(competition))
                .map(p -> p.definition().id())
                .toList();
    }

    private Match simulate(MatchDefinition definition, Instant date, String localLineupId, String visitantLineupId, List<String> localPlayerIds, List<String> visitantPlayerIds) {
        List<Player> localPlayers = localPlayerIds.stream().map(p -> application.entityStore().player(p)).toList();
        List<Player> visitantPlayers = visitantPlayerIds.stream().map(p -> application.entityStore().player(p)).toList();
        Competition.Phase phase = application.competitionManager().get(definition.competition(), definition.season()).phase(definition.phase());
        PlayersLineup localLineup = playersLineup(phase, application.lineupsManager().get(localLineupId), localPlayers);
        PlayersLineup visitantLineup = playersLineup(phase, application.lineupsManager().get(visitantLineupId), visitantPlayers);
        return application.models().matchSimulator().simulate(definition, date, localLineup, visitantLineup);
    }
}
