package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Pensions {
    private Map<Integer, Integer> players = new HashMap<>();
    private final Map<Integer, Double> pensionable = new HashMap<>();
    private final Map<Integer, Double> news = new HashMap<>();
    private final int newPlayers = 275;
    private final int iterations = 100;

    private int jubilations = 0;

    public Pensions() {
        this.players.put(16, 7);
        this.players.put(17, 192);
        this.players.put(18, 112);
        this.players.put(19, 334);
        this.players.put(20, 253);
        this.players.put(21, 270);
        this.players.put(22, 348);
        this.players.put(23, 359);
        this.players.put(24, 365);
        this.players.put(25, 366);
        this.players.put(26, 342);
        this.players.put(27, 336);
        this.players.put(28, 286);
        this.players.put(29, 280);
        this.players.put(30, 277);
        this.players.put(31, 207);
        this.players.put(32, 171);
        this.players.put(33, 134);
        this.players.put(34, 95);
        this.players.put(35, 83);
        this.players.put(36, 58);
        this.players.put(37, 31);
        this.players.put(38, 13);
        this.players.put(39, 28);
        this.players.put(40, 6);
        this.players.put(41, 11);
        this.players.put(42, 2);
        this.players.put(43, 0);
        this.players.put(44, 0);

        this.pensionable.put(31, 0.15);
        this.pensionable.put(32, 0.2);
        this.pensionable.put(33, 0.25);
        this.pensionable.put(34, 0.3);
        this.pensionable.put(35, 0.35);
        this.pensionable.put(36, 0.4);
        this.pensionable.put(37, 0.4);
        this.pensionable.put(38, 0.4);
        this.pensionable.put(39, 0.4);
        this.pensionable.put(40, 0.4);
        this.pensionable.put(41, 0.4);
        this.pensionable.put(42, 0.5);
        this.pensionable.put(43, 0.5);
        this.pensionable.put(44, 1.0);

        this.news.put(16, 0.05);
        this.news.put(17, 0.15);
        this.news.put(18, 0.35);
        this.news.put(19, 0.45);
    }

    public void iterate() {
        printData(0);
        int i = 1;
        while (i <= iterations) {
            iteration();
            printData(i);
            i++;
        }
    }

    private void iteration() {
        jubilations = 0;
        Map<Integer, Integer> newPlayers = new HashMap<>();

        for (Integer age : players.keySet()) {
            if (!pensionable.containsKey(age)) {
                newPlayers.put(age + 1, players.get(age));
            } else {
                int newPlayerNumber = 0;
                for (int i = 0; i < players.get(age); i++) {
                    double random = Math.random();
                    if (random < pensionable.get(age)) {
                        jubilations++;
                    } else {
                        newPlayerNumber++;
                    }
                }
                newPlayers.put(age + 1, newPlayerNumber);
            }
        }

        for (int i = 0; i < this.newPlayers; i++) {
            double accumulate = 0;
            double random = Math.random();
            for (Integer age : news.keySet()) {
                accumulate += news.get(age);
                if (random <= accumulate) {
                    newPlayers.putIfAbsent(age, 0);
                    newPlayers.put(age, newPlayers.get(age) + 1);
                    break;
                }
            }
        }
        this.players = newPlayers;
    }

    private void printData(int iteration) {
        System.out.println("Iteración: " + iteration + " ---------------------------------------");
        System.out.println("Jugadores totales: " + players.values().stream().mapToInt(n -> n).sum());
        System.out.println("Jugadores jubilados: " + jubilations);
        System.out.println("------------------------------------------------------------");
    }

    private void printDistribution() {
        for (int i = 16; i < 50; i++) {
            Integer playerNumber = players.get(i);
            if (playerNumber == null) continue;
            System.out.println(i + ": " + playerNumber);
        }
    }

    public static void main(String[] args) {
        Pensions pensions = new Pensions();
        pensions.iterate();
        pensions.printDistribution();
    }
}
