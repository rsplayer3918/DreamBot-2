package GUI;

import wc.state.WCState;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Window extends JFrame {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape main bot";
	private JPanel RootPanel;

	private JButton startButton;
	private JComboBox walkLocation, logType;
	private JTextField radius;
	private JTabbedPane Bank;
        private WCState s;

	public Window() {
	}

        public Window(WCState s) {
                this.s = s;
		startButton.addActionListener(actionEvent -> {
			s.setState(1);
			s.setBankLocation(walkLocation.getSelectedIndex());
			s.setTree(logType.getSelectedIndex());
			s.setRadius(radius.getText());
			s.killFrame();
		});
	}

	public JPanel getRootPanel() {
		return RootPanel;
	}

}
