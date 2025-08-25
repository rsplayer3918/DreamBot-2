package Handler;

/**
 * Enumerates the different states the combat script can be in.
 */
public enum BotState {
    /** Initial state before the GUI has been completed. */
    INIT,
    /** Idle after configuration, waiting for tasks. */
    IDLE,
    ATTACK,
    MOVE_TO_BANK,
    BANK,
    LOOT,
    WALK_BACK,
    ANTI_BAN
}
