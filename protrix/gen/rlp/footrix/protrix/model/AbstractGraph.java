package rlp.footrix.protrix.model;

import io.intino.magritte.framework.Graph;

public class AbstractGraph extends io.intino.magritte.framework.GraphWrapper {
	protected io.intino.magritte.framework.Graph graph;
	private java.util.List<rlp.footrix.protrix.model.Match> matchList = new java.util.ArrayList<>();
	private java.util.List<rlp.footrix.protrix.model.Classification> classificationList = new java.util.ArrayList<>();
	private java.util.List<rlp.footrix.protrix.model.PlayerRecord> playerRecordList = new java.util.ArrayList<>();
	private java.util.List<rlp.footrix.protrix.model.PlayerMatchRecord> playerMatchRecordList = new java.util.ArrayList<>();
	private java.util.List<rlp.footrix.protrix.model.PlayerDayRecord> playerDayRecordList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.magritte.framework.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("protrix");
	}

	public AbstractGraph(io.intino.magritte.framework.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("protrix");
		this.matchList = new java.util.ArrayList<>(wrapper.matchList);
		this.classificationList = new java.util.ArrayList<>(wrapper.classificationList);
		this.playerRecordList = new java.util.ArrayList<>(wrapper.playerRecordList);
		this.playerMatchRecordList = new java.util.ArrayList<>(wrapper.playerMatchRecordList);
		this.playerDayRecordList = new java.util.ArrayList<>(wrapper.playerDayRecordList);
	}

	public <T extends io.intino.magritte.framework.GraphWrapper> T a$(Class<T> t) {
		return this.core$().as(t);
	}

    @Override
	public void update() {
		this._index.values().forEach(v -> v.clear());
		graph.rootList().forEach(r -> addNode$(r));
	}

	@Override
	protected void addNode$(io.intino.magritte.framework.Node node) {
		for (io.intino.magritte.framework.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).add(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).add(node);
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		for (io.intino.magritte.framework.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).remove(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).remove(node);
	}

	public java.net.URL resourceAsMessage$(String language, String key) {
		return graph.loadResource(graph.i18n().message(language, key));
	}

	public java.util.List<rlp.footrix.protrix.model.Match> matchList() {
		return matchList;
	}

	public java.util.List<rlp.footrix.protrix.model.Classification> classificationList() {
		return classificationList;
	}

	public java.util.List<rlp.footrix.protrix.model.PlayerRecord> playerRecordList() {
		return playerRecordList;
	}

	public java.util.List<rlp.footrix.protrix.model.PlayerMatchRecord> playerMatchRecordList() {
		return playerMatchRecordList;
	}

	public java.util.List<rlp.footrix.protrix.model.PlayerDayRecord> playerDayRecordList() {
		return playerDayRecordList;
	}

	public java.util.stream.Stream<rlp.footrix.protrix.model.Match> matchList(java.util.function.Predicate<rlp.footrix.protrix.model.Match> filter) {
		return matchList.stream().filter(filter);
	}

	public rlp.footrix.protrix.model.Match match(int index) {
		return matchList.get(index);
	}

	public java.util.stream.Stream<rlp.footrix.protrix.model.Classification> classificationList(java.util.function.Predicate<rlp.footrix.protrix.model.Classification> filter) {
		return classificationList.stream().filter(filter);
	}

	public rlp.footrix.protrix.model.Classification classification(int index) {
		return classificationList.get(index);
	}

	public java.util.stream.Stream<rlp.footrix.protrix.model.PlayerRecord> playerRecordList(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerRecord> filter) {
		return playerRecordList.stream().filter(filter);
	}

	public rlp.footrix.protrix.model.PlayerRecord playerRecord(int index) {
		return playerRecordList.get(index);
	}

	public java.util.stream.Stream<rlp.footrix.protrix.model.PlayerMatchRecord> playerMatchRecordList(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerMatchRecord> filter) {
		return playerMatchRecordList.stream().filter(filter);
	}

	public rlp.footrix.protrix.model.PlayerMatchRecord playerMatchRecord(int index) {
		return playerMatchRecordList.get(index);
	}

	public java.util.stream.Stream<rlp.footrix.protrix.model.PlayerDayRecord> playerDayRecordList(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerDayRecord> filter) {
		return playerDayRecordList.stream().filter(filter);
	}

	public rlp.footrix.protrix.model.PlayerDayRecord playerDayRecord(int index) {
		return playerDayRecordList.get(index);
	}

	public io.intino.magritte.framework.Graph core$() {
		return graph;
	}

	public io.intino.magritte.framework.utils.I18n i18n$() {
		return graph.i18n();
	}

	public Create create() {
		return new Create("Misc", null);
	}

	public Create create(String stash) {
		return new Create(stash, null);
	}

	public Create create(String stash, String name) {
		return new Create(stash, name);
	}

	public Clear clear() {
		return new Clear();
	}

	public class Create {
		private final String stash;
		private final String name;

		public Create(String stash, String name) {
			this.stash = stash;
			this.name = name;
		}

		public rlp.footrix.protrix.model.Match match(java.lang.String matchId, java.lang.String competitionName, java.time.Instant date, java.lang.String matchDay, java.lang.String localName, java.lang.String visitantName, java.lang.String localGoals, java.lang.String visitantGoals) {
			rlp.footrix.protrix.model.Match newElement = AbstractGraph.this.graph.createRoot(rlp.footrix.protrix.model.Match.class, stash, this.name).a$(rlp.footrix.protrix.model.Match.class);
			newElement.core$().set(newElement, "matchId", java.util.Collections.singletonList(matchId));
			newElement.core$().set(newElement, "competitionName", java.util.Collections.singletonList(competitionName));
			newElement.core$().set(newElement, "date", java.util.Collections.singletonList(date));
			newElement.core$().set(newElement, "matchDay", java.util.Collections.singletonList(matchDay));
			newElement.core$().set(newElement, "localName", java.util.Collections.singletonList(localName));
			newElement.core$().set(newElement, "visitantName", java.util.Collections.singletonList(visitantName));
			newElement.core$().set(newElement, "localGoals", java.util.Collections.singletonList(localGoals));
			newElement.core$().set(newElement, "visitantGoals", java.util.Collections.singletonList(visitantGoals));
			return newElement;
		}

		public rlp.footrix.protrix.model.Classification classification(java.lang.String competitionId, int phase, java.lang.String team, java.lang.String teamName, int playedGames, int wonGames, int drawGames, int lostGames, int goalsFor, int goalsAgainst) {
			rlp.footrix.protrix.model.Classification newElement = AbstractGraph.this.graph.createRoot(rlp.footrix.protrix.model.Classification.class, stash, this.name).a$(rlp.footrix.protrix.model.Classification.class);
			newElement.core$().set(newElement, "competitionId", java.util.Collections.singletonList(competitionId));
			newElement.core$().set(newElement, "phase", java.util.Collections.singletonList(phase));
			newElement.core$().set(newElement, "team", java.util.Collections.singletonList(team));
			newElement.core$().set(newElement, "teamName", java.util.Collections.singletonList(teamName));
			newElement.core$().set(newElement, "playedGames", java.util.Collections.singletonList(playedGames));
			newElement.core$().set(newElement, "wonGames", java.util.Collections.singletonList(wonGames));
			newElement.core$().set(newElement, "drawGames", java.util.Collections.singletonList(drawGames));
			newElement.core$().set(newElement, "lostGames", java.util.Collections.singletonList(lostGames));
			newElement.core$().set(newElement, "goalsFor", java.util.Collections.singletonList(goalsFor));
			newElement.core$().set(newElement, "goalsAgainst", java.util.Collections.singletonList(goalsAgainst));
			return newElement;
		}

		public rlp.footrix.protrix.model.PlayerRecord playerRecord(java.lang.String competitionId, java.lang.String teamName, java.lang.String playerId, java.lang.String playerName, rlp.footrix.protrix.model.PlayerRecord.Type type, int amount, int playedMatches, double playedMinutes) {
			rlp.footrix.protrix.model.PlayerRecord newElement = AbstractGraph.this.graph.createRoot(rlp.footrix.protrix.model.PlayerRecord.class, stash, this.name).a$(rlp.footrix.protrix.model.PlayerRecord.class);
			newElement.core$().set(newElement, "competitionId", java.util.Collections.singletonList(competitionId));
			newElement.core$().set(newElement, "teamName", java.util.Collections.singletonList(teamName));
			newElement.core$().set(newElement, "playerId", java.util.Collections.singletonList(playerId));
			newElement.core$().set(newElement, "playerName", java.util.Collections.singletonList(playerName));
			newElement.core$().set(newElement, "type", java.util.Collections.singletonList(type));
			newElement.core$().set(newElement, "amount", java.util.Collections.singletonList(amount));
			newElement.core$().set(newElement, "playedMatches", java.util.Collections.singletonList(playedMatches));
			newElement.core$().set(newElement, "playedMinutes", java.util.Collections.singletonList(playedMinutes));
			return newElement;
		}

		public rlp.footrix.protrix.model.PlayerMatchRecord playerMatchRecord(java.lang.String matchId, java.lang.String teamId, int number, java.lang.String playerName, java.lang.String position, java.lang.String enters, java.lang.String exits, int goals, int assists, int yellowCards, int redCards, java.lang.String score, boolean substitute) {
			rlp.footrix.protrix.model.PlayerMatchRecord newElement = AbstractGraph.this.graph.createRoot(rlp.footrix.protrix.model.PlayerMatchRecord.class, stash, this.name).a$(rlp.footrix.protrix.model.PlayerMatchRecord.class);
			newElement.core$().set(newElement, "matchId", java.util.Collections.singletonList(matchId));
			newElement.core$().set(newElement, "teamId", java.util.Collections.singletonList(teamId));
			newElement.core$().set(newElement, "number", java.util.Collections.singletonList(number));
			newElement.core$().set(newElement, "playerName", java.util.Collections.singletonList(playerName));
			newElement.core$().set(newElement, "position", java.util.Collections.singletonList(position));
			newElement.core$().set(newElement, "enters", java.util.Collections.singletonList(enters));
			newElement.core$().set(newElement, "exits", java.util.Collections.singletonList(exits));
			newElement.core$().set(newElement, "goals", java.util.Collections.singletonList(goals));
			newElement.core$().set(newElement, "assists", java.util.Collections.singletonList(assists));
			newElement.core$().set(newElement, "yellowCards", java.util.Collections.singletonList(yellowCards));
			newElement.core$().set(newElement, "redCards", java.util.Collections.singletonList(redCards));
			newElement.core$().set(newElement, "score", java.util.Collections.singletonList(score));
			newElement.core$().set(newElement, "substitute", java.util.Collections.singletonList(substitute));
			return newElement;
		}

		public rlp.footrix.protrix.model.PlayerDayRecord playerDayRecord(java.time.Instant ts, java.lang.String playerId, java.lang.String teamId, double energy, double physical, double selfConfidence, double contractSatisfaction, double gameTimeSatisfaction, double collectivePerformance, int minutes, double stamina, boolean injured) {
			rlp.footrix.protrix.model.PlayerDayRecord newElement = AbstractGraph.this.graph.createRoot(rlp.footrix.protrix.model.PlayerDayRecord.class, stash, this.name).a$(rlp.footrix.protrix.model.PlayerDayRecord.class);
			newElement.core$().set(newElement, "ts", java.util.Collections.singletonList(ts));
			newElement.core$().set(newElement, "playerId", java.util.Collections.singletonList(playerId));
			newElement.core$().set(newElement, "teamId", java.util.Collections.singletonList(teamId));
			newElement.core$().set(newElement, "energy", java.util.Collections.singletonList(energy));
			newElement.core$().set(newElement, "physical", java.util.Collections.singletonList(physical));
			newElement.core$().set(newElement, "selfConfidence", java.util.Collections.singletonList(selfConfidence));
			newElement.core$().set(newElement, "contractSatisfaction", java.util.Collections.singletonList(contractSatisfaction));
			newElement.core$().set(newElement, "gameTimeSatisfaction", java.util.Collections.singletonList(gameTimeSatisfaction));
			newElement.core$().set(newElement, "collectivePerformance", java.util.Collections.singletonList(collectivePerformance));
			newElement.core$().set(newElement, "minutes", java.util.Collections.singletonList(minutes));
			newElement.core$().set(newElement, "stamina", java.util.Collections.singletonList(stamina));
			newElement.core$().set(newElement, "injured", java.util.Collections.singletonList(injured));
			return newElement;
		}
	}

	public class Clear {
	    public void match(java.util.function.Predicate<rlp.footrix.protrix.model.Match> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.matchList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void classification(java.util.function.Predicate<rlp.footrix.protrix.model.Classification> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.classificationList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void playerRecord(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerRecord> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.playerRecordList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void playerMatchRecord(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerMatchRecord> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.playerMatchRecordList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void playerDayRecord(java.util.function.Predicate<rlp.footrix.protrix.model.PlayerDayRecord> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.playerDayRecordList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("Match", new Indexer(node -> matchList.add(node.as(rlp.footrix.protrix.model.Match.class)), node -> matchList.remove(node.as(rlp.footrix.protrix.model.Match.class)), () -> matchList.clear()));
		map.put("Classification", new Indexer(node -> classificationList.add(node.as(rlp.footrix.protrix.model.Classification.class)), node -> classificationList.remove(node.as(rlp.footrix.protrix.model.Classification.class)), () -> classificationList.clear()));
		map.put("PlayerRecord", new Indexer(node -> playerRecordList.add(node.as(rlp.footrix.protrix.model.PlayerRecord.class)), node -> playerRecordList.remove(node.as(rlp.footrix.protrix.model.PlayerRecord.class)), () -> playerRecordList.clear()));
		map.put("PlayerMatchRecord", new Indexer(node -> playerMatchRecordList.add(node.as(rlp.footrix.protrix.model.PlayerMatchRecord.class)), node -> playerMatchRecordList.remove(node.as(rlp.footrix.protrix.model.PlayerMatchRecord.class)), () -> playerMatchRecordList.clear()));
		map.put("PlayerDayRecord", new Indexer(node -> playerDayRecordList.add(node.as(rlp.footrix.protrix.model.PlayerDayRecord.class)), node -> playerDayRecordList.remove(node.as(rlp.footrix.protrix.model.PlayerDayRecord.class)), () -> playerDayRecordList.clear()));
		return map;
	}

	public static io.intino.magritte.io.model.Stash[] _language() {
		return new io.intino.magritte.io.model.Stash[]{stash()};
	}

	private static io.intino.magritte.io.model.Stash stash() {
		String content = stash0();
		return io.intino.magritte.io.StashDeserializer.stashFrom(java.util.Base64.getDecoder().decode(content));
	}

	private static String stash0() {
		return "gAEAamF2YS51dGlsLkFycmF5TGlz9IYBAWlvLmludGluby5tYWdyaXR0ZS5pby5tb2RlbC5Db25jZXD0AHJscC5mb290cml4LnByb3RyaXgubW9kZWwuTWF0Y+gBAAEAAAEATWF0Y+gBAAEBAAGAAQACQ29uY2Vw9AEAAalybHAuZm9vdHJpeC5wcm90cml4Lm1vZGVsLkNsYXNzaWZpY2F0aW9uAQABAAABAENsYXNzaWZpY2F0aW/uAQABAQABgAEAAkNvbmNlcPQBAAGncmxwLmZvb3RyaXgucHJvdHJpeC5tb2RlbC5QbGF5ZXJSZWNvcmQBAAEAAAEAUGxheWVyUmVjb3LkAQABAQABgAEAAkNvbmNlcPQBAAGscmxwLmZvb3RyaXgucHJvdHJpeC5tb2RlbC5QbGF5ZXJNYXRjaFJlY29yZAEAAQAAAQBQbGF5ZXJNYXRjaFJlY29y5AEAAQEAAYABAAJDb25jZXD0AQABqnJscC5mb290cml4LnByb3RyaXgubW9kZWwuUGxheWVyRGF5UmVjb3JkAQABAAABAFBsYXllckRheVJlY29y5AEAAQEAAYABAAJDb25jZXD0AQABAQCGAQJpby5pbnRpbm8ubWFncml0dGUuaW8ubW9kZWwuQ29uY2VwdCRDb250ZW70AP7///8PAE1hdGPo/v///w8AQ2xhc3NpZmljYXRpb+7+////DwBQbGF5ZXJSZWNvcuT+////DwBQbGF5ZXJNYXRjaFJlY29y5P7///8PAFBsYXllckRheVJlY29y5FByb3Rl7wEAAU1vZGVsLnN0YXPoAQABgA==";
	}

	public static class Indexer {
		Add add;
		Remove remove;
		IndexClear clear;

		public Indexer(Add add, Remove remove, IndexClear clear) {
			this.add = add;
			this.remove = remove;
			this.clear = clear;
		}

		void add(io.intino.magritte.framework.Node node) {
			this.add.add(node);
		}

		void remove(io.intino.magritte.framework.Node node) {
			this.remove.remove(node);
		}

		void clear() {
			this.clear.clear();
		}
	}

	interface Add {
		void add(io.intino.magritte.framework.Node node);
	}

	interface Remove {
		void remove(io.intino.magritte.framework.Node node);
	}

	interface IndexClear {
		void clear();
	}
}