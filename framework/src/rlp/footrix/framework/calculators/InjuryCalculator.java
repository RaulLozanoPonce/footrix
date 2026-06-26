package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;

import java.util.List;

public class InjuryCalculator extends Calculator {

    public InjuryCalculator(Application application) {
        super(application);
    }

    public int injuryDays(Player player, Match match) {
        List<Match.MatchEvent> injuries = injuriesOf(player, match);
        if (injuries.isEmpty()) return 0;
        int level = injuryLevel(injuries);
        return injuryDays(level, player.psychophysics().energy(), player.psychophysics().physicalCondition(), player.psychophysics().selfConfidence(), player.definition().injuryResistance());
    }

    public int injuryDays(int level, double energy, double physicalCondition, double selfConfidence, PlayerDefinition.InjuryResistance resistance) {
        double random = 0.99 * Math.random();
        double baseDays = minInjuryDays(level) - meanInjuryDays(level) * Math.log10(1 - random);
        double factor = fatigueFactor(energy) * physicalConditionFactor(physicalCondition) * selfConfidenceFactor(selfConfidence) * injuryResistanceFactor(resistance);
        return (int) Math.round(baseDays * factor);
    }

    private List<Match.MatchEvent> injuriesOf(Player player, Match match) {
        return match.events().stream()
                .filter(e -> e.who().equals(player.definition().id()))
                .filter(e -> e.type() == Match.MatchEvent.Type.Injury)
                .toList();
    }

    private int injuryLevel(List<Match.MatchEvent> injuries) {
        return injuries.stream()
                .filter(i -> i.metaInfo().has("level"))
                .mapToInt(i -> i.metaInfo().get("level").getAsInt())
                .max().orElse(1);
    }

    private int minInjuryDays(int level) {
        if (level == 1) return 1;
        if (level == 2) return 20;
        return 120;
    }

    private int meanInjuryDays(int level) {
        if (level == 1) return 9;
        if (level == 2) return 15;
        return 90;
    }

    private double fatigueFactor(double energy) {
        return energy * 0.95 + (1 - energy) * 1.1;
    }

    private double physicalConditionFactor(double physicState) {
        return physicState * 0.9 + (1 - physicState) * 1.2;
    }

    private double selfConfidenceFactor(double selfConfidence) {
        return selfConfidence * 0.98 + (1 - selfConfidence) * 1.05;
    }

    private double injuryResistanceFactor(PlayerDefinition.InjuryResistance resistance) {
        if (resistance == PlayerDefinition.InjuryResistance.A) return 0.9;
        if (resistance == PlayerDefinition.InjuryResistance.B) return 1;
        if (resistance == PlayerDefinition.InjuryResistance.C) return 1.15;
        return 1;
    }
}
