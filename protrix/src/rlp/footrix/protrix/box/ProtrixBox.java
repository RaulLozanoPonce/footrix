package rlp.footrix.protrix.box;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.PlayerClassification;
import rlp.footrix.framework.types.definitions.CompetitionDefinition;
import rlp.footrix.framework.types.definitions.CompetitionDefinition.PhaseDefinition.GroupDefinition.TeamClassification;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.Statistics;
import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.simulator.ProtrixMatchSimulator;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtrixBox extends AbstractBox {

	private ProtrixApplication application;

	public ProtrixBox(String[] args) {
		this(new ProtrixConfiguration(args));
	}

	public ProtrixBox(ProtrixConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	public void beforeStart() {
		application = new ProtrixApplication(new ProtrixAppConfiguration(), ProtrixMatchSimulator::new);
		application.start();
	}

	public void afterStart() {
		if (configuration.debug().equals("true")) {
			application.setDate(Instant.parse("2025-08-01T00:00:00Z"));
			System.out.println(Statistics.toText());
			System.out.println("-----------------------------------------------------------------------------------------");
			for (CompetitionDefinition.PhaseDefinition.GroupDefinition.TeamClassification classification : application.competitionManager().classificationOf("ESP-1", "season1", 0, 0)) {
				System.out.println(classification.teamName() + "\t" + classification.points() + "\t" + classification.goalsFor() + "\t" + classification.goalsAgainst());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : application.statisticTables().scorersOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + classification.score());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : application.statisticTables().assistantsOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + classification.score());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : application.statisticTables().bestGoalkeepersOf("ESP-1", "season1", 10)) {
				System.out.println(classification.name() + " - " + (classification.score() * 90));
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			for (PlayerClassification classification : application.statisticTables().bestPlayer("season1", 10)) {
				System.out.println(classification.id() + " - " + classification.name() + " - " + classification.score());
			}
			Map<Integer, Integer> substitutions = new HashMap<>();
			application.matchStore().get("ESP-1", "season1", 0, 0)
					.forEach(m -> m.events().stream().filter(e -> e.type() == Match.MatchEvent.Type.SubstituteIn).forEach(e -> {
						substitutions.putIfAbsent(e.minute(), 0);
						substitutions.put(e.minute(), substitutions.get(e.minute()) + 1);
					}));
			/*for (Integer minute : substitutions.keySet().stream().sorted().toList()) {
				System.out.println(minute + "\t" + substitutions.get(minute));
			}*/
		}
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
}