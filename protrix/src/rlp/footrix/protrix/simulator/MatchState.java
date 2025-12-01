package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.simulator.weights.PositionWeight;

import java.util.*;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Goal;
import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.Substitution;

public class MatchState {
    private final List<Match.MatchEvent> events = new ArrayList<>();
    private final List<Match.MatchEvent> minuteEvents = new ArrayList<>();

    private final Map<String, Integer> minutes = new HashMap<>();
    private final Map<String, Double> baseScore = new HashMap<>();
    private final Map<String, Double> fatigue = new HashMap<>();

    private final Map<String, PlayersLineup> lineups = new HashMap<>();
    private final String local;
    private final String visitant;
    private final Map<String, Map<String, Position>> positions = new HashMap<>();

    private final Random random;

    public MatchState(String local, String visitant, PlayersLineup localLineup, PlayersLineup visitantLineup) {
        this.local = local;
        this.visitant = visitant;
        this.lineups.put(local, localLineup);
        this.lineups.put(visitant, visitantLineup);
        this.positions.put(local, new HashMap<>());
        this.positions.put(visitant, new HashMap<>());
        localLineup.fieldPlayers().forEach(p -> this.positions.get(local).put(p.definition().id(), localLineup.positionOf(p.definition().id())));
        visitantLineup.fieldPlayers().forEach(p -> this.positions.get(visitant).put(p.definition().id(), visitantLineup.positionOf(p.definition().id())));
        this.random = new Random();
    }

    public String local() {
        return local;
    }

    public String visitant() {
        return visitant;
    }

    public PlayersLineup lineup(String team) {
        return lineups.get(team);
    }

    public PlayersLineup localLineup() {
        return lineup(local);
    }

    public PlayersLineup visitantLineup() {
        return lineup(visitant);
    }

    public void substitute(String team, String playerIn, String playerOut) {
        PlayersLineup lineup = lineup(team);
        Player in = lineup.substitutes().stream().filter(p -> p.definition().id().equals(playerIn)).findFirst().orElse(null);
        Player out = lineup.fieldPlayers().stream().filter(p -> p.definition().id().equals(playerOut)).findFirst().orElse(null);
        if (in == null || out == null) return;
        Integer[] position = lineup.locationOf(playerOut);
        lineup.positions().put(in, position);
        lineup.positions().remove(out);
        lineup.substitutes().remove(in);
        lineup.substitutions().add(out);
        this.positions.get(team).put(in.definition().id(), lineup.positionOf(in.definition().id()));
    }

    public void expell(String team, String playerId) {
        PlayersLineup lineup = lineup(team);
        Player out = lineup.fieldPlayers().stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
        if (out == null) return;
        lineup.positions().remove(out);
        lineup.expelled().add(out);
    }

    public List<Match.MatchEvent> events() {
        return events;
    }

    public List<Match.MatchEvent> minuteEvents() {
        return minuteEvents;
    }

    public Position positionOf(String team, String player) {
        return positions.get(team).get(player);
    }





    public void addFatigue(String player, Double delta) {
        fatigue.putIfAbsent(player, 0.0);
        fatigue.put(player, Math.min(1, fatigue.get(player) + delta));
    }

    public double fatigue(String player) {
        return fatigue.getOrDefault(player, 0.0);
    }

    public double score(String team, String player, int currentMinute) {
        this.baseScore.putIfAbsent(player, 5.8 + 0.5 * random.nextGaussian());
        double baseScore = this.baseScore.get(player);
        double minuteFactor = (minutesOf(player, currentMinute) / (double) currentMinute);
        double score = baseScore * (0.8 + 0.2 * minuteFactor);
        score += events().stream()
                .filter(e -> e.who().equals(player) || (e.secondaryWho() != null && e.secondaryWho().equals(player)))
                .mapToDouble(e -> bonusOf(e, team, player))
                .sum();
        score += teamScore(team, player);
        return score;
    }

    private int minutesOf(String player, int currentMinute) {
        int enterMinute = events().stream()
                .filter(e -> e.type() == Substitution).filter(e -> e.who().equals(player))
                .map(Match.MatchEvent::minute).findFirst().orElse(0);
        int exitMinute = events().stream()
                .filter(e -> e.type() == Substitution).filter(e -> e.secondaryWho().equals(player))
                .map(Match.MatchEvent::minute).findFirst().orElse(currentMinute);
        return exitMinute - enterMinute;
    }

    private double bonusOf(Match.MatchEvent event, String team, String player) {
        return switch (event.type()) {
            case Goal -> bonusOfGoal(event, team, player);
            case Expulsion -> -1;
            case YellowCard -> (!expelled(player)) ? -0.3 : 0;
            default -> 0;
        };
    }

    private double bonusOfGoal(Match.MatchEvent event, String team, String player) {
        if (event.who().equals(player)) {
            return bonusOfGoal(team, player);
        } else {
            return bonusOfAssist(team, player);
        }
    }

    private boolean expelled(String player) {
        return events().stream().anyMatch(e -> e.type() == Match.MatchEvent.Type.Expulsion && e.who().equals(player));
    }

    private double teamScore(String team, String player) {
        long teamGoals = events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(team)).count();
        long otherGoals = events().stream().filter(e -> e.type() == Goal).filter(e -> !e.team().equals(team)).count();
        double cleanSheetBonus = otherGoals == 0 ? bonusOfCleanSheet(team, player) : 0;
        double resultBonus = teamGoals > otherGoals ? 0.2 : (teamGoals < otherGoals ? -0.2 : 0);
        return cleanSheetBonus + resultBonus;
    }

    private double bonusOfGoal(String team, String player) {
        Position position = positionOf(team, player);
        return PositionWeight.bonusOfGoal(position);
    }

    private double bonusOfAssist(String team, String player) {
        Position position = positionOf(team, player);
        return PositionWeight.bonusOfAssist(position);
    }

    private double bonusOfCleanSheet(String team, String player) {
        Position position = positionOf(team, player);
        return PositionWeight.bonusOfCleanSheet(position);
    }

    public void addMinute(String player) {
        this.minutes.putIfAbsent(player, 0);
        this.minutes.put(player, this.minutes.get(player) + 1);
    }

    public Integer minutes(String player) {
        return this.minutes.get(player);
    }
}
