package rlp.footrix.framework.types.entities.team.facets;

import rlp.footrix.framework.types.entities.team.Team;

public class StadiumFacet {

    private final Team team;
    private int capacity;

    public StadiumFacet(Team team) {
        this.team = team;
    }

    public void init(int capacity) {
        this.capacity = capacity;
    }

    public int capacity() {
        return capacity;
    }
}
