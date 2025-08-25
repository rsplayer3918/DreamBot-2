package Handler;

import GUI.Window;
import common.state.ScriptState;
import common.gui.ScriptWindow;

public class State extends ScriptState {

    @Override
    protected ScriptWindow createWindow() {
        return new Window(this);
    }
}
