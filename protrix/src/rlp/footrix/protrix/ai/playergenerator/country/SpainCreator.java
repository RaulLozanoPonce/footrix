package rlp.footrix.protrix.ai.playergenerator.country;

import rlp.footrix.pes6.types.Countries;
import rlp.footrix.protrix.ai.playergenerator.CountryCreator;

public class SpainCreator extends CountryCreator {

    public SpainCreator() {
        super(Countries.SPAIN.id());
    }

    @Override
    public String playerName() {
        return name() + " " + surname() + " " + surname();
    }

    @Override
    protected double averageHeight() {
        return -0.95;
    }
}
