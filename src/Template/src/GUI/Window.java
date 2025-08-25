package GUI;

import template.state.TemplateState;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends JFrame {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape main bot";
	private JPanel RootPanel;

	private JButton startButton;
	private JComboBox walkLocation;
	private JTabbedPane Bank;
        private TemplateState s;

	public Window() {
	}

        public Window(TemplateState s) {
                this.s = s;
		startButton.addActionListener(actionEvent -> {
			s.setState(1);
			s.killFrame();
		});
	}

	public JPanel getRootPanel() {
		return RootPanel;
	}

}
