package rlp.footrix.protrix.model;

import rlp.footrix.protrix.model.*;

public class PlayerMatchRecord  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.lang.String matchId;
	protected java.lang.String teamId;
	protected int number;
	protected java.lang.String playerName;
	protected java.lang.String position;
	protected java.lang.String enters;
	protected java.lang.String exits;
	protected int goals;
	protected int assists;
	protected int yellowCards;
	protected int redCards;
	protected java.lang.String score;
	protected boolean substitute;

	public PlayerMatchRecord(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.lang.String matchId() {
		return matchId;
	}

	public java.lang.String teamId() {
		return teamId;
	}

	public int number() {
		return number;
	}

	public java.lang.String playerName() {
		return playerName;
	}

	public java.lang.String position() {
		return position;
	}

	public java.lang.String enters() {
		return enters;
	}

	public java.lang.String exits() {
		return exits;
	}

	public int goals() {
		return goals;
	}

	public int assists() {
		return assists;
	}

	public int yellowCards() {
		return yellowCards;
	}

	public int redCards() {
		return redCards;
	}

	public java.lang.String score() {
		return score;
	}

	public boolean substitute() {
		return substitute;
	}

	public PlayerMatchRecord matchId(java.lang.String value) {
		this.matchId = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord teamId(java.lang.String value) {
		this.teamId = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord number(int value) {
		this.number = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord playerName(java.lang.String value) {
		this.playerName = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord position(java.lang.String value) {
		this.position = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord enters(java.lang.String value) {
		this.enters = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord exits(java.lang.String value) {
		this.exits = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord goals(int value) {
		this.goals = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord assists(int value) {
		this.assists = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord yellowCards(int value) {
		this.yellowCards = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord redCards(int value) {
		this.redCards = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord score(java.lang.String value) {
		this.score = value;
		return (PlayerMatchRecord) this;
	}

	public PlayerMatchRecord substitute(boolean value) {
		this.substitute = value;
		return (PlayerMatchRecord) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("matchId", new java.util.ArrayList(java.util.Collections.singletonList(this.matchId)));
		map.put("teamId", new java.util.ArrayList(java.util.Collections.singletonList(this.teamId)));
		map.put("number", new java.util.ArrayList(java.util.Collections.singletonList(this.number)));
		map.put("playerName", new java.util.ArrayList(java.util.Collections.singletonList(this.playerName)));
		map.put("position", new java.util.ArrayList(java.util.Collections.singletonList(this.position)));
		map.put("enters", new java.util.ArrayList(java.util.Collections.singletonList(this.enters)));
		map.put("exits", new java.util.ArrayList(java.util.Collections.singletonList(this.exits)));
		map.put("goals", new java.util.ArrayList(java.util.Collections.singletonList(this.goals)));
		map.put("assists", new java.util.ArrayList(java.util.Collections.singletonList(this.assists)));
		map.put("yellowCards", new java.util.ArrayList(java.util.Collections.singletonList(this.yellowCards)));
		map.put("redCards", new java.util.ArrayList(java.util.Collections.singletonList(this.redCards)));
		map.put("score", new java.util.ArrayList(java.util.Collections.singletonList(this.score)));
		map.put("substitute", new java.util.ArrayList(java.util.Collections.singletonList(this.substitute)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("matchId")) this.matchId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("teamId")) this.teamId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("number")) this.number = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playerName")) this.playerName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("position")) this.position = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("enters")) this.enters = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("exits")) this.exits = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("goals")) this.goals = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("assists")) this.assists = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("yellowCards")) this.yellowCards = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("redCards")) this.redCards = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("score")) this.score = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("substitute")) this.substitute = io.intino.magritte.framework.loaders.BooleanLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("matchId")) this.matchId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("teamId")) this.teamId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("number")) this.number = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("playerName")) this.playerName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("position")) this.position = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("enters")) this.enters = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("exits")) this.exits = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("goals")) this.goals = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("assists")) this.assists = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("yellowCards")) this.yellowCards = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("redCards")) this.redCards = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("score")) this.score = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("substitute")) this.substitute = (java.lang.Boolean) values.get(0);
	}

	public rlp.footrix.protrix.model.ProtrixGraph graph() {
		return (rlp.footrix.protrix.model.ProtrixGraph) core$().graph().as(rlp.footrix.protrix.model.ProtrixGraph.class);
	}
}