package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.commands.Command;
import rlp.footrix.framework.events.types.InitGameEvent;

public class InitGameCommand extends Command {

    public InitGameCommand(Application application, InitGameEvent event) {
        super(application);
    }

    public void execute() {
        application.taskHub().add(application.newSeasonTasks(true));
    }
}
