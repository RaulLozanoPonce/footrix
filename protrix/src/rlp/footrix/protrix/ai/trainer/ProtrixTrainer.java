package rlp.footrix.protrix.ai.trainer;

import rlp.footrix.framework.ai.Trainer;
import rlp.footrix.framework.types.entities.Training;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;
import rlp.footrix.protrix.types.player.ProtrixSkills;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ProtrixTrainer implements Trainer {
    @Override
    public Training train(Instant instant, Team team, int duration) {
        //TODO DURATION
        Map<Player, Training.TrainingRecord> records = new HashMap<>();
        for (Player player : team.players()) {
            if (player.isInjured()) continue;
            double fatigue = 25 * (1.2 - skills(player).stamina() / 200.0) / 100.0;  //TODO 15 TACTICO, 25 TECNICO, 40 FISICO
            int injuryLevel = injuryLevel(player);
            records.put(player, new Training.TrainingRecord(6, fatigue, injuryLevel));
        }
        return new Training(records);
    }

    private int injuryLevel(Player player) {
        int sessionFactor = 2;  //TODO 1 TACTICO, 2 TECNICO, 5 FISICO
        double fatigueFactor = (100 - 100 * player.energy()) / 10;
        double staminaFactor = (100 - skills(player).stamina()) / 20;
        double risk = sessionFactor + fatigueFactor + staminaFactor;
        double random = 100 * Math.random();
        /*if (random > risk) return 0;
        if (random > risk * 0.4) return 1;
        if (random > risk * 0.1) return 2;
        return 3;*/
        return 0;
    }

    private ProtrixSkills skills(Player player) {
        return (ProtrixSkills) player.skills();
    }
}
