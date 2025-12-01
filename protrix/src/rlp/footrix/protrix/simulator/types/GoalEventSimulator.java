package rlp.footrix.protrix.simulator.types;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.weights.PlayerValue;
import rlp.footrix.protrix.simulator.weights.PositionWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static rlp.footrix.protrix.simulator.weights.PositionWeight.attackWeight;
import static rlp.footrix.protrix.simulator.weights.PositionWeight.defenseWeight;

public class GoalEventSimulator extends EventSimulator {
    private static final double BaseXG = 1.25;
    private static final double PowerUp = 5.3;
    private static final double Adjust = 0.2;
    private static final double LocalPowerUp = 1.3;
    private static final double VisitantPowerUp = 0.7;

    public GoalEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<Match.MatchEvent> simulate(int minute) {
        List<Match.MatchEvent> events = new ArrayList<>();
        double localXG = teamXG(attackScore(localLineup()), defenseScore(visitantLineup())) * LocalPowerUp - Adjust;
        double visitantXG = teamXG(attackScore(visitantLineup()), defenseScore(localLineup())) * VisitantPowerUp - Adjust;

        if (Math.random() < Math.min(Math.max(perMinuteGoalProb(localXG), 0.0), 0.5)) {
            String scorer = chooseGoalScorer(localLineup().fieldPlayers(), localLineup());
            String assist = chooseAssister(localLineup().fieldPlayers(), scorer);
            events.add(new Match.MatchEvent(local(), Match.MatchEvent.Type.Goal, minute, scorer, assist, null));
        }

        if (Math.random() < Math.min(Math.max(perMinuteGoalProb(visitantXG), 0.0), 0.5)) {
            String scorer = chooseGoalScorer(visitantLineup().fieldPlayers(), visitantLineup());
            String assist = chooseAssister(visitantLineup().fieldPlayers(), scorer);
            events.add(new Match.MatchEvent(visitant(), Match.MatchEvent.Type.Goal, minute, scorer, assist, null));
        }
        return events;
    }

    public double teamXG(double atkStrength, double defStrengthOpponent) {
        if (defStrengthOpponent <= 0) defStrengthOpponent = 0.000001;
        return BaseXG * (atkStrength / defStrengthOpponent);
    }

    public double perMinuteGoalProb(double teamXG) {
        return 1 - Math.exp(-teamXG/90);
    }

    private double attackScore(PlayersLineup lineup) {
        double weightSum = lineup.fieldPlayers().stream().mapToDouble(p -> attackWeight(lineup.positionOf(p.definition().id()))).sum();
        return lineup.fieldPlayers().stream().mapToDouble(p -> attackOf((ProtrixPlayer) p, lineup, weightSum)).sum();
    }

    private double defenseScore(PlayersLineup lineup) {
        double weightSum = lineup.fieldPlayers().stream().mapToDouble(p -> defenseWeight(lineup.positionOf(p.definition().id()))).sum();
        return lineup.fieldPlayers().stream().mapToDouble(p -> defenseOf((ProtrixPlayer) p, lineup, weightSum)).sum();
    }

    private double attackOf(ProtrixPlayer player, PlayersLineup lineup, double weightSum) {
        Position position = lineup.positionOf(player.definition().id());
        return (attackWeight(position) / weightSum) * (player.overall(position) / player.overall()) * pow(playerValue.attack(player) * 100, PowerUp)/100.0;
    }

    private double defenseOf(ProtrixPlayer player, PlayersLineup lineup, double weightSum) {
        Position position = lineup.positionOf(player.definition().id());
        return (defenseWeight(position) / weightSum) * (player.overall(position) / player.overall()) * pow(playerValue.defense(player, position) * 100, PowerUp)/100.0;
    }

    public String chooseGoalScorer(List<Player> players, PlayersLineup lineup) {
        List<Double> weights = new ArrayList<>();
        for (Player p : players) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double positionWeight = PositionWeight.goal(lineup.positionOf(player.definition().id()));
            double weight = playerValue.attack(player) * playerValue.form(player) * playerValue.energy(player) * positionWeight;
            weights.add(weight);
        }
        return weightedChoice(players, weights);
    }

    public String chooseAssister(List<Player> players, String scorerId) {
        if (Math.random() > 0.75) return null;

        List<Player> candidates = players.stream()
                .filter(p -> !p.definition().id().equals(scorerId))
                .collect(Collectors.toList());

        if (candidates.isEmpty()) return null;

        List<Double> weights = new ArrayList<>();
        for (Player p : candidates) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double weight = playerValue.pass(player) * playerValue.form(player) * playerValue.energy(player);
            weights.add(weight);
        }

        return weightedChoice(candidates, weights);
    }

    public String weightedChoice(List<Player> players, List<Double> weights) {
        double total = 0.0;
        for (double w : weights) total += w;
        if (total <= 0) {
            return players.get((int) (Math.random() * players.size())).definition().id();
        }

        double r = Math.random() * total;
        double upto = 0.0;

        for (int i = 0; i < players.size(); i++) {
            upto += weights.get(i);
            if (r <= upto) {
                return players.get(i).definition().id();
            }
        }
        return players.getLast().definition().id();
    }
}
