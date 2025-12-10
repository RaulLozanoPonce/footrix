package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.types.entities.player.Player;

import java.time.Instant;

public class NewDayCommand extends Command {
    public Instant date;

    public NewDayCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        application.game().date(date);
        for (Player player : application.playerManager().players()) {
            if (player.isInjured() && !player.recoveryDate().isAfter(date)) player.recovery();
            player.energy(0.17 * (1 - player.energy()));  //todo 0.33 de normal, pero hay que poner los entrenos
            player.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceInjuryMood(player));
            if (application.retireCalculator().decidedToRetire(player)) player.decidedToRetire();
        }
        application.taskHub().execute(date);
    }
}
