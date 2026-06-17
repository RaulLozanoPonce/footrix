package rlp.footrix.pes6.types;

import rlp.footrix.framework.types.entities.Country;

import java.util.List;

public class Countries {
    public static Country SPAIN = Country.of("SPAIN", "España");
    public static Country ENGLAND = Country.of("ENGLAND", "Inglaterra");
    public static Country FRANCE = Country.of("FRANCE", "Francia");
    public static Country GERMANY = Country.of("GERMANY", "Alemania");
    public static Country PORTUGAL = Country.of("PORTUGAL", "Portugal");
    public static Country NETHERLANDS = Country.of("NETHERLANDS", "Países Bajos");
    public static Country ITALY = Country.of("ITALY", "Italia");
    public static Country BELGIUM = Country.of("BELGIUM", "Bélgica");
    public static Country CROATIA = Country.of("CROATIA", "Croacia");
    public static Country ARGENTINA = Country.of("ARGENTINA", "Argentina");
    public static Country MOROCCO = Country.of("MOROCCO", "Marruecos");
    public static Country USA = Country.of("USA", "EEUU");
    public static Country JAPAN = Country.of("JAPAN", "Japón");

    public static List<Country> values() {
        return List.of(SPAIN, ENGLAND, FRANCE, GERMANY, PORTUGAL, NETHERLANDS, ITALY, BELGIUM, CROATIA, ARGENTINA, MOROCCO, USA, JAPAN);
    }

    public static Country of(String countryId) {
        return values().stream().filter(v -> v.id().equals(countryId)).findFirst().orElse(null);
    }
}
