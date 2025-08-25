package miner.state;

import Miner.GUI.Window;
import common.state.BaseState;

public class MinerState extends BaseState {

        private int radius, bankArea;
        private boolean drop;

        public MinerState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }

        public int getRadius() {
                return radius;
        }

        public void setRadius(int radius) {
                this.radius = radius;
        }

        public void setRadius(String radius) {
                try {
                        this.radius = Integer.parseInt(radius);
                } catch (Exception e) {
                        this.radius = 10;
                        System.out.println(e);
                }
        }

        public boolean isDrop() {
                return drop;
        }

        public void setDrop(boolean drop) {
                this.drop = drop;
        }

        public int getBankArea() {
                return bankArea;
        }

        public void setBankArea(int bankArea) {
                this.bankArea = bankArea;
        }
}
