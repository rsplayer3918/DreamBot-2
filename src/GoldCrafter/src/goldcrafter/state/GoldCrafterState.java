package goldcrafter.state;

import GUI.Window;
import common.state.BaseState;

public class GoldCrafterState extends BaseState {

        private int smeltLocation, product;

        public GoldCrafterState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }

        @Override
        public void killFrame() {
                super.killFrame();
                setState(1);
        }

        public int getSmeltLocation() {
                return smeltLocation;
        }

        public void setSmeltLocation(int smeltLocation) {
                this.smeltLocation = smeltLocation;
        }

        public int getProduct() {
                return product;
        }

        public void setProduct(int p) {
                product = p;
        }
}
