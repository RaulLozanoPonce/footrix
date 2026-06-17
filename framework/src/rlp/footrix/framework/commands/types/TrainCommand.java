package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.TrainEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.time.Instant;

public class TrainCommand extends Command {
    private final Team team;
    private final Instant date;
    private final int minutes;

    public TrainCommand(Application application, TrainEvent event) {
        super(application);
        this.team = application.entityStore().team(event.teamId());
        this.date = event.ts();
        this.minutes = event.minutes();
    }

    public void execute() {
        for (Player player : team.players()) {
            train(player);
        }
    }

    private void train(Player player) {
        if (player.isInjured()) return;
        double score = 6.0;
        double fatigue = application.energyCalculator().trainingFatigue(player);
        int injuryLevel = injuryLevel(player);
        player.skills().trainingProgress(score);
        player.energy(-fatigue);
        player.addInjury(application.timeManager().future(application.injuryCalculator().injuryDays(injuryLevel)));
        //TODO CAMBIO EN LA FELICIDAD INDIVIDUAL
    }

    private int injuryLevel(Player player) {
        int sessionFactor = 2;  //TODO 1 TACTICO, 2 TECNICO, 5 FISICO
        double fatigueFactor = (100 - 100 * player.energy()) / 10;
        double staminaFactor = (100 - player.skills().stamina()) / 20;
        double risk = sessionFactor + fatigueFactor + staminaFactor;
        double random = 100 * Math.random();
        /*if (random > risk) return 0;
        if (random > risk * 0.4) return 1;
        if (random > risk * 0.1) return 2;
        return 3;*/
        return 0;
    }
}
