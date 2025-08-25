package GUI;

import goldcrafter.state.GoldCrafterState;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends JFrame {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape Crafting bot";
	private JPanel RootPanel;
	private JComboBox bankLocation, location;

	private JButton startButton;
	private JTabbedPane Bank;
	private JComboBox product;
	private JComboBox comboBox1;
        private GoldCrafterState s;

	public Window() {
	}

        public Window(GoldCrafterState s) {
                this.s = s;
		startButton.addActionListener(actionEvent -> {
			s.setSmeltLocation(location.getSelectedIndex());
			s.setProduct(product.getSelectedIndex());
			s.killFrame();
		});
	}

	public JPanel getRootPanel() {
		return RootPanel;
	}

}
