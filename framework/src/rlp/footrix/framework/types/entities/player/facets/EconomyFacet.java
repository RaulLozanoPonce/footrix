package rlp.footrix.framework.types.entities.player.facets;

import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import java.time.Instant;

import static java.lang.Math.*;

public class EconomyFacet {
    private final Player player;

    public EconomyFacet(Player player) {
        this.player = player;
    }

    public float expectedSalary() {
        return expectedSalary(player.contract().role());
    }

    public float expectedSalary(PlayerContract.Role role) {
        return (float) (baseSalary() * player.cache().absoluteCache() * role.salaryFactor());
    }

    public float marketValue(Instant now) {
        return (float) (baseMarketValue(now) * player.cache().relativeCache());
    }

    private float baseSalary() {
        //TODO CUAL ES EL SALARIO BASE PARA UN JUGADOR CON X CARACTERISTICAS
        return 0;
    }

    private float baseMarketValue(Instant now) {
        int age = player.definition().age(now);
        double overall = player.overall();
        return (float) (3 * pow(10, -23) * pow(age, 13) * (0.002 * pow(overall, 2) - 0.1488 * overall + 2.8026));
    }
}
