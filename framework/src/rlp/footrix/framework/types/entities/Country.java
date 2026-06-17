package rlp.footrix.framework.types.entities;

public class Country {
    private final String id;
    private final String label;

    public Country(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String id() {
        return id;
    }

    public String label() {
        return label;
    }

    public static Country of(String id, String label) {
        return new Country(id, label);
    }
}
