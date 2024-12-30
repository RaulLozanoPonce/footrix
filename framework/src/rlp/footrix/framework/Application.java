package rlp.footrix.framework;

import rlp.footrix.framework.configuration.TeamRule;
import rlp.footrix.framework.deprecated.StatisticTables;
import rlp.footrix.framework.events.EventConfiguration;
import rlp.footrix.framework.managers.*;
import rlp.footrix.framework.stores.TeamRankingHandler;
import rlp.footrix.framework.stores.match.MatchMemoryStore;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition;
import rlp.footrix.framework.types.definitions.MatchDefinition;
import rlp.footrix.framework.types.team.Lineup;
import rlp.footrix.framework.utils.TriFunction;
import rlp.footrix.framework.var.VarTerminal;

import java.time.Instant;

public class Application {

    private final Game game;
    private final MatchMemoryStore matchStore;
    private final EventManager eventManager;
    private final TimeManager timeManager;
    private final CompetitionManager competitionManager;
    private final LineupsManager lineupsManager;
    private final TeamManager teamManager;
    private final PlayerManager playerManager;
    private final RulesManager rulesManager;
    private final StatisticTables statisticTables;  //TODO DESAPARECERÁ
    private final TeamRankingHandler teamRankingHandler;

    private TriFunction<MatchDefinition, PhaseDefinition, Instant, MatchSimulator> matchSimulator;

    public Application(FootrixConfiguration configuration) {
        this.game = new Game().date(configuration.initDate()).initSeason(0).seasonProvider(configuration.seasonProvider());
        this.matchStore = new MatchMemoryStore();
        this.teamRankingHandler = new TeamRankingHandler();

        this.competitionManager = new CompetitionManager(this.game, configuration.initDatabase().competitions());
        this.lineupsManager = new LineupsManager();
        this.teamManager = new TeamManager(configuration.initDatabase().teams());
        this.playerManager = new PlayerManager(configuration.initDatabase().players());

        this.eventManager = new EventManager();
        this.timeManager = new TimeManager(this.game, this.eventManager, this.playerManager, configuration.energyRecoveryProvider());
        this.rulesManager = new RulesManager();

        this.statisticTables = new StatisticTables(this.playerManager, this.matchStore);
        VarTerminal.var(configuration.var());

        this.eventManager.add(configuration.initEvents());
        this.timeManager.set(configuration.initDate());
        configuration.initDatabase().competitions().forEach(this.teamRankingHandler::addCompetition);
    }

    protected void add(Lineup lineup) {
        this.lineupsManager.add(lineup);
    }

    protected void add(String id, TeamRule rule) {
        this.rulesManager.add(id, rule);
    }

    protected void add(TriFunction<MatchDefinition, PhaseDefinition, Instant, MatchSimulator> matchSimulator) {
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

    private EventConfiguration eventConfiguration() {
        return new EventConfiguration() {
            @Override
            public Game game() {
                return game;
            }

            @Override
            public CompetitionManager competitionManager() {
                return competitionManager;
            }

            @Override
            public RulesManager rulesManager() {
                return rulesManager;
            }

            @Override
            public MatchSimulator matchSimulator(MatchDefinition definition, Instant date) {
                return matchSimulator.apply(definition, competitionManager.get(definition.competition(), definition.season()).phase(definition.phase()).definition(), date);
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
            public TeamRankingHandler teamRankingHandler() {
                return teamRankingHandler;
            }

            @Override
            public LineupsManager lineupsManager() {
                return lineupsManager;
            }
        };
    }
}
