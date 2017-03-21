package display;

import main.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StartListener implements MouseListener {

    JLabel violations;
    Controller generator;

    public StartListener(JLabel violationsBox, Controller gen) {
        violations = violationsBox;
        generator = gen;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

        ArrayList<String> roleList = AddListener.target.getRoles();
        if (roleList.size() == 0) {
            violations.setText("<html>Violations: Must have at least one character to start the game.<html>");
        } else {
            for (String role: roleList) {
                System.out.println(role);
            }
        }

    }

}
