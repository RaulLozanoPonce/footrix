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
        player.energy(application.energyCalculator().dayRecovery(player));
        player.mood().individualPerformance(application.moodCalculator().deltaIndividualPerformanceInjuryMood(player)); //TODO Se quitará para modificar el estado de ánimo
        player.skills().naturalProgress(application.getDate());
        if (application.retireCalculator().decidedToRetire(player)) player.decidedToRetire();
    }

    private void makeTimePassTo(Team team) {
        //TODO ESTOS SON ENTRENAMIENTOS BÁSICOS. SE DEBERÍA GENERAR CON LO QUE EL MANAGER PONGA EN SU EQUIPO
        //TODO VARIAR LOS ENTRENAMIENTOS
        if (weekDayOf(newDate) != 7) return;
        application.taskHub().add(nextInstant(newDate, Day), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 2), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 3), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 4), new TrainEvent().teamId(team.definition().id()).minutes(120));
        application.taskHub().add(nextInstant(newDate, Day, 5), new TrainEvent().teamId(team.definition().id()).minutes(120));
    }
}
