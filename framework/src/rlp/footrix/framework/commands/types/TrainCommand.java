package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.TrainEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainCommand extends Command {
    private final Team team;
    private final TrainEvent.TrainType type;
    private final int minutes;

    public TrainCommand(Application application, TrainEvent event) {
        super(application);
        this.team = application.entityStore().team(event.teamId());
        this.type = event.type();
        this.minutes = event.minutes();
    }

    public void execute() {
        List<Player> trainedPlayers = new ArrayList<>();
        for (Player player : team.players()) {
            boolean trained = train(player);
            if (trained) trainedPlayers.add(player);
        }
        handleInjury(trainedPlayers);
    }

    private boolean train(Player player) {
        if (player.isInjured()) return false;
        double score = 6.0;
        double fatigue = application.psychophysicsCalculator().trainingFatigue(player);
        double physicalCondition = application.psychophysicsCalculator().physicalConditionTrainGain(minutes);
        player.skills().trainingProgress(score);
        player.psychophysics().energy(-fatigue);
        player.psychophysics().physicalCondition(physicalCondition);
        //if (injuryLevel > 0) player.addInjury(application.timeManager().future(application.injuryCalculator().injuryDays(injuryLevel)));
        return true;
    }

    private void handleInjury(List<Player> trainedPlayers) {
        if (trainedPlayers.isEmpty()) return;
        Set<String> injuredPlayers = new HashSet<>();
        double riskPerMinute = 0.0015 * (0.5 + type.intensity() / 2.0);
        for (int i = 0; i < minutes; i++) {
            double random = Math.random();
            if (random < riskPerMinute) {
                Player injuredPlayer = injuredPlayer(trainedPlayers, injuredPlayers);
                int injuryDays = application.injuryCalculator().injuryDays(injuryLevel());
                if (injuryDays == 0) continue;
                injuredPlayer.addInjury(application.timeManager().future(injuryDays));
                injuredPlayers.add(injuredPlayer.definition().id());
            }
        }
    }

    private int injuryLevel() {
        double random = Math.random();
        if (type == TrainEvent.TrainType.Tactic) {
            if (random <= 0.96) return 1;
            return 2;
        } else if (type == TrainEvent.TrainType.Technique) {
            if (random <= 0.91) return 1;
            else if (random <= 0.99) return 2;
            return 3;
        }
        if (random <= 0.80) return 1;
        else if (random <= 0.97) return 2;
        return 3;
    }

    private Player injuredPlayer(List<Player> trainedPlayers, Set<String> injuredPlayers) {
        //TODO MEJORAR
        List<Player> injurablePlayers = trainedPlayers.stream().filter(p -> !injuredPlayers.contains(p.definition().id())).toList();
        double random = Math.random() * injurablePlayers.size();
        return injurablePlayers.get((int) Math.floor(random));
    }
}
