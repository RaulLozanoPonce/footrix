package rlp.footrix.framework.ai;

import rlp.footrix.framework.types.entities.player.Player;

import java.time.Instant;

public interface PlayerGenerator {
    Player generate(Instant now);
}
