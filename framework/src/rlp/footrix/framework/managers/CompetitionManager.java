package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.types.Competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompetitionManager {

    private final Game game;
    private final Map<String, Competition> competitions;
    private final Map<String, Map<String, Competition>> lastCompetitions = new HashMap<>();

    public CompetitionManager(Game game, List<Competition> competitions) {
        this.game = game;
        this.competitions = competitions.stream().collect(Collectors.toMap(c -> c.definition().id(), c -> c));
    }

    public Competition get(String id, String season) {
        if (game.season().equals(season)) return competitions.get(id);
        return lastCompetitions.get(id).get(season);
    }
}
