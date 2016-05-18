package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ButtonHandler - The main button handling class of the GUI
 */

public class ButtonHandler implements ActionListener {

    public static RoleStack roleList;

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add")) {
            roleList.pushRole("Town Investigative");
        } else if (command.equals("Remove")) {
            roleList.popRole();
        }
    }

}
