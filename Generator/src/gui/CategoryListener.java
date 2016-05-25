package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * CategoryListener - Handles all button presses in the GUI that are
 * NOT role selections
 */

public class CategoryListener implements ActionListener {

    public static RoleSelect categorySorter;

    public void actionPerformed(ActionEvent e) {
        categorySorter.showNewPanel(e.getActionCommand());
    }

}
