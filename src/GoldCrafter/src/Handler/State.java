package Handler;


import GUI.Window;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class State {

        private JFrame frame;
        private Window window;
        private Craft.Main.State state = Craft.Main.State.SETUP;
        private int smeltLocation, product;

	public State() {
		SwingUtilities.invokeLater(() -> {
			window = new Window(this);
			frame = (new JFrame(Window.TITLE));
			frame.setSize(Window.W, Window.H);
			frame.setLocationRelativeTo(null);
			frame.setPreferredSize(new Dimension(Window.W, Window.H));
			frame.setContentPane(window.getRootPanel());
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		});
	}

	public void killFrame() {
		try {
			frame.setVisible(false);
			frame.dispose();
			window.dispose();
		} catch (Exception woeIsMe) {
			woeIsMe.printStackTrace();
		}
                setState(Craft.Main.State.INIT);
        }

	public int getSmeltLocation() {
		return smeltLocation;
	}

	public void setSmeltLocation(int smeltLocation) {
		this.smeltLocation = smeltLocation;
	}

        public Craft.Main.State getState() {
                return state;
        }

        public void setState(Craft.Main.State s) {
                state = s;
        }


	public int getProduct() {
		return product;
	}

	public void setProduct(int p) {
		product = p;
	}
}