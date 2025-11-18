package rlp.footrix.framework.managers;

import rlp.footrix.framework.types.entities.definitions.CompetitionDefinition;

import java.util.HashMap;
import java.util.Map;

public class EloManager {
    private final Map<String, Integer> competitionScores = new HashMap<>();

    public void addCompetition(CompetitionDefinition competition) {
        for (int i = 0; i < competition.phases().size(); i++) {
            this.competitionScores.put(competition.id() + "-" + i, competition.phases().get(i).rankingScore());
        }
    }

    public int deltaElo(int teamElo, int rivalElo, String competition, int result, boolean withPenalties) {
        return (int) Math.round(importance(competition) * (result(result, withPenalties) - expectedResult(teamElo, rivalElo)));
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

    private double expectedResult(int teamElo, int rivalElo) {
        return 1 / (Math.pow(10, - (teamElo - rivalElo)/600.0) + 1.0);
    }
}
