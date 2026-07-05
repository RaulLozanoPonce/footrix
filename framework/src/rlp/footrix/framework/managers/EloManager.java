package rlp.footrix.framework.managers;

import rlp.footrix.framework.Application;

public class EloManager {
    private final Application application;

    public EloManager(Application application) {
        this.application = application;
    }

    public double percentElo(String team) {
        int teamElo = application.teamManager().get(team).elo().quantity();
        int maxElo = maxElo();
        if (maxElo == 0) return 0.0;
        return teamElo / (double) maxElo;
    }

    public int maxElo() {
        return application.teamManager().teams().stream().mapToInt(t -> t.elo().quantity()).max().orElse(0);
    }

    public int deltaElo(int teamElo, int rivalElo, String competition, int phase, int result, boolean withPenalties) {
        return (int) Math.round(importance(competition, phase) * (result(result, withPenalties) - expectedResult(teamElo, rivalElo)));
    }

    public double importance(String competition, int phase) {
        return application.competitionManager().get(competition).phase(phase).definition().rankingScore();
    }

    private double result(int result, boolean withPenalties) {
        if (withPenalties) {
            if (result == 0) return 0.5;
            else return 0.75;
        } else {
            if (result == 0) return 0;
            else if (result == 1) return 0.5;
            else return 1;
        }
    }

    private double expectedResult(int teamElo, int rivalElo) {
        return 1 / (Math.pow(10, - (teamElo - rivalElo)/600.0) + 1.0);
    }
}
