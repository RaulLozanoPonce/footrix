package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.PlayersLineup;
import rlp.footrix.framework.var.Var;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.var.*;

import java.time.Instant;
import java.util.*;

import static rlp.footrix.protrix.simulator.helpers.PositionFactors.*;

public class MatchState {
    private final String local;
    private final String visitant;
    private final List<Match.MatchEvent> events = new ArrayList<>();
    private final Map<String, Match.PlayerStatistics> playerStatistics = new HashMap<>();
    private final Map<String, Integer> restSubstitutions = new HashMap<>();
    private final Var var;
    private final double matchFrames;

    private PlayersLineup localPlayers;
    private PlayersLineup visitantPlayers;
    private String teamWithPossession;
    private Player[] playerWithPossession = new Player[2];

    public MatchState(String local, String visitant, Var var, int maxSubstitutions, double matchFrames) {
        this.local = local;
        this.visitant = visitant;
        this.restSubstitutions.put(local, maxSubstitutions);
        this.restSubstitutions.put(visitant, maxSubstitutions);
        this.var = var;
        this.matchFrames = matchFrames;
    }

    public MatchState localPlayers(PlayersLineup localPlayers) {
        this.localPlayers = localPlayers;
        return this;
    }

    public MatchState visitantPlayers(PlayersLineup visitantPlayers) {
        this.visitantPlayers = visitantPlayers;
        return this;
    }

    public void setPossession(String team, Player player) {
        teamWithPossession = team;
        playerWithPossession = new ProtrixPlayer[2];
        playerWithPossession[1] = player;
    }

    public String local() {
        return local;
    }

    public String visitant() {
        return visitant;
    }

    public String rivalOf(String team) {
        if (team.equals(local)) return visitant;
        return local;
    }

    public String teamWithPossession() {
        return teamWithPossession;
    }

    public List<Player> localPlayers() {
        return localPlayers.positions().keySet().stream().toList();
    }

    public List<Player> visitantPlayers() {
        return visitantPlayers.positions().keySet().stream().toList();
    }

    public PlayersLineup localPlayersLineup() {
        return localPlayers;
    }

    public PlayersLineup visitantPlayersLineup() {
        return visitantPlayers;
    }

    public List<Player> playersOf(String team) {
        if (team.equals(local)) return localPlayers();
        return visitantPlayers();
    }

    public Player playerWithPossession() {
        return playerWithPossession[1];
    }

    public Player previousPlayerWithPossession() {
        return playerWithPossession[0];
    }

    public MatchState playerWithPossession(Player player) {
        playerWithPossession[0] = playerWithPossession[1];
        playerWithPossession[1] = player;
        return this;
    }

    public Position positionOf(Player player) {
        Integer[] localPosition = localPlayers.positions().get(player);
        if (localPosition != null) return localPlayers.lineup().positionOf(localPosition);
        Integer[] visitantPosition = visitantPlayers.positions().get(player);
        if (visitantPosition != null) return visitantPlayers.lineup().positionOf(visitantPosition);
        return null;
    }

    public Player playerWith(Map<Player, Integer[]> playersMap, Integer[] coordinates) {
        return playersMap.entrySet().stream()
                .filter(e -> Arrays.equals(e.getValue(), coordinates)).map(Map.Entry::getKey).findAny().orElse(null);
    }

    public Map<Player, Integer[]> playersMapOf(String team) {
        if (team.equals(local)) return localPlayers.positions();
        return visitantPlayers.positions();
    }

    public Map<String, Match.PlayerStatistics> playerStatistics() {
        return playerStatistics;
    }

    public List<Match.MatchEvent> events() {
        return events;
    }

    public MatchState events(List<Match.MatchEvent> events) {
        this.events.clear();
        this.events.addAll(events);
        return this;
    }

    public String mvp() {
        //TODO TENER EN CUENTA MINUTOS JUGADOS
        return playerStatistics.entrySet().stream().reduce((e1, e2) -> {
            if (e1.getValue().score() > e2.getValue().score()) return e1;
            return e2;
        }).map(Map.Entry::getKey).orElse(null);
    }

    public void addMinutes() {
        localPlayers.positions().forEach((key, value) -> playerStatisticsOf(key.definition().id()).addMinute(positionOf(localPlayers, value)));
        visitantPlayers.positions().forEach((key, value) -> playerStatisticsOf(key.definition().id()).addMinute(positionOf(visitantPlayers, value)));
    }

    public void addFatigue() {
        localPlayers.positions().forEach((key, value) -> key.energy(-fatigueOf(key)));
        visitantPlayers.positions().forEach((key, value) -> key.energy(-fatigueOf(key)));
    }

    public double goalsFor(String team) {
        return events.stream().filter(e -> e.type() == Match.MatchEvent.Type.Goal).filter(e -> e.team().equals(team)).count();
    }

    public void addSuccessfulDribble(Player dribbler, Player haggled) {
        playerStatisticsOf(dribbler.definition().id()).addScore(successfulDribbleOf(positionOf(dribbler)));
        var.publish(new SuccessfulDribbleRevision(Instant.now()).position(positionOf(dribbler)));
    }

    public void addUnsuccessfulDribble(Player dribbler, Player haggled) {
        playerStatisticsOf(dribbler.definition().id()).addScore(unsuccessfulDribbleOf(positionOf(dribbler)));
        var.publish(new UnsuccessfulDribbleRevision(Instant.now()).position(positionOf(dribbler)));
    }

    public void addSuccessfulPass(Player passer, Player cutter) {
        playerStatisticsOf(passer.definition().id()).addScore(successfulPassOf(positionOf(passer)));
        var.publish(new SuccessfulPassRevision(Instant.now()).position(positionOf(passer)));
    }

    public void addUnsuccessfulPass(Player passer, Player cutter) {
        playerStatisticsOf(passer.definition().id()).addScore(unsuccessfulPassOf(positionOf(passer)));
        var.publish(new UnsuccessfulPassRevision(Instant.now()).position(positionOf(passer)));
    }

    public void addShootOffTarget(Player shooter) {
        playerStatisticsOf(shooter.definition().id()).addScore(shootOffTargetOf(positionOf(shooter)));
        var.publish(new ShootOffTargetRevision(Instant.now()).position(positionOf(shooter)));
    }

    public void addShootInTargetSaved(Player shooter, Player goalkeeper) {
        playerStatisticsOf(shooter.definition().id()).addScore(addShootInTargetSavedOf(positionOf(shooter)));
        playerStatisticsOf(goalkeeper.definition().id()).addScore(addShootInTargetSavedOf(positionOf(goalkeeper)));
        var.publish(new ShootInTargetRevision(Instant.now()).position(positionOf(shooter)));
    }

    public void addGoal(Player scorer, Player goalkeeper) {
        playerStatisticsOf(goalkeeper.definition().id()).addGoalAgainst();
        playerStatisticsOf(scorer.definition().id()).addScore(goalOf(positionOf(scorer)));
        playerStatisticsOf(goalkeeper.definition().id()).addScore(goalOf(positionOf(goalkeeper)));
        var.publish(new ScoredGoalRevision(Instant.now()).position(positionOf(scorer)));
    }

    public void addAssistance(Player assistant) {
        playerStatisticsOf(assistant.definition().id()).addScore(assistanceOf(positionOf(assistant)));
        var.publish(new AssistanceRevision(Instant.now()).position(positionOf(assistant)));
    }

    public void addFault(Player fouler, Player fouled) {
        playerStatisticsOf(fouler.definition().id()).addScore(faultCommitedOf(positionOf(fouler)));
        playerStatisticsOf(fouled.definition().id()).addScore(foulsReceivedOf(positionOf(fouled)));
        var.publish(new FaultCommitedRevision(Instant.now()).position(positionOf(fouler)));
    }

    public void addYellowCard(Player fouler) {
        playerStatisticsOf(fouler.definition().id()).addScore(yellowCardOf(positionOf(fouler)));
        var.publish(new YellowCardRevision(Instant.now()).position(positionOf(fouler)));
    }

    public void addYellowExpulsion(Player fouler) {
        var.publish(new YellowExpulsionRevision(Instant.now()).position(positionOf(fouler)));
    }

    public void addRedCard(Player fouler) {
        playerStatisticsOf(fouler.definition().id()).addScore(redCardOf(positionOf(fouler)));
        var.publish(new RedCardRevision(Instant.now()).position(positionOf(fouler)));
    }

    public void addInjury() {
        var.publish(new InjuryRevision(Instant.now()));
    }

    private Position positionOf(PlayersLineup playersLineup, Integer[] position) {
        return playersLineup.lineup().positionOf(position);
    }

    private double fatigueOf(Player player) {
        return fatigueFactorOf(positionOf(player)) * (((ProtrixPlayer) player).stamina() * (-0.01688) + 1.92839) / matchFrames;
    }

    private Match.PlayerStatistics playerStatisticsOf(String player) {
        if (!playerStatistics.containsKey(player)) playerStatistics.put(player, new Match.PlayerStatistics());
        return playerStatistics.get(player);
    }

    public Map<String, Integer> restSubstitutions() {
        return restSubstitutions;
    }

    public int restSubstitutions(String team) {
        return restSubstitutions.get(team);
    }

    public void out(String team, String playerId) {
        Player player = playerOf(playerId, team);
        if (team.equals(local)) localPlayers.positions().remove(player);
        else visitantPlayers.positions().remove(player);
    }

    public Player playerOf(String player, String team) {
        return playersOf(team).stream().filter(p -> p.definition().id().equals(player)).findFirst().orElse(null);
    }

    public void change(String team, String p1, String p2) {
        if (team.equals(local)) change(localPlayers, p1, p2);
        else change(visitantPlayers, p1, p2);
    }

    private void change(PlayersLineup players, String p1, String p2) {
        Integer[] p1Location = players.locationOf(p1);
        Integer[] p2Location = players.locationOf(p2);
        players.setLocation(p1, p2Location);
        players.setLocation(p2, p1Location);
    }
}
