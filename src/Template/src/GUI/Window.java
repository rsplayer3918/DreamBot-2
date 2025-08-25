package GUI;

import Handler.State;
import common.gui.ConfigWindow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends ConfigWindow<Void> {

    private JPanel RootPanel;
    private JButton startButton;
    private JComboBox walkLocation;
    private JTabbedPane Bank;

    public Window() {
    }

    public Window(State s) {
        this.state = s;
        startButton.addActionListener(actionEvent -> {
            s.setState(1);
            s.killFrame();
        });
    }

    @Override
    public JPanel getRootPanel() {
        return RootPanel;
    }
}

