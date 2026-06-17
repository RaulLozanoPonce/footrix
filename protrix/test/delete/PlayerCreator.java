package delete;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.protrix.ai.playergenerator.position.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {

    public static void main(String[] args) {
        List<Double> overalls = new ArrayList<>();
        double max = 0.0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            Player player = new DlCreator(1.075, 1.1).generate(Instant.now());
            double overall = player.overall();
            System.out.println(overall);
            overalls.add(overall);
            min = Math.min(min, overall);
            max = Math.max(max, overall);
        }
        double mu = overalls.stream().mapToDouble(v -> v).average().getAsDouble();
        System.out.println("Media: " + mu);
        double sigma = Math.sqrt(
                overalls.stream()
                        .mapToDouble(x -> (x - mu) * (x - mu))
                        .average()
                        .orElse(0)
        );
        System.out.println("Sigma: " + sigma);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Dif: " + (max - min));
    }
}
