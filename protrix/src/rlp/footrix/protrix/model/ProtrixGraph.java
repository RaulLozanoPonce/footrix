package rlp.footrix.protrix.model;

import io.intino.magritte.framework.Graph;

public class ProtrixGraph extends rlp.footrix.protrix.model.AbstractGraph {
    public static final String MatchesStash = "Matches";

	public ProtrixGraph(Graph graph) {
		super(graph);
	}

	public ProtrixGraph(io.intino.magritte.framework.Graph graph, ProtrixGraph wrapper) {
	    super(graph, wrapper);
	}


	public static ProtrixGraph load(io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph().loadLanguage("Protrix", _language()).loadStashes(startingModel).as(ProtrixGraph.class);
	}

	public static ProtrixGraph load(io.intino.magritte.framework.Store store, io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph(store).loadLanguage("Protrix", _language()).loadStashes(startingModel).as(ProtrixGraph.class);
	}

	public static ProtrixGraph load(String... startingModel) {
		return new Graph().loadLanguage("Protrix", _language()).loadStashes(startingModel).as(ProtrixGraph.class);
	}

	public static ProtrixGraph load(io.intino.magritte.framework.Store store, String... startingModel) {
		return new Graph(store).loadLanguage("Protrix", _language()).loadStashes(startingModel).as(ProtrixGraph.class);
	}

    public static ProtrixGraph load(io.intino.magritte.framework.Store store) {
        return new Graph(store).loadLanguage("Protrix", _language()).loadStashes(false, MatchesStash).as(ProtrixGraph.class);
    }

    public PlayerRecord playerRecord(String competitionId, String playerId, PlayerRecord.Type type) {
        return playerRecordList().stream()
                .filter(r -> r.competitionId().equals(competitionId))
                .filter(r -> r.playerId().equals(playerId))
                .filter(r -> r.type() == type)
                .findFirst().orElse(null);
    }
}