package Master.tasks;

import Master.Task;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;

/**
 * Handles banking when the inventory is full.
 */
public class BankTask implements Task {

    private final AbstractScript ctx;

    public BankTask(AbstractScript ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean shouldExecute() {
        return ctx.getInventory().isFull();
    }

    @Override
    public int execute() {
        if (ctx.getBank().isOpen()) {
            ctx.getBank().depositAllItems();
        } else {
            ctx.getBank().openClosest();
        }
        return Calculations.random(300, 600);
    }

    @Override
    public int priority() {
        return 10;
    }
}
