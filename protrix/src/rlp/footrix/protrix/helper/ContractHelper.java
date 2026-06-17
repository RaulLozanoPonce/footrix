package rlp.footrix.protrix.helper;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;
import rlp.footrix.framework.utils.TimeHelper;

import java.time.Instant;
import java.util.*;

import static rlp.footrix.framework.utils.TimeHelper.nextInstant;

public class ContractHelper {

    public static Map<Player, PlayerContract> generate(Map<Player, String> players, double eloPosition) {
        Map<Player, PlayerContract> contracts = new HashMap<>();
        List<Player> copy = new ArrayList<>(players.keySet());
        copy.sort((p1, p2) -> Double.compare(p2.overall(), p1.overall()));
        for (int i = 0; i < 6; i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Undisputed, players.get(copy.get(i)), eloPosition));
        for (int i = 6; i < 11; i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Regular, players.get(copy.get(i)), eloPosition));
        for (int i = 11; i < Math.min(18, copy.size()); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Rotation, players.get(copy.get(i)), eloPosition));
        for (int i = 18; i < Math.min(22, copy.size()); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Substitute, players.get(copy.get(i)), eloPosition));
        for (int i = 22; i < copy.size(); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Reserve, players.get(copy.get(i)), eloPosition));
        return contracts;
    }

    private static PlayerContract contractOf(Player player, PlayerContract.Role role, String year, double eloPosition) {
        //player.cache().absoluteCache(0.5);
        player.cache().absoluteCache(eloPosition * initialCacheFactorOf(role)); //TODO REVISAR, QUIZÁS ES MUCHO
        return new PlayerContract(contractEndDate(year), player.economy().expectedSalary(), role);
    }



    //TODO QUITAR. ESTA EN EL FRAMEWORK
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

    private static Instant contractEndDate(String year) {
        return Instant.parse(year + "-07-01T00:00:00Z");
    }


}
