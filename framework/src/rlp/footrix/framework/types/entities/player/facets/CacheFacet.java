package rlp.footrix.framework.types.entities.player.facets;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;

public class CacheFacet {
    private final Player player;
    private double absoluteCache;

    public CacheFacet(Player player) {
        this.player = player;
    }

    public double absoluteCache() {
        return absoluteCache;
    }

    public CacheFacet absoluteCache(double deltaAbsoluteCache) {
        this.absoluteCache = Math.min(1, Math.max(0, this.absoluteCache + deltaAbsoluteCache));
        return this;
    }

    public double relativeCache() {
        return relativeCache(player.mainPosition());
    }

    public double relativeCache(Position position) {
        double overall = player.overall(position);
        return Math.max(0, Math.min(1, ((overall - 40) / (99 - 40)) * absoluteCache));
    }
}
