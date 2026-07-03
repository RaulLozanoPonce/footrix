package rlp.footrix.protrix.ai.matchsimulator.types;

import rlp.footrix.framework.types.entities.match.MatchEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.pes6.types.Pes6Player;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardEventSimulator extends EventSimulator {
    private static final double BaseCardChance = 0.053;

    public CardEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<MatchEvent> simulate(int minute) {
        if (Math.random() > BaseCardChance) return new ArrayList<>();
        MatchEvent.Type type = Math.random() < 0.972 ? MatchEvent.Type.YellowCard : MatchEvent.Type.RedCard;
        if (Math.random() < 0.5) {
            String player = pickPlayerForCard(localLineup());
            return eventsOf(player, local(), type, minute);
        } else {
            String player = pickPlayerForCard(visitantLineup());
            return eventsOf(player, visitant(), type, minute);
        }
    }

    private List<MatchEvent> eventsOf(String player, String team, MatchEvent.Type type, int minute) {
        List<MatchEvent> events = new ArrayList<>();
        events.add(new MatchEvent(team, type, minute, player, null, null));
        if (type == MatchEvent.Type.RedCard || hasDoubleYellowCard(player))
            events.add(new MatchEvent(team, MatchEvent.Type.Expulsion, minute, player, null, null));
        return events;
    }

    private boolean hasDoubleYellowCard(String player) {
        return state.events().stream().anyMatch(e -> e.type() == MatchEvent.Type.YellowCard && e.who().equals(player));
    }

    private String pickPlayerForCard(PlayersLineup lineup) {
        double totalWeight = 0.0;
        Map<Player, Double> weights = new HashMap<>();

        for (Player p : lineup.fieldPlayers()) {
            Pes6Player player = (Pes6Player) p;
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
