package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class UnsuccessfulDribbleRevision implements Revision {

    private final String key;
    private Position position;

    public UnsuccessfulDribbleRevision() {
        this.key = java.util.UUID.randomUUID().toString();
    }

    @Override
    public String key() {
        return key;
    }

    public Position position() {
        return position;
    }

    public UnsuccessfulDribbleRevision position(Position position) {
        this.position = position;
        return this;
    }
}
