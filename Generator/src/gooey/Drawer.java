package gooey;

import javax.swing.*;
import java.awt.*;

public class Drawer {

    JFrame mainFrame;
    JPanel leftPanel;
    JPanel centerPanel;
    JPanel rightPanel;
    JPanel stackPanel;
    JPanel printerPanel;
    JPanel categoryPanel;
    JPanel rolePanel;
    JButton removeButton;
    JButton generateButton;

    public Drawer() {

        mainFrame = new JFrame();
        leftPanel = new JPanel();
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        stackPanel = new JPanel();
        printerPanel = new JPanel();
        categoryPanel = new JPanel();
        rolePanel = new JPanel();
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

        // Set up the left JPanel
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(Color.DARK_GRAY);
        pane.add(leftPanel, ContainerSetter.setUpLeftPanel());


        // Set up the category JPanel
        categoryPanel.setLayout(new GridLayout(4, 1));
        categoryPanel.setBackground(Color.green);
        leftPanel.add(categoryPanel, ContainerSetter.setUpCategoryPanel());

        for (int i = 0; i < 4; i++) {
            JButton butt = new JButton("test");
            categoryPanel.add(butt);
        }

        // Set up the role JPanel
        rolePanel.setLayout(new GridLayout(14, 1));
        rolePanel.setBackground(SystemColor.green);
        leftPanel.add(rolePanel, ContainerSetter.setUpRolePanel());

        for (int i = 0; i < 14; i++) {
            JButton butt = new JButton("test");
            rolePanel.add(butt);
        }

        // Set up the center JPanel
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(Color.DARK_GRAY);
        pane.add(rightPanel, ContainerSetter.setUpRightPanel());

        // Set up the right JPanel
        centerPanel.setLayout(new GridLayout(1, 1));
        centerPanel.setBackground(Color.DARK_GRAY);
        pane.add(centerPanel, ContainerSetter.setUpCenterPanel());

        /*

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
        */

        // Show it all
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}
