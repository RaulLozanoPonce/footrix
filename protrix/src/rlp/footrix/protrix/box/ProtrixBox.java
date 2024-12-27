package rlp.footrix.protrix.box;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.PlayerClassification;
import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;
import rlp.footrix.protrix.simulator.ProtrixMatchSimulator;
import rlp.footrix.protrix.var.*;

import java.time.Instant;
import java.util.HashMap;
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
		ProtrixVar var = new ProtrixVar();
		ProtrixAppConfiguration config = new ProtrixAppConfiguration(var);
		application = new ProtrixApplication(config, definition -> new ProtrixMatchSimulator(definition, var));
		application.start();
	}

	public void afterStart() {
			application.setDate(Instant.parse("2025-08-01T00:00:00Z"));
			printDribbles();
			printGoals();
			printPasses();
			printFaults();

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
			for (Integer minute : substitutions.keySet().stream().sorted().toList()) {
				System.out.println(minute + "\t" + substitutions.get(minute));
			}
	}

	private void printDribbles() {
		double successfulDribbles = application.var().revisions(SuccessfulDribbleRevision.class).size() / 380.0;
		double unsuccessfulDribbles = application.var().revisions(UnsuccessfulDribbleRevision.class).size() / 380.0;
		double totalDribbles = successfulDribbles + unsuccessfulDribbles;
		System.out.println("Regates exitosos: " + successfulDribbles + " - Regates fallidos: " + unsuccessfulDribbles + " - Regates totales: " + totalDribbles);
	}

	private void printGoals() {
		double shootOffTarget = application.var().revisions(ShootOffTargetRevision.class).size() / 380.0;
		double shootInTarget = application.var().revisions(ShootInTargetRevision.class).size() / 380.0;
		double goals = application.var().revisions(ScoredGoalRevision.class).size() / 380.0;
		double assistance = application.var().revisions(AssistanceRevision.class).size() / 380.0;
		double totalShoots = shootOffTarget + shootInTarget + goals;
		System.out.println("Tiros fuera: " + shootOffTarget + " - Tiros parados: " + shootInTarget + " - Goles: " + goals + " - Asistencias: " + assistance + " - Tiros totales: " + totalShoots);
	}

	private void printPasses() {
		double successfulPasses = application.var().revisions(SuccessfulPassRevision.class).size() / 380.0;
		double unsuccessfulPasses = application.var().revisions(UnsuccessfulPassRevision.class).size() / 380.0;
		double totalPasses = successfulPasses + unsuccessfulPasses;
		System.out.println("Pases exitosos: " + successfulPasses + " - Pases fallidos: " + unsuccessfulPasses + " - Pases totales: " + totalPasses);
	}

	private void printFaults() {
		double faultCommited = application.var().revisions(FaultCommitedRevision.class).size() / 380.0;
		double yellowCard = application.var().revisions(YellowCardRevision.class).size() / 380.0;
		double yellowExpulsion = application.var().revisions(YellowExpulsionRevision.class).size() / 380.0;
		double redCards = application.var().revisions(RedCardRevision.class).size() / 380.0;
		double injuries = application.var().revisions(InjuryRevision.class).size() / 380.0;
		System.out.println("Faltas cometidas: " + faultCommited + " - Tarjetas amarillas: " + yellowCard + " - Expulsiones por amarilla: " + yellowExpulsion + "- Tarjetas Rojas: " + redCards + " - Lesiones: " + injuries);
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