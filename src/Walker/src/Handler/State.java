package Handler;


import GUI.Window;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class State {

private JFrame frame;
private Window window;

private int destination = 0, state = 0;
private Runnable onConfigComplete;

public State() {
this(null);
}

public State(Runnable onConfigComplete) {
this.onConfigComplete = onConfigComplete;
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

private void fireConfigComplete() {
if (onConfigComplete != null) {
Runnable cb = onConfigComplete;
onConfigComplete = null;
cb.run();
}
}

	public void killFrame() {
		try {
			frame.setVisible(false);
			frame.dispose();
			window.dispose();
		} catch (Exception woeIsMe) {
			woeIsMe.printStackTrace();
		}
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getState() {
		return state;
	}

public void setState(int s) {
state = s;
if (state >= 1) {
fireConfigComplete();
}
}


}