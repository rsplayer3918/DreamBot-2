package wc.state;

import GUI.Window;
import common.state.BaseState;

public class WCState extends BaseState {

        private int bankLocation, radius;
        private String tree;

        public WCState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }

        public String getTree() {
                return tree;
        }

        public void setTree(int l) {
                switch (l) {
                        case 0:
                                tree = "Tree";
                                break;
                        case 1:
                                tree = "Oak Tree";
                                break;
                        case 2:
                                tree = "Willow Tree";
                                break;
                        case 3:
                                tree = "Yew Tree";
                                break;
                }
        }

        public int getRadius() {
                return radius;
        }

        public void setRadius(String r) {
                try {
                        radius = Integer.parseInt(r);
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Some shit went wrong");
                }
        }

        public int getBankLocation() {
                return bankLocation;
        }

        public void setBankLocation(int bankLocation) {
                this.bankLocation = bankLocation;
        }
}
