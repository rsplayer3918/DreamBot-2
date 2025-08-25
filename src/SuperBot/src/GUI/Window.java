package SuperBot.GUI;

import SuperBot.SuperBotConfig;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int W = 400, H = 300;

    public Window(SuperBotConfig config) {
        super("Super Bot");
        setSize(W, H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        // Combat tab
        JPanel combatPanel = new JPanel();
        JTextField targetField = new JTextField(10);
        JTextField foodField = new JTextField(10);
        combatPanel.add(new JLabel("Target:"));
        combatPanel.add(targetField);
        combatPanel.add(new JLabel("Food:"));
        combatPanel.add(foodField);
        tabs.add("Combat", combatPanel);

        // Woodcutting tab
        JPanel wcPanel = new JPanel();
        JTextField treeField = new JTextField(10);
        wcPanel.add(new JLabel("Tree:"));
        wcPanel.add(treeField);
        tabs.add("Woodcutting", wcPanel);

        // Mining tab
        JPanel miningPanel = new JPanel();
        JCheckBox dropCheck = new JCheckBox("Drop ores");
        miningPanel.add(dropCheck);
        tabs.add("Mining", miningPanel);

        // Gold crafting tab
        JPanel goldPanel = new JPanel();
        JTextField productField = new JTextField(10);
        goldPanel.add(new JLabel("Product ID:"));
        goldPanel.add(productField);
        tabs.add("GoldCrafting", goldPanel);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            config.combat.target = targetField.getText();
            config.combat.food = foodField.getText();
            config.woodcutting.tree = treeField.getText();
            config.mining.drop = dropCheck.isSelected();
            try {
                config.goldCrafting.product = Integer.parseInt(productField.getText());
            } catch (NumberFormatException ex) {
                config.goldCrafting.product = 0;
            }
            config.start = true;
            dispose();
        });

        add(tabs, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}
