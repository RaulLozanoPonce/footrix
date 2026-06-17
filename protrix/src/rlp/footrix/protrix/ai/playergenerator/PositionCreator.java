package rlp.footrix.protrix.ai.playergenerator;

import rlp.footrix.framework.types.entities.Country;
import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.ai.playergenerator.country.EnglandCreator;
import rlp.footrix.protrix.ai.playergenerator.country.ItalyCreator;
import rlp.footrix.protrix.ai.playergenerator.country.SpainCreator;
import rlp.footrix.protrix.types.Countries;
import rlp.footrix.protrix.types.ProtrixPlayer;
import rlp.footrix.protrix.types.player.ProtrixSkills;

import java.time.Instant;
import java.util.*;

import static rlp.footrix.framework.utils.TimeHelper.Scale.Day;
import static rlp.footrix.framework.utils.TimeHelper.Scale.Year;
import static rlp.footrix.framework.utils.TimeHelper.nextInstant;
import static rlp.footrix.framework.utils.TimeHelper.previousInstant;
import static rlp.footrix.protrix.helper.InjuryHelper.randomInjuryResistance;

public abstract class PositionCreator {
    private final static Map<Integer, Double> probabilities = new HashMap<>();

    static {
        probabilities.put(16, 0.05);
        probabilities.put(17, 0.15);
        probabilities.put(18, 0.35);
        probabilities.put(19, 0.45);
    }

    protected final double mean;
    protected final double std;

    public PositionCreator(double mean, double std) {
        this.mean = mean;
        this.std = std;
    }

    public ProtrixPlayer generate(Instant now) {
        PlayerDefinition definition = definition(now);
        ProtrixPlayer player = new ProtrixPlayer(definition, position(), new ArrayList<>());
        ProtrixSkills skills = new ProtrixSkills(player, attack(), defense(), balance(), stamina(), topSpeed(), acceleration(),
                response(), agility(), dribbleAccuracy(), dribbleSpeed(), shortPassAccuracy(), shortPassSpeed(), longPassAccuracy(),
                longPassSpeed(), shotAccuracy(), shotPower(), shotTechnique(), freeKickAccuracy(), swerve(), heading(),
                jump(), technique(), aggression(), mentality(), goalKeeping(), teamWork());
        player.skills(skills);
        return player;
    }

    private PlayerDefinition definition(Instant now) {
        String id = UUID.randomUUID().toString();
        Country country = country();
        CountryCreator countryCreator = countryCreator(country);
        String name = countryCreator.playerName();
        Instant birth = birth(now);
        int height = countryCreator.height(positionHeight());
        int weight = weight(height);
        PlayerDefinition.Foot foot = foot();
        PlayerDefinition.InjuryResistance injuryResistance = randomInjuryResistance();
        return new PlayerDefinition() {
            @Override
            public String id() {
                return id;
            }

            @Override
            public String name() {
                return name;
            }

            @Override
            public Instant birth() {
                return birth;
            }

            @Override
            public String country() {
                return country.id();
            }

            @Override
            public int height() {
                return height;
            }

            @Override
            public int weight() {
                return weight;
            }

            @Override
            public Foot foot() {
                return foot;
            }

            @Override
            public InjuryResistance injuryResistance() {
                return injuryResistance;
            }
        };
    }

    private Country country() {
        List<Country> countries = Countries.values();
        return countries.get(Math.min((int) (Math.random() * countries.size()), countries.size() - 1));
    }

    private CountryCreator countryCreator(Country country) {
        if (country.equals(Countries.SPAIN)) return new SpainCreator();
        if (country.equals(Countries.ENGLAND)) return new EnglandCreator();
        if (country.equals(Countries.ITALY)) return new ItalyCreator();

        if (country.equals(Countries.FRANCE)) return new SpainCreator();
        if (country.equals(Countries.GERMANY)) return new EnglandCreator();
        if (country.equals(Countries.PORTUGAL)) return new SpainCreator();
        if (country.equals(Countries.NETHERLANDS)) return new EnglandCreator(); //GERMANY
        if (country.equals(Countries.BELGIUM)) return new SpainCreator();   //FRANCE
        if (country.equals(Countries.CROATIA)) return new EnglandCreator(); //GERMANY
        if (country.equals(Countries.ARGENTINA)) return new SpainCreator();
        if (country.equals(Countries.MOROCCO)) return new SpainCreator(); //FRANCE
        if (country.equals(Countries.USA)) return new EnglandCreator();
        if (country.equals(Countries.JAPAN)) return new EnglandCreator();   //CROATIA

        return new SpainCreator();
    }

    private Instant birth(Instant now) {
        return nextInstant(previousInstant(now, Year, age() + 1), Day, (int) (Math.random() * 365));
    }

    private int weight(int height) {
        Random random = new Random();
        double imcMin = 20.0;
        double imcMax = 25.0;
        double imc = imcMin + (imcMax - imcMin) * random.nextDouble();
        double heightMeters = height / 100.0;
        double peso = imc * Math.pow(heightMeters, 2);
        return (int) Math.round(peso);
    }

    private PlayerDefinition.Foot foot() {
        return (Math.random() < 0.2) ? PlayerDefinition.Foot.L : PlayerDefinition.Foot.R;
    }

    private int age() {
        double random = Math.random();
        double accumulated = 0.0;
        for (Integer age : probabilities.keySet()) {
            accumulated += probabilities.get(age);
            if (random < accumulated) return age;
        }
        return 16;
    }

    protected double nextSkewNormal(double mean, double std, double skew) {
        Random random = new Random();
        double u0 = random.nextGaussian();
        double v = random.nextGaussian();
        double u1 = skew * u0 + v * Math.sqrt(1 - skew * skew);
        double sign = (u1 >= 0) ? 1 : -1;
        return mean + std * u0 * sign;
    }

    protected abstract Position position();
    protected abstract double attack();
    protected abstract double defense();
    protected abstract double balance();
    protected abstract double stamina();
    protected abstract double topSpeed();
    protected abstract double acceleration();
    protected abstract double response();
    protected abstract double agility();
    protected abstract double dribbleAccuracy();
    protected abstract double dribbleSpeed();
    protected abstract double shortPassAccuracy();
    protected abstract double shortPassSpeed();
    protected abstract double longPassAccuracy();
    protected abstract double longPassSpeed();
    protected abstract double shotAccuracy();
    protected abstract double shotPower();
    protected abstract double shotTechnique();
    protected abstract double freeKickAccuracy();
    protected abstract double swerve();
    protected abstract double heading();
    protected abstract double jump();
    protected abstract double technique();
    protected abstract double aggression();
    protected abstract double mentality();
    protected abstract double goalKeeping();
    protected abstract double teamWork();
    protected abstract double meanFactor();
    protected abstract double stdFactor();
    protected abstract double positionHeight();
}
