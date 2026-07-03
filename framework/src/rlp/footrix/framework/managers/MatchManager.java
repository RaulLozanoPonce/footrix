package rlp.footrix.framework.managers;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.types.ScheduledMatchEvent;
import rlp.footrix.framework.types.entities.definitions.MatchDefinition;
import rlp.footrix.framework.types.entities.match.Match;

import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;

public class MatchManager {
    private final Application application;

    public MatchManager(Application application) {
        this.application = application;
    }

    public List<MatchDefinition> get(Instant from, Instant to, Integer season, String competition, List<Predicate<MatchDefinition>> predicates) {
        Map<Instant, List<MatchDefinition>> definitions = new HashMap<>();
        definitions.putAll(playedDefinitions(from, to, season, competition, predicates));
        definitions.putAll(futureDefinitions(from, to, season, competition, predicates));
        return definitions.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .flatMap(ts -> definitions.get(ts).stream())
                .toList();
    }

    private Map<Instant, List<MatchDefinition>> playedDefinitions(Instant from, Instant to, Integer season, String competition, List<Predicate<MatchDefinition>> predicates) {
        Map<Instant, List<MatchDefinition>> definitions = new HashMap<>();
        for (Match match : application.entityStore().matches(from, to, season, competition, predicates)) {
            definitions.putIfAbsent(match.date(), new ArrayList<>());
            definitions.get(match.date()).add(match.definition());
        }
        return definitions;
    }

    private Map<Instant, List<MatchDefinition>> futureDefinitions(Instant from, Instant to, Integer season, String competition, List<Predicate<MatchDefinition>> predicates) {
        Map<Instant, List<MatchDefinition>> definitions = new HashMap<>();
        for (Event event : application.taskHub().tasksFrom(from)) {
            if (event instanceof ScheduledMatchEvent scheduled) {
                if (scheduled.date().isAfter(to)) continue;
                if (season != null && scheduled.definition().season() != season) continue;
                if (competition != null && !scheduled.definition().competition().equals(competition)) continue;
                if (predicates.stream().allMatch(p -> p.test(scheduled.definition()))) {
                    definitions.putIfAbsent(scheduled.date(), new ArrayList<>());
                    definitions.get(scheduled.date()).add(scheduled.definition());
                }
            }
        }
        return definitions;
    }
}
