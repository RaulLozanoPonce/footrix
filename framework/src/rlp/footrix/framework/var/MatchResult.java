package rlp.footrix.framework.var;

public class MatchResult implements Revision {
    private final String key;
    private final String competition;
    private final String phase;
    private final String group;
    private final String matchDay;
    private final String season;
    private final String local;
    private final String visitant;
    private int localGoals;
    private int visitantGoals;

    public MatchResult(String key) {
        this.key = key;
        String[] tokens = key.split(";");
        this.competition = tokens[0];
        this.phase = tokens[1];
        this.group = tokens[2];
        this.matchDay = tokens[3];
        this.season = tokens[4];
        this.local = tokens[5];
        this.visitant = tokens[6];
    }

    @Override
    public String key() {
        return key;
    }

    public String competition() {
        return competition;
    }

    public String phase() {
        return phase;
    }

    public String group() {
        return group;
    }

    public String matchDay() {
        return matchDay;
    }

    public String season() {
        return season;
    }

    public String local() {
        return local;
    }

    public String visitant() {
        return visitant;
    }

    public int localGoals() {
        return localGoals;
    }

    public MatchResult localGoals(int localGoals) {
        this.localGoals = localGoals;
        return this;
    }

    public int visitantGoals() {
        return visitantGoals;
    }

    public MatchResult visitantGoals(int visitantGoals) {
        this.visitantGoals = visitantGoals;
        return this;
    }
}
