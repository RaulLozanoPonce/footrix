package rlp.footrix.framework;

import rlp.footrix.framework.ai.ModelCloudAccessor;
import rlp.footrix.framework.calculators.CacheCalculator;
import rlp.footrix.framework.calculators.InjuryCalculator;
import rlp.footrix.framework.calculators.MoodCalculator;
import rlp.footrix.framework.calculators.RetireCalculator;
import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.events.Event;
import rlp.footrix.framework.events.EventHub;
import rlp.footrix.framework.events.subscribers.*;
import rlp.footrix.framework.events.types.*;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.EntityStore;
import rlp.footrix.framework.stores.RecordStore;
import rlp.footrix.framework.stores.TableStore;
import rlp.footrix.framework.events.TaskHub;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Lineup;

import java.time.Instant;
import java.util.List;
import java.util.Map;
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
    private final RetireCalculator retireCalculator;

    public Application(FootrixConfiguration configuration) {
        this.configuration = configuration;

        this.game = new Game().date(configuration.initDate()).initSeason(configuration.initSeason()).seasonProvider(configuration.seasonProvider());
        this.entityStore = configuration.entityStore();
        this.recordStore = configuration.recordStore();
        this.tableStore = configuration.tableStore();
        this.models = configuration.models();

        this.eventHub = new EventHub();
        this.taskHub = new TaskHub(eventHub);

        this.timeManager = new TimeManager(this.game, this.eventHub);
        this.rulesManager = new RulesManager();
        this.competitionManager = new CompetitionManager(this.game, this.entityStore);
        this.teamManager = new TeamManager(this.game, this.entityStore);
        this.playerManager = new PlayerManager(this.game, this.entityStore);
        this.lineupsManager = new LineupsManager();
        this.eloManager = new EloManager();

        this.cacheCalculator = new CacheCalculator(this);
        this.moodCalculator = new MoodCalculator(this);
        this.injuryCalculator = new InjuryCalculator(this);
        this.retireCalculator = new RetireCalculator(this);

        //TODO SOLO CUANDO ESTÉ INICIALIZADO
        this.taskHub.add(configuration.initTasks(this));
        this.tableStore.setup(configuration.initDatabase(this).elos());
        configuration.initDatabase(this).competitions().forEach(c -> {
            this.competitionManager.add(c);
            this.eloManager.addCompetition(c);
        });
        configuration.initDatabase(this).teams().forEach(this.teamManager::add);
        configuration.initDatabase(this).players().forEach(this.playerManager::add);
        this.competitionManager.setupNewSeason();
    }

    protected void add(Lineup lineup) {
        this.lineupsManager.add(lineup);
    }

    protected void add(String id, TeamRule rule) {
        this.rulesManager.add(id, rule);
    }

    public void start() {
        this.eventHub.subscribe(InitGameEvent.class, new InitGameSubscriber(this));
        this.eventHub.subscribe(NewSeasonEvent.class, new NewSeasonSubscriber(this));
        this.eventHub.subscribe(InitPhaseEvent.class, new InitPhaseSubscriber(this));
        this.eventHub.subscribe(NewDayEvent.class, new NewDaySubscriber(this));
        this.eventHub.subscribe(SetPhaseCalendarEvent.class, new SetPhaseCalendarSubscriber(this));
        this.eventHub.subscribe(ScheduledMatchEvent.class, new ScheduledMatchSubscriber(this));
        this.eventHub.subscribe(SimulateMatchEvent.class, new SimulateMatchSubscriber(this));
        this.eventHub.subscribe(PlayMatchEvent.class, new PlayMatchSubscriber(this));
        this.eventHub.subscribe(PlayedMatchEvent.class, new PlayedMatchSubscriber(this));
        this.eventHub.subscribe(TrainEvent.class, new TrainSubscriber(this));
    }

    public Instant getDate() {
        return this.game.date();
    }

    public void setDate(Instant to) {
        this.timeManager.update(to);
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

    public RetireCalculator retireCalculator() {
        return retireCalculator;
    }

    public Map<Instant, List<Event>> newSeasonTasks(boolean isNewGame) {
        return Map.of();    //TODO
    }
}
