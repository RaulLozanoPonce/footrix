package algorithms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class LevenshteinDistance {

    public static String normalize(String text) {
        if (text == null) return "";
        String result = text.toLowerCase();
        result = Normalizer.normalize(result, Normalizer.Form.NFD);
        result = result.replaceAll("\\p{M}+", "");
        result = Normalizer.normalize(result, Normalizer.Form.NFC);
        return result;
    }

    public static int levenshtein(String text1, String text2) {
        text1 = normalize(text1);
        text2 = normalize(text2);

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= text2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                int cost = (text1.charAt(i - 1) == text2.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1
                        ),
                        dp[i - 1][j - 1] + cost
                );
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static String similarWord(List<String> list, String text) {
        if (list == null || list.isEmpty()) return null;

        List<String> best = new ArrayList<>();
        int bestDistance = Integer.MAX_VALUE;

        for (String word : list) {
            int distance = levenshtein(word, text);

            if (distance < 1) continue;

            if (distance < bestDistance) {
                bestDistance = distance;
                best = new ArrayList<>();
            }

            if (distance <= bestDistance) {
                best.add(word);
            }
        }

        return best.get((int) (Math.random() * best.size()));
    }

    public static void main(String[] args) throws IOException {
        String name = "Xabier";
        String surname1 = "Alonso";
        String surname2 = "Olano";
        List<String> names = Files.readAllLines(new File("./temp/names/spain-names.tsv").toPath()).stream().map(l -> l.split("\t")[0]).toList();
        List<String> surnames = Files.readAllLines(new File("./temp/names/spain-surnames.tsv").toPath()).stream().map(l -> l.split("\t")[0]).toList();
        System.out.println(similarWord(names, name) + " " + similarWord(surnames, surname1) + " " + similarWord(surnames, surname2));
    }
}
