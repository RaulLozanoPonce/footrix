package algorithms;

import java.util.Random;

public class NormalDistribution {

    public static void main(String[] args) {
        Random random = new Random();
        int i = 0;
        while (i < 100) {
            double mean = 5.7;
            double stdDev = 0.6;
            double valor = mean + stdDev * random.nextGaussian();
            System.out.println(valor);
            i++;
        }
    }
}
