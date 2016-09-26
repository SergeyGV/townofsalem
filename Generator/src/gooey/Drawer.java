package gooey;

import javax.swing.*;
import java.awt.*;

public class Drawer {

    JFrame mainFrame;
    JPanel stackPanel;
    JPanel printerPanel;
    JButton removeButton;
    JButton generateButton;

    public Drawer() {

        mainFrame = new JFrame();
        stackPanel = new JPanel();
        printerPanel = new JPanel();
        removeButton = new JButton("REMOVE");
        generateButton = new JButton("GENERATE");

    }

    public void drawGUI() {

        // Set up the Frame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up the pane
        Container pane = mainFrame.getContentPane();
        pane.setLayout(new GridBagLayout());

        // Set up the control JPanel
        stackPanel.setLayout(new GridLayout(15, 1));
        stackPanel.setBackground(Color.CYAN);
        pane.add(stackPanel, setUpStackPanel());

        // Set up the printer JPanel
        printerPanel.setLayout(new GridLayout(1, 1));
        printerPanel.setBackground(Color.lightGray);
        pane.add(printerPanel, setUpPrinterPanel());

        // Show it all
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    private GridBagConstraints setUpStackPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 300;
        constraints.ipady = 300;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    private GridBagConstraints setUpPrinterPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        constraints.ipadx = 500;
        constraints.ipady = 500;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

}
