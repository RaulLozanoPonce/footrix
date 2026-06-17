package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.TrainEvent;
import rlp.footrix.framework.types.entities.Training;
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
        Training training = application.models().trainer().train(date, team, minutes);
        process(training);
    }

    private void process(Training training) {
        for (Player player : training.records().keySet()) {
            Training.TrainingRecord record = training.records().get(player);
            player.skills().trainingProgress(record.score());
            player.energy(-record.fatigue());
            player.addInjury(application.timeManager().future(application.injuryCalculator().injuryDays(record.injuryLevel())));
        }
        //TODO CAMBIO EN LA FELICIDAD INDIVIDUAL
    }
}
