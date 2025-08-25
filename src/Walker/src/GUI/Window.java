package GUI;

import Handler.State;
import common.gui.ScriptWindow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends ScriptWindow {

	public static final int W = 400, H = 290;
	public static final String TITLE = "Yet Another RuneScape Walker bot";
	private JPanel RootPanel;

	private JButton startButton;
	private JComboBox walkLocation;
	private JPanel StartTab;
	private JTabbedPane tabs;
	private State s;

        public Window(State s) {
                super(TITLE, W, H);
                this.s = s;
                startButton.addActionListener(actionEvent -> {
                        s.setDestination(walkLocation.getSelectedIndex());
                        s.killFrame();
                        s.setState(1);
                });
                setup(RootPanel);
        }

        public JPanel getRootPanel() {
                return RootPanel;
        }

}
