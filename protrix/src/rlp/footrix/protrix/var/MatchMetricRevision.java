package rlp.footrix.protrix.var;

import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.var.Revision;

public abstract class MatchMetricRevision implements Revision {
    private final String key;
    private final Position position;
    private int value = 1;

    public MatchMetricRevision(String key) {
        this.key = key;
        this.position = Position.valueOf(key);
    }

    @Override
    public String key() {
        return key;
    }

    public Position position() {
        return position;
    }

    public int value() {
        return value;
    }

    public MatchMetricRevision sum() {
        this.value++;
        return this;
    }
}