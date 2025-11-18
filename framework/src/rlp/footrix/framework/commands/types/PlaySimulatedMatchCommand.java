package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;

import java.time.Instant;
import java.util.List;

import static rlp.footrix.framework.generators.LineupGenerator.playersLineup;

public class PlaySimulatedMatchCommand extends Command {
    public MatchDefinition definition;
    public Instant date;
    public String localLineupId;
    public String visitantLineupId;
    public List<Player> localPlayers;
    public List<Player> visitantPlayers;

    public PlaySimulatedMatchCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        Match match = simulate();
        application.entityStore().match(match);
    }

    private Match simulate() {
        Competition.Phase phase = application.competitionManager().get(definition.competition(), definition.season()).phase(definition.phase());
        PlayersLineup localLineup = playersLineup(phase, application.lineupsManager().get(localLineupId), localPlayers);
        PlayersLineup visitantLineup = playersLineup(phase, application.lineupsManager().get(visitantLineupId), visitantPlayers);
        return application.models().matchSimulator().simulate(definition, date, localLineup, visitantLineup);
    }
}
