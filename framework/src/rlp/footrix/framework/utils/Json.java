package rlp.footrix.framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rlp.footrix.framework.types.Match;

public class Json {

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson().fromJson(json, clazz);
    }

    public static <T> String toJson(T object) {
        return gson().toJson(object);
    }

    private static Gson gson() {
        return new GsonBuilder().setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(Match.class, new MatchAdapter())
                .create();
    }
}
