package rlp.footrix.framework.generators;

import rlp.footrix.framework.types.*;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Lineup;
import rlp.footrix.framework.types.team.PlayersLineup;
import rlp.footrix.framework.types.team_player.PlayerContract;

import java.util.*;

public class LineupGenerator {

    private static final double EnergyFactor = 0.40;
    private static final double RoleFactor = 0.25;
    private static final double GameTimeFactor = 0.20;
    private static final double IndividualFactor = 0.15;

    public static PlayersLineup playersLineup(Competition.Phase phase, Lineup lineup, List<Player> players) {
        Map<Player, Integer[]> playersMap = starters(entries(lineup, players));
        List<Player> substitutes = substitutes(phase, entries(lineup, players.stream().filter(p -> !playersMap.containsKey(p)).toList()));
        substitutes.addAll(reserves(phase, entries(lineup, players.stream().filter(p -> !playersMap.containsKey(p) && !substitutes.contains(p)).toList())));
        return new PlayersLineup(lineup, playersMap, substitutes);
    }

    public static double scoreOfMatch(Player player, Position position) {
        return player.relativeCache(position) *
                (
                        EnergyFactor * fix(player.energy()) +
                        RoleFactor * (player.role().expectedPlayingTime() / PlayerContract.Role.Undisputed.expectedPlayingTime()) +
                        GameTimeFactor * (1 - player.mood().gameTime()) +
                        IndividualFactor * player.mood().individualPerformance()
                );
    }

    private static Map<Player, Integer[]> starters(List<LineupEntry> entries) {
        return players(entries, 11, true);
    }

    private static List<Player> substitutes(Competition.Phase phase, List<LineupEntry> entries) {
        Map<Player, Integer[]> playersMap = players(entries, Math.min(11, phase.definition().substitutesNumber()), false);
        return new ArrayList<>(playersMap.keySet());
    }

    private static List<Player> reserves(Competition.Phase phase, List<LineupEntry> entries) {
        if (phase.definition().substitutesNumber() - 11 <= 0) return new ArrayList<>();
        Map<Player, Integer[]> playersMap = players(entries, phase.definition().substitutesNumber() - 11, false);
        return new ArrayList<>(playersMap.keySet());
    }

    private static Map<Player, Integer[]> players(List<LineupEntry> entries, int maxPlayers, boolean neededAllPlayers) {
        int count = 0;
        Set<String> locations = new HashSet<>();
        Set<String> players = new HashSet<>();
        List<LineupEntry> subEntries = new ArrayList<>();
        for (LineupEntry entry : entries) {
            subEntries.add(entry);
            if (locations.contains(Arrays.toString(entry.location())) || players.contains(entry.player().definition().id())) continue;
            locations.add(Arrays.toString(entry.location()));
            players.add(entry.player().definition().id());
            count++;
            if (count == maxPlayers) return playersOf(subEntries, maxPlayers);
        }
        if (!neededAllPlayers) return playersOf(subEntries, (int) entries.stream().map(e -> e.player().definition().id()).distinct().count());
        throw new RuntimeException("Exception");
    }

    private static Map<Player, Integer[]> playersOf(List<LineupEntry> entries, int maxPlayers) {
        List<LineupEntry> copy = new ArrayList<>(entries);
        copy.sort((o1, o2) -> Double.compare(o2.overall(), o1.overall()));
        Map<Player, Integer[]> playersMap = new LinkedHashMap<>();
        Set<String> registeredPositions = new HashSet<>();
        Set<String> registeredPlayers = new HashSet<>();
        return playersOf(copy, playersMap, registeredPositions, registeredPlayers, maxPlayers);
    }

    private static Map<Player, Integer[]> playersOf(List<LineupEntry> entries, Map<Player, Integer[]> playersMap, Set<String> positions, Set<String> players, int maxPlayers) {
        if (playersMap.size() == maxPlayers) return playersMap;
        for (int i = 0; i < entries.size(); i++) {
            LineupEntry entry = entries.get(i);
            if (positions.contains(Arrays.toString(entry.location()))) continue;
            if (players.contains(entry.player().definition().id())) continue;
            List<LineupEntry> entriesParam = entries.subList(i + 1, entries.size());
            Map<Player, Integer[]> playersMapParam = new HashMap<>(playersMap);
            Set<String> positionsParam = new HashSet<>(positions);
            Set<String> playersParam = new HashSet<>(players);
            playersMapParam.put(entry.player(), entry.location());
            positionsParam.add(Arrays.toString(entry.location()));
            playersParam.add(entry.player().definition().id());
            Map<Player, Integer[]> newPlayersMap = playersOf(entriesParam, playersMapParam, positionsParam, playersParam, maxPlayers);
            if (newPlayersMap != null) return newPlayersMap;
        }
        return null;
    }

    private static List<LineupEntry> entries(Lineup lineup, List<Player> players) {
        List<LineupEntry> entries = new ArrayList<>();
        for (int i = 0; i < lineup.distribution().length; i++) {
            for (int j = 0; j < lineup.distribution()[i].length; j++) {
                Position position = lineup.distribution()[i][j];
                if (position == null) continue;
                for (Player player : players) {
                    entries.add(new LineupEntry(new Integer[]{i, j}, position, player, scoreOfMatch(player, position)));
                }
            }
        }
        entries.sort((o1, o2) -> Double.compare(o2.overall(), o1.overall()));
        return entries;
    }

    private static double fix(double energy) {
        if (energy >= 0.75) return energy;
        return Math.pow(energy, 2);
    }

    private record LineupEntry(Integer[] location, Position position, Player player, double overall) {}
}
