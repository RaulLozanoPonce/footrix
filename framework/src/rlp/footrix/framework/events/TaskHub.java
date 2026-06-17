package rlp.footrix.framework.events;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskHub {
    private final EventHub eventHub;
    private Map<Instant, List<Event>> tasks = new ConcurrentHashMap<>();

    public TaskHub(EventHub eventHub) {
        this.eventHub = eventHub;
    }

    public boolean execute(Instant date) {
        Map<Instant, List<Event>> futureTasks = new ConcurrentHashMap<>();
        Map<Instant, List<Event>> tasksToExecute = new ConcurrentHashMap<>();
        for (Instant executionDate : tasks.keySet()) {
            if (executionDate.isAfter(date)) {
                futureTasks.putIfAbsent(executionDate, new ArrayList<>());
                futureTasks.get(executionDate).addAll(tasks.get(executionDate));
            } else {
                tasksToExecute.putIfAbsent(executionDate, new ArrayList<>());
                tasksToExecute.get(executionDate).addAll(tasks.get(executionDate));
            }
        }
        this.tasks = futureTasks;
        //TODO DE MOMENTO NO LO ACTIVO
        /*for (Instant executionDate : tasksToExecute.keySet()) {
            if (tasksToExecute.get(executionDate).stream().anyMatch(e -> !e.preconditions())) {
                this.tasks.putAll(tasksToExecute);
                return false;
            }
        }*/

        for (Instant executionDate : tasksToExecute.keySet()) {
            tasksToExecute.get(executionDate).forEach(eventHub::publish);
        }
        return true;
    }

    public void add(Instant executionDate, Event event) {
        this.tasks.putIfAbsent(executionDate, new ArrayList<>());
        this.tasks.get(executionDate).add(event);
    }

    public void add(Map<Instant, List<Event>> tasks) {
        this.tasks.putAll(tasks);
    }
}
