package display;

import main.Controller;

import javax.swing.*;
import java.awt.*;

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
        constraints.gridheight = 3;

        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new GridLayout(15, 1));
        CategoryListener.categorySorter = new RoleSelect(rolePanel);
        leftPanel.add(rolePanel, constraints);

    }

}