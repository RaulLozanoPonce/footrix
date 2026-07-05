package rlp.footrix.framework.managers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.match.Match;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.*;

public class StreakManager {
    private final Application application;

    private final Map<String, Queue<Match>> streak = new HashMap<>();

    public StreakManager(Application application) {
        this.application = application;
        init();
    }

    public void newMatch(Match match) {
        streak.get(match.definition().local()).offer(match);
        while (streak.get(match.definition().local()).size() > 5) {
            streak.get(match.definition().local()).poll();
        }
        streak.get(match.definition().visitant()).offer(match);
        while (streak.get(match.definition().visitant()).size() > 5) {
            streak.get(match.definition().visitant()).poll();
        }
    }

    public int streak(Team team) {
        return streak.get(team.definition().id()).stream().mapToInt(m -> m.streak(team.definition().id())).sum();
    }

    private void init() {
        for (Team team : application.teamManager().teams()) {
            streak.put(team.definition().id(), init(team));
        }
    }

    private Queue<Match> init(Team team) {
        List<Match> matches = application.entityStore().matches(team).stream()
                .sorted((o1, o2) -> o2.date().compareTo(o1.date()))
                .limit(5)
                .sorted(Comparator.comparing(Match::date))
                .toList();
        return new ArrayDeque<>(matches);
    }
}
