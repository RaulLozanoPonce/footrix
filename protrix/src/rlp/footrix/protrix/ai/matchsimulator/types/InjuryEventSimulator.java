package rlp.footrix.protrix.ai.matchsimulator.types;

import com.google.gson.JsonObject;
import rlp.footrix.framework.types.entities.Match;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.PlayersLineup;
import rlp.footrix.protrix.types.ProtrixPlayer;
import rlp.footrix.protrix.ai.matchsimulator.MatchState;
import rlp.footrix.protrix.ai.matchsimulator.weights.PlayerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InjuryEventSimulator extends EventSimulator {
    private static final double BaseInjuryChance = 0.014;

    public InjuryEventSimulator(MatchState state, PlayerValue playerValue) {
        super(state, playerValue);
    }

    @Override
    public List<Match.MatchEvent> simulate(int minute) {
        if (Math.random() > BaseInjuryChance) return new ArrayList<>();
        JsonObject metainfo = new JsonObject();
        metainfo.addProperty("level", 1);   //TODO
        if (Math.random() < 0.5) {
            String player = pickPlayerForInjury(localLineup());
            return List.of(new Match.MatchEvent(local(), Match.MatchEvent.Type.Injury, minute, player, null, metainfo));
        } else {
            String player = pickPlayerForInjury(visitantLineup());
            return List.of(new Match.MatchEvent(visitant(), Match.MatchEvent.Type.Injury, minute, player, null, metainfo));
        }
    }

    private String pickPlayerForInjury(PlayersLineup lineup) {
        Map<Player, Double> weights = new HashMap<>();
        double total = 0.0;

        for (Player p : lineup.fieldPlayers()) {
            ProtrixPlayer player = (ProtrixPlayer) p;
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
}
