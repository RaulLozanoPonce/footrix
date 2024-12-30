package rlp.footrix.framework.types.definitions;

import rlp.footrix.framework.types.Country;

public interface TeamDefinition {
    String id();
    String name();
    Country country();

    record Simple(String id, String name, Country country) implements TeamDefinition {}
}
