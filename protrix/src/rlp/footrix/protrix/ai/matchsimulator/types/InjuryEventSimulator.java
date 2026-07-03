package rlp.footrix.protrix.ai.matchsimulator.types;

import com.google.gson.JsonObject;
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

public class InjuryEventSimulator extends EventSimulator {
    private static final double BaseInjuryChance = 0.01;

    public InjuryEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<MatchEvent> simulate(int minute) {
        if (Math.random() > BaseInjuryChance) return new ArrayList<>();
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("level", level());
        if (Math.random() < 0.5) {
            String player = pickPlayerForInjury(localLineup());
            return List.of(new MatchEvent(local(), MatchEvent.Type.Injury, minute, player, null, metainfo));
        } else {
            String player = pickPlayerForInjury(visitantLineup());
            return List.of(new MatchEvent(visitant(), MatchEvent.Type.Injury, minute, player, null, metainfo));
        }
    }

    private String pickPlayerForInjury(PlayersLineup lineup) {
        Map<Player, Double> weights = new HashMap<>();
        double total = 0.0;

        for (Player p : lineup.fieldPlayers()) {
            Pes6Player player = (Pes6Player) p;
            double weight = (playerValue.injuryProne(player) * 0.6) + ((1 - playerValue.energy(player)) * 0.5) + ((1.0 - playerValue.fitness(player)) * 0.3);
            if (weight < 0.01) weight = 0.01;
            weights.put(p, weight);
            total += weight;
        }

        double r = Math.random() * total;

        for (Map.Entry<Player, Double> e : weights.entrySet()) {
            r -= e.getValue();
            if (r <= 0) {
                return e.getKey().definition().id();
            }
        }

        return lineup.fieldPlayers().get((int) (Math.random() * lineup.fieldPlayers().size())).definition().id();
    }

    private int level() {
        double random = Math.random();
        if (random <= 0.8) return 1;
        if (random <= 0.8 + 0.17) return 2;
        return 3;
    }
}
