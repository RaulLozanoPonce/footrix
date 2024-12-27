package rlp.footrix.framework.configuration;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team.Team;

import java.util.List;

public interface DataBase {
    List<Competition> competitions();
    List<Team> teams();
    List<Player> players();
}
