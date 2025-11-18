package rlp.footrix.framework.tasks;

import rlp.footrix.framework.Application;

import java.time.Instant;

public abstract class Task {
    protected final Instant executionDate;
    protected final Application application;

    protected Task(Instant executionDate, Application application) {
        this.executionDate = executionDate;
        this.application = application;
    }

    public boolean preconditions() {
        return true;
    }

    public Instant executionDate() {
        return executionDate;
    }

    public abstract void execute();
}
