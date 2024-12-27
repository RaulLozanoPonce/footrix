package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class YellowCardRevision implements Revision {

    private final Instant date;
    private Position position;

    public YellowCardRevision(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public Position position() {
        return position;
    }

    public YellowCardRevision position(Position position) {
        this.position = position;
        return this;
    }
}
