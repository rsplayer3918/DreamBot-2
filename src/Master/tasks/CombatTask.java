package Master.tasks;

import Master.Task;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.NPC;

/**
 * Simple combat task that attacks the specified NPC when available.
 */
public class CombatTask implements Task {

    private final AbstractScript ctx;
    private final String targetName;

    public CombatTask(AbstractScript ctx, String targetName) {
        this.ctx = ctx;
        this.targetName = targetName;
    }

    @Override
    public boolean shouldExecute() {
        return !ctx.getInventory().isFull();
    }

    @Override
    public int execute() {
        NPC npc = ctx.getNpcs().closest(n -> n != null && n.getName().equals(targetName) && !n.isInCombat());
        if (npc != null) {
            npc.interact("Attack");
            ctx.sleepUntil(() -> ctx.getLocalPlayer().isInCombat(), 2000);
        }
        return Calculations.random(200, 400);
    }

    @Override
    public int priority() {
        return 5;
    }
}
