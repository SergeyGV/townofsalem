package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * NonRoleListener - Handles all button presses in the GUI that are
 * NOT role selections
 */

public class NonRoleListener implements ActionListener {

    public static RoleSelect categorySorter;

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Start":
                break;
            default: // All other cases will be the user selecting categories
                categorySorter.showNewPanel(command);
                break;
        }
    }

}
