package rlp.footrix.framework.deprecated;

import rlp.footrix.framework.managers.PlayerManager;
import rlp.footrix.framework.stores.MatchMemoryStore;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static rlp.footrix.framework.types.Match.MatchEvent.Type.Goal;

public class StatisticTables {

    private final PlayerManager playerManager;
    private final MatchMemoryStore matchStore;

    public StatisticTables(PlayerManager playerManager, MatchMemoryStore matchStore) {
        this.playerManager = playerManager;
        this.matchStore = matchStore;
    }

    public List<PlayerClassification> scorersOf(String competition, String season, int n) {
        Map<String, List<Match.MatchEvent>> goals = matchStore.get(competition, season).stream()
                .flatMap(m -> m.events().stream().filter(e -> e.type() == Goal))
                .collect(Collectors.groupingBy(Match.MatchEvent::who));
        return goals.keySet().stream()
                .map(id -> new PlayerClassification(id, playerManager.get(id).definition().name(), (double) goals.get(id).size()))
                .sorted((o1, o2) -> o2.score().compareTo(o1.score()))
                .limit(n)
                .toList();
    }

    public List<PlayerClassification> assistantsOf(String competition, String season, int n) {
        Map<String, List<Match.MatchEvent>> assists = matchStore.get(competition, season).stream()
                .flatMap(m -> m.events().stream().filter(e -> e.type() == Goal && e.secondaryWho() != null))
                .collect(Collectors.groupingBy(Match.MatchEvent::secondaryWho));
        return assists.keySet().stream()
                .map(id -> new PlayerClassification(id, playerManager.get(id).definition().name(), (double) assists.get(id).size()))
                .sorted((o1, o2) -> o2.score().compareTo(o1.score()))
                .limit(n)
                .toList();
    }

    public List<PlayerClassification> bestGoalkeepersOf(String competition, String season, int n) {
        Map<String, Double> minutes = new HashMap<>();
        Map<String, Integer> goalsAgainst = new HashMap<>();
        for (Match match : matchStore.get(competition, season)) {
            for (String player : match.playerStatistics().keySet()) {
                Match.PlayerStatistics statistics = match.playerStatistics().get(player);
                if (!statistics.minutes().containsKey(Position.PT)) continue;
                if (!minutes.containsKey(player)) minutes.put(player, 0.0);
                if (!goalsAgainst.containsKey(player)) goalsAgainst.put(player, 0);
                minutes.put(player, minutes.get(player) + statistics.minutes().get(Position.PT));
                goalsAgainst.put(player, goalsAgainst.get(player) + statistics.goalsAgainst());
            }
        }
        double maxMinutes = minutes.values().stream().mapToDouble(m -> m).max().orElse(0.0);
        return minutes.keySet().stream()
                .filter(id -> minutes.get(id) >= 0.8 * maxMinutes)
                .map(id -> new PlayerClassification(id, playerManager.get(id).definition().name(), goalsAgainst.get(id) / (double) minutes.get(id)))
                .sorted(Comparator.comparing(PlayerClassification::score))
                .limit(n)
                .toList();
    }

    public List<PlayerClassification> bestPlayer(String season, int n) {
        Map<String, Double> points = new HashMap<>();
        for (Match match : matchStore.get(season)) {
            for (String player : match.playerStatistics().keySet()) {
                if (!points.containsKey(player)) points.put(player, 0.0);
                points.put(player, points.get(player) + match.playerStatistics().get(player).score());
            }
        }

        return points.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).limit(n).map(e -> {
            Player player = playerManager.get(e.getKey());
            return new PlayerClassification(player.definition().id(), player.definition().name(), e.getValue());
        }).toList();
    }
}
