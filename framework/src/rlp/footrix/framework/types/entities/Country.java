package rlp.footrix.framework.types.entities;

public abstract class Country {
    private final String id;
    private final String label;

    protected Country(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String id() {
        return id;
    }

    public String label() {
        return label;
    }
}
