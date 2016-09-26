package gooey;

import javax.swing.*;
import java.awt.*;

public class Drawer {

    JFrame mainFrame;
    JPanel controlPanel;

    public Drawer() {

        mainFrame = new JFrame();
        controlPanel = new JPanel();

    }

    public void drawGUI() {

        GridBagConstraints constraints;

        // Set up the Frame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up the pane
        Container pane = mainFrame.getContentPane();
        pane.setLayout(new GridBagLayout());

        // Set up the controlling JPanel
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        constraints.ipadx = 500;
        constraints.ipady = 500;
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        controlPanel.setLayout(new GridBagLayout());
        controlPanel.setBackground(Color.lightGray);
        pane.add(controlPanel, constraints);

        // Show it all
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}
