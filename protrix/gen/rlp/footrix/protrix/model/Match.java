package rlp.footrix.protrix.model;

import rlp.footrix.protrix.model.*;

public class Match  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.lang.String matchId;
	protected java.lang.String competitionName;
	protected java.time.Instant date;
	protected java.lang.String matchDay;
	protected java.lang.String localName;
	protected java.lang.String visitantName;
	protected java.lang.String localGoals;
	protected java.lang.String visitantGoals;

	public Match(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.lang.String matchId() {
		return matchId;
	}

	public java.lang.String competitionName() {
		return competitionName;
	}

	public java.time.Instant date() {
		return date;
	}

	public java.lang.String matchDay() {
		return matchDay;
	}

	public java.lang.String localName() {
		return localName;
	}

	public java.lang.String visitantName() {
		return visitantName;
	}

	public java.lang.String localGoals() {
		return localGoals;
	}

	public java.lang.String visitantGoals() {
		return visitantGoals;
	}

	public Match matchId(java.lang.String value) {
		this.matchId = value;
		return (Match) this;
	}

	public Match competitionName(java.lang.String value) {
		this.competitionName = value;
		return (Match) this;
	}

	public Match date(java.time.Instant value) {
		this.date = value;
		return (Match) this;
	}

	public Match matchDay(java.lang.String value) {
		this.matchDay = value;
		return (Match) this;
	}

	public Match localName(java.lang.String value) {
		this.localName = value;
		return (Match) this;
	}

	public Match visitantName(java.lang.String value) {
		this.visitantName = value;
		return (Match) this;
	}

	public Match localGoals(java.lang.String value) {
		this.localGoals = value;
		return (Match) this;
	}

	public Match visitantGoals(java.lang.String value) {
		this.visitantGoals = value;
		return (Match) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("matchId", new java.util.ArrayList(java.util.Collections.singletonList(this.matchId)));
		map.put("competitionName", new java.util.ArrayList(java.util.Collections.singletonList(this.competitionName)));
		map.put("date", new java.util.ArrayList(java.util.Collections.singletonList(this.date)));
		map.put("matchDay", new java.util.ArrayList(java.util.Collections.singletonList(this.matchDay)));
		map.put("localName", new java.util.ArrayList(java.util.Collections.singletonList(this.localName)));
		map.put("visitantName", new java.util.ArrayList(java.util.Collections.singletonList(this.visitantName)));
		map.put("localGoals", new java.util.ArrayList(java.util.Collections.singletonList(this.localGoals)));
		map.put("visitantGoals", new java.util.ArrayList(java.util.Collections.singletonList(this.visitantGoals)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("matchId")) this.matchId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("competitionName")) this.competitionName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("date")) this.date = io.intino.magritte.framework.loaders.InstantLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("matchDay")) this.matchDay = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("localName")) this.localName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("visitantName")) this.visitantName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("localGoals")) this.localGoals = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("visitantGoals")) this.visitantGoals = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("matchId")) this.matchId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("competitionName")) this.competitionName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("date")) this.date = (java.time.Instant) values.get(0);
		else if (name.equalsIgnoreCase("matchDay")) this.matchDay = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("localName")) this.localName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("visitantName")) this.visitantName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("localGoals")) this.localGoals = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("visitantGoals")) this.visitantGoals = (java.lang.String) values.get(0);
	}

	public rlp.footrix.protrix.model.ProtrixGraph graph() {
		return (rlp.footrix.protrix.model.ProtrixGraph) core$().graph().as(rlp.footrix.protrix.model.ProtrixGraph.class);
	}
}