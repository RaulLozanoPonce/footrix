package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.PlayersLineup;
import rlp.footrix.framework.types.Position;
import rlp.footrix.protrix.model.ProtrixPlayer;

import java.util.*;

import static rlp.footrix.protrix.simulator.PositionFactors.*;

public class MatchState {
    private final String local;
    private final String visitant;
    private final PlayersLineup localPlayers;
    private final PlayersLineup visitantPlayers;
    private final List<Match.MatchEvent> events = new ArrayList<>();
    private final Map<String, Match.PlayerStatistics> playerStatistics = new HashMap<>();
    private final MatchStatistics statistics;
    private String teamWithPossession;
    private Player[] playerWithPossession = new Player[2];
    private final Map<String, Integer> restSubstitutions = new HashMap<>();

    public MatchState(String local, String visitant, PlayersLineup localPlayers, PlayersLineup visitantPlayers) {
        this.local = local;
        this.visitant = visitant;
        this.localPlayers = localPlayers;
        this.visitantPlayers = visitantPlayers;
        this.statistics = new MatchStatistics();
        this.restSubstitutions.put(local, 5);   //TODO depende de la competicion
        this.restSubstitutions.put(visitant, 5);
    }

    public void init(String team, Player player) {
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
        statistics.addSuccessfulDribble(positionOf(dribbler), positionOf(haggled));
        playerStatisticsOf(dribbler.definition().id()).addScore(successfulDribbleOf(positionOf(dribbler)));
    }

    public void addUnsuccessfulDribble(Player dribbler, Player haggled) {
        statistics.addUnsuccessfulDribble(positionOf(dribbler), positionOf(haggled));
        playerStatisticsOf(dribbler.definition().id()).addScore(unsuccessfulDribbleOf(positionOf(dribbler)));
    }

    public void addSuccessfulPass(Player passer, Player cutter) {
        statistics.addSuccessfulPass(positionOf(passer), positionOf(cutter));
        playerStatisticsOf(passer.definition().id()).addScore(successfulPassOf(positionOf(passer)));
    }

    public void addUnsuccessfulPass(Player passer, Player cutter) {
        statistics.addUnsuccessfulPass(positionOf(passer), positionOf(cutter));
        playerStatisticsOf(passer.definition().id()).addScore(unsuccessfulPassOf(positionOf(passer)));
    }

    public void addShootOffTarget(Player shooter) {
        statistics.addShootOffTarget(positionOf(shooter));
        playerStatisticsOf(shooter.definition().id()).addScore(shootOffTargetOf(positionOf(shooter)));
    }

    public void addShootInTargetSaved(Player shooter, Player goalkeeper) {
        statistics.addShootInTargetSaved(positionOf(goalkeeper));
        playerStatisticsOf(shooter.definition().id()).addScore(addShootInTargetSavedOf(positionOf(shooter)));
        playerStatisticsOf(goalkeeper.definition().id()).addScore(addShootInTargetSavedOf(positionOf(goalkeeper)));
    }

    public void addGoal(Player scorer, Player goalkeeper) {
        statistics.addGoal(positionOf(scorer));
        playerStatisticsOf(goalkeeper.definition().id()).addGoalAgainst();
        playerStatisticsOf(scorer.definition().id()).addScore(goalOf(positionOf(scorer)));
        playerStatisticsOf(goalkeeper.definition().id()).addScore(goalOf(positionOf(goalkeeper)));
    }

    public void addAssistance(Player assistant) {
        statistics.addAssistance(positionOf(assistant));
        playerStatisticsOf(assistant.definition().id()).addScore(assistanceOf(positionOf(assistant)));
    }

    public void addFault(Player fouler, Player fouled) {
        statistics.addFault(positionOf(fouler), positionOf(fouled));
        playerStatisticsOf(fouler.definition().id()).addScore(faultCommitedOf(positionOf(fouler)));
        playerStatisticsOf(fouled.definition().id()).addScore(foulsReceivedOf(positionOf(fouled)));
    }

    public void addYellowCard(Player fouler) {
        statistics.addYellowCard(positionOf(fouler));
        playerStatisticsOf(fouler.definition().id()).addScore(yellowCardOf(positionOf(fouler)));
    }

    public void addYellowExpulsion(Player fouler) {
        statistics.addYellowExpulsion(positionOf(fouler));
    }

    public void addRedCard(Player fouler) {
        statistics.addRedCard(positionOf(fouler));
        playerStatisticsOf(fouler.definition().id()).addScore(redCardOf(positionOf(fouler)));
    }

    public void addInjury() {
        statistics.addInjury();
    }

    private Position positionOf(PlayersLineup playersLineup, Integer[] position) {
        return playersLineup.lineup().positionOf(position);
    }

    private double fatigueOf(Player player) {
        return fatigueFactorOf(positionOf(player)) * (((ProtrixPlayer) player).stamina() * (-0.01688) + 1.92839) / (90 * 3);    //TODO, ESTOS SON LOS FRAMES POR PARTIDO
    }

    private Match.PlayerStatistics playerStatisticsOf(String player) {
        if (!playerStatistics.containsKey(player)) playerStatistics.put(player, new Match.PlayerStatistics());
        return playerStatistics.get(player);
    }

    public MatchStatistics statistics() {
        return statistics;
    }

    public Player substitute(String team, Player playerToSubstitute) {
        PlayersLineup lineup;
        if (team.equals(local)) lineup = localPlayers;
        else lineup = visitantPlayers;
        Player successful = lineup.substitute(playerToSubstitute);
        if (successful != null) restSubstitutions.put(team, restSubstitutions.get(team) - 1);
        return successful;
    }

    public int restSubstitutions(String team) {
        return restSubstitutions.get(team);
    }

    public void out(String team, String playerId) {
        Player player = playersOf(team).stream().filter(p -> p.definition().id().equals(playerId)).findFirst().orElse(null);
        if (team.equals(local)) localPlayers.positions().remove(player);
        else visitantPlayers.positions().remove(player);
    }
}
