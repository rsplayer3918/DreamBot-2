package task;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "TaskManagerScript", author = "Andrew", version = 1.0)
public class TaskManagerScript extends AbstractScript {

    private TaskManager taskManager;

    @Override
    public void onStart() {
        taskManager = new TaskManager();

        Combat.Main combat = new Combat.Main();
        combat.onStart();
        taskManager.addTask(combat, 1);

        WC.Main wc = new WC.Main();
        wc.onStart();
        taskManager.addTask(wc, 1);

        Craft.Main craft = new Craft.Main();
        craft.onStart();
        taskManager.addTask(craft, 1);

        nezz.dreambot.scriptmain.powerminer.Miner miner = new nezz.dreambot.scriptmain.powerminer.Miner();
        miner.onStart();
        taskManager.addTask(miner, 1);
    }

    @Override
    public int onLoop() {
        return taskManager.onLoop();
    }
}
