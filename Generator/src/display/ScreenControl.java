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

        stateOne.add(leftPanel);
        stateOne.add(midPanel);
        stateOne.add(rightPanel);

        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}