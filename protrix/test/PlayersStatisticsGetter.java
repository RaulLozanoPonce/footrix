import com.google.gson.JsonObject;
import io.intino.alexandria.Json;
import requests.HttpEntityWrapper;
import requests.RequestBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;
import static requests.RequestBuilder.RequestType.GET;

public class PlayersStatisticsGetter {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./temp/players_statistics.tsv");
        if (file.exists()) Files.delete(file.toPath());
        Files.writeString(file.toPath(), header(), CREATE, WRITE, APPEND);
        List<String> lines = Files.readAllLines(new File("./temp/players.csv").toPath());
        for (String line : lines) {
            if (line.startsWith(",")) continue;
            String[] tokens = line.split(",");
            boolean state;
            do {
                try {
                    HttpEntityWrapper wrapper = new RequestBuilder(GET, "https://api.pes6.es/stats/playerStatsByPlayerId?player_id=" + idOf(tokens)).timeout(3000).call();
                    JsonObject playerJson = Json.fromJson(wrapper.andGetContent(), JsonObject.class);
                    state = true;
                    Files.writeString(file.toPath(), lineOf(playerJson, tokens[4]), CREATE, WRITE, APPEND);
                } catch (Throwable t) {
                    state = t instanceof NullPointerException;
                    Thread.sleep(1000);
                }
            } while (!state);
        }
    }

    private static String idOf(String[] tokens) {
        return Arrays.stream(tokens).filter(t -> t.startsWith("http")).map(PlayersStatisticsGetter::idOf).findFirst().orElse(null);
    }

    private static String idOf(String url) {
        String[] tokens = url.split("/");
        return tokens[tokens.length - 1];
    }

    private static String lineOf(JsonObject player, String overall) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.get("name").isJsonNull() ? "null" : player.get("name").getAsString()).append("\t");
        sb.append(player.get("age").isJsonNull() ? "null" : player.get("age").getAsString()).append("\t");
        sb.append(player.get("height").isJsonNull() ? "null" : player.get("height").getAsString()).append("\t");
        sb.append(player.get("weight").isJsonNull() ? "null" : player.get("weight").getAsString()).append("\t");
        sb.append(player.get("foot").isJsonNull() ? "null" : player.get("foot").getAsString()).append("\t");
        sb.append(player.get("injury tolerance").isJsonNull() ? "null" : player.get("injury tolerance").getAsString()).append("\t");
        sb.append(player.get("position_prefered_team").isJsonNull() ? "null" : player.get("position_prefered_team").getAsString()).append("\t");
        sb.append(player.get("positions").isJsonNull() ? "null" : player.get("positions").getAsJsonArray()).append("\t");
        sb.append(player.get("fifa_team").isJsonNull() ? "null" : player.get("fifa_team").getAsString()).append("\t");
        sb.append(player.get("contract_valid_until").isJsonNull() ? "null" : player.get("contract_valid_until").getAsString()).append("\t");
        sb.append(player.get("attack").isJsonNull() ? "null" : player.get("attack").getAsString()).append("\t");
        sb.append(player.get("defence").isJsonNull() ? "null" : player.get("defence").getAsString()).append("\t");
        sb.append(player.get("balance").isJsonNull() ? "null" : player.get("balance").getAsString()).append("\t");
        sb.append(player.get("stamina").isJsonNull() ? "null" : player.get("stamina").getAsString()).append("\t");
        sb.append(player.get("speed").isJsonNull() ? "null" : player.get("speed").getAsString()).append("\t");
        sb.append(player.get("acceleration").isJsonNull() ? "null" : player.get("acceleration").getAsString()).append("\t");
        sb.append(player.get("response").isJsonNull() ? "null" : player.get("response").getAsString()).append("\t");
        sb.append(player.get("agility").isJsonNull() ? "null" : player.get("agility").getAsString()).append("\t");
        sb.append(player.get("dribble accuracy").isJsonNull() ? "null" : player.get("dribble accuracy").getAsString()).append("\t");
        sb.append(player.get("dribble speed").isJsonNull() ? "null" : player.get("dribble speed").getAsString()).append("\t");
        sb.append(player.get("short pass accuracy").isJsonNull() ? "null" : player.get("short pass accuracy").getAsString()).append("\t");
        sb.append(player.get("short pass speed").isJsonNull() ? "null" : player.get("short pass speed").getAsString()).append("\t");
        sb.append(player.get("long pass accuracy").isJsonNull() ? "null" : player.get("long pass accuracy").getAsString()).append("\t");
        sb.append(player.get("long pass speed").isJsonNull() ? "null" : player.get("long pass speed").getAsString()).append("\t");
        sb.append(player.get("shot accuracy").isJsonNull() ? "null" : player.get("shot accuracy").getAsString()).append("\t");
        sb.append(player.get("shot power").isJsonNull() ? "null" : player.get("shot power").getAsString()).append("\t");
        sb.append(player.get("shot technique").isJsonNull() ? "null" : player.get("shot technique").getAsString()).append("\t");
        sb.append(player.get("free kick accuracy").isJsonNull() ? "null" : player.get("free kick accuracy").getAsString()).append("\t");
        sb.append(player.get("swerve").isJsonNull() ? "null" : player.get("swerve").getAsString()).append("\t");
        sb.append(player.get("heading").isJsonNull() ? "null" : player.get("heading").getAsString()).append("\t");
        sb.append(player.get("jump").isJsonNull() ? "null" : player.get("jump").getAsString()).append("\t");
        sb.append(player.get("technique").isJsonNull() ? "null" : player.get("technique").getAsString()).append("\t");
        sb.append(player.get("aggression").isJsonNull() ? "null" : player.get("aggression").getAsString()).append("\t");
        sb.append(player.get("mentality").isJsonNull() ? "null" : player.get("mentality").getAsString()).append("\t");
        sb.append(player.get("gk skills").isJsonNull() ? "null" : player.get("gk skills").getAsString()).append("\t");
        sb.append(player.get("team work").isJsonNull() ? "null" : player.get("team work").getAsString()).append("\t");
        sb.append(overall).append("\n");
        return sb.toString();
    }

    private static String header() {
        return "name\tage\theight\tweight\tfoot\tinjury tolerance\tposition_prefered_team\tpositions\tfifa_team\tcontract_valid_until\tattack\tdefence\tbalance\tstamina\tspeed\tacceleration\tresponse\tagility\tdribble accuracy\tdribble speed\tshort pass accuracy\tshort pass speed\tlong pass accuracy\tlong pass speed\tshot accuracy\tshot power\tshot technique\tfree kick accuracy\tswerve\theading\tjump\ttechnique\taggression\tmentality\tgk skills\tteam work\toverall\n";
    }
}