package rlp.footrix.protrix.ai.playergenerator.country;

import rlp.footrix.pes6.types.Countries;
import rlp.footrix.protrix.ai.playergenerator.CountryCreator;

public class ItalyCreator extends CountryCreator {

    public ItalyCreator() {
        super(Countries.ITALY.id());
    }

    @Override
    public String playerName() {
        return name() + " " + surname();
    }

    @Override
    protected double averageHeight() {
        return 0.37;
    }
}
