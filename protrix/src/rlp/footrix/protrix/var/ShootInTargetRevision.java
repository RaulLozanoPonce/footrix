package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;

import java.time.Instant;

public class ShootInTargetRevision implements Revision {

    private final String key;
    private Position position;

    public ShootInTargetRevision() {
        this.key = java.util.UUID.randomUUID().toString();
    }

    @Override
    public String key() {
        return key;
    }

    public Position position() {
        return position;
    }

    public ShootInTargetRevision position(Position position) {
        this.position = position;
        return this;
    }
}
