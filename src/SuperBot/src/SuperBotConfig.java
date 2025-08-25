package SuperBot;

import java.util.ArrayList;
import java.util.List;

public class SuperBotConfig {

    public CombatConfig combat = new CombatConfig();
    public WoodcuttingConfig woodcutting = new WoodcuttingConfig();
    public MiningConfig mining = new MiningConfig();
    public GoldCraftingConfig goldCrafting = new GoldCraftingConfig();
    public boolean start = false;

    public static class CombatConfig {
        public String target = "";
        public String food = "";
        public int foodAmount = 0;
        public int fightRadius = 5;
        public int bankLocation = 0;
        public int eatPercentage = 50;
        public boolean buryBones = false;
        public boolean takeOtherPlayersLoot = false;
        public List<String> loot = new ArrayList<>();
    }

    public static class WoodcuttingConfig {
        public String tree = "";
        public int radius = 5;
        public int bankLocation = 0;
    }

    public static class MiningConfig {
        public int radius = 5;
        public int bankLocation = 0;
        public boolean drop = false;
    }

    public static class GoldCraftingConfig {
        public int smeltLocation = 0;
        public int product = 0;
    }
}
