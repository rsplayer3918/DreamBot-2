package Walk;


import Handler.State;
import java.util.Random;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.MISC, name = "tmp.01", author = "Andrew", version = .01)

public class Main extends AbstractScript {

	private State s;

	@Override
        public void onStart() { //0th state
                log("onStart: template walker starting");
                super.onStart();
                s = new State();
                while (s.getState() < 1) {
                        antiBan();
                        sleep(100);
                }
                init();
        }

	private void init() { //1st state
	}


	private void checkState() {

	}


	private void moveToBank() {  //////////////3rd state////////////////
	}


        @Override
        public int onLoop() {
                log("onLoop: state " + s.getState());
                checkState();
                switch (s.getState()) {
                        case 2:
                                break;
                        case 3:
                                break;
                }
                antiBan();

                //RUN EVERY SECOND-ISH
                return Calculations.random(200, 800);
        }

        @Override
        public void onExit() {
                log("onExit: template walker stopping");
                super.onExit();
        }

        private void antiBan() {
                Random srand = new Random();
                double chance = srand.nextDouble();
                if (chance < 0.096) {
                        log("Antiban: changing camera angle...");
                        getCamera().rotateToEvent(srand.nextInt(360), srand.nextInt(90));
                } else if (chance < 0.192) {
                        log("Antiban: random pause");
                        sleep(Calculations.random(300, 1200));
                }
        }
}
