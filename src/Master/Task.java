package Master;

/**
 * Represents a unit of work that can be executed by the Master script.
 */
public interface Task {
    /**
     * Determines whether this task is ready to be executed.
     *
     * @return true if the task should run
     */
    boolean shouldExecute();

    /**
     * Performs the task's logic.
     *
     * @return delay in milliseconds before the next loop
     */
    int execute();

    /**
     * Priority used when multiple tasks are available. Higher values are run first.
     *
     * @return task priority
     */
    int priority();
}
