package rlp.footrix.framework.types.entities.definitions;

public record MatchDefinition(String local, String visitant, String competition, int season, int phase, int group, String matchDay) {

    public static MatchDefinition of(String matchId) {
        String[] tokens = matchId.split("-");
        return new MatchDefinition(tokens[4], tokens[5], tokens[0], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[6]);
    }

    public String id() {
        return competition + "-" + phase + "-" + group + "-" + season + "-" + local + "-" + visitant + "-" + matchDay;
    }
}
