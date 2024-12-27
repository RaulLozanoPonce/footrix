package rlp.footrix.framework.types.team_player;

import java.util.HashMap;
import java.util.Map;

public class PlayerRegistration {
    private final PlayerContract contract;
    private final Map<String, Double> playedMinutes = new HashMap<>();
    private final Map<String, Double> possibleMinutes = new HashMap<>();
    private int sanctions = 0;

    public PlayerRegistration(PlayerContract contract) {
        this.contract = contract;
    }

    public PlayerContract contract() {
        return contract;
    }

    public Double percentMinutes(String competition) {
        if (!possibleMinutes.containsKey(competition)) return null;
        if (!playedMinutes.containsKey(competition)) return 0.0;
        return playedMinutes.get(competition) / possibleMinutes.get(competition);
    }

    public void addMinutes(double minutes, double maxMinutes, String competition) {
        possibleMinutes.putIfAbsent(competition, 0.0);
        playedMinutes.putIfAbsent(competition, 0.0);
        possibleMinutes.put(competition, possibleMinutes.get(competition) + maxMinutes);
        playedMinutes.put(competition, playedMinutes.get(competition) + minutes);
    }

    public int sanctions() {
        return sanctions;
    }

    public void addSanction(int deltaSanctions) {
        this.sanctions = Math.max(0, sanctions + deltaSanctions);
    }
}
