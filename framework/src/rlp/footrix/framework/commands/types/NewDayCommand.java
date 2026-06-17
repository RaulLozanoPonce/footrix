package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.NewDayEvent;
import rlp.footrix.framework.events.types.TrainEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.time.Instant;

import static rlp.footrix.framework.utils.TimeHelper.Scale.Day;
import static rlp.footrix.framework.utils.TimeHelper.nextInstant;
import static rlp.footrix.framework.utils.TimeHelper.weekDayOf;

public class NewDayCommand extends Command {
    private final Instant newDate;

    public NewDayCommand(Application application, NewDayEvent event) {
        super(application);
        this.newDate = event.date();
    }

    public void execute() {
        boolean result = application.taskHub().execute(application.getDate());
        if (!result) return;
        application.game().date(newDate);
        for (Player player : application.playerManager().players().stream().filter(Player::active).toList()) makeTimePassTo(player);    //TODO Quizas se pueda hacer que los jugadores activos estén separados
        for (Team team : application.teamManager().teams()) makeTimePassTo(team);
    }

    private void makeTimePassTo(Player player) {
        if (player.isInjured() && !player.recoveryDate().isAfter(newDate)) player.recovery();
        player.energy(recovery(player));
        player.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceInjuryMood(player)); //TODO Se quitará para modificar el estado de ánimo
        player.skills().naturalProgress(application.getDate());
        if (application.retireCalculator().decidedToRetire(player)) player.decidedToRetire();
    }

    private void makeTimePassTo(Team team) {
        //TODO ESTOS SON ENTRENAMIENTOS BÁSICOS. SE DEBERÍA GENERAR CON LO QUE EL MANAGER PONGA EN SU EQUIPO
        if (weekDayOf(newDate) != 1) return;
        application.taskHub().add(newDate, new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 2), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 3), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 4), new TrainEvent().teamId(team.definition().id()).minutes(120));
    }

    private double recovery(Player player) {
        double factor = 1.0;
        if (player.energy() < 0.15) factor = 0.6;
        else if (player.energy() < 0.3) factor = 0.8;
        return factor * (10 + (player.skills().stamina() / 10.0)) / 100.0;
    }
}
