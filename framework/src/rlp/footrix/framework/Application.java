package rlp.footrix.framework;

import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.events.EventConfiguration;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.MatchMemoryStore;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.var.Var;

import java.time.Instant;
import java.util.function.Function;

public class Application {

    private final Game game;
    private final MatchMemoryStore matchStore;
    private final EventManager eventManager;
    private final TimeManager timeManager;
    private final CompetitionManager competitionManager;
    private final TeamManager teamManager;
    private final PlayerManager playerManager;
    private final RulesManager rulesManager;
    private final StatisticTables statisticTables;  //TODO DESAPARECERÁ
    private final Var var;

    private Function<MatchDefinition, MatchSimulator> matchSimulator;

    public Application(FootrixConfiguration configuration) {
        this.game = new Game().date(configuration.initDate()).season(configuration.initSeason());
        this.matchStore = new MatchMemoryStore();

        this.competitionManager = new CompetitionManager(this.game, configuration.initDatabase().competitions());
        this.teamManager = new TeamManager(configuration.initDatabase().teams());
        this.playerManager = new PlayerManager(configuration.initDatabase().players());

        this.eventManager = new EventManager();
        this.timeManager = new TimeManager(this.game, this.eventManager, this.playerManager);
        this.rulesManager = new RulesManager();

        this.statisticTables = new StatisticTables(this.playerManager, this.matchStore);
        this.var = configuration.var();

        this.eventManager.add(configuration.initEvents());
        this.timeManager.set(configuration.initDate());
    }

    protected void add(String id, TeamRule rule) {
        this.rulesManager.add(id, rule);
    }

    protected void add(Function<MatchDefinition, MatchSimulator> matchSimulator) {
        this.matchSimulator = matchSimulator;
    }

    public void start() {
        this.eventManager.with(eventConfiguration());
    }

    public Instant getDate() {
        return this.timeManager.get();
    }

    public void setDate(Instant to) {
        Instant currentDate = this.timeManager.get();
        while (currentDate.isBefore(to)) {
            currentDate = Instant.ofEpochMilli(currentDate.toEpochMilli() + 24 * 60 * 60 * 1000);
            this.timeManager.update(currentDate);
        }
    }

    public MatchMemoryStore matchStore() {
        return matchStore;
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

    public StatisticTables statisticTables() {
        return statisticTables;
    }

    public Var var() {
        return var;
    }

    private EventConfiguration eventConfiguration() {
        return new EventConfiguration() {
            @Override
            public CompetitionManager competitionManager() {
                return competitionManager;
            }

            @Override
            public RulesManager rulesManager() {
                return rulesManager;
            }

            @Override
            public MatchSimulator matchSimulator(MatchDefinition definition) {
                return matchSimulator.apply(definition);
            }

            @Override
            public EventManager eventManager() {
                return eventManager;
            }

            @Override
            public MatchMemoryStore matchStore() {
                return matchStore;
            }

            @Override
            public TeamManager teamManager() {
                return teamManager;
            }

            @Override
            public PlayerManager playerManager() {
                return playerManager;
            }

            @Override
            public TimeManager timeManager() {
                return timeManager;
            }

            @Override
            public Var var() {
                return var;
            }
        };
    }
}
