package GUI;

import Handler.State;
import common.gui.ScriptWindow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Window extends ScriptWindow {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape main bot";
	private JPanel RootPanel;

	private JButton startButton;
	private JComboBox walkLocation, logType;
	private JTextField radius;
	private JTabbedPane Bank;
	private State s;

        public Window(State s) {
                super(TITLE, W, H);
                this.s = s;
                startButton.addActionListener(actionEvent -> {
                        s.setState(1);
                        s.setBankLocation(walkLocation.getSelectedIndex());
                        s.setTree(logType.getSelectedIndex());
                        s.setRadius(radius.getText());
                        s.killFrame();
                });
                setup(RootPanel);
        }

        public JPanel getRootPanel() {
                return RootPanel;
        }

}
