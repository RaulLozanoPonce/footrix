package rlp.footrix.framework.types.entities.definitions;

import rlp.footrix.framework.utils.TimeHelper;

import java.time.Instant;

public interface PlayerDefinition {
    String id();
    String name();
    Instant birth();
    String country();
    int height();
    int weight();
    Foot foot();
    InjuryResistance injuryResistance();

    default int age(Instant now) {
        return (int) TimeHelper.getInstantDiff(now, birth(), TimeHelper.Scale.Year);
    }

    enum Foot {
        R, L
    }

    enum InjuryResistance {
        A, B, C
    }
}
