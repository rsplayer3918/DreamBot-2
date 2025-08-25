package common.gui;

import javax.swing.JPanel;

/**
 * Generic configuration window that provides a root panel for scripts.
 * Specific scripts should extend this class and populate the panel with
 * their own configuration components. The window is used by {@link State}
 * to display the configuration frame.
 */
public abstract class ConfigWindow<C> {

    public static final int W = 400, H = 250;
    public static final String TITLE = "Yet Another RuneScape main bot";

    protected State<C> state;

    /**
     * Assigns the state managing this window. Called internally by {@link State}.
     */
    public void setState(State<C> state) {
        this.state = state;
    }

    /**
     * @return root panel to embed inside the configuration frame
     */
    public abstract JPanel getRootPanel();
}

