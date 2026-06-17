import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PlayerName {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            System.out.println(name() + " " + surname() + " " + surname());
        }
    }

    private static String name() throws IOException {
        double random = Math.random();
        double accumulated = 0.0;
        for (String line : Files.readAllLines(new File("./temp/names/spain-names.tsv").toPath())) {
            String[] components = line.split("\t");
            accumulated += Double.parseDouble(components[1]);
            if (random <= accumulated) return components[0].replace("-", " ");
        }
        return "-";
    }

    private static String surname() throws IOException {
        double random = Math.random();
        double accumulated = 0.0;
        for (String line : Files.readAllLines(new File("./temp/names/spain-surnames.tsv").toPath())) {
            String[] components = line.split("\t");
            accumulated += Double.parseDouble(components[1]);
            if (random <= accumulated) return components[0];
        }
        return "-";
    }
}
