package rlp.footrix.protrix.simulator.types;

import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.MatchState;
import rlp.footrix.protrix.simulator.weights.PlayerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardEventSimulator extends EventSimulator {
    private static final double BaseCardChance = 0.03;

    public CardEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<Match.MatchEvent> simulate(int minute) {
        if (Math.random() > BaseCardChance) return new ArrayList<>();
        Match.MatchEvent.Type type = Math.random() < 0.85 ? Match.MatchEvent.Type.YellowCard : Match.MatchEvent.Type.RedCard;
        if (Math.random() < 0.5) {
            String player = pickPlayerForCard(localLineup());
            return List.of(new Match.MatchEvent(local(), type, minute, player, null, null));
        } else {
            String player = pickPlayerForCard(visitantLineup());
            return List.of(new Match.MatchEvent(visitant(), type, minute, player, null, null));
        }
    }

    private String pickPlayerForCard(PlayersLineup lineup) {
        double totalWeight = 0.0;
        Map<Player, Double> weights = new HashMap<>();

        for (Player p : lineup.fieldPlayers()) {
            ProtrixPlayer player = (ProtrixPlayer) p;
            double weight = (playerValue.agression(player) * 0.5) + ((1 - playerValue.defense(player, lineup.positionOf(player.definition().id()))) * 0.3) + ((1.0 - playerValue.discipline(player)) * 0.7);
            if (weight < 0.01) weight = 0.01;
            weights.put(p, weight);
            totalWeight += weight;
        }

        double r = Math.random() * totalWeight;

        for (Map.Entry<Player, Double> entry : weights.entrySet()) {
            r -= entry.getValue();
            if (r <= 0) {
                return entry.getKey().definition().id();
            }
        }

        return lineup.fieldPlayers().get((int) (Math.random() * lineup.fieldPlayers().size())).definition().id();
    }
}
