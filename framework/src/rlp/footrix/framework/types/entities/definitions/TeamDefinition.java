package rlp.footrix.framework.types.entities.definitions;

public interface TeamDefinition {
    String id();
    String name();
    String country();

    record Simple(String id, String name, String country) implements TeamDefinition {}
}
