package walker.state;

import GUI.Window;
import common.state.BaseState;

public class WalkerState extends BaseState {

        private int destination = 0;

        public WalkerState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }

        public int getDestination() {
                return destination;
        }

        public void setDestination(int destination) {
                this.destination = destination;
        }
}
