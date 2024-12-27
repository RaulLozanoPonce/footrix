package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class ShootInTargetRevision implements Revision {

    private final Instant date;
    private Position position;

    public ShootInTargetRevision(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public Position position() {
        return position;
    }

    public ShootInTargetRevision position(Position position) {
        this.position = position;
        return this;
    }
}
