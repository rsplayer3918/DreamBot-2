package superbot;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;

import java.util.ArrayList;
import java.util.List;

public class SuperBot extends AbstractScript {

    private final List<BotTask> tasks = new ArrayList<>();
    private BotTask activeTask;
    private int taskIndex = 0;
    private long sessionEnd;

    @Override
    public void onStart() {
        if (!tasks.isEmpty()) {
            activeTask = tasks.get(0);
            activeTask.onStart();
            sessionEnd = System.currentTimeMillis() + Calculations.random(15 * 60_000, 45 * 60_000);
        }
    }

    @Override
    public int onLoop() {
        if (activeTask == null) {
            return 600;
        }

        int delay = activeTask.onLoop();

        if (System.currentTimeMillis() > sessionEnd) {
            activeTask.onExit();
            taskIndex = (taskIndex + 1) % tasks.size();
            activeTask = tasks.get(taskIndex);
            activeTask.onStart();
            sessionEnd = System.currentTimeMillis() + Calculations.random(15 * 60_000, 45 * 60_000);
        }

        return delay;
    }

    public void addTask(BotTask task) {
        tasks.add(task);
    }
}
