package rlp.footrix.framework.configuration;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.Team;

import java.util.List;

public interface DataBase {
    List<Competition> competitions();
    List<Team> teams();
    List<Player> players();
}
