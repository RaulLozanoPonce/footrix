package rlp.footrix.framework.managers;

import rlp.footrix.framework.types.entities.Country;

import java.util.HashMap;
import java.util.Map;

public class CountryManager {
    private final Map<String, Country> countries = new HashMap<>();

    public void add(Country country) {
        this.countries.put(country.id(), country);
    }

    public Country get(String id) {
        return this.countries.get(id);
    }
}
