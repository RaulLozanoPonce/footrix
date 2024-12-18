package rlp.footrix.framework.types.definitions;

import rlp.footrix.framework.types.Country;

import java.time.Instant;

public interface PlayerDefinition {
    String id();
    String name();
    Instant birth();
    Country country();
    int height();
    int weight();
    Foot foot();
    InjuryResistance injuryResistance();

    enum Foot {
        R, L
    }

    enum InjuryResistance {
        A, B, C
    }
}
