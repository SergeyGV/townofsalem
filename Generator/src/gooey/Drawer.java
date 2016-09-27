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
        pane.setBackground(Color.GRAY);

        // Set up the stack JPanel
        stackPanel.setLayout(new GridLayout(15, 1));
        stackPanel.setBackground(Color.CYAN);
        pane.add(stackPanel, ContainerSetter.setUpStackPanel());

        // Set up the remove JButton
        removeButton.setBackground(Color.MAGENTA);
        pane.add(removeButton, ContainerSetter.setUpRemoveButton());

        // Set up the generate JButton
        generateButton.setBackground(Color.RED);
        pane.add(generateButton, ContainerSetter.setUpGenerateButton());

        // Set up the printer JPanel
        printerPanel.setLayout(new GridLayout(1, 1));
        printerPanel.setBackground(Color.lightGray);
        pane.add(printerPanel, ContainerSetter.setUpPrinterPanel());

        // Show it all
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}
