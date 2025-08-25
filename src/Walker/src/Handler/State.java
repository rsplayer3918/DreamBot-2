package Handler;

import GUI.Window;
import common.state.ScriptState;
import common.gui.ScriptWindow;

public class State extends ScriptState {

    private int destination;

    @Override
    protected ScriptWindow createWindow() {
        return new Window(this);
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
