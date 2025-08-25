package nezz.dreambot.tasks;

import java.util.List;

/**
 * Simple manager for iterating over a list of {@link Task}s and advancing when a
 * task's goal has been reached.
 */
public class TaskManager<T extends Task> {

    private final List<T> tasks;
    private int index;

    public TaskManager(List<T> tasks) {
        this.tasks = tasks;
        this.index = 0;
    }

    public T getCurrentTask() {
        return tasks.get(index);
    }

    /**
     * Checks the current task's goal and advances to the next task if necessary.
     *
     * @param monitor monitor used for goal detection
     * @return {@code true} if the manager advanced to the next task
     */
    public boolean update(XpMonitor monitor) {
        if (getCurrentTask().reachedGoal(monitor)) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasTasks() {
        return index < tasks.size();
    }
}

