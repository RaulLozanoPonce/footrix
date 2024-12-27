package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class RedCardRevision implements Revision {

    private final Instant date;
    private Position position;

    public RedCardRevision(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public Position position() {
        return position;
    }

    public RedCardRevision position(Position position) {
        this.position = position;
        return this;
    }
}
