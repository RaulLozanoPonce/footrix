package rlp.footrix.framework.var;

import java.time.Instant;

public class TeamResult implements Revision {
    private final Instant date;
    private String competitionId;   //TODO MEJORAR Y AÑADIR FASE, GRUPO Y SEASON
    private String teamId;
    private int points;
    private int goalsFor;
    private int goalsAgainst;

    public TeamResult(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public String competitionId() {
        return competitionId;
    }

    public TeamResult competitionId(String competitionId) {
        this.competitionId = competitionId;
        return this;
    }

    public String teamId() {
        return teamId;
    }

    public TeamResult teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public int points() {
        return points;
    }

    public TeamResult points(int points) {
        this.points = points;
        return this;
    }

    public int goalsFor() {
        return goalsFor;
    }

    public TeamResult goalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
        return this;
    }

    public int goalsAgainst() {
        return goalsAgainst;
    }

    public TeamResult goalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
        return this;
    }
}
