package common.state;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * BaseState provides shared GUI initialization and state management
 * functionality for script-specific state classes.
 */
public class BaseState {

    private JFrame frame;
    private JFrame window;
    private int state = 0;

    /**
     * Initializes the GUI using the provided window details.
     *
     * @param window the script specific window instance
     * @param rootPanel the root panel for the frame content
     * @param width the window width
     * @param height the window height
     * @param title the frame title
     */
    protected void init(final JFrame window, final JPanel rootPanel,
                        final int width, final int height, final String title) {
        SwingUtilities.invokeLater(() -> {
            this.window = window;
            frame = new JFrame(title);
            frame.setSize(width, height);
            frame.setLocationRelativeTo(null);
            frame.setPreferredSize(new Dimension(width, height));
            frame.setContentPane(rootPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    /**
     * Disposes of the GUI frame and window.
     */
    public void killFrame() {
        try {
            frame.setVisible(false);
            frame.dispose();
            if (window != null) {
                window.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
