package rlp.footrix.framework.types.entities.player;

public class Position {
    protected final String id;

    protected Position(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public static Position of(String id) {
        return new Position(id);
    }
}
