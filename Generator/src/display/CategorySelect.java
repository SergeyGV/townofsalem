package display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CategorySelect {

    private ArrayList<JButton> categories;
    private ArrayList<String> catNames;

    public CategorySelect(JPanel targetPanel) {

        catNames = new ArrayList<>(Arrays.asList("Town", "Mafia", "Neutral", "General"));
        for (int i = 0; i < catNames.size(); i++) {
            JButton catButt = new JButton(catNames.get(i));
            catButt.setBackground(Color.LIGHT_GRAY);
            catButt.addMouseListener(new CategoryListener(catNames.get(i), catButt));
            targetPanel.add(catButt);
        }

    }

}
