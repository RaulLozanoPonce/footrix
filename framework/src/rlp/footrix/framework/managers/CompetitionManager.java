package rlp.footrix.framework.managers;

import rlp.footrix.framework.Game;
import rlp.footrix.framework.stores.MatchMemoryStore;
import rlp.footrix.framework.types.Competition;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Team;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.GroupDefinition.TeamClassification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompetitionManager {

    private final MatchMemoryStore matchStore;
    private final Game game;
    private final Map<String, Competition> competitions;
    private final Map<String, Map<String, Competition>> lastCompetitions = new HashMap<>();

    public CompetitionManager(MatchMemoryStore matchStore, Game game, List<Competition> competitions) {
        this.matchStore = matchStore;
        this.game = game;
        this.competitions = competitions.stream().collect(Collectors.toMap(c -> c.definition().id(), c -> c));
    }

    public Competition get(String id, String season) {
        if (game.season().equals(season)) return competitions.get(id);
        return lastCompetitions.get(id).get(season);
    }

    public List<TeamClassification> classificationOf(String id, String season, int phaseId, int groupId) {
        Competition competition = get(id, season);
        if (competition == null) return new ArrayList<>();
        Competition.Phase.Group group = competition.phase(phaseId).group(groupId);
        List<Match> matches = matchStore.get(id, season, phaseId, groupId);
        List<TeamClassification> teams = group.teams().stream().map(t -> classificationOf(t, matches)).toList();
        return group.definition().classification(teams);
    }

    private TeamClassification classificationOf(Team team, List<Match> matches) {
        //TODO REFACTORIZAR
        int points = getPoints(team, matches);
        int goalsFor = getGoalsFor(team, matches);
        int goalsAgainst = getGoalsAgainst(team, matches);
        return new TeamClassification(team.definition().id(), team.definition().name(), points, goalsFor, goalsAgainst);
    }

    private int getGoalsFor(Team team, List<Match> matches) {
        int goalsFor = 0;
        goalsFor += matches.stream()
                .filter(m -> m.definition().local().equals(team.definition().id()))
                .mapToInt(Match::localGoals).sum();
        goalsFor += matches.stream()
                .filter(m -> m.definition().visitant().equals(team.definition().id()))
                .mapToInt(Match::visitantGoals).sum();
        return goalsFor;
    }

    private int getGoalsAgainst(Team team, List<Match> matches) {
        int goalsFor = 0;
        goalsFor += matches.stream()
                .filter(m -> m.definition().local().equals(team.definition().id()))
                .mapToInt(Match::visitantGoals).sum();
        goalsFor += matches.stream()
                .filter(m -> m.definition().visitant().equals(team.definition().id()))
                .mapToInt(Match::localGoals).sum();
        return goalsFor;
    }

    private static int getPoints(Team team, List<Match> matches) {
        int points = 0;
        points += matches.stream()
                .filter(m -> m.definition().local().equals(team.definition().id()))
                .mapToInt(Match::localPoints).sum();
        points += matches.stream()
                .filter(m -> m.definition().visitant().equals(team.definition().id()))
                .mapToInt(Match::visitantPoints).sum();
        return points;
    }
}
