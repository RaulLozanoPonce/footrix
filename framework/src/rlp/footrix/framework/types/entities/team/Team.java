package rlp.footrix.framework.types.entities.team;

import rlp.footrix.framework.types.entities.definitions.TeamDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.facets.EloFacet;
import rlp.footrix.framework.types.entities.team.facets.FanFacet;
import rlp.footrix.framework.types.entities.team.facets.StadiumFacet;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Team {
    private final TeamDefinition definition;
    private final Map<Player, PlayerContract> players = new HashMap<>();
    private String lineup;
    private Set<String> competitions = new HashSet<>();

    private final EloFacet elo = new EloFacet(this);
    private final FanFacet fans = new FanFacet(this);
    private final StadiumFacet stadium = new StadiumFacet(this);

    public Team(TeamDefinition definition) {
        this.definition = definition;
    }

    public Team init(int eloQuantity, double eloPoints, int nFans, int stadiumCapacity) {
        elo.init(eloQuantity);
        stadium.init(stadiumCapacity);
        fans.init(nFans, eloPoints);
        return this;
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

    public Set<Player> players() {
        return players.keySet();
    }

    public PlayerContract contractOf(String player) {
        return players.entrySet().stream().filter(e -> e.getKey().definition().id().equals(player)).map(Map.Entry::getValue).findFirst().orElse(null);
    }

    public Player player(String id) {
        return players().stream().filter(p -> p.definition().id().equals(id)).findFirst().orElse(null);
    }

    public void setPlayer(Player player, PlayerContract contract) {
        this.players.put(player, contract);
        player.team(this);
        player.contract(contract);
    }

    public Team addCompetition(String competition) {
        competitions.add(competition);
        return this;
    }

    public void resetCompetitions() {
        competitions = new HashSet<>();
    }

    public EloFacet elo() {
        return elo;
    }

    public FanFacet fans() {
        return fans;
    }

    public StadiumFacet stadium() {
        return stadium;
    }
}
