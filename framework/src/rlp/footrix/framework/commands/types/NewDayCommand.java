package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;

import java.time.Instant;

public class NewDayCommand extends Command {
    public Instant date;

    public NewDayCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        application.game().date(date);
        application.playerManager().players().forEach(p -> {
            if (p.isInjured() && !p.recoveryDate().isAfter(date)) p.recovery();
            p.energy(0.17 * (1 - p.energy()));  //todo 0.33 de normal, pero hay que poner los entrenos
            p.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceInjuryMood(p));
        });
        application.taskHub().execute(date);
    }
}
