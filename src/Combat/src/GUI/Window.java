package GUI;

import Handler.State;
import common.gui.ScriptWindow;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends ScriptWindow {

	public static final int W = 400, H = 250;
	public static final String TITLE = "Yet Another RuneScape main bot";
	private JPanel RootPanel;
	private JTabbedPane tabs;

	private JTextField targetField, radiusField, foodField, FoodAmtField;
	private JTextArea lootField;
	private JComboBox bankLocation;
	private JLabel FoodAmtLabel, fightRadiusLabel;
	private JCheckBox takeAllCheckBox, buryBonesCheckBox;
	private JButton startButton;
	private Slider eatSlider;
	private State s;

        public Window(State s) {
                super(TITLE, W, H);
                this.s = s;
                startButton.addActionListener(actionEvent -> {
                        s.setTarget(targetField.getText());
                        s.setFoodAmt(FoodAmtField.getText());
                        s.setFightRadius(radiusField.getText());
                        s.setFood(foodField.getText());
                        s.setLoot(lootField.getText());
                        s.setBuryBones(buryBonesCheckBox.isSelected());
                        s.setTakeOtherPlayersLoot(takeAllCheckBox.isSelected());
                        s.setBankLocation(bankLocation.getSelectedIndex());
                        s.setEatPercentage(eatSlider.getValue());
                        s.setState(1);
                        s.killFrame();
                });
                setup(RootPanel);
        }

        public JPanel getRootPanel() {
                return RootPanel;
        }

}
