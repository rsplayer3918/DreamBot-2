package Handler;

import GUI.Window;
import common.state.ScriptState;
import common.gui.ScriptWindow;

public class State extends ScriptState {

    private int smeltLocation, product;

    @Override
    protected ScriptWindow createWindow() {
        return new Window(this);
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
