package rlp.footrix.framework.helpers;

import rlp.footrix.framework.types.Player;
import rlp.footrix.framework.types.PlayerContract;

public class AbsoluteCacheGenerator {

    public static double initial(Player player, PlayerContract contract) {
        return factorOf(contract) / (100.0 - player.overall());
    }

    private static double factorOf(PlayerContract contract) {
        return switch (contract.role()) {
            case Undisputed -> 1;
            case Regular -> 0.8;
            case Rotation -> 0.5;
            case Substitute -> 0.3;
            case Reserve -> 0.15;
            case Young -> 0.05;
        };
    }
}
