package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CategorySelect - In charge of controlling the Category selection box
 */
public class CategorySelect {

    private int initx = 30;
    private int inity = 130;
    private int length = 144;
    private int height = 40;
    private ArrayList<String> selections;

    public CategorySelect(JPanel target) {

        // Constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        // Set up
        selections = new ArrayList<>(Arrays.asList("Town", "Mafia", "Neutral", "Random"));
        JPanel catPanel = new JPanel();
        catPanel.setBounds(initx, inity, length, height*4);
        catPanel.setLayout(new GridLayout(4, 1));
        JButton catButton;
        for (int i = 0; i < 4; i++) {
            catButton = new JButton(selections.get(i));
            catButton.setVisible(true);
            catButton.setBackground(Color.LIGHT_GRAY);
            catButton.addMouseListener(new CategoryListener(selections.get(i), catButton));
            catPanel.add(catButton);
        }
        catPanel.setVisible(true);
        target.add(catPanel, constraints);

    }

}
