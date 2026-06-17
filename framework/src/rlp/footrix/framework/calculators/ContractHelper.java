package rlp.footrix.framework.calculators;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.utils.TimeHelper;

import java.time.Instant;

import static rlp.footrix.framework.utils.TimeHelper.nextInstant;

public class ContractHelper {

    public static PlayerContract youngContractOf(Player player, double eloPosition) {
        player.cache().absoluteCache(eloPosition * initialCacheFactorOf(PlayerContract.Role.Young)); //TODO REVISAR, QUIZÁS ES MUCHO
        return new PlayerContract(years21(player.definition().birth()), player.economy().expectedSalary(), PlayerContract.Role.Young);
    }

    private static double initialCacheFactorOf(PlayerContract.Role role) {
        return switch (role) {
            case Undisputed -> 1;
            case Regular -> 0.8;
            case Rotation -> 0.5;
            case Substitute -> 0.3;
            case Reserve -> 0.15;
            case Young -> 0.05;
        };
    }

    private static Instant years21(Instant date) {
        return nextInstant(date, TimeHelper.Scale.Year, 21);
    }
}
