package Miner;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import SuperBot.SuperBotConfig;

@ScriptManifest(category = Category.MINING, name = "Miner", author = "Andrew", version = 0.01)
public class Main extends AbstractScript {

    private SuperBotConfig.MiningConfig config;

    @Override
    public void onStart() {
        // default start does nothing
    }

    public void onStart(SuperBotConfig.MiningConfig config) {
        this.config = config;
    }

    @Override
    public int onLoop() {
        return 1000;
    }
}
