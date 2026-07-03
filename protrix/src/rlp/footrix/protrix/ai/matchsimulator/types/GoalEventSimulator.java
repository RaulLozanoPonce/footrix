package rlp.footrix.protrix.ai.matchsimulator.types;

import com.google.gson.JsonObject;
import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.pes6.types.Positions;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;
import rlp.footrix.protrix.ai.matchsimulator.weights.PositionWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static rlp.footrix.protrix.ai.matchsimulator.weights.PositionWeight.attackWeight;
import static rlp.footrix.protrix.ai.matchsimulator.weights.PositionWeight.defenseWeight;

public class GoalEventSimulator extends EventSimulator {
    private static final double AssistedGoalByMinute = 1.83 / 90;
    private static final double PenaltyGoalByMinute = 0.26 / 90;
    private static final double FreeKickGoalByMinute = 0.03 / 90;
    private static final double OwnGoalByMinute = 0.06 / 90;
    private static final double UnassistedGoalByMinute = 0.56 / 90;
    private static final double NormalFailByMinute = 15.4 / 90;
    private static final double PenaltyFailByMinute = 0.02 / 90;
    private static final double FreeKickFailByMinute = 0.75 / 90;
    private static final double NormalSaveByMinute = 6.3 / 90;
    private static final double PenaltySaveByMinute = 0.04 / 90;
    private static final double FreeKickSaveByMinute = 0.12 / 90;
    private static final double LocalPowerUp = 1.15;
    private static final double PlayerExponentialPower = 2.5;
    private static final double TeamExponentialPower = 2.5;

    public GoalEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<MatchEvent> simulate(int minute) {
        double random = Math.random();
        double limit = AssistedGoalByMinute;
        if (random < limit) return assistedGoal(minute);
        limit += PenaltyGoalByMinute;
        if (random < limit) return unassistedGoal(minute, "penalty");
        limit += FreeKickGoalByMinute;
        if (random < limit) return unassistedGoal(minute, "free-kick");
        limit += OwnGoalByMinute;
        if (random < limit) return ownGoal(minute);
        limit += UnassistedGoalByMinute;
        if (random < limit) return unassistedGoal(minute, "normal");
        limit += NormalFailByMinute;
        if (random < limit) return fail(minute, "normal");
        limit += PenaltyFailByMinute;
        if (random < limit) return fail(minute, "penalty");
        limit += FreeKickFailByMinute;
        if (random < limit) return fail(minute, "free-kick");
        limit += NormalSaveByMinute;
        if (random < limit) return save(minute, "normal");
        limit += PenaltySaveByMinute;
        if (random < limit) return save(minute, "penalty");
        limit += FreeKickSaveByMinute;
        if (random < limit) return save(minute, "free-kick");
        return new ArrayList<>();
    }

    private List<MatchEvent> assistedGoal(int minute) {
        String team = chooseAttackTeam();
        String scorer = chooseGoalScorer(players(team), lineup(team));
        String assistant = chooseAssister(players(team), scorer);
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("type", "normal");
        return List.of(new MatchEvent(team, MatchEvent.Type.Goal, minute, scorer, assistant, metainfo));
    }

    private List<MatchEvent> unassistedGoal(int minute, String type) {
        String team = chooseAttackTeam();
        String scorer = chooseGoalScorer(players(team), lineup(team));
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("type", type);
        return List.of(new MatchEvent(team, MatchEvent.Type.Goal, minute, scorer, null, metainfo));
    }

    private List<MatchEvent> ownGoal(int minute) {
        String team = chooseAttackTeam();
        String scorer = chooseOwnGoalScorer(players(other(team)), lineup(other(team)));
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("type", "own");
        return List.of(new MatchEvent(team, MatchEvent.Type.Goal, minute, scorer, null, metainfo));
    }

    private List<MatchEvent> fail(int minute, String type) {
        String team = chooseAttackTeam();
        String failer = chooseGoalScorer(players(team), lineup(team));
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("type", type);
        return List.of(new MatchEvent(team, MatchEvent.Type.Fail, minute, failer, null, metainfo));
    }

    private List<MatchEvent> save(int minute, String type) {
        String team = other(chooseAttackTeam());
        String goalkeeper = goalkeeper(players(team), lineup(team));
        String failer = chooseGoalScorer(players(other(team)), lineup(other(team)));
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("type", type);
        return List.of(new MatchEvent(team, MatchEvent.Type.Save, minute, goalkeeper, failer, metainfo));
    }

    private String chooseAttackTeam() {
        double localStrength = LocalPowerUp * pow(strengthOf(attackScore(localLineup()), defenseScore(visitantLineup())), TeamExponentialPower);
        double visitantStrength = pow(strengthOf(attackScore(visitantLineup()), defenseScore(localLineup())), TeamExponentialPower);
        double localProbability = localStrength / (localStrength + visitantStrength);
        if (Math.random() < localProbability) return local();
        else return visitant();
    }

    private double strengthOf(double atkStrength, double defStrengthOpponent) {
        if (defStrengthOpponent <= 0) defStrengthOpponent = 0.000001;
        return atkStrength / defStrengthOpponent;
    }

    private double attackScore(PlayersLineup lineup) {
        double weightSum = lineup.fieldPlayers().stream().mapToDouble(p -> attackWeight(lineup.positionOf(p.definition().id()))).sum();
        return lineup.fieldPlayers().stream().mapToDouble(p -> attackOf((Pes6Player) p, lineup, weightSum)).sum();
    }

    private double defenseScore(PlayersLineup lineup) {
        double weightSum = lineup.fieldPlayers().stream().mapToDouble(p -> defenseWeight(lineup.positionOf(p.definition().id()))).sum();
        return lineup.fieldPlayers().stream().mapToDouble(p -> defenseOf((Pes6Player) p, lineup, weightSum)).sum();
    }

    private double attackOf(Pes6Player player, PlayersLineup lineup, double weightSum) {
        Position position = lineup.positionOf(player.definition().id());
        return (attackWeight(position) / weightSum) * (player.skills().overall(position) / player.overall()) * pow(playerValue.attack(player), PlayerExponentialPower);
    }

    private double defenseOf(Pes6Player player, PlayersLineup lineup, double weightSum) {
        Position position = lineup.positionOf(player.definition().id());
        return (defenseWeight(position) / weightSum) * (player.skills().overall(position) / player.overall()) * pow(playerValue.defense(player, position), PlayerExponentialPower);
    }

    //TODO REVISAR DE AQUI PA BAJO.

    private String chooseGoalScorer(List<Player> players, PlayersLineup lineup) {
        List<Double> weights = new ArrayList<>();
        for (Player p : players) {
            Pes6Player player = (Pes6Player) p;
            double positionWeight = PositionWeight.goal(lineup.positionOf(player.definition().id()));
            double weight = playerValue.attack(player) * playerValue.form(player) * playerValue.energy(player) * playerValue.selfConfidence(player) * positionWeight;
            weights.add(weight);
        }
        return weightedChoice(players, weights);
    }
    private String chooseAssister(List<Player> players, String scorerId) {
        List<Player> candidates = players.stream()
                .filter(p -> !p.definition().id().equals(scorerId))
                .collect(Collectors.toList());
        if (candidates.isEmpty()) return null;
        List<Double> weights = new ArrayList<>();
        for (Player p : candidates) {
            Pes6Player player = (Pes6Player) p;
            double weight = playerValue.pass(player) * playerValue.form(player) * playerValue.energy(player) * playerValue.selfConfidence(player);
            weights.add(weight);
        }
        return weightedChoice(candidates, weights);
    }

    private String chooseOwnGoalScorer(List<Player> players, PlayersLineup lineup) {
        List<Double> weights = new ArrayList<>();
        for (Player p : players) {
            Pes6Player player = (Pes6Player) p;
            double positionWeight = PositionWeight.defenseWeight(lineup.positionOf(player.definition().id()));
            double weight = (1 - playerValue.form(player)) * (1 - playerValue.energy(player)) * (1 - playerValue.selfConfidence(player)) * positionWeight; //TODO REVISAR
            weights.add(weight);
        }
        return weightedChoice(players, weights);
    }

    private String goalkeeper(List<Player> players, PlayersLineup lineup) {
        return players.stream().map(p -> p.definition().id()).filter(p -> lineup.positionOf(p) == Positions.PT).findFirst().orElse(null);
    }

    private String weightedChoice(List<Player> players, List<Double> weights) {
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

    private String other(String team) {
        if (team.equals(local())) return visitant();
        return local();
    }

    private List<Player> players(String team) {
        return lineup(team).fieldPlayers();
    }

    private PlayersLineup lineup(String team) {
        if (team.equals(local())) return localLineup();
        return visitantLineup();
    }
}
