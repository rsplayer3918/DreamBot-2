package common.state;

import common.gui.ScriptWindow;
import javax.swing.SwingUtilities;

/**
 * Base state handling for scripts.
 * Manages showing and closing the associated GUI window
 * and tracks a simple integer state value.
 */
public abstract class ScriptState {

    private ScriptWindow window;
    private int state = 0;

    protected ScriptState() {
        SwingUtilities.invokeLater(() -> {
            window = createWindow();
            window.setVisible(true);
        });
    }

    /**
     * Implementations should create and return the window used
     * for configuring the script.
     */
    protected abstract ScriptWindow createWindow();

    public void killFrame() {
        try {
            window.setVisible(false);
            window.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
