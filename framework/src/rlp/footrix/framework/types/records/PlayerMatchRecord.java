package rlp.footrix.framework.types.records;

public class PlayerMatchRecord {
    private final String player;
    private final String team;
    private final String competition;
    private final int season;
    private int playedMinutes = 0;
    private int maxMinutes = 0;
    private double totalScore = 0.0;

    public PlayerMatchRecord(String player, String team, String competition, int season) {
        this.player = player;
        this.team = team;
        this.competition = competition;
        this.season = season;
    }

    public String player() {
        return player;
    }

    public String team() {
        return team;
    }

    public String competition() {
        return competition;
    }

    public int season() {
        return season;
    }

    public int playedMinutes() {
        return playedMinutes;
    }

    public PlayerMatchRecord playedMinutes(int playedMinutes) {
        this.playedMinutes = playedMinutes;
        return this;
    }

    public int maxMinutes() {
        return maxMinutes;
    }

    public PlayerMatchRecord maxMinutes(int maxMinutes) {
        this.maxMinutes = maxMinutes;
        return this;
    }

    public double totalScore() {
        return totalScore;
    }

    public PlayerMatchRecord totalScore(double totalScore) {
        this.totalScore = totalScore;
        return this;
    }

    public double meanScore() {
        if (playedMinutes() == 0) return 0.0;
        return totalScore() / playedMinutes();
    }
}
