package Handler;

import GUI.Window;

/**
 * State for the WC script backed by the common generic state class.
 */
public class State extends common.gui.State<WCConfig> {

    public State() {
        super(new WCConfig(), Window::new);
    }
}

