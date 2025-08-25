package common.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.util.function.Supplier;

/**
 * Generic state that manages displaying a configuration window and storing
 * configuration data for a script. Scripts can supply any configuration
 * object which will be populated by their {@link ConfigWindow} implementation.
 */
public class State<C> {

    private JFrame frame;
    private final C config;
    private int state = 0;

    /**
     * Creates the state with an empty configuration and window supplier. The
     * supplier is invoked on the Swing thread and the resulting window is used
     * as the content of the frame.
     */
    public State(C config, Supplier<? extends ConfigWindow<C>> windowSupplier) {
        this.config = config;
        SwingUtilities.invokeLater(() -> {
            ConfigWindow<C> window = windowSupplier.get();
            window.setState(this);
            frame = new JFrame(ConfigWindow.TITLE);
            frame.setSize(ConfigWindow.W, ConfigWindow.H);
            frame.setLocationRelativeTo(null);
            frame.setPreferredSize(new Dimension(ConfigWindow.W, ConfigWindow.H));
            frame.setContentPane(window.getRootPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    public void killFrame() {
        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        state = s;
    }

    public C getConfig() {
        return config;
    }
}

