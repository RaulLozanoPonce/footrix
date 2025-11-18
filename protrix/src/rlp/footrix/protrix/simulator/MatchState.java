package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;

import java.util.*;

public class MatchState {
    private final List<Match.MatchEvent> events = new ArrayList<>();
    private final List<Match.MatchEvent> minuteEvents = new ArrayList<>();
    private final Map<String, Double> fatigue = new HashMap<>();
    private final Map<String, Double> rating = new HashMap<>();
    private final Map<String, PlayersLineup> lineups = new HashMap<>();
    private final String local;
    private final String visitant;

    public MatchState(String local, String visitant, PlayersLineup localLineup, PlayersLineup visitantLineup) {
        this.local = local;
        this.visitant = visitant;
        this.lineups.put(local, localLineup);
        this.lineups.put(visitant, visitantLineup);
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

    public void addFatigue(String player, Double delta) {
        fatigue.putIfAbsent(player, 0.0);
        fatigue.put(player, Math.min(1, fatigue.get(player) + delta));
    }

    public double fatigue(String player) {
        return fatigue.getOrDefault(player, 0.0);
    }

    public double rating(String player) {
        return rating.getOrDefault(player, 0.0);
    }

    public void substitute(String team, String playerIn, String playerOut) {
        PlayersLineup lineup = lineup(team);
        Player in = lineup.substitutes().stream().filter(p -> p.definition().id().equals(playerIn)).findFirst().orElse(null);
        Player out = lineup.fieldPlayers().stream().filter(p -> p.definition().id().equals(playerOut)).findFirst().orElse(null);
        Integer[] position = lineup.locationOf(playerOut);
        lineup.positions().put(in, position);
        lineup.positions().remove(out);
        lineup.substitutes().remove(in);
        lineup.substitutions().add(out);
    }

    public List<Match.MatchEvent> events() {
        return events;
    }

    public List<Match.MatchEvent> minuteEvents() {
        return minuteEvents;
    }
}
