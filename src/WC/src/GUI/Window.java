package GUI;

import Handler.State;
import Handler.WCConfig;
import common.gui.ConfigWindow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Window extends ConfigWindow<WCConfig> {

    private JPanel RootPanel;
    private JButton startButton;
    private JComboBox walkLocation, logType;
    private JTabbedPane Bank;
    private JTextField radius;

    public Window() {
    }

    public Window(State s) {
        this.state = s;
        startButton.addActionListener(actionEvent -> {
            WCConfig cfg = s.getConfig();
            cfg.setBankLocation(walkLocation.getSelectedIndex());
            cfg.setTree(getTreeName(logType.getSelectedIndex()));
            try {
                cfg.setRadius(Integer.parseInt(radius.getText()));
            } catch (Exception e) {
                cfg.setRadius(0);
            }
            s.setState(1);
            s.killFrame();
        });
    }

    private String getTreeName(int idx) {
        switch (idx) {
            case 0:
                return "Tree";
            case 1:
                return "Oak Tree";
            case 2:
                return "Willow Tree";
            case 3:
                return "Yew Tree";
            default:
                return "Tree";
        }
    }

    @Override
    public JPanel getRootPanel() {
        return RootPanel;
    }
}

