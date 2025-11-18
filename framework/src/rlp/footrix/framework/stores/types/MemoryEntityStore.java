package rlp.footrix.framework.stores.types;

import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.types.entities.Competition;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.*;

public class MemoryEntityStore implements EntityStore {
    private final Map<Integer, Map<String, Competition>> competitions = new HashMap<>();
    private final Map<String, Team> teams = new HashMap<>();
    private final Map<String, Player> players = new HashMap<>();
    private final Map<Integer, Map<String, Map<Integer, Map<String, List<Match>>>>> matches = new HashMap<>();

    @Override
    public Competition competition(String id, int season) {
        return competitions.get(season).get(id);
    }

    @Override
    public void competition(Competition competition, int season) {
        this.competitions.putIfAbsent(season, new HashMap<>());
        this.competitions.get(season).put(competition.definition().id(), competition);
    }

    @Override
    public Team team(String id) {
        return teams.get(id);
    }

    @Override
    public void team(Team team) {
        this.teams.put(team.definition().id(), team);
    }

    @Override
    public Player player(PlayerDefinition definition) {
        return player(definition.id());
    }

    @Override
    public Player player(String id) {
        return players.get(id);
    }

    @Override
    public void player(Player player) {
        this.players.put(player.definition().id(), player);
    }

    @Override
    public Match match(MatchDefinition definition) {
        return matches.get(definition.season())
                .get(definition.competition())
                .get(definition.phase())
                .get(definition.matchDay()).stream()
                .filter(m -> m.definition().equals(definition))
                .findFirst().orElse(null);
    }

    @Override
    public List<Match> matches(String competition, int season) {
        return matches.get(season)
                .get(competition).values().stream()
                .flatMap(v -> v.values().stream())
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public void match(Match match) {
        matches.putIfAbsent(match.definition().season(), new HashMap<>());
        matches.get(match.definition().season()).putIfAbsent(match.definition().competition(), new HashMap<>());
        matches.get(match.definition().season()).get(match.definition().competition()).putIfAbsent(match.definition().phase(), new HashMap<>());
        matches.get(match.definition().season()).get(match.definition().competition()).get(match.definition().phase()).putIfAbsent(match.definition().matchDay(), new ArrayList<>());
        matches.get(match.definition().season()).get(match.definition().competition()).get(match.definition().phase()).get(match.definition().matchDay()).add(match);
    }
}
