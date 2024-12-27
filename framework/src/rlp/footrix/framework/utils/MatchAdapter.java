package rlp.footrix.framework.utils;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.definitions.MatchDefinition;

import java.io.IOException;

public class MatchAdapter extends TypeAdapter<Match> {

    @Override
    public void write(JsonWriter writer, Match match) throws IOException {
        JsonObject json = new JsonObject();
        json.add("definition", write(match.definition()));
        //match.add("localStatistics", write(match.definition()));
        //match.add("visitantStatistics", write(match.definition()));
    }

    private JsonObject write(MatchDefinition definition) {
        JsonObject json = new JsonObject();
        json.addProperty("date", definition.date().toString());
        json.addProperty("local", definition.local());
        json.addProperty("visitant", definition.visitant());
        json.addProperty("competition", definition.competition());
        json.addProperty("season", definition.season());
        json.addProperty("phase", definition.phase());
        json.addProperty("group", definition.group());
        json.addProperty("matchDay", definition.matchDay());
        return json;
    }

    @Override
    public Match read(JsonReader reader) throws IOException {
        return null;
    }
}
