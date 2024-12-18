import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Positions {

    public static void main(String[] args) throws IOException {
        File file = new File("./temp/players.tsv");
        Set<String> positions = new HashSet<>();
        for (String line : Files.readAllLines(file.toPath())) {
            String[] tokens = line.split("\t");
            if (tokens.length <= 7) continue;
            String[] subPositions = tokens[7].replace("\"", "").replace("[", "").replace("]", "").split(",");
            positions.addAll(Arrays.stream(subPositions).toList());
        }
        System.out.println(positions);
    }
}
