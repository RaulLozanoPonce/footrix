package rlp.footrix.protrix.box;

import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.events.types.PlayedMatchEvent;
import rlp.footrix.protrix.PlayerDayRegisterSubscriber;
import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.Var;
import rlp.footrix.protrix.model.ProtrixGraph;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

public class ProtrixBox extends AbstractBox {
	private ProtrixApplication application;
    private Map<String, Double> initialCaches;
    private ProtrixGraph graph;

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
        registerSubscribers();

        //TODO QUITAR
        application.eventHub().subscribe(NewDayEvent.class, new PlayerDayRegisterSubscriber(application, this));
	}

    private void registerSubscribers() {
        application.eventHub().subscribe(PlayedMatchEvent.class, new PlayerMatchSubscriber(application, this));
        application.eventHub().subscribe(NewDayEvent.class, new NewDaySubscriber(application, this));
    }

    public void afterStart() {
        this.initialCaches = application.entityStore().players().stream().collect(Collectors.toMap(p -> p.definition().id(), p -> p.cache().absoluteCache()));
		//application.setDate(Instant.parse("2025-08-02T00:00:00Z"));
        application.setDate(Instant.parse("2025-07-01T00:00:00Z"));
        //application.setDate(Instant.parse("2025-03-01T00:00:00Z"));

        System.out.println("Finish");

        Var.showMetrics(application);
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