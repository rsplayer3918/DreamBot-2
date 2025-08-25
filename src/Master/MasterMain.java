package Master;

import Master.tasks.BankTask;
import Master.tasks.CombatTask;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "Master", author = "Andrew", version = 1.0)
public class MasterMain extends AbstractScript {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void onStart() {
        tasks.add(new BankTask(this));
        tasks.add(new CombatTask(this, "Chicken"));
    }

    @Override
    public int onLoop() {
        return tasks.stream()
                .filter(Task::shouldExecute)
                .max(Comparator.comparingInt(Task::priority))
                .map(Task::execute)
                .orElseGet(() -> Calculations.random(300, 600));
    }
}
