package nezz.dreambot.tasks;

/**
 * Represents a generic task that can be monitored for experience and level
 * goals.
 */
public interface Task {

    /**
     * Checks whether this task has reached its goal using the supplied
     * {@link XpMonitor}.
     *
     * @param monitor the monitor to query
     * @return {@code true} if the goal has been reached
     */
    boolean reachedGoal(XpMonitor monitor);

    /**
     * Resets any internal timers or counters so the task can be executed again.
     */
    void reset();
}

