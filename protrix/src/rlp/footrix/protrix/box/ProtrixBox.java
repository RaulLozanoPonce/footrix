package rlp.footrix.protrix.box;

import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.records.PlayerMatchRecord;
import rlp.footrix.protrix.PlayerDayRegisterSubscriber;
import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.Var;
import rlp.footrix.protrix.box.helper.DatamartFeeder;
import rlp.footrix.protrix.model.ProtrixGraph;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static rlp.footrix.framework.types.entities.Match.MatchEvent.Type.*;

public class ProtrixBox extends AbstractBox {
	private ProtrixApplication application;
    private Map<String, Double> initialCaches;
    private ProtrixGraph graph;
    private DatamartFeeder datamartFeeder;

    public ProtrixBox(String[] args) {
		this(new ProtrixConfiguration(args));
	}

	public ProtrixBox(ProtrixConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
        if (o instanceof ProtrixGraph graph) this.graph = graph;
        return this;
	}

	public void beforeStart() {
		ProtrixAppConfiguration config = new ProtrixAppConfiguration();
		application = new ProtrixApplication(config);
		application.start();
        datamartFeeder = new DatamartFeeder(this);
        registerSubscribers();

        //TODO QUITAR
        application.eventHub().subscribe(NewDayEvent.class, new PlayerDayRegisterSubscriber(application, this));
	}

    private void registerSubscribers() {
        application.eventHub().subscribe(PlayedMatchEvent.class, new PlayerMatchSubscriber(application, this));
    }

    public void afterStart() {
        this.initialCaches = application.entityStore().players().stream().collect(Collectors.toMap(p -> p.definition().id(), p -> p.cache().absoluteCache()));
		application.setDate(Instant.parse("2025-08-02T00:00:00Z"));
        //application.setDate(Instant.parse("2025-03-01T00:00:00Z"));
        datamartFeeder.feedMatches();

        System.out.println("Finish");

        Var.showMetrics(application);
	}

    private Map<String, Double> averages() {
        Map<String, Double> averages = new HashMap<>();
        List<Match> matchList = application.entityStore().matches("ESP-1", 0);
        for (Match match : matchList) {
            averages.putIfAbsent(Goal.name(), 0.0);
            averages.putIfAbsent("Assist", 0.0);
            averages.putIfAbsent(Substitution.name(), 0.0);
            averages.putIfAbsent(YellowCard.name(), 0.0);
            averages.putIfAbsent(RedCard.name(), 0.0);
            averages.putIfAbsent(Injury.name(), 0.0);

            averages.put(Goal.name(), averages.get(Goal.name()) + match.events().stream().filter(e -> e.type() == Goal).count() / (double) matchList.size());
            averages.put("Assist", averages.get("Assist") + match.events().stream().filter(e -> e.type() == Goal).filter(e -> e.secondaryWho() != null).count() / (double) matchList.size());
            averages.put(Substitution.name(), averages.get(Substitution.name()) + match.events().stream().filter(e -> e.type() == Substitution).count() / (double) matchList.size());
            averages.put(YellowCard.name(), averages.get(YellowCard.name()) + match.events().stream().filter(e -> e.type() == YellowCard).count() / (double) matchList.size());
            averages.put(RedCard.name(), averages.get(RedCard.name()) + match.events().stream().filter(e -> e.type() == RedCard).count() / (double) matchList.size());
            averages.put(Injury.name(), averages.get(Injury.name()) + match.events().stream().filter(e -> e.type() == Injury).count() / (double) matchList.size());
        }
        return averages;
    }

    public void beforeStop() {

	}

	public void afterStop() {

	}

	protected io.intino.alexandria.ui.services.AuthService authService(java.net.URL authServiceUrl) {
		//TODO add your authService
		return null;
	}

	public ProtrixApplication application() {
		return application;
	}

    public Map<String, Double> initialCaches() {
        return initialCaches;
    }

    public ProtrixGraph graph() {
        return graph;
    }
}