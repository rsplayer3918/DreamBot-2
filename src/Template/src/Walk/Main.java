package Walk;


import Handler.State;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.items.Item;

@ScriptManifest(category = Category.MISC, name = "tmp.01", author = "Andrew", version = .01)

public class Main extends AbstractScript {

        private State s;

	@Override
	public void onStart() { //0th state
		super.onStart();
		s = new State();
		while (s.getState() < 1) {
			sleep(100);
		}
		init();
	}

	private void init() { //1st state
	}


        private boolean safeToSwitch() {
                return getInventory().isEmpty() && !getLocalPlayer().isInCombat();
        }

        private void checkState() {
                if (!safeToSwitch()) {
                        ensureSafeState();
                }
        }

        private void ensureSafeState() {
                if (getLocalPlayer().isInCombat()) {
                        sleepUntil(() -> !getLocalPlayer().isInCombat(), Calculations.random(3000, 6000));
                }
                if (!getInventory().isEmpty()) {
                        bankAll(BankLocation.getNearest(getLocalPlayer()));
                }
        }

        private void bankAll(BankLocation bankLocation) {
                if (!getBank().isOpen()) {
                        if (bankLocation != null) {
                                if (!bankLocation.getArea(6).contains(getLocalPlayer())) {
                                        walkTo(bankLocation.getArea(6).getRandomTile());
                                }
                        }
                        getBank().openClosest();
                        sleepUntil(() -> getBank().isOpen(), Calculations.random(2000, 4000));
                }
                if (getBank().isOpen()) {
                        getBank().depositAllItems();
                        sleepUntil(() -> getInventory().isEmpty(), Calculations.random(2000, 4000));
                        getBank().close();
                }
        }

        private void checkHealth() {
                int hp = getSkills().getBoostedLevels(Skill.HITPOINTS);
                int max = getSkills().getRealLevel(Skill.HITPOINTS);
                if (hp < max * 0.5) {
                        Item food = getInventory().get(item -> item != null && item.hasAction("Eat"));
                        if (food != null) {
                                food.interact("Eat");
                                sleep(Calculations.random(600, 1200));
                        }
                }
        }

        private void walkTo(Tile tile) {
                if (tile == null) {
                        return;
                }
                Area a = tile.getArea(3);
                Tile dest = a.getRandomTile();
                getWalking().walk(dest);
                int reactionDistance = Calculations.random(4, 10);
                sleepUntil(() -> !getLocalPlayer().isMoving() || getWalking().getDestination().distance() < reactionDistance,
                                9000);
                if (Calculations.random(0, 10) == 0) {
                        sleep(Calculations.random(300, 1200));
                }
        }

        private void moveToBank() {  //////////////3rd state////////////////
                bankAll(BankLocation.getNearest(getLocalPlayer()));
        }

        @Override
        public int onLoop() {
                checkState();
                checkHealth();
                switch (s.getState()) {
                        case 2:
                                break;
                        case 3:
                                moveToBank();
                                break;
                }

                //RUN EVERY SECOND-ISH
                return Calculations.random(200, 800);
        }
}
