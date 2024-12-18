package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchMemoryStore {

    private final Map<String, Map<String, Map<Integer, Map<Integer, Map<String, Match>>>>> matches = new HashMap<>();

    public void save(Match match) {
        create(match);
        matches.get(match.definition().season())
                .get(match.definition().competition())
                .get(match.definition().phase())
                .get(match.definition().group())
                .put(match.definition().local() + "-" + match.definition().visitant(), match);
    }

    public List<Match> get(String season) {
        return matches.get(season)
                .keySet().stream()
                .flatMap(k -> get(k, season).stream())
                .toList();
    }

    public List<Match> get(String competition, String season) {
        return matches.get(season)
                .get(competition)
                .values().stream()
                .flatMap(v -> v.values().stream().flatMap(v2 -> v2.values().stream()))
                .toList();
    }

    public List<Match> get(String competition, String season, int phaseId, int groupId) {
        return matches.get(season)
                .get(competition)
                .get(phaseId)
                .get(groupId)
                .values().stream().toList();
    }

    private void create(Match match) {
        MatchDefinition definition = match.definition();
        if (!matches.containsKey(definition.season())) matches.put(definition.season(), new HashMap<>());
        if (!matches.get(definition.season()).containsKey(definition.competition())) matches.get(definition.season()).put(definition.competition(), new HashMap<>());
        if (!matches.get(definition.season()).get(definition.competition()).containsKey(definition.phase())) matches.get(definition.season()).get(definition.competition()).put(definition.phase(), new HashMap<>());
        if (!matches.get(definition.season()).get(definition.competition()).get(definition.phase()).containsKey(definition.group())) matches.get(definition.season()).get(definition.competition()).get(definition.phase()).put(definition.group(), new HashMap<>());
    }
}
