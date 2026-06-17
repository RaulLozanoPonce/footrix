package rlp.footrix.protrix.ai.playergenerator.country;

import rlp.footrix.protrix.types.Countries;
import rlp.footrix.protrix.ai.playergenerator.CountryCreator;

public class EnglandCreator extends CountryCreator {

    public EnglandCreator() {
        super(Countries.ENGLAND.id());
    }

    @Override
    public String playerName() {
        return name() + " " + surname();
    }

    @Override
    protected double averageHeight() {
        return -0.41;
    }
}
