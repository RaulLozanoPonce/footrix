package rlp.footrix.protrix.model;

public class Classification extends AbstractClassification {

	public Classification(io.intino.magritte.framework.Node node) {
		super(node);
	}

    public int goalsDifference() {
        return goalsFor - goalsAgainst;
    }

    public int points() {
        return 3 * wonGames + drawGames;
    }
}