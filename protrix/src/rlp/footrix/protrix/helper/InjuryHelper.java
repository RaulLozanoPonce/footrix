package rlp.footrix.protrix.helper;

import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;

public class InjuryHelper {

    public static PlayerDefinition.InjuryResistance randomInjuryResistance() {
        double random = Math.random();
        if (random < 0.25) return PlayerDefinition.InjuryResistance.A;
        if (random < 0.85) return PlayerDefinition.InjuryResistance.B;
        return PlayerDefinition.InjuryResistance.C;
    }
}
