package rlp.footrix.framework.managers;

import rlp.footrix.framework.types.team.Lineup;

import java.util.HashMap;
import java.util.Map;

public class LineupsManager {

    private final Map<String, Lineup> lineups = new HashMap<>();

    public Lineup get(String id) {
        return lineups.get(id);
    }

    public void add(Lineup lineup) {
        lineups.put(lineup.name(), lineup);
    }
}
