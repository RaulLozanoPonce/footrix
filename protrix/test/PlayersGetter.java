import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.intino.alexandria.Json;
import requests.RequestBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;
import static requests.RequestBuilder.RequestType.GET;

public class PlayersGetter {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./temp/players.tsv");
        if (file.exists()) Files.delete(file.toPath());
        Files.writeString(file.toPath(), header(), CREATE, WRITE, APPEND);
        List<Integer> leagues = leagues();
        for (Integer league : leagues) {
            boolean state1;
            do {
                try {
                    JsonArray teamsJson = Json.fromJson(new RequestBuilder(GET, "https://api.pes6.es/stats/teamsByLeague?league_id=" + league).timeout(3000).call().andGetContent(), JsonArray.class);
                    state1 = true;
                    for (JsonElement team : teamsJson) {
                        boolean state2;
                        do {
                            try {
                                JsonArray playersJson = Json.fromJson(new RequestBuilder(GET, "https://api.pes6.es/stats/playersByTeam?team_id=" + team.getAsJsonObject().get("id").getAsString()).timeout(3000).call().andGetContent(), JsonArray.class);
                                state2 = true;
                                for (JsonElement player : playersJson) {
                                    boolean state3;
                                    do {
                                        try {
                                            JsonObject playerJson = Json.fromJson(new RequestBuilder(GET, "https://api.pes6.es/stats/playerStatsByPlayerId?player_id=" + player.getAsJsonObject().get("id").getAsString()).timeout(3000).call().andGetContent(), JsonObject.class);
                                            state3 = true;
                                            Files.writeString(file.toPath(), lineOf(playerJson), CREATE, WRITE, APPEND);
                                        } catch (Throwable t) {
                                            state3 = false;
                                            Thread.sleep(1000);
                                        }
                                    } while (!state3);
                                }
                            } catch (Throwable t) {
                                state2 = false;
                                Thread.sleep(1000);
                            }
                        } while (!state2);
                    }
                } catch (Throwable t) {
                    state1 = false;
                    Thread.sleep(1000);
                }
            } while (!state1);
        }
    }

    private static List<Integer> leagues() {
        JsonArray leaguesJson = Json.fromJson(new RequestBuilder(GET, "https://api.pes6.es/stats/leagues").timeout(3000).call().andGetContent(), JsonArray.class);
        List<Integer> leagues = new ArrayList<>();
        for (JsonElement league : leaguesJson) {
            leagues.add(league.getAsJsonObject().get("id").getAsInt());
        }
        return leagues;
    }

    private static String lineOf(JsonObject player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.get("name").getAsString()).append("\t");
        sb.append(player.get("age").getAsString()).append("\t");
        sb.append(player.get("height").getAsString()).append("\t");
        sb.append(player.get("weight").getAsString()).append("\t");
        sb.append(player.get("foot").getAsString()).append("\t");
        sb.append(player.get("injury tolerance").getAsString()).append("\t");
        sb.append(player.get("position_prefered_team").getAsString()).append("\t");
        sb.append(player.get("positions").getAsJsonArray()).append("\t");
        sb.append(player.get("fifa_team").getAsString()).append("\t");
        sb.append(player.get("contract_valid_until").getAsString()).append("\t");
        sb.append(player.get("attack").getAsString()).append("\t");
        sb.append(player.get("defence").getAsString()).append("\t");
        sb.append(player.get("balance").getAsString()).append("\t");
        sb.append(player.get("stamina").getAsString()).append("\t");
        sb.append(player.get("speed").getAsString()).append("\t");
        sb.append(player.get("acceleration").getAsString()).append("\t");
        sb.append(player.get("response").getAsString()).append("\t");
        sb.append(player.get("agility").getAsString()).append("\t");
        sb.append(player.get("dribble accuracy").getAsString()).append("\t");
        sb.append(player.get("dribble speed").getAsString()).append("\t");
        sb.append(player.get("short pass accuracy").getAsString()).append("\t");
        sb.append(player.get("short pass speed").getAsString()).append("\t");
        sb.append(player.get("long pass accuracy").getAsString()).append("\t");
        sb.append(player.get("long pass speed").getAsString()).append("\t");
        sb.append(player.get("shot accuracy").getAsString()).append("\t");
        sb.append(player.get("shot power").getAsString()).append("\t");
        sb.append(player.get("shot technique").getAsString()).append("\t");
        sb.append(player.get("free kick accuracy").getAsString()).append("\t");
        sb.append(player.get("swerve").getAsString()).append("\t");
        sb.append(player.get("heading").getAsString()).append("\t");
        sb.append(player.get("jump").getAsString()).append("\t");
        sb.append(player.get("technique").getAsString()).append("\t");
        sb.append(player.get("aggression").getAsString()).append("\t");
        sb.append(player.get("mentality").getAsString()).append("\t");
        sb.append(player.get("gk skills").getAsString()).append("\t");
        sb.append(player.get("team work").getAsString()).append("\n");
        return sb.toString();
    }

    private static String header() {
        return "name\tage\theight\tweight\tfoot\tinjury tolerance\tposition_prefered_team\tpositions\tfifa_team\tcontract_valid_until\tattack\tdefence\tbalance\tstamina\tspeed\tacceleration\tresponse\tagility\tdribble accuracy\tdribble speed\tshort pass accuracy\tshort pass speed\tlong pass accuracy\tlong pass speed\tshot accuracy\tshot power\tshot technique\tfree kick accuracy\tswerve\theading\tjump\ttechnique\taggression\tmentality\tgk skills\tteam work";
    }
}
//body_type":"Normal (170-185)","condition":6,"consistency":5,"contract_valid_until":2025,"dribbling style":3,"drop kick style":1,"face_type":0, foot":"R","free kick style":1"height":179,"imageUrl":"https://cdn.sofifa.net/players/199/823/25_120.png","injury tolerance":"B","national_team":null,"national_team_overall":null,"nationality":"Spain","number_classic":0,"number_national_team":null,"number_team":8,"penalty style":1,"positions":["CM","SM"],"preset_face":1,"side":"L","skin_color":1,"soFifaId":"199823","special abilities":["Dribbling"],"":85,"weak foot accuracy":5,"weak foot frequency":5,"weight":70,"wristband":"N","wristband1":"None"}