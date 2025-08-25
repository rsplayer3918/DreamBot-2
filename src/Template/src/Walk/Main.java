package Walk;


import Handler.State;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "tmp.01", author = "Andrew", version = .01)

public class Main extends AbstractScript {

        private State s;
        private Area bankArea, walkArea;

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
                walkArea = getLocalPlayer().getSurroundingArea(5);
                bankArea = BankLocation.getNearest(getLocalPlayer()).getArea(3);
        }


        private void checkState() {
                if (getInventory().isFull()) {
                        if (bankArea.contains(getLocalPlayer())) {
                                s.setState(4); //Bank
                        } else {
                                s.setState(3); //Move to bank
                        }
                } else if (!walkArea.contains(getLocalPlayer())) {
                        s.setState(5); //Move back
                } else {
                        s.setState(2); //Main activity
                }
        }


        private void moveToBank() {  //////////////3rd state////////////////
                getWalking().walk(bankArea.getRandomTile());
                sleepUntil(() -> !getLocalPlayer().isMoving(), 2500);
        }

        private int bank() {  //4th state
                if (getBank().isOpen()) {
                        getBank().depositAllItems();
                        sleepUntil(() -> getInventory().isEmpty(), 1000);
                } else {
                        getBank().openClosest();
                        sleepUntil(() -> getBank().isOpen(), 1500);
                }
                return Calculations.random(200, 500);
        }

        private void walkBack() { //5th state
                getWalking().walk(walkArea.getCenter().getArea(1).getRandomTile());
        }

        @Override
        public int onLoop() {
                checkState();
                switch (s.getState()) {
                        case 2:
                                //Placeholder for main activity
                                break;
                        case 3:
                                moveToBank();
                                break;
                        case 4:
                                return bank();
                        case 5:
                                walkBack();
                                break;
                }

                //RUN EVERY SECOND-ISH
                return Calculations.random(200, 800);
        }
}
