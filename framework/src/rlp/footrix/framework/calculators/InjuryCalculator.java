package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;

import java.util.List;

public class InjuryCalculator extends Calculator {

    public InjuryCalculator(Application application) {
        super(application);
    }

    public int deltaInjury(Player player, Match match) {
        List<Match.MatchEvent> injuries = injuriesOf(player, match);
        if (injuries.isEmpty()) return 0;
        int level = injuryLevel(injuries);
        double random = 0.99 * Math.random();
        return (int) Math.round(minInjuryDays(level) - meanInjuryDays(level) * Math.log10(1 - random));
    }

    private int injuryLevel(List<Match.MatchEvent> injuries) {
        int matchEventLevel = injuries.stream()
                .filter(i -> i.metaInfo().has("level"))
                .mapToInt(i -> i.metaInfo().get("level").getAsInt())
                .max().orElse(0);
        if (matchEventLevel > 0) return matchEventLevel;
        return defaultLevel();
    }

    private int defaultLevel() {
        double level = Math.random();
        if (level < 0.4954) return 1;
        if (level < 0.4954 + 0.4208) return 2;
        return 3;
    }

    private int minInjuryDays(int level) {
        if (level == 1) return 1;
        if (level == 2) return 20;
        return 120;
    }

    private int meanInjuryDays(int level) {
        if (level == 1) return 9;
        if (level == 2) return 15;
        return 190;
    }

    private List<Match.MatchEvent> injuriesOf(Player player, Match match) {
        return match.events().stream()
                .filter(e -> e.who().equals(player.definition().id()))
                .filter(e -> e.type() == Match.MatchEvent.Type.Injury)
                .toList();
    }
}
