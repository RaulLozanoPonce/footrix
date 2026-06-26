package rlp.footrix.protrix.model;

import rlp.footrix.protrix.model.*;

public class PlayerRecord  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.lang.String competitionId;
	protected java.lang.String teamName;
	protected java.lang.String playerId;
	protected java.lang.String playerName;
	protected Type type;

	public enum Type {
		Goal, Assist, ReceivedGoals, YellowCard, RedCard;
	}
	protected int amount;
	protected int playedMatches;
	protected double playedMinutes;

	public PlayerRecord(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.lang.String competitionId() {
		return competitionId;
	}

	public java.lang.String teamName() {
		return teamName;
	}

	public java.lang.String playerId() {
		return playerId;
	}

	public java.lang.String playerName() {
		return playerName;
	}

	public Type type() {
		return type;
	}

	public int amount() {
		return amount;
	}

	public int playedMatches() {
		return playedMatches;
	}

	public double playedMinutes() {
		return playedMinutes;
	}

	public PlayerRecord competitionId(java.lang.String value) {
		this.competitionId = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord teamName(java.lang.String value) {
		this.teamName = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord playerId(java.lang.String value) {
		this.playerId = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord playerName(java.lang.String value) {
		this.playerName = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord type(rlp.footrix.protrix.model.PlayerRecord.Type value) {
		this.type = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord amount(int value) {
		this.amount = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord playedMatches(int value) {
		this.playedMatches = value;
		return (PlayerRecord) this;
	}

	public PlayerRecord playedMinutes(double value) {
		this.playedMinutes = value;
		return (PlayerRecord) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("competitionId", new java.util.ArrayList(java.util.Collections.singletonList(this.competitionId)));
		map.put("teamName", new java.util.ArrayList(java.util.Collections.singletonList(this.teamName)));
		map.put("playerId", new java.util.ArrayList(java.util.Collections.singletonList(this.playerId)));
		map.put("playerName", new java.util.ArrayList(java.util.Collections.singletonList(this.playerName)));
		map.put("type", new java.util.ArrayList(java.util.Collections.singletonList(this.type)));
		map.put("amount", new java.util.ArrayList(java.util.Collections.singletonList(this.amount)));
		map.put("playedMatches", new java.util.ArrayList(java.util.Collections.singletonList(this.playedMatches)));
		map.put("playedMinutes", new java.util.ArrayList(java.util.Collections.singletonList(this.playedMinutes)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("competitionId")) this.competitionId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("teamName")) this.teamName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playerId")) this.playerId = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playerName")) this.playerName = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("type")) this.type = io.intino.magritte.framework.loaders.WordLoader.load(values, Type.class, this).get(0);
		else if (name.equalsIgnoreCase("amount")) this.amount = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playedMatches")) this.playedMatches = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("playedMinutes")) this.playedMinutes = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("competitionId")) this.competitionId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("teamName")) this.teamName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("playerId")) this.playerId = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("playerName")) this.playerName = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("type")) this.type = (Type) values.get(0);
		else if (name.equalsIgnoreCase("amount")) this.amount = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("playedMatches")) this.playedMatches = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("playedMinutes")) this.playedMinutes = (java.lang.Double) values.get(0);
	}

	public rlp.footrix.protrix.model.ProtrixGraph graph() {
		return (rlp.footrix.protrix.model.ProtrixGraph) core$().graph().as(rlp.footrix.protrix.model.ProtrixGraph.class);
	}
}