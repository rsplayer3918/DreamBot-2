package common;

import org.dreambot.api.methods.map.Area;

/**
 * Shared configuration constants used across scripts.
 */
public final class Config {

    private Config() {
        // Prevent instantiation
    }

    // Item IDs
    public static final int FURNACE_ID = 24009;
    public static final int GOLD_BAR_ID = 2357;

    // Default areas
    public static final Area AL_KHARID_BANK_AREA = new Area(3269, 3166, 3271, 3169, 0);
    public static final Area AL_KHARID_SMELT_AREA = new Area(3274, 3184, 3279, 3188, 0);
}
