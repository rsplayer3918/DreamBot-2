package task;

/**
 * Represents a unit of work that can be executed by the TaskManager.
 */
public interface Task {
    /**
     * Returns true if this task has completed its work and should be removed from the queue.
     *
     * @return whether the task is complete
     */
    boolean isComplete();

    /**
     * Performs one iteration of this task's work.
     *
     * @return the delay before the next execution
     */
    int execute();
}
