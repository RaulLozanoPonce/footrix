package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;
import rlp.footrix.protrix.box.ui.displays.items.PositionMold;

import java.time.Instant;

public class SuccessfulDribbleRevision implements Revision {

    private final String key;
    private Position position;

    public SuccessfulDribbleRevision() {
        this.key = java.util.UUID.randomUUID().toString();
    }

    @Override
    public String key() {
        return key;
    }

    public Position position() {
        return position;
    }

    public SuccessfulDribbleRevision position(Position position) {
        this.position = position;
        return this;
    }
}
