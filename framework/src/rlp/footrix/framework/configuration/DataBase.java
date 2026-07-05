package rlp.footrix.framework.configuration;

import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public interface DataBase {
    List<CompetitionDefinition> competitions();
    List<Team> teams();
    List<Player> players();
}
