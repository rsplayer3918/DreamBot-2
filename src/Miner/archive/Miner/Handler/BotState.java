package Miner.Handler;

/**
 * States for the miner script.
 */
public enum BotState {
    INIT,
    IDLE,
    MINE,
    MOVE_TO_BANK,
    BANK,
    WALK_BACK,
    DROP
}
