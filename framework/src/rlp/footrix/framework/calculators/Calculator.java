package rlp.footrix.framework.calculators;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;

import java.util.List;

public class Calculator {
    protected final Application application;

    public Calculator(Application application) {
        this.application = application;
    }

    protected double percentMinutes(Player player, Match match) {
        int minutes = minutesOf(player, match);
        int maxMinutes = maxMinutesOf(player, match, minutes);
        return minutes / (double) maxMinutes;
    }

    private int minutesOf(Player player, Match match) {
        Match.PlayerStatistics statistics = match.playerStatistics().get(player.definition().id());
        return statistics != null ? statistics.minutes() : 0;
    }

    private int maxMinutesOf(Player player, Match match, int playedMinutes) {
        List<Integer> minutes = match.events().stream()
                .filter(e -> e.type() == Match.MatchEvent.Type.Injury || e.type() == Match.MatchEvent.Type.Expulsion)
                .filter(e -> e.who().equals(player.definition().id()))
                .map(Match.MatchEvent::minute)
                .toList();
        if (minutes.isEmpty()) return match.duration();
        return Math.max(playedMinutes, minutes.stream().mapToInt(m -> m).max().orElse(match.duration()));
    }
}
