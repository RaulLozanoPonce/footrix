package rlp.footrix.framework.commands;

import rlp.footrix.framework.Application;

public abstract class Command {
    protected final Application application;

    public Command(Application application) {
        this.application = application;
    }

    public abstract void execute();
}
