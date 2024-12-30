package rlp.footrix.framework.types.team;

import rlp.footrix.framework.types.player.Position;

public class Lineup {

    private final String name;
    private final Position[][] distribution;

    public Lineup(String name, Position[][] distribution) {
        this.name = name;
        this.distribution = distribution;
    }

    public String name() {
        return name;
    }

    public Position[][] distribution() {
        return distribution;
    }

    public Position positionOf(Integer[] position) {
        return distribution[position[0]][position[1]];
    }
}
