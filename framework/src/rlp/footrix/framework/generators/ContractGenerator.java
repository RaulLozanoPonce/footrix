package rlp.footrix.framework.generators;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import java.util.ArrayList;
import java.util.List;

public class ContractGenerator {

    public static PlayerContract expectedContract(Player player, Team team) {
        PlayerContract.Role expectedRole = expectedRole(player, team);
        return new PlayerContract(null, player.economy().expectedSalary(), expectedRole);
    }

    private static PlayerContract.Role expectedRole(Player player, Team team) {
        List<Player> copy = new ArrayList<>(team.players());
        copy.sort((p1, p2) -> Double.compare(p2.overall(), p1.overall()));
        int index = copy.indexOf(player);
        if (index < 6) return PlayerContract.Role.Undisputed;
        if (index < 11) return PlayerContract.Role.Regular;
        if (index < 18) return PlayerContract.Role.Rotation;
        if (index < 22) return PlayerContract.Role.Substitute;
        return PlayerContract.Role.Reserve;
    }
}
