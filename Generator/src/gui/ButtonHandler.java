package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;

/**
 * ButtonHandler - The main button handling class of the GUI
 */

public class ButtonHandler implements ActionListener {

    public static RoleStack roleList;

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add")) {
            Random randomizer = new Random();
            int res = randomizer.nextInt(47);
            if (res > 33) { // RANDOM
                roleList.pushRole("any");
            } else if (res > 24) { // MAFIA
                roleList.pushRole("random mafia");
            } else if (res > 15) { // NEUTRAL
                roleList.pushRole("neutral evil");
            } else { // TOWN
                roleList.pushRole("transporter");
            }
        } else if (command.equals("Remove")) {
            roleList.popRole();
        }
    }

}
