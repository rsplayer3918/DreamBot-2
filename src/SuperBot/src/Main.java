package SuperBot;

import SuperBot.GUI.Window;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "SuperBot", author = "Andrew", version = 0.01)
public class Main extends AbstractScript {

    private SuperBotConfig config = new SuperBotConfig();

    @Override
    public void onStart() {
        Window window = new Window(config);
        window.setVisible(true);
        while (window.isDisplayable() && !config.start) {
            sleep(100);
        }
        if (config.start) {
            new Combat.Main().onStart(config.combat);
            new WC.Main().onStart(config.woodcutting);
            new Miner.Main().onStart(config.mining);
            new Craft.Main().onStart(config.goldCrafting);
        }
    }

    @Override
    public int onLoop() {
        return 1000;
    }
}
