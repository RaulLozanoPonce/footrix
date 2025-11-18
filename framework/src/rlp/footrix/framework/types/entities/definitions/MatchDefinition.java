package rlp.footrix.framework.types.entities.definitions;

public record MatchDefinition(String local, String visitant, String competition, int season, int phase, int group, String matchDay) {
    public String id() {
        return competition + "-" + phase + "-" + group + "-" + season + "-" + local + "-" + visitant;
    }
}
