package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CategorySelect - In charge of controlling the Category selection box
 */
public class CategorySelect {

    private int initx = 500;
    private int inity = 28;
    private int length = 200;
    private int height = 40;
    private ArrayList<String> selections;

    public CategorySelect(Panel target) {

        selections = new ArrayList<>(Arrays.asList("Town", "Mafia", "Neutral", "Random"));
        Button catSelect;
        for (int i = 0; i < 4; i++) {
            catSelect = new Button(selections.get(i));
            catSelect.addActionListener(new NonRoleListener());
            catSelect.setActionCommand(selections.get(i));
            catSelect.setBounds(initx, inity + height*i, length, height);
            target.add(catSelect);
        }

    }

}
