package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Position;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {

    private static double matches = 0;
    private static final Map<Position, Integer> successfulDribbles = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> unsuccessfulDribbles = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> successfulPasses = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> unsuccessfulPasses = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> shootsOffTarget = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> shootsInTargetSaved = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> goals = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> assistances = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> faultsCommited = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> foulsReceived = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> yellowCards = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> yellowExpulsions = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static final Map<Position, Integer> redCards = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private static int injuries = 0;
    private static double minRating = 0;
    private static double maxRating = 0;
    private static double averageRating = 0;

    public static void register(MatchState state) {
        Statistics.matches += 1;
        Statistics.injuries += state.statistics().injuries();
        merge(Statistics.successfulDribbles, state.statistics().successfulDribbles());
        merge(Statistics.unsuccessfulDribbles, state.statistics().unsuccessfulDribbles());
        merge(Statistics.successfulPasses, state.statistics().successfulPasses());
        merge(Statistics.unsuccessfulPasses, state.statistics().unsuccessfulPasses());
        merge(Statistics.shootsOffTarget, state.statistics().shootsOffTarget());
        merge(Statistics.shootsInTargetSaved, state.statistics().shootsInTargetSaved());
        merge(Statistics.goals, state.statistics().goals());
        merge(Statistics.assistances, state.statistics().assistances());
        merge(Statistics.faultsCommited, state.statistics().faultsCommited());
        merge(Statistics.foulsReceived, state.statistics().foulsReceived());
        merge(Statistics.yellowCards, state.statistics().yellowCards());
        merge(Statistics.yellowExpulsions, state.statistics().yellowExpulsions());
        merge(Statistics.redCards, state.statistics().redCards());
        Statistics.minRating = Math.min(state.playerStatistics().values().stream().mapToDouble(Match.PlayerStatistics::score).min().orElse(0.0), minRating);
        Statistics.averageRating += state.playerStatistics().values().stream().mapToDouble(Match.PlayerStatistics::score).average().orElse(0.0);
        Statistics.maxRating = Math.max(state.playerStatistics().values().stream().mapToDouble(Match.PlayerStatistics::score).max().orElse(0.0), maxRating);
    }

    private static void merge(Map<Position, Integer> map, Map<Position, Integer> newMap) {
        newMap.forEach((position, value) -> map.put(position, map.get(position) + value));
    }

    public static String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("TOTAL").append("\n").append(statisticsOf(null)).append("\n");
//        sb.append("PT").append("\n").append(faultsCommited(Position.PT)).append("\n");
//        sb.append("CT").append("\n").append(faultsCommited(Position.CT)).append("\n");
//        sb.append("CAR").append("\n").append(faultsCommited(Position.CAR)).append("\n");
//        sb.append("LAT").append("\n").append(faultsCommited(Position.LAT)).append("\n");
//        sb.append("CCD").append("\n").append(faultsCommited(Position.CCD)).append("\n");
//        sb.append("CC").append("\n").append(faultsCommited(Position.CC)).append("\n");
//        sb.append("MP").append("\n").append(faultsCommited(Position.MP)).append("\n");
//        sb.append("VOL").append("\n").append(faultsCommited(Position.VOL)).append("\n");
//        sb.append("EXT").append("\n").append(faultsCommited(Position.EXT)).append("\n");
//        sb.append("SS").append("\n").append(faultsCommited(Position.SS)).append("\n");
//        sb.append("DL").append("\n").append(faultsCommited(Position.DL)).append("\n");
        sb.append("injuries: ").append(injuries / matches).append(" - min rating:").append(minRating).append(" - average rating:").append(averageRating/matches).append(" - max rating:").append(maxRating);
        return sb.toString();
    }

    private static String statisticsOf(Position position) {
        StringBuilder sb = new StringBuilder();
        if (position == null) {
            sb.append("successful dribbles: ").append(successfulDribbles(position)).append(" - ");
            sb.append("unsuccessful dribbles: ").append(unsuccessfulDribbles(position)).append(" - ");
            sb.append("successful passes: ").append(successfulPasses(position)).append(" - ");
            sb.append("unsuccessful passes: ").append(unsuccessfulPasses(position)).append(" - ");
            sb.append("shoots off target: ").append(shootsOffTarget(position)).append(" - ");
            sb.append("shoots in target saved: ").append(shootsInTargetSaved(position)).append(" - ");
            sb.append("goals: ").append(goals(position)).append(" - ");
            sb.append("assistances: ").append(assistances(position)).append(" - ");
            sb.append("faults commited: ").append(faultsCommited(position)).append(" - ");
            sb.append("fouls received: ").append(foulsReceived(position)).append(" - ");
            sb.append("yellow cards: ").append(yellowCards(position)).append(" - ");
            sb.append("yellow expulsions: ").append(yellowExpulsions(position)).append(" - ");
            sb.append("red cards: ").append(redCards(position));
        } else {
            sb.append(successfulDribbles(position)).append("\n");
            sb.append(unsuccessfulDribbles(position)).append("\n");
            sb.append(successfulPasses(position)).append("\n");
            sb.append(unsuccessfulPasses(position)).append("\n");
            sb.append(shootsOffTarget(position)).append("\n");
            sb.append(shootsInTargetSaved(position)).append("\n");
            sb.append(goals(position)).append("\n");
            sb.append(assistances(position)).append("\n");
            sb.append(faultsCommited(position)).append("\n");
            sb.append(foulsReceived(position)).append("\n");
            sb.append(yellowCards(position)).append("\n");
            sb.append(redCards(position));
        }
        return sb.toString();
    }

    private static Double successfulDribbles(Position position) {
        if (position == null) return successfulDribbles.values().stream().mapToDouble(v -> v).sum() / matches;
        return successfulDribbles.get(position) / matches;
    }

    private static Double unsuccessfulDribbles(Position position) {
        if (position == null) return unsuccessfulDribbles.values().stream().mapToDouble(v -> v).sum() / matches;
        return unsuccessfulDribbles.get(position) / matches;
    }

    private static Double successfulPasses(Position position) {
        if (position == null) return successfulPasses.values().stream().mapToDouble(v -> v).sum() / matches;
        return successfulPasses.get(position) / matches;
    }

    private static Double unsuccessfulPasses(Position position) {
        if (position == null) return unsuccessfulPasses.values().stream().mapToDouble(v -> v).sum() / matches;
        return unsuccessfulPasses.get(position) / matches;
    }

    private static Double shootsOffTarget(Position position) {
        if (position == null) return shootsOffTarget.values().stream().mapToDouble(v -> v).sum() / matches;
        return shootsOffTarget.get(position) / matches;
    }

    private static Double shootsInTargetSaved(Position position) {
        if (position == null) return shootsInTargetSaved.values().stream().mapToDouble(v -> v).sum() / matches;
        return shootsInTargetSaved.get(position) / matches;
    }

    private static Double goals(Position position) {
        if (position == null) return goals.values().stream().mapToDouble(v -> v).sum() / matches;
        return goals.get(position) / matches;
    }

    private static Double assistances(Position position) {
        if (position == null) return assistances.values().stream().mapToDouble(v -> v).sum() / matches;
        return assistances.get(position) / matches;
    }

    private static Double faultsCommited(Position position) {
        if (position == null) return faultsCommited.values().stream().mapToDouble(v -> v).sum() / matches;
        return faultsCommited.get(position) / matches;
    }

    private static Double foulsReceived(Position position) {
        if (position == null) return foulsReceived.values().stream().mapToDouble(v -> v).sum() / matches;
        return foulsReceived.get(position) / matches;
    }

    private static Double yellowCards(Position position) {
        if (position == null) return yellowCards.values().stream().mapToDouble(v -> v).sum() / matches;
        return yellowCards.get(position) / matches;
    }

    private static Double yellowExpulsions(Position position) {
        if (position == null) return yellowExpulsions.values().stream().mapToDouble(v -> v).sum() / matches;
        return yellowExpulsions.get(position) / matches;
    }

    private static Double redCards(Position position) {
        if (position == null) return redCards.values().stream().mapToDouble(v -> v).sum() / matches;
        return redCards.get(position) / matches;
    }
}
