package Handler;

import GUI.Window;

/**
 * Template state that uses the common generic state with no configuration.
 */
public class State extends common.gui.State<Void> {

    public State() {
        super(null, Window::new);
    }
}

