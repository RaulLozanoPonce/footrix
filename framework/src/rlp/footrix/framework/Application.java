package rlp.footrix.framework;

import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.calculators.CacheCalculator;
import rlp.footrix.framework.calculators.MoodCalculator;
import rlp.footrix.framework.calculators.InjuryCalculator;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.events.EventHub;
import rlp.footrix.framework.events.subscribers.InitPhaseSubscriber;
import rlp.footrix.framework.events.subscribers.NewDaySubscriber;
import rlp.footrix.framework.events.subscribers.SetPhaseCalendarSubscriber;
import rlp.footrix.framework.events.subscribers.SimulateMatchSubscriber;
import rlp.footrix.framework.events.types.InitPhaseEvent;
import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.events.types.SetPhaseCalendarEvent;
import rlp.footrix.framework.events.types.SimulateMatchEvent;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.stores.RecordStore;
import rlp.footrix.framework.stores.TableStore;
import rlp.footrix.framework.tasks.TaskHub;
import rlp.footrix.framework.types.entities.Country;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Lineup;

import java.time.Instant;
import java.util.function.Function;

public class Application {
    private final FootrixConfiguration configuration;
    private final Game game;
    private final EntityStore entityStore;
    private final RecordStore recordStore;
    private final TableStore tableStore;
    private final EventHub eventHub;
    private final TaskHub taskHub;
    private final TimeManager timeManager;
    private final CountryManager countryManager;
    private final CompetitionManager competitionManager;
    private final LineupsManager lineupsManager;
    private final TeamManager teamManager;
    private final PlayerManager playerManager;
    private final RulesManager rulesManager;
    private final EloManager eloManager;
    private final ModelCloudAccessor models;
    private final CacheCalculator cacheCalculator;
    private final MoodCalculator moodCalculator;
    private final InjuryCalculator injuryCalculator;

    public Application(FootrixConfiguration configuration) {
        this.configuration = configuration;

        this.game = new Game().date(configuration.initDate()).seasonProvider(configuration.seasonProvider());
        this.entityStore = configuration.entityStore();
        this.recordStore = configuration.recordStore();
        this.tableStore = configuration.tableStore();
        this.models = configuration.models();

        this.eventHub = new EventHub();
        this.taskHub = new TaskHub();

        this.timeManager = new TimeManager(this.game, this.eventHub);
        this.rulesManager = new RulesManager();
        this.countryManager = new CountryManager();
        this.competitionManager = new CompetitionManager(this.game, this.entityStore);
        this.teamManager = new TeamManager(this.game, this.entityStore);
        this.playerManager = new PlayerManager(this.game, this.entityStore);
        this.lineupsManager = new LineupsManager();
        this.eloManager = new EloManager();

        this.cacheCalculator = new CacheCalculator(this);
        this.moodCalculator = new MoodCalculator(this);
        this.injuryCalculator = new InjuryCalculator(this);

        //TODO SOLO CUANDO ESTÉ INICIALIZADO
        this.taskHub.add(configuration.initTasks(this));
        this.tableStore.setup(configuration.initDatabase(this).elos());
        configuration.initDatabase(this).competitions().forEach(c -> {
            this.competitionManager.setup(c);
            this.eloManager.addCompetition(c);
        });
        configuration.initDatabase(this).teams().forEach(this.teamManager::add);
        configuration.initDatabase(this).players().forEach(this.playerManager::add);
        this.competitionManager.setupNewSeason();
    }

    protected void add(Country country) {
        this.countryManager.add(country);
    }

    protected void add(Lineup lineup) {
        this.lineupsManager.add(lineup);
    }

    protected void add(String id, TeamRule rule) {
        this.rulesManager.add(id, rule);
    }

    public void start() {
        this.eventHub.subscribe(InitPhaseEvent.class, new InitPhaseSubscriber(this));
        this.eventHub.subscribe(NewDayEvent.class, new NewDaySubscriber(this));
        this.eventHub.subscribe(SetPhaseCalendarEvent.class, new SetPhaseCalendarSubscriber(this));
        this.eventHub.subscribe(SimulateMatchEvent.class, new SimulateMatchSubscriber(this));
    }

    public Instant getDate() {
        return this.game.date();
    }

    public void setDate(Instant to) {
        this.timeManager.update(to);
    }

    public CountryManager countryManager() {
        return countryManager;
    }

    public PlayerManager playerManager() {
        return playerManager;
    }

    public TeamManager teamManager() {
        return teamManager;
    }

    public CompetitionManager competitionManager() {
        return competitionManager;
    }

    public Game game() {
        return game;
    }

    public RulesManager rulesManager() {
        return rulesManager;
    }

    public TaskHub taskHub() {
        return taskHub;
    }

    public EventHub eventHub() {
        return eventHub;
    }

    public ModelCloudAccessor models() {
        return models;
    }

    public LineupsManager lineupsManager() {
        return lineupsManager;
    }

    public TimeManager timeManager() {
        return timeManager;
    }

    public EloManager eloManager() {
        return eloManager;
    }

    public EntityStore entityStore() {
        return entityStore;
    }

    public RecordStore recordStore() {
        return recordStore;
    }

    public TableStore tableStore() {
        return tableStore;
    }

    public Function<Player, Double> energyRecoveryProvider() {
        return configuration.energyRecoveryProvider();
    }

    public double averageMatchPlayer() {
        return configuration.averageMatchPlayer();
    }

    public CacheCalculator cacheCalculator() {
        return cacheCalculator;
    }

    public MoodCalculator moodCalculator() {
        return moodCalculator;
    }

    public InjuryCalculator injuryCalculator() {
        return injuryCalculator;
    }
}
