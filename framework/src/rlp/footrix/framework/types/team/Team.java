package rlp.footrix.framework.types.team;

import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team_player.PlayerContract;
import rlp.footrix.framework.types.team_player.PlayerRegistration;
import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.framework.types.definitions.TeamDefinition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Team {

    private final TeamDefinition definition;
    private final Set<PlayerDefinition> players = new HashSet<>();
    private final Map<String, PlayerRegistration> registrations = new HashMap<>();
    private final Lineup lineup;
    private Set<String> competitions = new HashSet<>();
    private Integer rankingScore = 0;

    public Team(TeamDefinition definition, Lineup lineup) {
        this.definition = definition;
        this.lineup = lineup;
    }

    public TeamDefinition definition() {
        return definition;
    }

    public Lineup lineup() {
        return lineup;
    }

    public Set<PlayerDefinition> players() {
        return players;
    }

    public PlayerRegistration registrationOf(String player) {
        return registrations.get(player);
    }

    public PlayerContract contractOf(String player) {
        return registrationOf(player).contract();
    }

    public void setPlayer(Player player, PlayerContract contract) {
        players.add(player.definition());
        player.team(definition.id());
        player.role(contract.role());
        registrations.put(player.definition().id(), new PlayerRegistration(contract));
    }

    public Team addCompetition(String competition) {
        competitions.add(competition);
        return this;
    }

    public void resetCompetitions() {
        competitions = new HashSet<>();
    }

    public abstract double attack();
    public abstract double midfield();
    public abstract double defense();

    public Integer rankingScore() {
        return rankingScore;
    }

    public Team rankingScore(Integer rankingScore) {
        this.rankingScore = rankingScore;
        return this;
    }
}
