package rlp.footrix.framework.types.team;

import rlp.footrix.framework.types.definitions.PlayerDefinition;
import rlp.footrix.framework.types.definitions.TeamDefinition;
import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team_player.PlayerContract;
import rlp.footrix.framework.types.team_player.PlayerRegistration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Team {

    private final TeamDefinition definition;
    private final Set<PlayerDefinition> players = new HashSet<>();
    private final Map<String, PlayerRegistration> registrations = new HashMap<>();
    private String lineup;
    private Set<String> competitions = new HashSet<>();
    private Integer elo = 0;

    public Team(TeamDefinition definition) {
        this.definition = definition;
    }

    public TeamDefinition definition() {
        return definition;
    }

    public String lineup() {
        return lineup;
    }

    public Team lineup(String lineup) {
        this.lineup = lineup;
        return this;
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

    public Integer elo() {
        return elo;
    }

    public Team elo(Integer elo) {
        this.elo = Math.max(0, elo);
        return this;
    }

    public abstract double attack();
    public abstract double midfield();
    public abstract double defense();
}
