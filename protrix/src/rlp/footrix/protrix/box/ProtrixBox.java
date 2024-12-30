package rlp.footrix.protrix.box;

import rlp.footrix.framework.deprecated.PlayerClassification;
import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.player.Position;
import rlp.footrix.framework.types.team.Team;
import rlp.footrix.framework.var.VarTerminal;
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
		ProtrixAppConfiguration config = new ProtrixAppConfiguration();
		application = new ProtrixApplication(config, ProtrixMatchSimulator::new);
		application.start();
	}

	public void afterStart() {
			application.setDate(Instant.parse("2025-08-01T00:00:00Z"));
			printDribbles();
			printGoals();
			printPasses();
			printFaults();
			printFaultsByPosition();

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
			/*Map<Integer, Integer> substitutions = new HashMap<>();
			application.matchStore().get("ESP-1", "season1", 0, 0)
					.forEach(m -> m.events().stream().filter(e -> e.type() == Match.MatchEvent.Type.Substitution).forEach(e -> {
						substitutions.putIfAbsent(e.minute(), 0);
						substitutions.put(e.minute(), substitutions.get(e.minute()) + 1);
					}));
			for (Integer minute : substitutions.keySet().stream().sorted().toList()) {
				System.out.println(minute + "\t" + substitutions.get(minute));
			}*/
			System.out.println("-----------------------------------------------------------------------------------------");
			for (Team team : application.teamManager().teams()) {
				System.out.println(team.definition().name() + "\t" + team.elo());
			}
	}

	private void printDribbles() {
		double successfulDribbles = VarTerminal.revisions(SuccessfulDribbleRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double unsuccessfulDribbles = VarTerminal.revisions(UnsuccessfulDribbleRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double totalDribbles = successfulDribbles + unsuccessfulDribbles;
		System.out.println("Regates exitosos: " + successfulDribbles + " - Regates fallidos: " + unsuccessfulDribbles + " - Regates totales: " + totalDribbles);
	}

	private void printGoals() {
		double shootOffTarget = VarTerminal.revisions(ShootOffTargetRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double shootInTarget = VarTerminal.revisions(ShootInTargetRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double goals = VarTerminal.revisions(ScoredGoalRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double assistance = VarTerminal.revisions(AssistanceRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double totalShoots = shootOffTarget + shootInTarget + goals;
		System.out.println("Tiros fuera: " + shootOffTarget + " - Tiros parados: " + shootInTarget + " - Goles: " + goals + " - Asistencias: " + assistance + " - Tiros totales: " + totalShoots);
	}

	private void printPasses() {
		double successfulPasses = VarTerminal.revisions(SuccessfulPassRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double unsuccessfulPasses = VarTerminal.revisions(UnsuccessfulPassRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double totalPasses = successfulPasses + unsuccessfulPasses;
		System.out.println("Pases exitosos: " + successfulPasses + " - Pases fallidos: " + unsuccessfulPasses + " - Pases totales: " + totalPasses);
	}

	private void printFaults() {
		double faultCommited = VarTerminal.revisions(FaultCommitedRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double yellowCard = VarTerminal.revisions(YellowCardRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double yellowExpulsion = VarTerminal.revisions(YellowExpulsionRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double redCards = VarTerminal.revisions(RedCardRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		double injuries = VarTerminal.revisions(InjuryRevision.class).stream().mapToInt(MatchMetricRevision::value).sum() / 380.0;
		System.out.println("Faltas cometidas: " + faultCommited + " - Tarjetas amarillas: " + yellowCard + " - Expulsiones por amarilla: " + yellowExpulsion + "- Tarjetas Rojas: " + redCards + " - Lesiones: " + injuries);
	}

	private void printFaultsByPosition() {
		for (Position position : Position.values()) {
			System.out.print(position.name() + ": " + VarTerminal.revisions(FaultCommitedRevision.class).stream().filter(e -> e.position() == position).mapToInt(MatchMetricRevision::value).sum()/380.0 + " - ");
		}
		System.out.println("\n");
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