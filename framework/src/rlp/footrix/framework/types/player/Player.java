package rlp.footrix.framework.types.player;

import rlp.footrix.framework.types.team_player.PlayerContract;
import rlp.footrix.framework.types.definitions.PlayerDefinition;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Player {

    private final PlayerDefinition definition;
    private final Map<Position, Double> mainPositions = new HashMap<>();
    protected final Map<Position, Double> otherPositions = new HashMap<>();
    private double energy = 1.0;
    private final Mood mood = new Mood();
    private double absoluteCache = 0.5;
    private String team;
    private PlayerContract.Role role;
    private final Map<String, Integer> yellowCards = new HashMap<>();
    private final Map<String, Integer> sanctions = new HashMap<>();
    private Instant recoveryDate = null;

    protected Player(PlayerDefinition definition, Position mainPosition, List<Position> secondaryPositions) {
        this.definition = definition;
        secondaryPositions.forEach(p -> this.mainPositions.put(p, 0.0));
        this.mainPositions.put(mainPosition, 1.0);
    }

    public PlayerDefinition definition() {
        return definition;
    }

    public Position mainPosition() {
        return mainPositions.entrySet().stream().reduce((e1, e2) -> {
            if (e1.getValue() > e2.getValue()) return e1;
            return e2;
        }).map(Map.Entry::getKey).orElse(null);
    }

    public Set<Position> secondaryPositions() {
        Position mainPosition = mainPosition();
        return mainPositions.keySet().stream().filter(p -> p != mainPosition).collect(Collectors.toSet());
    }

    public Player energy(double deltaEnergy) {
        this.energy = Math.max(0, Math.min(1, energy + deltaEnergy));
        return this;
    }

    public double energy() {
        return energy;
    }

    public Mood mood() {
        return mood;
    }

    public double relativeCache() {
        return relativeCache(mainPosition());
    }

    public double relativeCache(Position position) {
        double overall = overall(position);
        return Math.max(0, Math.min(1, ((overall - 40) / (85 - 40)) * absoluteCache));
    }

    public String team() {
        return team;
    }

    public void team(String team) {
        this.team = team;
    }

    public PlayerContract.Role role() {
        return role;
    }

    public void role(PlayerContract.Role role) {
        this.role = role;
    }

    public Integer yellowCards(String competition) {
        return this.yellowCards.get(competition);
    }

    public void yellowCards(int deltaYellowCards, String competition) {
        this.yellowCards.putIfAbsent(competition, 0);
        this.yellowCards.put(competition, this.yellowCards.get(competition) + deltaYellowCards);
    }

    public boolean hasSanction(String competition) {
        return this.sanctions.containsKey(competition) && this.sanctions.get(competition) > 0;
    }

    public void sanction(int deltaSanction, String competition) {
        this.sanctions.putIfAbsent(competition, 0);
        this.sanctions.put(competition, Math.max(0, this.sanctions.get(competition) + deltaSanction));
    }

    public Instant recoveryDate() {
        return recoveryDate;
    }

    public boolean isInjured() {
        return recoveryDate != null;
    }

    public void addInjury(Instant recoveryDate) {
        this.recoveryDate = recoveryDate;
    }

    public void recovery() {
        this.recoveryDate = null;
    }

    public double overall() {
        return overall(mainPosition());
    }

    public abstract double overall(Position position);

    public static class Mood {
        private double contract = 0.5;
        private double gameTime = 0.5;
        private double individualPerformance = 0.5;
        private double collectivePerformance = 0.5;

        public double overall() {
            //return 0.2 * contract + 0.15 * gameTime + 0.35 * individualPerformance + 0.3 * collectivePerformance;
            return 0.5;
        }

        public double contract() {
            return contract;
        }

        public void contract(double delta) {
            this.contract = Math.max(0, Math.min(1, this.contract + delta));
        }

        public double gameTime() {
            return gameTime;
        }

        public void gameTime(double delta) {
            this.gameTime = Math.max(0, Math.min(1, this.gameTime + delta));
        }

        public double individualPerformance() {
            return individualPerformance;
        }

        public void individualPerformance(double delta) {
            this.individualPerformance = Math.max(0, Math.min(1, this.individualPerformance + delta));
        }

        public double collectivePerformance() {
            return collectivePerformance;
        }

        public void collectivePerformance(double delta) {
            this.collectivePerformance = Math.max(0, Math.min(1, this.collectivePerformance + delta));
        }
    }
}
