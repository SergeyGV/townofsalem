package display;

import main.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StartListener implements MouseListener {

    JLabel violations;
    Controller generator;
    ScreenControl drawer;

    public StartListener(JLabel violationsBox, Controller gen, ScreenControl display) {
        violations = violationsBox;
        generator = gen;
        drawer = display;
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
            ArrayList<String> results = generator.simulate(roleList);
            if (results.get(0).equals("Violations:")) {
                String listOfViolations = "<html>";
                for (String violation: results) {
                    listOfViolations += violation + "<br>";
                }
                listOfViolations += "<html>";
                violations.setText(listOfViolations);
            } else {
                violations.setText("<html>Violations:<html>");
                new InfoDisplay(results);
            }
        }

    }

}
