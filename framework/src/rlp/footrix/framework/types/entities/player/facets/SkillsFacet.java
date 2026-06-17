package rlp.footrix.framework.types.entities.player.facets;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;

import java.time.Instant;

public interface SkillsFacet {
    Player player();
    double overall(Position position);
    void naturalProgress(Instant now);
    void trainingProgress(double score);
    double stamina();
}
