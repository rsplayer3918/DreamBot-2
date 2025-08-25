package GUI;

import Handler.State;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private State s;

	public Window() {
	}

	public Window(State s) {
                this.s = s;
                startButton.addActionListener(actionEvent -> {
                        int smeltIndex = location.getSelectedIndex();
                        int productIndex = product.getSelectedIndex();

                        if (smeltIndex < 0 || smeltIndex >= location.getItemCount()) {
                                JOptionPane.showMessageDialog(Window.this, "Please select a valid smelt location.");
                                return;
                        }

                        if (productIndex < 0 || productIndex >= product.getItemCount()) {
                                JOptionPane.showMessageDialog(Window.this, "Please select a valid product.");
                                return;
                        }

                        s.setSmeltLocation(smeltIndex);
                        s.setProduct(productIndex);
                        s.killFrame();
                });
        }

	public JPanel getRootPanel() {
		return RootPanel;
	}

}
