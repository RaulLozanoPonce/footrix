package rlp.footrix.framework.types.tables;

public class TeamElo {
    private final String team;
    private int elo;

    public TeamElo(String team, int elo) {
        this.team = team;
        this.elo = elo;
    }

    public String team() {
        return team;
    }

    public int elo() {
        return elo;
    }

    public TeamElo elo(int elo) {
        this.elo = elo;
        return this;
    }
}
