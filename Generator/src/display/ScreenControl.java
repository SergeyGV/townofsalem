package display;

import main.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScreenControl {

    JFrame mainFrame;
    JPanel stateOne;
    JPanel leftPanel; // Contains category and role selection
    JPanel midPanel; // Contains the current role stack and the remove role button
    JPanel rightPanel; // Contains the info box, violations box, generate button

    Controller generator;

    public ScreenControl(Controller caller) {
        generator = caller;
        mainFrame = new JFrame();
        stateOne =  new JPanel();
        leftPanel = new JPanel();
        midPanel = new JPanel();
        rightPanel = new JPanel();
    }

    public void showGUI() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = mainFrame.getContentPane();
        pane.setLayout(new GridLayout(1, 1));
        pane.setBackground(Color.GRAY);

        stateOne.setLayout(new GridLayout(1, 3, 40, 0));
        leftPanel.setLayout(new GridBagLayout());
        midPanel.setLayout(new GridBagLayout());
        rightPanel.setLayout(new GridBagLayout());

        setUpLeftPanel();
        setUpMiddlePanel();
        setUpRightPanel();

        stateOne.add(leftPanel);
        stateOne.add(midPanel);
        stateOne.add(rightPanel);

        pane.add(stateOne);

        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    private void setUpLeftPanel() {

        // Category Panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        JPanel catPanel = new JPanel();
        catPanel.setLayout(new GridLayout(4, 1));
        new CategorySelect(catPanel);
        leftPanel.add(catPanel, constraints);

        // Role Panel
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 4;

        JPanel rolePanel = new JPanel();
        // Rows = max(amount of roles per category) + 1
        rolePanel.setLayout(new GridLayout(16, 1));
        CategoryListener.categorySorter = new RoleSelect(rolePanel);
        leftPanel.add(rolePanel, constraints);

    }

    private void setUpMiddlePanel() {

        // Role stack
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;

        JPanel roleStackPanel = new JPanel();
        // Rows = max player size + 1
        roleStackPanel.setLayout(new GridLayout(16, 1, 0, 1));
        RoleStack stack = new RoleStack(roleStackPanel);
        AddListener.target = stack;
        RemoveListener.target = stack;
        midPanel.add(roleStackPanel, constraints);

        // Remove Role button
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        JButton removeRole = new JButton("Remove role");
        removeRole.addMouseListener(new RemoveListener());
        removeRole.setBackground(Color.LIGHT_GRAY);
        midPanel.add(removeRole, constraints);

    }

    private void setUpRightPanel() {

        // Info box
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        JLabel infoBox = new JLabel("<html>To fill in with actual information a while later.<html>");
        infoBox.setPreferredSize(new Dimension(200, 150));
        infoBox.setBackground(Color.LIGHT_GRAY);
        infoBox.setOpaque(true);
        rightPanel.add(infoBox, constraints);

        // Violations box
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;

        JLabel violationsBox = new JLabel("<html>Violations:<html>");
        violationsBox.setPreferredSize(new Dimension(200, 250));
        violationsBox.setBackground(Color.LIGHT_GRAY);
        violationsBox.setOpaque(true);
        rightPanel.add(violationsBox, constraints);

        // Generation Button
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        JButton generateButt = new JButton("Generate!");
        generateButt.setBackground(Color.LIGHT_GRAY);
        generateButt.addMouseListener(new StartListener(violationsBox, generator, this));
        rightPanel.add(generateButt, constraints);

    }

}