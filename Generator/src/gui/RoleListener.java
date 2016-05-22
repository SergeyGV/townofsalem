package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RoleListener - Handles all button presses in the GUI for role selection
 */
public class RoleListener implements ActionListener {

    private static RoleStack destination;
    private static String curRole = "";

    public RoleListener() {
        // Do nothing!
    }

    public RoleListener(RoleStack source) {

        destination = source;

    }


    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command) {
            case "Add":
                if (!curRole.equals("")) {
                    destination.pushRole(curRole);
                }
                break;
            case "Remove":
                destination.popRole();
                break;
            default:
                curRole = command;
                break;
        }

    }

}
