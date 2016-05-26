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
        Label catSelect;
        for (int i = 0; i < 4; i++) {
            catSelect = new Label(selections.get(i));
            catSelect.addMouseListener(new CategoryListener(selections.get(i)));
            catSelect.setBounds(initx, inity + height*i, length, height);
            target.add(catSelect);
        }

    }

    class CatDisplay extends Label {

        Image background;
        public CatDisplay(String role) {
            /*
            try {
                background = ImageMapper.roleImages.get(role);
            } catch (Exception e) {
                System.out.println("Couldn't add the background");
            }
            */
        }

        public void paint(Graphics g) {
            super.paint(g);
            //g.drawImage(background, 0, 0, null);
        }

    }

}
