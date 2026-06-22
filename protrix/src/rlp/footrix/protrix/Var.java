package rlp.footrix.protrix;

import rlp.footrix.framework.types.entities.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Var {

    public static void showMetrics(ProtrixApplication application) {
        substitutionMetrics(application);
        injuriesMetrics(application);
    }

    private static void substitutionMetrics(ProtrixApplication application) {
        System.out.println("Generando estadísticas de sustituciones -------------------------------------------------");
        Map<Integer, Integer> substitutions = substitutions(application);
        for (int i = 1; i <= 90; i++) {
            Integer subs = substitutions.get(i);
            System.out.println(i + "\t" + Objects.requireNonNullElse(subs, 0));
        }
    }

    private static Map<Integer, Integer> substitutions(ProtrixApplication application) {
        Map<Integer, Integer> substitutions = new HashMap<>();
        for (Match match : application.entityStore().matches("ESP-1", 0)) {
            Map<String, Integer> teamSubstitutions = new HashMap<>();
            for (Match.MatchEvent event : match.events()) {
                if (event.type() != Match.MatchEvent.Type.Substitution) continue;
                int minute = event.minute();
                substitutions.putIfAbsent(minute, 0);
                substitutions.put(minute, substitutions.get(minute) + 1);
                teamSubstitutions.putIfAbsent(event.team(), 0);
                teamSubstitutions.put(event.team(), teamSubstitutions.get(event.team()) + 1);
            }
            for (String team : teamSubstitutions.keySet()) {
                if (teamSubstitutions.get(team) > 5) System.out.println("Hay " + teamSubstitutions.get(team) + " del equipo " + team + " en " + match.definition().id());
            }
        }
        return substitutions;
    }

    private static void injuriesMetrics(ProtrixApplication application) {
        System.out.println("Generando estadísticas de lesiones-------------------------------------------------------");
        Map<Integer, Integer> injuries = injuries(application);
        for (int i = 1; i <= 3; i++) {
            Integer subs = injuries.get(i);
            System.out.println(i + "\t" + Objects.requireNonNullElse(subs, 0));
        }
    }

    private static Map<Integer, Integer> injuries(ProtrixApplication application) {
        Map<Integer, Integer> injuries = new HashMap<>();
        for (Match match : application.entityStore().matches("ESP-1", 0)) {
            for (Match.MatchEvent event : match.events()) {
                if (event.type() != Match.MatchEvent.Type.Injury) continue;
                int level = event.metaInfo().get("level").getAsInt();
                injuries.putIfAbsent(level, 0);
                injuries.put(level, injuries.get(level) + 1);
            }
        }
        return injuries;
    }
}
