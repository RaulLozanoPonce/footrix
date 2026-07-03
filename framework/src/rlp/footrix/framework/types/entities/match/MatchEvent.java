package rlp.footrix.framework.types.entities.match;

import com.google.gson.JsonObject;

public record MatchEvent(String team, Type type, int minute, String who, String secondaryWho, JsonObject metaInfo) {

    public enum Type {
        Goal,
        Fail,
        Save,
        RedCard,
        YellowCard,
        Substitution,
        Injury,
        Expulsion,
        Offside
    }
}