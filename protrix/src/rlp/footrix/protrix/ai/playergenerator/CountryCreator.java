package rlp.footrix.protrix.ai.playergenerator;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

public abstract class CountryCreator {
    private final String country;

    protected CountryCreator(String country) {
        this.country = country;
    }

    protected String name() {
        try {
            double random = Math.random();
            double accumulated = 0.0;
            for (String line : Files.readAllLines(new File("./temp/names/" + country + "-names.tsv").toPath())) {
                String[] components = line.split("\t");
                accumulated += Double.parseDouble(components[1]);
                if (random <= accumulated) return components[0].replace("-", " ");
            }
            return "-";
        } catch (Throwable t) {
            return "-";
        }
    }

    protected String surname() {
        try {
            double random = Math.random();
            double accumulated = 0.0;
            for (String line : Files.readAllLines(new File("./temp/names/" + country + "-surnames.tsv").toPath())) {
                String[] components = line.split("\t");
                accumulated += Double.parseDouble(components[1]);
                if (random <= accumulated) return components[0];
            }
            return "-";
        } catch (Throwable t) {
            return "-";
        }
    }

    public int height(double positionHeight) {
        Random random = new Random();
        double std = random.nextGaussian() * 3;
        return (int) Math.round(181.65 + positionHeight + averageHeight() + std);
    }

    public abstract String playerName();
    protected abstract double averageHeight();
}
