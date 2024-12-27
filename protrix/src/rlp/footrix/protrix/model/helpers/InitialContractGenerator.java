package rlp.footrix.protrix.model.helpers;

import rlp.footrix.framework.types.player.Player;
import rlp.footrix.framework.types.team_player.PlayerContract;

import java.time.Instant;
import java.util.*;

public class InitialContractGenerator {

    public static Map<Player, PlayerContract> generate(Map<Player, String> players) {
        Map<Player, PlayerContract> contracts = new HashMap<>();
        List<Player> copy = new ArrayList<>(players.keySet());
        copy.sort((p1, p2) -> Double.compare(p2.relativeCache(), p1.relativeCache()));
        for (int i = 0; i < 6; i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Undisputed, players.get(copy.get(i))));
        for (int i = 6; i < 11; i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Regular, players.get(copy.get(i))));
        for (int i = 11; i < Math.min(18, copy.size()); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Rotation, players.get(copy.get(i))));
        for (int i = 18; i < Math.min(22, copy.size()); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Substitute, players.get(copy.get(i))));
        for (int i = 22; i < copy.size(); i++) contracts.put(copy.get(i), contractOf(copy.get(i), PlayerContract.Role.Reserve, players.get(copy.get(i))));
        return contracts;
    }

    private static PlayerContract contractOf(Player player, PlayerContract.Role role, String year) {
        return new PlayerContract(contractEndDate(year), 0, role);   //TODO
    }

    private static Instant contractEndDate(String year) {
        return Instant.parse(year + "-07-01T00:00:00Z");
    }
}
