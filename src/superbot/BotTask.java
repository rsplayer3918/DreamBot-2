package superbot;

/**
 * Represents a generic task in a bot's lifecycle.
 */
public interface BotTask {
    /**
     * Called once when the task is started.
     */
    default void onStart() {}

    /**
     * Called repeatedly while the task is running.
     *
     * @return the delay in milliseconds before the next loop.
     */
    int onLoop();

    /**
     * Called when the task is exiting.
     */
    default void onExit() {}

    /**
     * Optional human-readable name for logging.
     *
     * @return the task's name.
     */
    default String getName() {
        return getClass().getSimpleName();
    }
}
