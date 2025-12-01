package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public interface EntityStore {
    Competition competition(String id, int season);
    void competition(Competition competition, int season);
    Team team(String id);
    void team(Team team);
    List<Player> players();
    Player player(PlayerDefinition definition);
    Player player(String id);
    void player(Player player);
    Match match(MatchDefinition definition);
    List<Match> matches(String competition, int season);
    void match(Match match);
}