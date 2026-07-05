package rlp.footrix.framework.types.entities.team.facets;

import rlp.footrix.framework.types.entities.team.Team;

public class EloFacet {
    private final Team team;

    private int quantity = 0;

    public EloFacet(Team team) {
        this.team = team;
    }

    public void init(int quantity) {
        this.quantity = quantity;
    }

    public int quantity() {
        return quantity;
    }

    public void adjust(int quantity) {
        this.quantity = quantity;
    }
}
