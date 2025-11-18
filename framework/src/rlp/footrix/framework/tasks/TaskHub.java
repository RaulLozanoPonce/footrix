package rlp.footrix.framework.tasks;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskHub {
    private List<Task> tasks = new ArrayList<>();

    public synchronized void execute(Instant date) {
        List<Task> futureTasks = new ArrayList<>();
        List<Task> tasksToExecute = new ArrayList<>();
        for (Task event : tasks.stream().sorted(Comparator.comparing(Task::executionDate)).toList()) {
            if (event.executionDate().isAfter(date)) {
                futureTasks.add(event);
            } else {
                tasksToExecute.add(event);
            }
        }
        this.tasks = futureTasks;
        if (tasksToExecute.stream().allMatch(Task::preconditions)) {
            tasksToExecute.forEach(Task::execute);
        } else {
            this.tasks.addAll(tasksToExecute);
        }
    }

    public synchronized void add(Task task) {
        this.tasks.add(task);
    }

    public synchronized void add(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }
}
