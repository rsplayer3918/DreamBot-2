package task;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Simple manager that runs tasks in order of priority, advancing when a task completes.
 */
public class TaskManager {

    private static class PrioritizedTask {
        final Task task;
        final int priority;

        PrioritizedTask(Task task, int priority) {
            this.task = task;
            this.priority = priority;
        }
    }

    private final PriorityQueue<PrioritizedTask> tasks =
            new PriorityQueue<>(Comparator.comparingInt((PrioritizedTask pt) -> pt.priority).reversed());

    private PrioritizedTask current;

    /**
     * Adds a task with the given priority to the queue.
     */
    public void addTask(Task task, int priority) {
        tasks.offer(new PrioritizedTask(task, priority));
    }

    /**
     * Executes the current task and advances when it completes.
     *
     * @return delay before the next loop iteration
     */
    public int onLoop() {
        if (current == null || current.task.isComplete()) {
            current = tasks.poll();
        }
        if (current == null) {
            return 600;
        }
        return current.task.execute();
    }
}
