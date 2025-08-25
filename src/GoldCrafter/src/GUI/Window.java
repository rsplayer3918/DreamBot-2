package GUI;

import Handler.State;
import common.gui.ScriptWindow;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends ScriptWindow {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape Crafting bot";
	private JPanel RootPanel;
	private JComboBox bankLocation, location;

	private JButton startButton;
	private JTabbedPane Bank;
	private JComboBox product;
	private JComboBox comboBox1;
	private State s;

        public Window(State s) {
                super(TITLE, W, H);
                this.s = s;
                startButton.addActionListener(actionEvent -> {
                        s.setSmeltLocation(location.getSelectedIndex());
                        s.setProduct(product.getSelectedIndex());
                        s.setState(1);
                        s.killFrame();
                });
                setup(RootPanel);
        }

        public JPanel getRootPanel() {
                return RootPanel;
        }

}
