package rlp.footrix.framework.stores;

import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.team.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamRankingHandler {

    private final Map<String, Integer> competitionScores = new HashMap<>();

    public void addCompetition(Competition competition) {
        for (int i = 0; i < competition.definition().phases().size(); i++) {
            this.competitionScores.put(competition.definition().id() + "-" + i, competition.definition().phases().get(i).rankingScore());
        }
    }

    public int newScore(Team team, Team rival, String competition, int result, boolean withPenalties) {
        double deltaScore = importance(competition) * (result(result, withPenalties) - expectedResult(team, rival));
        return team.elo() + (int) Math.round(deltaScore);
    }

    private double importance(String competition) {
        return this.competitionScores.get(competition);
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

    private double expectedResult(Team team, Team rival) {
        return 1 / (Math.pow(10, - (team.elo() - rival.elo())/600.0) + 1.0);
    }
}
