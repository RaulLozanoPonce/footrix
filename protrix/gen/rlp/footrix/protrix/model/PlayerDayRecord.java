package rlp.footrix.protrix.model;

import rlp.footrix.protrix.model.*;

public class PlayerDayRecord  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.time.Instant ts;
	protected java.lang.String playerId;
	protected java.lang.String teamId;
	protected double energy;
	protected double physical;
	protected double selfConfidence;
	protected double contractSatisfaction;
	protected double gameTimeSatisfaction;
	protected double collectivePerformance;
	protected int minutes;
	protected double stamina;
	protected boolean injured;

	public PlayerDayRecord(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.time.Instant ts() {
		return ts;
	}

	public java.lang.String playerId() {
		return playerId;
	}

	public java.lang.String teamId() {
		return teamId;
	}

	public double energy() {
		return energy;
	}

	public double physical() {
		return physical;
	}

	public double selfConfidence() {
		return selfConfidence;
	}

	public double contractSatisfaction() {
		return contractSatisfaction;
	}

	public double gameTimeSatisfaction() {
		return gameTimeSatisfaction;
	}

	public double collectivePerformance() {
		return collectivePerformance;
	}

	public int minutes() {
		return minutes;
	}

	public double stamina() {
		return stamina;
	}

	public boolean injured() {
		return injured;
	}

	public PlayerDayRecord ts(java.time.Instant value) {
		this.ts = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord playerId(java.lang.String value) {
		this.playerId = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord teamId(java.lang.String value) {
		this.teamId = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord energy(double value) {
		this.energy = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord physical(double value) {
		this.physical = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord selfConfidence(double value) {
		this.selfConfidence = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord contractSatisfaction(double value) {
		this.contractSatisfaction = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord gameTimeSatisfaction(double value) {
		this.gameTimeSatisfaction = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord collectivePerformance(double value) {
		this.collectivePerformance = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord minutes(int value) {
		this.minutes = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord stamina(double value) {
		this.stamina = value;
		return (PlayerDayRecord) this;
	}

	public PlayerDayRecord injured(boolean value) {
		this.injured = value;
		return (PlayerDayRecord) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("ts", new java.util.ArrayList(java.util.Collections.singletonList(this.ts)));
		map.put("playerId", new java.util.ArrayList(java.util.Collections.singletonList(this.playerId)));
		map.put("teamId", new java.util.ArrayList(java.util.Collections.singletonList(this.teamId)));
		map.put("energy", new java.util.ArrayList(java.util.Collections.singletonList(this.energy)));
		map.put("physical", new java.util.ArrayList(java.util.Collections.singletonList(this.physical)));
		map.put("selfConfidence", new java.util.ArrayList(java.util.Collections.singletonList(this.selfConfidence)));
		map.put("contractSatisfaction", new java.util.ArrayList(java.util.Collections.singletonList(this.contractSatisfaction)));
		map.put("gameTimeSatisfaction", new java.util.ArrayList(java.util.Collections.singletonList(this.gameTimeSatisfaction)));
		map.put("collectivePerformance", new java.util.ArrayList(java.util.Collections.singletonList(this.collectivePerformance)));
		map.put("minutes", new java.util.ArrayList(java.util.Collections.singletonList(this.minutes)));
		map.put("stamina", new java.util.ArrayList(java.util.Collections.singletonList(this.stamina)));
		map.put("injured", new java.util.ArrayList(java.util.Collections.singletonList(this.injured)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("ts")) this.ts = io.intino.magritte.framework.loaders.InstantLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playerId")) this.playerId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("teamId")) this.teamId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("energy")) this.energy = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("physical")) this.physical = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("selfConfidence")) this.selfConfidence = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("contractSatisfaction")) this.contractSatisfaction = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("gameTimeSatisfaction")) this.gameTimeSatisfaction = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("collectivePerformance")) this.collectivePerformance = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("minutes")) this.minutes = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("stamina")) this.stamina = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("injured")) this.injured = io.intino.magritte.framework.loaders.BooleanLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("ts")) this.ts = (java.time.Instant) values.get(0);
		else if (name.equalsIgnoreCase("playerId")) this.playerId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("teamId")) this.teamId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("energy")) this.energy = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("physical")) this.physical = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("selfConfidence")) this.selfConfidence = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("contractSatisfaction")) this.contractSatisfaction = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("gameTimeSatisfaction")) this.gameTimeSatisfaction = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("collectivePerformance")) this.collectivePerformance = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("minutes")) this.minutes = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("stamina")) this.stamina = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("injured")) this.injured = (java.lang.Boolean) values.get(0);
	}

	public rlp.footrix.protrix.model.ProtrixGraph graph() {
		return (rlp.footrix.protrix.model.ProtrixGraph) core$().graph().as(rlp.footrix.protrix.model.ProtrixGraph.class);
	}
}