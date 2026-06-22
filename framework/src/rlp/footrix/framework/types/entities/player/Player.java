package rlp.footrix.framework.types.entities.player;

import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.facets.*;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.framework.types.entities.team_player.PlayerContract;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private final PlayerDefinition definition;
    private Team team;

    private final Map<Position, Double> mainPositions = new HashMap<>();
    protected final Map<Position, Double> otherPositions = new HashMap<>(); //TODO

    private SkillsFacet skillsFacet;
    private PsychophysicsFacet psychophysicsFacet = new PsychophysicsFacet(this);
    private final EconomyFacet economy = new EconomyFacet(this);
    private final CacheFacet cache = new CacheFacet(this);
    private PlayerContract contract;
    private Instant recoveryDate = null;

    private final Map<String, Integer> accumulatedYellowCards = new HashMap<>();
    private final Map<String, Integer> sanctionsMatches = new HashMap<>();

    private boolean decidedToRetire = false;
    private boolean retired = false;

    public Player(PlayerDefinition definition, Position mainPosition, List<Position> secondaryPositions) {
        this.definition = definition;
        secondaryPositions.forEach(p -> this.mainPositions.put(p, 0.0));
        this.mainPositions.put(mainPosition, 1.0);
    }

    public PlayerDefinition definition() {
        return definition;
    }

    public Position mainPosition() {
        return mainPositions.entrySet().stream().reduce((e1, e2) -> {
            if (e1.getValue() > e2.getValue()) return e1;
            return e2;
        }).map(Map.Entry::getKey).orElse(null);
    }

    public void skills(SkillsFacet skills) {
        this.skillsFacet = skills;
    }

    public SkillsFacet skills() {
        return skillsFacet;
    }

    public double overall() {
        return skillsFacet.overall(mainPosition());
    }

    public Set<Position> secondaryPositions() {
        Position mainPosition = mainPosition();
        return mainPositions.keySet().stream().filter(p -> p != mainPosition).collect(Collectors.toSet());
    }

    public PsychophysicsFacet psychophysics() {
        return psychophysicsFacet;
    }

    public EconomyFacet economy() {
        return economy;
    }

    public CacheFacet cache() {
        return cache;
    }

    public Team team() {
        return team;
    }

    public void team(Team team) {
        this.team = team;
    }

    public Integer yellowCards(String competition) {
        return this.accumulatedYellowCards.get(competition);
    }

    public void yellowCards(int deltaYellowCards, String competition) {
        this.accumulatedYellowCards.putIfAbsent(competition, 0);
        this.accumulatedYellowCards.put(competition, Math.max(0, this.accumulatedYellowCards.get(competition) + deltaYellowCards));
    }

    public boolean hasSanction(String competition) {
        return this.sanctionsMatches.containsKey(competition) && this.sanctionsMatches.get(competition) > 0;
    }

    public void sanction(int deltaSanction, String competition) {
        this.sanctionsMatches.putIfAbsent(competition, 0);
        this.sanctionsMatches.put(competition, Math.max(0, this.sanctionsMatches.get(competition) + deltaSanction));
    }

    public Instant recoveryDate() {
        return recoveryDate;
    }

    public boolean isInjured() {
        return recoveryDate != null;
    }

    public void addInjury(Instant recoveryDate) {
        this.recoveryDate = recoveryDate;
    }

    public void recovery() {
        this.recoveryDate = null;
    }

    public PlayerContract contract() {
        return contract;
    }

    public Player contract(PlayerContract contract) {
        this.contract = contract;
        return this;
    }

    public boolean isDecidedToRetire() {
        return decidedToRetire;
    }

    public void decidedToRetire() {
        this.decidedToRetire = true;
    }

    public boolean active() {
        return !retired;
    }

    public void retire() {
        retired = true;
        //TODO QUITAR EL RESTO DE COSAS
    }
}
