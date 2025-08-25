package common.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 * Base GUI window for script configuration.
 * Provides common sizing and frame setup utilities.
 */
public abstract class ScriptWindow extends JFrame {

    protected ScriptWindow(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    protected void setup(JPanel root) {
        setContentPane(root);
        pack();
    }
}
