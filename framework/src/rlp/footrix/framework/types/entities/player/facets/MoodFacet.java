package rlp.footrix.framework.types.entities.player.facets;

import rlp.footrix.framework.generators.ContractGenerator;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MoodFacet {
    private final Player player;
    private double gameTime = 0.5;
    private double individualPerformance = 0.5;
    private double collectivePerformance = 0.5;

    public MoodFacet(Player player) {
        this.player = player;
    }

    public double overall() {
        return 0.2 * contract() + 0.15 * gameTime + 0.35 * individualPerformance + 0.3 * collectivePerformance;
    }

    public double contract() {
        PlayerContract expected = ContractGenerator.expectedContract(player, player.team());
        double salarySatisfaction = min(max((player.contract().salary()/(double) expected.salary())/2.0, 0), 1);
        double roleSatisfaction = min(max(0.5 + player.contract().role().expectedPlayingTime() - expected.role().expectedPlayingTime(), 0), 1);
        double contractMood = 0.6 * salarySatisfaction + 0.4 * roleSatisfaction;
        if (contractMood >= 0.5) return 0.7 * contractMood + 0.4;
        else return 1.3 * contractMood;
    }

    public double gameTime() {
        return gameTime;
    }

    public void gameTime(double delta) {
        this.gameTime = max(0, min(1, this.gameTime + delta));
    }

    public double individualPerformance() {
        return individualPerformance;
    }

    public void individualPerformance(double delta) {
        this.individualPerformance = max(0, min(1, this.individualPerformance + delta));
    }

    public double collectivePerformance() {
        return max(0, min(1, this.collectivePerformance));
    }

    public void collectivePerformance(double delta) {
        this.collectivePerformance = this.collectivePerformance + delta;
    }
}