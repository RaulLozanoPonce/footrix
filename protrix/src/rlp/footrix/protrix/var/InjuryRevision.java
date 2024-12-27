package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class InjuryRevision implements Revision {

    private final Instant date;
    private Position position;

    public InjuryRevision(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public Position position() {
        return position;
    }

    public InjuryRevision position(Position position) {
        this.position = position;
        return this;
    }
}
